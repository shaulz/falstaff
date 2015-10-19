package com.falstaff.core.execution;

import java.util.Calendar;

public class ProcessMonitor implements IProcessMonitor {

	private int percentageCompleted;
	
	private String processName;
	
	private Calendar started;

	private ProcessStatus status;

	public ProcessMonitor() {
		started = Calendar.getInstance();
		status = ProcessStatus.STARTED;
		percentageCompleted = 0;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#getPercentageCompleted()
	 */
	@Override
	synchronized public int getPercentageCompleted() {
		return percentageCompleted;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#setPercentageCompleted(int)
	 */
	@Override
	synchronized public void setPercentageCompleted(int percentageCompleted) {
		this.percentageCompleted = percentageCompleted;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#getProcessName()
	 */
	@Override
	synchronized public String getProcessName() {
		return processName;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#setProcessName(java.lang.String)
	 */
	@Override
	synchronized public void setProcessName(String processName) {
		this.processName = processName;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#getStarted()
	 */
	@Override
	synchronized public Calendar getStarted() {
		return started;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#setStarted(java.util.Calendar)
	 */
	@Override
	synchronized public void setStarted(Calendar started) {
		this.status = ProcessStatus.STARTED;
		this.started = started;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#getStatus()
	 */
	@Override
	synchronized public ProcessStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.execution.IProcessMonitor#setStatus(com.falstaff.core.execution.ProcessStatus)
	 */
	@Override
	synchronized public void setStatus(ProcessStatus status) {
		this.status = status;
	}
	
}
