package com.falstaff.crawler;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

import com.falstaff.core.classification.FeaturedSamplesSet;

public class LocalRecursiveSamplesDownloader implements ILocalSamplesDownloader {

	private FeaturedSamplesSet samplesSet;
	private String folder;
	private boolean filterExtensions = true;
		
	public LocalRecursiveSamplesDownloader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalRecursiveSamplesDownloader(FeaturedSamplesSet samplesSet) {
		super();
		this.samplesSet = samplesSet;
	}
	
	public void copy(String sourceDir, String targetDir) throws IOException {

	    abstract class MyFileVisitor implements FileVisitor<Path> {
	    	protected Path fromPath;
	        protected Path toPath;
	    }

	    MyFileVisitor copyVisitor = new MyFileVisitor() {

	        @Override
	        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	            Path targetPath = toPath.resolve(fromPath.relativize(dir));
	            if(!Files.exists(targetPath)){
	                Files.createDirectory(targetPath);
	            }
	            return FileVisitResult.CONTINUE;
	        }

	        @Override
	        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	        	if (filterExtensions) {
	        		String fileName = file.getFileName().toString();
	        		boolean extensionFound = false;
	        		for (String extension : samplesSet.getFormat().getOntology().getExtensions()) {
	        			if (fileName.endsWith(extension)) {
	        				extensionFound = true;
	        				break;
	        			}
	        		}
	        		if (!extensionFound && samplesSet.getFormat().getOntology().getExtensions().size() > 0) {
	        			return FileVisitResult.CONTINUE;
	        		}
	        	}
	        	
	            Files.copy(file, toPath.resolve(fromPath.relativize(file)), StandardCopyOption.COPY_ATTRIBUTES);
	            return FileVisitResult.CONTINUE;
	        }

	        @Override
	        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
	            throw exc;
	        }

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				return FileVisitResult.CONTINUE;
			}

	    };

	    copyVisitor.toPath = Paths.get(targetDir);
	    copyVisitor.fromPath = Paths.get(sourceDir);
	    Files.walkFileTree(Paths.get(sourceDir), copyVisitor);
	}
	@Override
	public void download() throws IOException {
		copy(folder, samplesSet.getFolder());
	}

	@Override
	public FeaturedSamplesSet getSamplesSet() {
		return samplesSet;
	}

	@Override
	public void setSamplesSet(FeaturedSamplesSet samplesSet) {
		this.samplesSet = samplesSet;
	}

	@Override
	public void setFolder(String folder) {
		this.folder = folder;
	}

	@Override
	public String getFolder() {
		return folder;
	}

	@Override
	public boolean isFilterExtensions() {
		return filterExtensions;
	}

	@Override
	public void setFilterExtensions(boolean filterExtensions) {
		this.filterExtensions = filterExtensions;
	}

}
