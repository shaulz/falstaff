package com.falstaff.crawler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.alignable.signature.pattern.Matcher;
import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.ontology.MagicNumbers;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord;
import com.falstaff.core.score.Alphabet;

@Component
public class MagicNumberCrawler {
		
	private static final Logger log = (Logger) LoggerFactory.getLogger(MagicNumberCrawler.class.getName());

	private static final String url = "http://www.garykessler.net/library/file_sigs.html";
	private static Pattern offsetPattern = Pattern.compile("^\\s*" + Pattern.quote("[") + "([\\d,]+) byte offset" + Pattern.quote("]"));
	private static Pattern boundaryPattern = Pattern.compile(Pattern.quote("[") + "At a cluster boundary" + Pattern.quote("]"));
	private static Pattern alternativePattern = Pattern.compile("^(.*)\\s+or", Pattern.DOTALL);
	private MagicNumbers magicNumbers;
	private WebDriver driver;

	public MagicNumberCrawler() {
		magicNumbers = new MagicNumbers();
	}

	public void run() {
		//driver = new HtmlUnitDriver();
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get(url);
		WebElement tableElement = driver.findElement(By.xpath("//table"));
		List<WebElement> rows = tableElement.findElements(By.xpath(".//tbody/tr"));

		int recordsCount = 0;
		Set<NSignature> signatures = null;
		boolean alternativeSignatures = false;
		String offset = null;
		for (WebElement rowElement : rows) {
			List<WebElement> columns = rowElement.findElements(By.xpath(".//td"));
			if (columns.size() == 0) {
				continue;
			}
			
			if (columns.size() == 1) {
				// notes
				for (int i = magicNumbers.getMagicNumbers().size() - recordsCount; i < magicNumbers.getMagicNumbers().size(); i++) {
					magicNumbers.getMagicNumbers().get(i).setDescription(magicNumbers.getMagicNumbers().get(i).getDescription() + "\n" + columns.get(0).getAttribute("innerHTML"));
				}
				continue;
			}
			// valign="top" align="right"
			if ("top".equals(columns.get(0).getAttribute("valign")) &&
			"right".equals(columns.get(0).getAttribute("align"))) {
				// extension
				String extensionsText = columns.get(0).getText();
				String description = columns.get(2).getAttribute("innerHTML");
				if (description == null) {
					description = columns.get(2).getText();
				}
				MagicNumberRecord magicRecord = new MagicNumberRecord();
				magicNumbers.getMagicNumbers().add(magicRecord);
				String[] extensionsArray = extensionsText.split("\\s*,\\s*");
				magicRecord.setExtensions(new HashSet<String>(Arrays.asList(extensionsArray)));
				magicRecord.setDescription(description);
				recordsCount++;
			}
			else {
				if (columns.get(0).findElements(By.xpath(".//font[@face=\"courier\"]")).size() > 0) {
					// fill records with signatures
					for (int i = magicNumbers.getMagicNumbers().size() - recordsCount; i < magicNumbers.getMagicNumbers().size(); i++) {
						if (signatures != null) {
							magicNumbers.getMagicNumbers().get(i).setSignatures(signatures);
						}
						log.info(magicNumbers.getMagicNumbers().get(i).toString());
					}
					recordsCount = 0;
					if (!alternativeSignatures) {
						signatures = new HashSet<NSignature>();
						offset = null;
					}
					
					String signaturesText = columns.get(0).getText();
					log.info("signaturesText at start " + signaturesText);
					Matcher matcher = offsetPattern.matcher(signaturesText);
					if (matcher.find()) {
						offset = matcher.group(1).replace(",","");
						signaturesText = signaturesText.substring(matcher.end());
					}
					matcher = boundaryPattern.matcher(signaturesText);
					if (matcher.find()) {
						signaturesText = signaturesText.substring(matcher.end());
					}
					matcher = alternativePattern.matcher(signaturesText);
					if (matcher.find()) {
						signaturesText = matcher.group(1);
						alternativeSignatures = true;
					}
					else {
						alternativeSignatures = false;
					}
					
					log.info("signaturesText at end " + signaturesText);

					String[] bytes = signaturesText.trim().split("\\s+");
					StringBuilder signature = new StringBuilder("^");
					if (offset != null) {
						signature.append(".{").append(offset).append("}");
					}
					for (String s : bytes) {
						if (s.equals("nn")) {
							signature.append(".");
							continue;
						}
						if (s.equals("xx")) {
							signature.append(".");
							continue;
						}
						if (s.endsWith("x")) {
							String rangeStart = s.replace("x", "0");
							String rangeEnd = s.replace("x", "F");
							signature.append("[").append(Alphabet.byte2chars(Alphabet.hex2byte(rangeStart))).append("-").append(Alphabet.byte2chars(Alphabet.hex2byte(rangeEnd))).append("]");
							continue;
						}
						signature.append(Alphabet.byte2chars(Alphabet.hex2byte(s.toUpperCase())));
					}
					signatures.add(new NSignature(Pattern.compile(signature.toString())));
				}
				else {
					throw new RuntimeException("unknown line:");
				}
			}
			// last record
			for (int i = magicNumbers.getMagicNumbers().size() - recordsCount; i < magicNumbers.getMagicNumbers().size(); i++) {
				if (signatures != null) {
					magicNumbers.getMagicNumbers().get(i).setSignatures(signatures);
				}
				log.info(magicNumbers.getMagicNumbers().get(i).toString());
			}
		}
	}

	public MagicNumbers getMagicNumbers() {
		return magicNumbers;
	}

	public void setMagicNumbers(MagicNumbers magicNumbers) {
		this.magicNumbers = magicNumbers;
	}

}
