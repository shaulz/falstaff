package com.falstaff.service;

import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.crawler.ILocalSamplesDownloader;
import com.falstaff.crawler.IRemoteSamplesDownloader;
import com.falstaff.crawler.RemoteSamplesDownloader;
import com.falstaff.repository.dao.FeaturedSamplesSetDao;
import com.falstaff.repository.dao.FileFormatDao;

@Component
public class AsyncSamplesDownloader {

	private static final Logger log = LoggerFactory
			.getLogger(AsyncSamplesDownloader.class.getName());

	@Autowired
	FeaturedSamplesSetDao featuredSamplesSetDao;

	@Async
	public void downloadRemote(IRemoteSamplesDownloader downloader)
			throws IOException {
		try {
			downloader.getSamplesSet().getRwl().writeLock().lock();
			downloader.download();
			downloader.getSamplesSet().setSamples();
			downloader.getSamplesSet().setUpdated(Calendar.getInstance());
			featuredSamplesSetDao.save(downloader.getSamplesSet());
			log.info("download of url " + downloader.getUrl()
					+ " of samples set " + downloader.getSamplesSet().getName()
					+ " completed successfully");
			downloader.getSamplesSet().getProcessMonitor()
					.setStatus(ProcessStatus.FINISHED);
		} catch (Exception e) {
			downloader.getSamplesSet().getProcessMonitor()
					.setStatus(ProcessStatus.FINISHED);
			log.error("download of url " + downloader.getUrl()
					+ " of samples set " + downloader.getSamplesSet().getName()
					+ " failed " + e);
		} finally {
			downloader.getSamplesSet().getRwl().writeLock().unlock();
		}
	}

	@Async
	public void downloadLocalRecursive(ILocalSamplesDownloader downloader)
			throws IOException {
		try {
			downloader.getSamplesSet().getRwl().writeLock().lock();
			downloader.download();
			downloader.getSamplesSet().setSamples();
			downloader.getSamplesSet().setUpdated(Calendar.getInstance());
			featuredSamplesSetDao.save(downloader.getSamplesSet());
			log.info("download of folder " + downloader.getFolder()
					+ " of samples set " + downloader.getSamplesSet().getName()
					+ " completed successfully");
			downloader.getSamplesSet().getProcessMonitor()
					.setStatus(ProcessStatus.FINISHED);
		} catch (Exception e) {
			downloader.getSamplesSet().getProcessMonitor()
					.setStatus(ProcessStatus.FINISHED);
			log.error("download of folder " + downloader.getFolder()
					+ " of samples set " + downloader.getSamplesSet().getName()
					+ " failed " + e);
		} finally {
			downloader.getSamplesSet().getRwl().writeLock().unlock();
		}
	}

}
