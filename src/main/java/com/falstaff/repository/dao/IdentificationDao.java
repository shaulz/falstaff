package com.falstaff.repository.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.IdentificationBatch;

@Component
public class IdentificationDao implements Converter<String, IdentificationBatch> {
	
	private static final Logger log = LoggerFactory
			.getLogger(IdentificationDao.class.getName());
	
	private Map<Long, IdentificationBatch> identifications;
	private ReentrantReadWriteLock idetificationsLock = new ReentrantReadWriteLock();

	@Value("${falstaff.core.dao.identification_keep_period}")
	private int identificationKeepPeriod;
	
	@PostConstruct
	public void init() {
		identifications = new HashMap<Long, IdentificationBatch>();
		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, identificationKeepPeriod); // Create Repetitively task for every identificationKeepPeriod millisecs
	}
	
	public class ScheduledTask extends TimerTask {
		 
		public void run() {
			long now = Calendar.getInstance().getTimeInMillis();
			idetificationsLock.writeLock().lock();
			try {
				Set<Long> ids = new HashSet<Long>(identifications.keySet());
				for (Long id : ids) {
					long created = identifications.get(id).getCreated().getTimeInMillis();
					if (now - created > identificationKeepPeriod) {
						identifications.remove(id);
						log.info("identification with id " + id + " deleted after " + (now - created) / 60000 + " minutes");
					}
				}
			}
			finally {
				idetificationsLock.writeLock().unlock();
			}
		}
	}
	
	public void saveIdentification(IdentificationBatch identification) {
		idetificationsLock.writeLock().lock();
		try {
			identifications.put(identification.getId(), identification);
			log.info("identification with id " + identification.getId() + " will be available for " + identificationKeepPeriod / 60000 + " minutes");
		}
		finally {
			idetificationsLock.writeLock().unlock();
		}
	}
	
	public IdentificationBatch readIdentification(long id) {
		idetificationsLock.readLock().lock();
		try {
			return identifications.get(id);
		}
		finally {
			idetificationsLock.readLock().unlock();
		}
	}

	@Override
	public IdentificationBatch convert(String id) {
		return readIdentification(new Long(id));
	}
}
