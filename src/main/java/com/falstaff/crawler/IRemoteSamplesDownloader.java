package com.falstaff.crawler;

public interface IRemoteSamplesDownloader extends ISamplesDownloader {
	public String getUrl();
	public void setUrl(String url);
	public boolean isRobots();
	public void setRobots(boolean robots);
	public boolean isArchives();
	public void setArchives(boolean archives);
}
