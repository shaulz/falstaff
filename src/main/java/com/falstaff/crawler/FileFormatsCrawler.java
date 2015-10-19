package com.falstaff.crawler;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.execution.IProcessMonitor;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.ontology.FileFormatOntologyFirstGroup;
import com.falstaff.core.ontology.FileFormatOntologySecondGroup;
import com.falstaff.core.ontology.Ontology;
import com.falstaff.repository.dao.FeaturedClassifierDao;
import com.falstaff.repository.dao.FileFormatDao;
import com.falstaff.repository.dao.OntologyDao;
import com.falstaff.repository.ds.FlatDS;

@Component
public class FileFormatsCrawler implements IProcessMonitor  {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(FileFormatsCrawler.class.getName());

	private WebDriver driver;
	
	private String[] extensionsURLS;
	
	private Ontology ontology;
	
	@Autowired
	private FlatDS flatDS;
	
	@Autowired
	private OntologyDao ontologyDao;
	
	@Autowired
	private FileFormatDao fileFormatDao;
	
	@Autowired
	private FeaturedClassifierDao classifierDao;
	
	private Set<String> visitedUrls;
	
	private ProcessMonitor processMonitor = null;
	
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	private static int maxRetires = 20;
	private static int retriesSleep = 4000;
	
	private static final String classifierName = "falstaff";
	
	@PostConstruct
	private void init() {
		ontology = ontologyDao.getOntology();
		if (ontology == null) {
			ontology = new Ontology();
		}
		visitedUrls = new HashSet<String>();
	}
	
	public FileFormatsCrawler() {
		int extensionsNum = 1242;
		int pagesNum = extensionsNum / 200 + 1;
		extensionsURLS = new String[pagesNum];
		int index = -1;
		extensionsURLS[++index] = "http://fileformats.archiveteam.org/wiki/Category:File_formats_by_extension";
		extensionsURLS[++index] = "http://fileformats.archiveteam.org/index.php?title=Category:File_formats_by_extension&subcatfrom=C%0AFile+formats+with+extension+.chan#mw-subcategories";
		extensionsURLS[++index] = "http://fileformats.archiveteam.org/index.php?title=Category:File_formats_by_extension&subcatfrom=G%0AFile+formats+with+extension+.gdi#mw-subcategories";
		extensionsURLS[++index] = "http://fileformats.archiveteam.org/index.php?title=Category:File_formats_by_extension&subcatfrom=M%0AFile+formats+with+extension+.m2k#mw-subcategories";
		extensionsURLS[++index] = "http://fileformats.archiveteam.org/index.php?title=Category:File_formats_by_extension&subcatfrom=P%0AFile+formats+with+extension+.php#mw-subcategories";
		extensionsURLS[++index] = "http://fileformats.archiveteam.org/index.php?title=Category:File_formats_by_extension&subcatfrom=S%0AFile+formats+with+extension+.spf#mw-subcategories";
		extensionsURLS[++index] = "http://fileformats.archiveteam.org/index.php?title=Category:File_formats_by_extension&subcatfrom=X%0AFile+formats+with+extension+.xls#mw-subcategories";
		
		Logger root = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.INFO);
	}
	
	public void run() throws IOException {
		
		boolean locked = rwl.writeLock().tryLock();
		
		if (!locked) {
			log.error("another crawler process is already running");
			return;
		}
		
		try {
			
			ontology.initUpdates();
			
			setPercentageCompleted(0);
			setProcessName("checking formats by extension pages");
			driver = new HtmlUnitDriver();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			List<String> dynamicExtensionsURLs = new LinkedList<String>();
			String baseURL = "http://fileformats.archiveteam.org/wiki/Category:File_formats_by_extension";
			dynamicExtensionsURLs.add(baseURL);
			driver.get(baseURL);
			WebElement extensionLink = driver.findElement(By.partialLinkText("next 200"));
			while (extensionLink != null) {
				String extensionsURL = extensionLink.getAttribute("href");
				log.info("extensions page found " + extensionsURL);
				dynamicExtensionsURLs.add(extensionsURL);
				driver.get(extensionsURL);
				
				try {
					extensionLink = driver.findElement(By.partialLinkText("next 200"));
				} catch (NoSuchElementException e) {
					extensionLink = null;
				}
			}
			int extensionsURLsCount = 0; 
			for (String extensionsURL : dynamicExtensionsURLs) {
				setProcessName("updating formats from extensions page\n" + extensionsURL);
				int retries = 0;
				while (true) {
					try {
						processExtensionsURL(extensionsURL);
						break;
					} catch (Exception e) {
						retries++;
						log.error("processing of extensions URL " + extensionsURL + " failed " + e.toString() + " retrying for " + retries + " time");
						if (retries == maxRetires) {
							setStatus(ProcessStatus.FINISHED);
							driver.close();
							log.error("processing of extensions URL " + extensionsURL + " failed " + e.getMessage());
							return;
						}
						Thread.sleep(retriesSleep);
					}
				}
				//ontologyDao.setOntology(ontology);
				log.info("processing of extensions URL " + extensionsURL + " succeedded");
				extensionsURLsCount++;
				setPercentageCompleted(extensionsURLsCount * 100 / dynamicExtensionsURLs.size());
			}

			setDeletedOntologies();
			
			setNewOntologies();
			
			setUpdatedOntologies();
			
			if (ontology.getUpdatedOntologies() != null) {
				log.info(ontology.getUpdatedOntologies().size() + " out of " + ontology.getOntologies().size() + " formats were updated");
			}
			if (ontology.getNewOntologies() != null) {
				log.info(ontology.getNewOntologies().size() + " formats were added");
			}
			if (ontology.getDeletedOntologies() != null) {
				log.info(ontology.getDeletedOntologies().size() + " formats were deleted");
			}
			
			ontology.setUpdateDate(Calendar.getInstance());
			log.info("ontology successfully updated");
			ontologyDao.setOntology(ontology);
			
			setStatus(ProcessStatus.FINISHED);
			driver.close();
		} catch (Exception e) {
			log.error("crawler process failed " + e.getMessage());
		}
		finally {
			rwl.writeLock().unlock();
		}
	}
	
	private void setDeletedOntologies() {
		for (FileFormatOntology formatOntology : ontology.getOntologies()) {
			if (!visitedUrls.contains(formatOntology.getFormatUrl())) {
				// check if format exists and only the URL have been changed
				Iterator<FileFormatOntology> iterator = ontology.getNewOntologies().iterator();
				while (iterator.hasNext()) {
					FileFormatOntology newOntology = iterator.next();
					if (newOntology.getName().equalsIgnoreCase(formatOntology.getName()) &&
						newOntology.getFirstGroup().equals(formatOntology.getFirstGroup()) &&
						newOntology.getSecondGroup().equals(formatOntology.getSecondGroup())) {
						log.info("the URL of ontology " + formatOntology.getName() + " was changed from " + formatOntology.getFormatUrl() + " to " + newOntology.getFormatUrl());
						formatOntology.setFormatUrl(newOntology.getFormatUrl());
						iterator.remove();
						break;
					}
				}
				if (visitedUrls.contains(formatOntology.getFormatUrl())) {
					continue;
				}
				ontology.getDeletedOntologies().add(formatOntology);
				log.info("format " + formatOntology.getFormatUrl() + " was deleted");
			}
		}		
	}
	
	private void setNewOntologies() throws IOException {
		Iterator<FileFormatOntology> iterator = ontology.getNewOntologies().iterator();
		while (iterator.hasNext()) {
			FileFormatOntology formatOntology = iterator.next();
			if (formatOntology.isAutomaticCreate()) {
				formatOntology.setUpdateDate(Calendar.getInstance());
				ontology.add(formatOntology);
				FileFormat fileFormat = new FileFormat(formatOntology);
				fileFormat.setClassifierName(classifierName);
				FeaturedClassifier classifier = classifierDao.get(classifierName);
				fileFormat.setClassifier(classifier);
				ontology.addFormat(fileFormat);
				fileFormatDao.save(fileFormat);
				iterator.remove();
				log.info("ontology " + formatOntology.getFormatUrl() + " was automaticaly created");
			}
		}
		
		ontology.setNewFormats();
	}
	
	private void setUpdatedOntologies() {
		Iterator<FileFormatOntology> iterator = ontology.getUpdatedOntologies().iterator();
		while (iterator.hasNext()) {
			FileFormatOntology updatedFormatOntology = iterator.next();
			FileFormatOntology formatOntology = ontology.getByUrl(updatedFormatOntology.getFormatUrl());
			if (formatOntology.isAutomaticUpdate(updatedFormatOntology)) {
				formatOntology.update(updatedFormatOntology);
				iterator.remove();
				log.info("ontology " + formatOntology.getFormatUrl() + " was automaticaly updated");
			}
		}
	}
	
	public void processExtensionsURL(String extensionsURL) throws IOException, InterruptedException {
		driver.get(extensionsURL);
		List<WebElement> links = driver.findElements(By.partialLinkText("File formats with extension"));
		HashSet<String> extensionsURLCash = new HashSet<String>();
		for (WebElement link : links) {
			String extensionURL = link.getAttribute("href");
			extensionsURLCash.add(extensionURL);
		}
		for (String extensionURL : extensionsURLCash) {
			log.info("extensionLink " + extensionURL);
			processExtensionURL(extensionURL);
		}
		
		log.info("finished processing extension url " + extensionsURL);
	}
	
	public void processExtensionURL(String extensionURL) throws IOException, InterruptedException {
		driver.get(extensionURL);
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='mw-pages']//a"));
		HashSet<String> specificationsURL = new HashSet<String>();
		for (WebElement link : links) {
			String specificationURL = link.getAttribute("href");
			specificationsURL.add(specificationURL);
		}
		for (String specificationURL : specificationsURL) {
			if (visitedUrls.contains(specificationURL)) {
				log.info("specificationURL " + specificationURL + " already processed");
				continue;
			}
			log.info("processing format specificationURL " + specificationURL);
			FileFormatOntology formatOntology = null;
			int retries = 0;
			while (true) {
				try {
					formatOntology = processSpecificationURL(specificationURL);
					break;
				} catch (Exception e) {
					retries++;
					log.error("failed processing of specificationURL " + specificationURL + " " + e.getMessage() + " retrying for " + retries + " time");
					if (retries == maxRetires) {
						log.error("failed processing of specificationURL " + specificationURL + " " + e.getMessage());
						break;
					}
					Thread.sleep(retriesSleep);
				}
			}
			if (formatOntology != null) {
				if (ontology.contains(formatOntology)) {
					FileFormatOntology currentOntology = ontology.getByUrl(specificationURL);
					currentOntology.setSync(formatOntology);
					if (!currentOntology.getSync().equals("")) {
						ontology.getUpdatedOntologies().add(formatOntology);
						log.info("format is not in sync " + formatOntology.getFormatUrl() + currentOntology.getSync());
					}
				}
				else {
					ontology.getNewOntologies().add(formatOntology);
					log.info("new format found " + formatOntology.getFormatUrl());
				}
				//ontology.add(formatOntology);
			}
			visitedUrls.add(specificationURL);
		}
	}
	
	public FileFormatOntology processSpecificationURL(String specificationURL) {
		driver.get(specificationURL);
		/*
		List<WebElement> links = driver.findElements(By.xpath("//*[@class='mw-headline']"));
		for (WebElement link : links) {
			String id = link.getAttribute("id");
			log.info("specification heading id " + id);
		}
		*/
		
		// format name
		WebElement formatNameElement = driver.findElement(By.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/tr[2]/td"));
		if (formatNameElement == null) {
			log.error("could not extract format name in specification url " + specificationURL);
			return null;
		}
		String formatName = formatNameElement.getText();
		if (formatName == null || formatName.equals("")) {
			log.error("could not extract format name in specification url " + specificationURL);
			return null;			
		}
		
		// format groups
		
		// first group
		List<WebElement> ontologyLevels = driver.findElements(By.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/tr[3]/descendant::*[self::a]"));
		WebElement firstGroupElement = ontologyLevels.get(0);
		String formatFirstGroup = firstGroupElement.getText();
		FileFormatOntologyFirstGroup firstGroup = FileFormatOntologyFirstGroup.findByName(formatFirstGroup);
		if (firstGroup == null) {
			log.error("unexisting first group " + formatFirstGroup + " in specification url " + specificationURL);
			return null;					
		}

		FileFormatOntologySecondGroup secondGroup;
		if (ontologyLevels.size() == 1) {
			secondGroup = FileFormatOntologySecondGroup.undefined;
		}
		else {
			WebElement formatGroupElement = ontologyLevels.get(1);
			String formatSecondGroup = formatGroupElement.getText();
			if (formatSecondGroup == null || formatSecondGroup.equals("")) {
				log.error("could not extract format second group in specification url " + specificationURL);
				return null;			
			}
			
			secondGroup = FileFormatOntologySecondGroup.findByName(formatSecondGroup);
			if (secondGroup == null) {
				log.error("unexisting group " + formatSecondGroup + " in specification url " + specificationURL);
				return null;					
			}
		}
		
		// validate format name
		int subGroupIndex = 2;
		formatNameElement = null;
		try {
			formatNameElement = driver.findElement(By.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/tr[3]/descendant::*[self::strong]"));
		} catch (Exception e) {
			if (ontologyLevels.size() >= 2) {
				formatNameElement = ontologyLevels.get(2);
				subGroupIndex = -1;
			}
			if (formatNameElement == null) {
				log.error("could not extract format ontology name in specification url " + specificationURL);
				throw new RuntimeException("could not extract format ontology name in specification url " + specificationURL);
			}
		}
		String formatOntologyName = formatNameElement.getText();
		if (formatOntologyName == null || formatOntologyName.equals("")) {
			log.error("could not extract format ontology name in specification url " + specificationURL);
			return null;			
		}
		if (!formatName.equals(formatOntologyName)) {
			log.error("formatName " + formatName + " and format ontology name " + formatOntologyName + " are diferent");
			return null;						
		}
				
		FileFormatOntology formatOntology = new FileFormatOntology(firstGroup, secondGroup, formatName);
		if (ontologyLevels.size() > 2 && subGroupIndex >= 0) {
			String subgroup = ontologyLevels.get(subGroupIndex).getText();
			formatOntology.setSubgroup(subgroup);
		}
		
		// extensions
		List<WebElement> extensionElements = driver.findElements(By.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/tr[4]/th/../td/code"));
		if (extensionElements.size() == 0) {
			log.error("no extensions extracted in specification url " + specificationURL );
		}
		for (WebElement extensionElement : extensionElements) {
			String extension = extensionElement.getText();
			formatOntology.addExtension(extension);
		}

		// mime		
		List<WebElement> mimeElements = driver.findElements(By.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/*/th[contains(text(),'MIME Type')]/following-sibling::*/*/a"));
		for (WebElement mimeElement : mimeElements) {
			String mime = mimeElement.getText();
			formatOntology.addMimeType(mime);
		}
		
		// fdd
		List<WebElement> fddElements = driver.findElements(By.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/*/th[contains(text(),'LoCFDD')]/following-sibling::*/a"));
		for (WebElement fddElement : fddElements) {
			String fdd = fddElement.getText();
			formatOntology.addFddId(fdd);
		}
		
		if (fddElements.size() > 0) {
			WebElement fddList = driver
					.findElement(By
							.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/*/th[contains(text(),'LoCFDD')]/following-sibling::*"));
			if (fddList != null) {
				String fddListText = fddList.getText();
				if (fddListText.toLowerCase().contains("other")) {
					fddElements = driver.findElements(By
							.xpath(".//*[contains(text(),'fdd')]"));
					for (WebElement fddElement : fddElements) {
						String fdd = fddElement.getText();
						formatOntology.addFddId(fdd);
					}
				}
			}
		}
		
		// pronom
		List<WebElement> pronomElements = driver.findElements(By.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/*/th[contains(text(),'PRONOM')]/following-sibling::*/a"));
		for (WebElement pronomElement : pronomElements) {
			String pronom = pronomElement.getText();
			formatOntology.addPronomId(pronom);
		}
		
		if (pronomElements.size() > 0) {
			WebElement pronomList = driver
					.findElement(By
							.xpath(".//*[@id='mw-content-text']/table[@class='infobox formatinfo']/tbody/*/th[contains(text(),'PRONOM')]/following-sibling::*"));
			if (pronomList != null) {
				String pronomListText = pronomList.getText();
				if (pronomListText.toLowerCase().contains("other")) {
					pronomElements = driver.findElements(By
							.xpath(".//*[contains(text(),'fmt/')]"));
					for (WebElement pronomElement : pronomElements) {
						String pronom = pronomElement.getText();
						formatOntology.addPronomId(pronom);
					}
				}
			}
		}
		
		// all links in the sample file
		List<WebElement> sampleElements = driver.findElements(By.xpath(".//*[@id='Sample_files' or @id='Sample_Files']/../following-sibling::*[1]/descendant::*[self::a]"));
		for (WebElement sampleElement : sampleElements) {
			String sampleURL = sampleElement.getAttribute("href");
			String sampleURLText = sampleElement.getText();
			formatOntology.addSampleUrl(sampleURL, sampleURLText);
		}

		
		// page headers
		List<WebElement> headerElements = driver.findElements(By.xpath(".//*[@id='mw-content-text']/*[self::h2]/span"));
		for (WebElement headerElement : headerElements) {
			String header = headerElement.getText();
			formatOntology.addFormatUrlHeader(header);
		}
		
		// url
		String url = driver.getCurrentUrl();
		formatOntology.setFormatUrl(url);
		
		return formatOntology;
	}
	
	public void save(Ontology ontology, String ontologyName) throws IOException {
		flatDS.save(ontology, flatDS.ontologyPath(ontologyName));
	}
	
	public Ontology read(String ontologyName) {
		return (Ontology)flatDS.read(flatDS.ontologyPath(ontologyName));
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public int getPercentageCompleted() {
		return processMonitor.getPercentageCompleted();
	}

	public void setPercentageCompleted(int percentageCompleted) {
		processMonitor.setPercentageCompleted(percentageCompleted);
	}

	public String getProcessName() {
		return processMonitor.getProcessName();
	}

	public void setProcessName(String processName) {
		processMonitor.setProcessName(processName);
	}

	public Calendar getStarted() {
		return processMonitor.getStarted();
	}

	public void setStarted(Calendar started) {
		processMonitor.setStarted(started);
	}

	public ProcessStatus getStatus() {
		return processMonitor.getStatus();
	}

	public void setStatus(ProcessStatus status) {
		processMonitor.setStatus(status);
	}

	public Object getProcessMonitor() {
		return processMonitor;
	}

	public void setProcessMonitor(ProcessMonitor processMonitor) {
		if (this.processMonitor != null && !this.processMonitor.getStatus().equals(ProcessStatus.FINISHED)) {
			return;
		}
		this.processMonitor = processMonitor;
	}

}
