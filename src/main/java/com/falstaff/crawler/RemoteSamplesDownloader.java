package com.falstaff.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSample;

public class RemoteSamplesDownloader implements IRemoteSamplesDownloader {
	
	private String url;
	private FeaturedSamplesSet samplesSet;
	private boolean robots = true;
	private boolean archives = true;
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(RemoteSamplesDownloader.class.getName());
	
	public RemoteSamplesDownloader() {
		super();
	}

	public RemoteSamplesDownloader(FeaturedSamplesSet samplesSet) {
		super();
		this.samplesSet = samplesSet;
	}

	public RemoteSamplesDownloader(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public FeaturedSamplesSet getSamplesSet() {
		return samplesSet;
	}

	public void setSamplesSet(FeaturedSamplesSet samplesSet) {
		this.samplesSet = samplesSet;
	}

	public boolean isRobots() {
		return robots;
	}

	public void setRobots(boolean robots) {
		this.robots = robots;
	}

	public boolean isArchives() {
		return archives;
	}

	public void setArchives(boolean archives) {
		this.archives = archives;
	}



	public class ExtensionFileFilter implements FileFilter {
		
		Set<String> extensions;

	    private ExtensionFileFilter(Set<String> extensions) {
			super();
			this.extensions = extensions;
		}

		@Override
	    public boolean accept(File pathname) {
			for (String extension : extensions) {
				if( pathname.getName().toLowerCase().endsWith(extension) ) {
					return true;
				}
			}
	        return false;
	    }
	}
	
	public static class DirFilter implements FileFilter {

	    @Override
	    public boolean accept(File pathname) {
	        if( pathname.isDirectory() ) 
	            return true;

	        return false;
	    }

	}
	
	/* (non-Javadoc)
	 * @see com.falstaff.crawler.ISamplesDownloader#download()
	 */
	@Override
	public void download() throws IOException {
		String fullName = FilenameUtils.separatorsToUnix(samplesSet.getFolder()).replaceFirst("^(\\w):", "/cygdrive/$1/");
		List<File> files = download(url, fullName, samplesSet.getFormat().getOntology().getExtensions());
	}
	
	private List<File> download(String url, String fullName, Set<String> extensions) {
		// construct wget command
		List<String> command = new ArrayList<String>();
		String bashCommand = "C:\\cygwin\\bin\\bash ";
		command.add(bashCommand);
		command.add("-l");
		command.add("-c");
		String commandName = "wget_bash.sh";
		if (!archives) {
			commandName = "wget_bash_no_zip.sh";
		}
		String bashArguments = " /cygdrive/f/fileformats/" + commandName
		+ " '" + fullName
		+ "' ";
		boolean first = true;
		for (String extension : extensions) {
			bashArguments = bashArguments + (first? "" : ",") + extension.toLowerCase() + ',' + extension.toUpperCase();
			first = false;
		}
		bashArguments = bashArguments + " " + url;
		if (robots) {
			bashArguments += " robots";
		}
		log.info("bash command:\n" + bashCommand + "\nwget command:\n" + bashArguments);
				
		command.add(bashArguments);
		
		File fullPath = new File(fullName);

		List<File> filesBefore = listFiles(fullPath, extensions, false);

		runExternal(command);
		
		List<File> files = listFiles(fullPath, extensions, false);
		
		files.removeAll(filesBefore);
		
		if (files.size() == 0) {
			log.warn("url " + url + " produced no files");
		}
		else {
			log.info("url " + url + " produced some " + files.size() + " files");
		}

		return files;
	}
	
	public List<File> listFiles(File rootDir, Set<String> extensions, boolean recursive) {
		FileFilter filter = new ExtensionFileFilter(extensions);
	    List<File> result = new ArrayList<File>();
	    if( !rootDir.exists() || !rootDir.isDirectory() ) 
	        return result;

	    //Add all files that comply with the given filter
	    File[] files = rootDir.listFiles(filter);
	    for( File f : files) {
	        if( !result.contains(f) )
	            result.add(f);
	    }

	    //Recurse through all available dirs if we are scanning recursively
	    if( recursive ) {
	        File[] dirs = rootDir.listFiles(new DirFilter());
	        for( File f : dirs ) {
	            if( f.canRead() ) {
	                result.addAll(listFiles(f, extensions, recursive));
	            }
	        }
	    }

	    return result;
	}
	
	public int runExternal(List<String> command) {

		ProcessBuilder probuilder = new ProcessBuilder(command);
		// You can set up your work directory
		probuilder.directory(new File("f:\\fileformats\\archiveteam"));
		probuilder.redirectErrorStream(true);
		try {
			Process process = probuilder.start();

			// Read out dir output
			String line;
			/*
			InputStream es = process.getErrorStream();
			InputStreamReader esr = new InputStreamReader(es);
			BufferedReader ebr = new BufferedReader(esr);
			log.info("stderr of running " + command + " is:\n");
			while ((line = ebr.readLine()) != null) {
				log.info(line);
			}
			*/
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			log.info("stdout of running " + command + " is:\n");
			while ((line = br.readLine()) != null) {
				log.info(line);
			}
			

			// Wait to get exit value
			int exitValue = process.waitFor();
			return exitValue;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("run of command " + command.toString() + " failed "
					+ e.getMessage());
		} 
		
		return -1;
	}

}
