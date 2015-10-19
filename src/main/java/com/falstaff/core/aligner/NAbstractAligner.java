package com.falstaff.core.aligner;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INContinuousAlignable;
import com.falstaff.core.alignable.INLookupAlignable;
import com.falstaff.core.execution.IProcessMonitor;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;

public abstract class NAbstractAligner<From extends INLookupAlignable,To extends INLookupAlignable> implements IProcessMonitor {
	
	private static final Logger log = LoggerFactory.getLogger(NAbstractAligner.class.getName());

	protected NAbstractAligner next = null;
	protected int alignedCount = 0;
	protected boolean clearAfterTransform = true;
	protected IProcessMonitor processMonitor;

	public Collection<INLookupAlignable> transform(Collection<? extends From> alignables) {
		if (processMonitor != null) {
			setPercentageCompleted(0);
			setStatus(ProcessStatus.PROCESS_STARTED);
			setProcessName(getName());
		}
		Collection<? extends To> transformed = transformInternal(alignables);
		if (log.isInfoEnabled()) {
			log.info(this.getClass().getSimpleName() + " transform done");
		}
		List<INLookupAlignable> abstractAlignables = new LinkedList<INLookupAlignable>();
		if (processMonitor != null) {
			setPercentageCompleted(100);
			setStatus(ProcessStatus.PROCESS_FINISHED);
		}
		if (next != null) {
			abstractAlignables.addAll(next.transform(transformed));
		} else {
			abstractAlignables.addAll(transformed);
		}
		alignedCount += alignables.size();
		if (clearAfterTransform) {
			clear();
		}
		return abstractAlignables;
	}

	public boolean isClearAfterTransform() {
		return clearAfterTransform;
	}

	public void setCleanAfterTransform(boolean cleanAfterTransform) {
		this.clearAfterTransform = cleanAfterTransform;
	}

	public abstract Collection<? extends To> transformInternal(Collection<? extends From> alignables);
	
	public abstract void clear();
	
	public abstract String getName();
	
	public void setNext(NAbstractAligner next) {
		this.next = next;
	}

	public IProcessMonitor getProcessMonitor() {
		return processMonitor;
	}

	public void setProcessMonitor(IProcessMonitor processMonitor) {
		this.processMonitor = processMonitor;
	}

	public int getPercentageCompleted() {
		return processMonitor.getPercentageCompleted();
	}

	public void setPercentageCompleted(int percentageCompleted) {
		processMonitor.setPercentageCompleted(percentageCompleted);
	}

	public String getProcessName() {
		return processMonitor.getProcessName();
	}

	public void setProcessName(String processName) {
		processMonitor.setProcessName(processName);
	}

	public Calendar getStarted() {
		return processMonitor.getStarted();
	}

	public void setStarted(Calendar started) {
		processMonitor.setStarted(started);
	}

	public ProcessStatus getStatus() {
		return processMonitor.getStatus();
	}

	public void setStatus(ProcessStatus status) {
		processMonitor.setStatus(status);
	}
		
}