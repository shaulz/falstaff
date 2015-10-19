package com.falstaff.repository.ds;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlatDSFinder {
	
	private static final Logger log = LoggerFactory
	.getLogger(FlatDSFinder.class.getName());
	 
    /**
     * A {@code FileVisitor} that finds
     * all files that match the
     * specified pattern.
     */
    public static class Finder
        extends SimpleFileVisitor<Path> {
 
        private final PathMatcher matcher;
        private int numMatches = 0;
    	private List<File> paths = new LinkedList<File>();
    	
        Finder(String pattern) {
            matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + pattern);
        }
  
        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file,
                BasicFileAttributes attrs) {
            if (matcher.matches(file)) {
            	paths.add(file.toFile());
            }
            return CONTINUE;
        }
         
        @Override
        public FileVisitResult visitFileFailed(Path file,
                IOException exc) {
            log.error(exc.getMessage());
            return CONTINUE;
        }

		public List<File> getPaths() {
			return paths;
		}
        
    }
    
    static List<File> find(File root, String pattern) {
        Path startingDir = Paths.get(root.toURI()); 
        Finder finder = new Finder(pattern);
        try {
			Files.walkFileTree(startingDir, finder);
		} catch (IOException e) {
			log.error("failed to find files " + e.getMessage());
			return null;
		}
        List<File> paths = finder.getPaths();
    	return paths;
    }
    
    
}
