package com.falstaff.crawler;

public interface ILocalSamplesDownloader extends ISamplesDownloader {
	void setFolder(String folder);
	String getFolder();
	boolean isFilterExtensions();
	void setFilterExtensions(boolean filterExtensions);
}
