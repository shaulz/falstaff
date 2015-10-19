package com.falstaff.core.classification;

import java.util.Comparator;

public class FormatQuery {
	
	public enum FormatQueryOrderBy {
		name,
		date
	}
	
	public enum FormatQueryOrder {
		ascending,
		descending
	}
	
	public enum PendingQueue {
		update,
		create,
		delete,
		magic
	}

	private String name;
	private String extension;
	private String pronomId;
	private String fddId;
	private String mimeType;
	private Boolean pending;
	private PendingQueue pendingQueue;
	private FormatQueryOrderBy orderBy;
	private FormatQueryOrder order;
	
	public FormatQuery() {
		name = "";
		extension = "";
		pronomId = "";
		fddId = "";
		mimeType = "";
		pending = false;
		pendingQueue = PendingQueue.create;
		orderBy = FormatQueryOrderBy.name;
		order = FormatQueryOrder.ascending;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getPronomId() {
		return pronomId;
	}

	public void setPronomId(String pronomId) {
		this.pronomId = pronomId;
	}

	public String getFddId() {
		return fddId;
	}

	public void setFddId(String fddId) {
		this.fddId = fddId;
	}

	public FormatQueryOrderBy getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(FormatQueryOrderBy orderBy) {
		this.orderBy = orderBy;
	}

	public FormatQueryOrder getOrder() {
		return order;
	}

	public void setOrder(FormatQueryOrder order) {
		this.order = order;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Boolean getPending() {
		return pending;
	}

	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public PendingQueue getPendingQueue() {
		return pendingQueue;
	}

	public void setPendingQueue(PendingQueue pendingQueue) {
		this.pendingQueue = pendingQueue;
	}
	
	public class FormatQuerySort implements Comparator<FileFormat> {

		@Override
		public int compare(FileFormat arg0, FileFormat arg1) {
			int direction = 1;
			if (order.equals(FormatQueryOrder.descending)) {
				direction = -1;
			}
			if (orderBy.equals(FormatQueryOrderBy.name)) {
				return direction * arg0.getName().compareTo(arg1.getName());
			}
			if (orderBy.equals(FormatQueryOrderBy.date)) {
				return direction * arg0.getUpdateDate().compareTo(arg1.getUpdateDate());
			}
			
			return 0;
		}		
	}
}
