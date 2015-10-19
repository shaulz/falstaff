package com.falstaff.repository.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.repository.ds.FlatDS;

@Component
public class FeaturedSamplesSetDao {

	private static final Logger log = LoggerFactory
	.getLogger(FeaturedSamplesSetDao.class.getName());
	
	@Autowired
	private FlatDS flatDS;
	
	@Autowired
	private FileFormatDao formatDao;
	
	@PostConstruct
	public void init() {
		List<FileFormat> formats = formatDao.getFormats();
		for (FileFormat format : formats) {
			List<FeaturedSamplesSet> samples = format.getSamples();
			if (samples == null) {
				continue;
			}
			for (FeaturedSamplesSet samplesSet : samples) {
				setIds(samplesSet);
			}
		}
	}
	
	public void save(FeaturedSamplesSet featuredSamplesSet) throws IOException {
		formatDao.save(featuredSamplesSet.getFormat());
	}
	
	private void setIds(FeaturedSamplesSet featuredSamplesSet) {
		featuredSamplesSet.setId();
		List<FeaturedSample> samples = featuredSamplesSet.getSamples();
		if (samples == null) {
			return;
		}
		for (FeaturedSample sample : samples) {
			sample.setId();
		}
	}
	
	public void createSamplesSetFolder(FeaturedSamplesSet samplesSet) throws IOException {
		flatDS.createSamplesSetFolder(samplesSet);
	}
	
	public void delete(FeaturedSamplesSet featuredSamplesSet) throws IOException {
		removeRecursive(new File(featuredSamplesSet.getFolder()).toPath());
	}
	
	public void removeRecursive(Path path) throws IOException
	{
	    Files.walkFileTree(path, new SimpleFileVisitor<Path>()
	    {
	        @Override
	        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
	                throws IOException
	        {
	            Files.delete(file);
	            return FileVisitResult.CONTINUE;
	        }

	        @Override
	        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
	        {
	            // try to delete the file anyway, even if its attributes
	            // could not be read, since delete-only access is
	            // theoretically possible
	            Files.delete(file);
	            return FileVisitResult.CONTINUE;
	        }

	        @Override
	        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
	        {
	            if (exc == null)
	            {
	                Files.delete(dir);
	                return FileVisitResult.CONTINUE;
	            }
	            else
	            {
	                // directory iteration failed; propagate exception
	                throw exc;
	            }
	        }
	    });
	}
}
