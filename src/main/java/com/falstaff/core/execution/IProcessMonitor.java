package com.falstaff.core.execution;

import java.util.Calendar;

public interface IProcessMonitor {

	public int getPercentageCompleted();

	public void setPercentageCompleted(int percentageCompleted);

	public String getProcessName();

	public void setProcessName(String processName);

	public Calendar getStarted();

	public void setStarted(Calendar started);

	public ProcessStatus getStatus();

	public void setStatus(ProcessStatus status);

}