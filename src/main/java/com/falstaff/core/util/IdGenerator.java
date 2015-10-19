package com.falstaff.core.util;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

	private HashMap<String,AtomicInteger> ids;
	private static IdGenerator idGenerator;

	public synchronized static IdGenerator getIdGenerator() {
		if (idGenerator == null) {
			idGenerator = new IdGenerator();
		}
		return idGenerator;
	}

	private IdGenerator() {
		ids = new HashMap<String,AtomicInteger>();
	}

	public int getId(String className) {
		if (!ids.containsKey(className)) {
			ids.put(className, new AtomicInteger(1));
		}
		return ids.get(className).getAndIncrement();		
	}
}
