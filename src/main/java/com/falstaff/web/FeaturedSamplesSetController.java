package com.falstaff.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.crawler.ILocalSamplesDownloader;
import com.falstaff.crawler.IRemoteSamplesDownloader;
import com.falstaff.crawler.LocalRecursiveSamplesDownloader;
import com.falstaff.crawler.RemoteSamplesDownloader;
import com.falstaff.service.FeaturedSamplesSetService;
import com.falstaff.service.FileFormatService;

@Controller
public class FeaturedSamplesSetController {

	@Autowired
	FileFormatService fileFormatService;

	@Autowired
	FeaturedSamplesSetService featuredSamplesSetService;

	private static final Logger logger = LoggerFactory
			.getLogger(FeaturedSamplesSetController.class.getName());

	@RequestMapping(value = "/formats/{formatId}/samples-sets", method = RequestMethod.GET, params = "corpora=govdoc1")
	public ModelAndView formGovdoc1SamplesSet(
			@PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("samples-sets/create",
				"fileFormat", fileFormat);
		FeaturedSamplesSet samplesSet = new FeaturedSamplesSet(fileFormat);
		samplesSet.setName("govdoc1");
		FeaturedSamplesSet.SamplesUrl samplesUrl = new FeaturedSamplesSet.SamplesUrl("http://digitalcorpora.org/corpora/files/", "govdoc1");
		samplesSet.addSampleURL(samplesUrl);
		modelAndView.addObject("samplesSet", samplesSet);
		return modelAndView;
	}
	
	@RequestMapping(value = "/formats/{formatId}/samples-sets", method = RequestMethod.GET, params = "corpora=github")
	public ModelAndView formGitHubSamplesSet(
			@PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("samples-sets/create",
				"fileFormat", fileFormat);
		FeaturedSamplesSet samplesSet = new FeaturedSamplesSet(fileFormat);
		samplesSet.setName("github");
		FeaturedSamplesSet.SamplesUrl samplesUrl = new FeaturedSamplesSet.SamplesUrl("https://github.com", "github");
		samplesSet.addSampleURL(samplesUrl);
		modelAndView.addObject("samplesSet", samplesSet);
		return modelAndView;
	}
	
	@RequestMapping(value = "/formats/{formatId}/samples-sets", method = RequestMethod.GET, params = "corpora=archiveteam")
	public ModelAndView formArchiveteamSamplesSet(
			@PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("samples-sets/create",
				"fileFormat", fileFormat);
		FeaturedSamplesSet samplesSet = new FeaturedSamplesSet(fileFormat);
		samplesSet.setName("archiveteam");
		for (FileFormatOntology.SampleUrl sampleUrl : fileFormat.getOntology().getSampleUrls()) {
			FeaturedSamplesSet.SamplesUrl samplesUrl = new FeaturedSamplesSet.SamplesUrl(sampleUrl.getUrl(), sampleUrl.getDescription());
			samplesSet.addSampleURL(samplesUrl);
		}
		modelAndView.addObject("samplesSet", samplesSet);
		return modelAndView;
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets", method = RequestMethod.POST)
	public ModelAndView createSamplesSet(
			@PathVariable("formatId") FileFormat fileFormat,
			@Valid FeaturedSamplesSet samplesSet, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		if (result.hasErrors()) {
			return new ModelAndView("samples-sets/create", "formErrors",
					result.getAllErrors());
		}
		featuredSamplesSetService.setFormat(samplesSet, fileFormat);
		samplesSet = featuredSamplesSetService.create(samplesSet);
		redirect.addFlashAttribute("globalMessage",
				"Successfully created a new samples set");
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/formats/{formatId}/samples-sets/{samplesSetId}",
				"samplesSetId", new Integer(samplesSet.getId()));
		modelAndView.addObject("formatId", fileFormat.getId());
		return modelAndView;
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}", method = RequestMethod.POST, params = "operation=update")
	public ModelAndView updateSamplesSet(
			@PathVariable("formatId") FileFormat fileFormat,
			@ModelAttribute("samplesSet") @Valid FeaturedSamplesSet updatedSamplesSet,
			@PathVariable("samplesSetId") String samplesSetId)
			throws IOException {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		logger.info("samples set " + samplesSet.getName() + " will be updated");
		samplesSet.setName(updatedSamplesSet.getName());
		samplesSet.setDescription(updatedSamplesSet.getDescription());
		samplesSet.setSampleURLs(updatedSamplesSet.getSampleURLs());
		featuredSamplesSetService.save(samplesSet);
		return new ModelAndView("samples-sets/view", "samplesSet", samplesSet);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}", method = RequestMethod.POST, params = "operation=delete")
	public ModelAndView deleteSamplesSet(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId)
			throws IOException {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		logger.warn("samples set " + samplesSet.getName() + " will be deleted");
		featuredSamplesSetService.delete(samplesSet);
		return new ModelAndView("formats/view", "fileFormat", fileFormat);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}", method = RequestMethod.GET)
	public ModelAndView viewSamplesSet(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId) {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		return new ModelAndView("samples-sets/view", "samplesSet", samplesSet);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples/{sampleId}", method = RequestMethod.GET)
	public ModelAndView viewSample(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId,
			@PathVariable("sampleId") String sampleId) {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		return new ModelAndView("samples/view", "sample",
				featuredSamplesSetService.getSample(samplesSet, new Integer(sampleId)));
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples", method = RequestMethod.GET)
	public ModelAndView formSampleLocal(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId) {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		return new ModelAndView("samples/create", "samplesSet", samplesSet);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples", method = RequestMethod.POST)
	public ModelAndView createSampleLocal(MultipartHttpServletRequest mrequest,
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId,
			RedirectAttributes redirect) throws IOException {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));

		Map<String, MultipartFile> fileMap = mrequest.getFileMap();
		for (String name : fileMap.keySet()) {
			MultipartFile multipartFile = fileMap.get(name);
			byte[] bytes = multipartFile.getBytes();
			String originalName = multipartFile.getOriginalFilename();
			long modificationDate = new Long(mrequest.getParameter(name
					+ ".modificationDate"));
			Date date = new Date(modificationDate);
			String formatted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
			FeaturedSample sample = featuredSamplesSetService.createSample(bytes, originalName, modificationDate, samplesSet);
			logger.info("sample " + sample.getFileName() + " from sample set "
					+ samplesSet.getName() + " was created, sample  size = " + bytes.length + " original name "
					+ originalName + " modificationDate " + formatted);
		}
		samplesSet.setUpdated(Calendar.getInstance());
		featuredSamplesSetService.setSamples(samplesSet);
		featuredSamplesSetService.save(samplesSet);
		return new ModelAndView("samples-sets/view", "samplesSet", samplesSet);
	}
	
	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples", method = RequestMethod.GET, params = "corpora=remote")
	public ModelAndView formSampleRemote(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId) {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		IRemoteSamplesDownloader samplesDownloader = new RemoteSamplesDownloader(samplesSet);
		return new ModelAndView("samples/download", "samplesDownloader", samplesDownloader);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples", method = RequestMethod.POST, params = "corpora=remote")
	public ModelAndView createSampleRemote(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId,
			@Valid IRemoteSamplesDownloader samplesDownloader, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		samplesDownloader.setSamplesSet(samplesSet);
		featuredSamplesSetService.downloadRemote(samplesDownloader);
		return new ModelAndView("samples-sets/view", "samplesSet", samplesSet);
	}
	
	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples", method = RequestMethod.GET, params = "corpora=local_recursive")
	public ModelAndView formSampleLocalRecursive(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId) {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		ILocalSamplesDownloader samplesDownloader = new LocalRecursiveSamplesDownloader(samplesSet);
		return new ModelAndView("samples/create-recursive", "samplesDownloader", samplesDownloader);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples", method = RequestMethod.POST, params = "corpora=local_recursive")
	public ModelAndView createSampleLocalRecursive(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId,
			@Valid LocalRecursiveSamplesDownloader samplesDownloader, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		samplesDownloader.setSamplesSet(samplesSet);
		featuredSamplesSetService.downloadLocalRecursive(samplesDownloader);
		return new ModelAndView("samples-sets/view", "samplesSet", samplesSet);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples/{sampleId}", method = RequestMethod.POST, params = "operation=delete")
	public ModelAndView deleteSample(
			@PathVariable("formatId") FileFormat fileFormat,
			@PathVariable("samplesSetId") String samplesSetId,
			@PathVariable("sampleId") String sampleId) throws IOException {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		FeaturedSample sample = samplesSet.getSample(new Integer(sampleId));
		logger.warn("sample " + sample.getFileName() + " from sample set "
				+ samplesSet.getName() + " will be deleted");
		samplesSet.clearSample(sample.getId());
		featuredSamplesSetService.save(samplesSet);
		return new ModelAndView("samples-sets/view", "samplesSet", samplesSet);
	}

	@RequestMapping(value = "/formats/{formatId}/samples-sets/{samplesSetId}/samples/{sampleId}", method = RequestMethod.POST, params = "operation=update")
	public ModelAndView updateSample(
			@PathVariable("formatId") FileFormat fileFormat,
			@ModelAttribute("sample") @Valid FeaturedSample updatedSample,
			@PathVariable("samplesSetId") String samplesSetId,
			@PathVariable("sampleId") String sampleId) throws IOException {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(
				samplesSetId));
		FeaturedSample sample = samplesSet.getSample(new Integer(sampleId));
		logger.info("sample " + sample.getFileName() + " from sample set "
				+ samplesSet.getName() + " will be updated");
		sample.setTraining(updatedSample.isTraining());
		sample.setTesting(updatedSample.isTesting());
		sample.setAligning(updatedSample.isAligning());
		featuredSamplesSetService.save(samplesSet);
		return new ModelAndView("samples/view", "sample", sample);
	}
	
	@RequestMapping(value="/formats/{formatId}/samples-sets/{samplesSetId}/samples/monitor", method = RequestMethod.GET)
	public String viewSamplesSetProgressStatus(Model model, @PathVariable("formatId") FileFormat fileFormat, @PathVariable("samplesSetId") String samplesSetId) {
		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(new Integer(samplesSetId));
		model.addAttribute("processMonitor", samplesSet.getProcessMonitor());		
		return "execution/process-view :: process";
	}
}
