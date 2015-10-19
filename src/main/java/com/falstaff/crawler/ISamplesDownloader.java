package com.falstaff.crawler;

import java.io.IOException;

import com.falstaff.core.classification.FeaturedSamplesSet;

public interface ISamplesDownloader {
	public void download() throws IOException;
	public FeaturedSamplesSet getSamplesSet();
	public void setSamplesSet(FeaturedSamplesSet samplesSet);
}