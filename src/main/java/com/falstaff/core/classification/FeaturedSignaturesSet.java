package com.falstaff.core.classification;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.execution.IProcessMonitor;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.maxent.Datum;
import com.falstaff.core.util.IdGenerator;

public class FeaturedSignaturesSet implements IDatumSource, IProcessMonitor {

	@NotEmpty(message = "Name is required.")
	protected String name;
	@NotNull(message = "Source is required.")
	protected SignaturesSource source;
	protected List<FeaturedSignature> signatures;
	protected String description;
	protected FileFormat format;
	protected Calendar created;
	protected Calendar updated;
	transient protected ProcessMonitor processMonitor = null;
	protected transient int id;

	public int getId() {
		return id;
	}

	public void setId() {
		id = IdGenerator.getIdGenerator().getId(FeaturedSignaturesSet.class.getName());
	}
		
	public void setId(int id) {
		this.id = id;
	}

	public FeaturedSignaturesSet() {
		super();
		source = SignaturesSource.ARCHIVETEAM;
		signatures = new LinkedList<FeaturedSignature>();
	}
	
	public FeaturedSignaturesSet(String name, FileFormat format) {
		this.name = name;
		this.source = SignaturesSource.ARCHIVETEAM;
		this.format = format;
		signatures = new LinkedList<FeaturedSignature>();
		setId();
	}

	public FeaturedSignaturesSet(String name, SignaturesSource source, List<NSignature> signatures,
			FileFormat format) {
		super();
		this.name = name;
		this.source = source;
		this.format = format;
		this.signatures = new LinkedList<FeaturedSignature>();
		created = Calendar.getInstance();
		updated = created;
		for (NSignature signature : signatures) {
			FeaturedSignature featuredSignature = new FeaturedSignature(signature, this);
			this.signatures.add(featuredSignature);
		}
		setId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileFormat getFormat() {
		return format;
	}

	public void setFormat(FileFormat format) {
		this.format = format;
	}

	public SignaturesSource getSource() {
		return source;
	}

	public List<FeaturedSignature> getSignatures() {
		return signatures;
	}
	
	public FeaturedSignature getSignature(int signatureId) {
		if (signatures == null) {
			return null;
		}
		for (FeaturedSignature signature : signatures) {
			if (signature.getId() == signatureId) {
				return signature;
			}
		}
		return null;
	}
	
	public void addSignature(FeaturedSignature signature) {
		signature.getSignature().normalizeRegularExpression();
		signature.getSignature().resetFeatureSignatures();
		signature.setSignaturesSet(this);
		signatures.add(signature);
	}
	
	public void clearSignature(int signatureId) {
		if (signatures == null) {
			return;
		}
		for (int i = 0; i < signatures.size(); i++) {
			if (signatures.get(i).getId() == signatureId) {
				signatures.remove(i);
				break;
			}
		}
		return;
	}
	
	public Long getIndex() {
		for (int i = 0; i < format.getSignatures().size(); i++) {
			if (format.getSignatures().get(i).getName().equals(name)) {
				return (long) i;
			}
		}
		return null;		
	}

	public Calendar getUpdated() {
		return updated;
	}

	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setSignatures(List<FeaturedSignature> signatures) {
		this.signatures = signatures;
	}
	
	public void addSignatures(Set<NSignature> signatures) {
		for (NSignature signature : signatures) {
			FeaturedSignature featuredSignature = new FeaturedSignature(signature, this);
			addSignature(featuredSignature);
		}
	}

	public void setSource(SignaturesSource source) {
		this.source = source;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public String getDescription() {
		if (description == null || description.isEmpty()) {
			return "signatures created manually";
		}
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<Datum> getDatum(int simulatedFeaturesNumber) {
		List<Datum> datums = new LinkedList<Datum>();
		for (FeaturedSignature signature : signatures) {
			datums.addAll(signature.getDatum(simulatedFeaturesNumber));
		}
		return datums;
	}

	public ProcessMonitor getProcessMonitor() {
		return processMonitor;
	}

	public void setProcessMonitor(ProcessMonitor processMonitor) {
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
	
	public void test() {
		for (FeaturedSignature signature : signatures) {
			signature.test();
		}
	}

	public Boolean isMissClassified() {
		if (signatures == null) {
			return false;
		}
		
		Boolean missClassified = false;
		
		for (FeaturedSignature signature : signatures) {
			Boolean signatureMissClassified = signature.isMissClassified();
			if (signatureMissClassified == null) {
				return null;
			}
			if (signatureMissClassified) {
				missClassified = true;
			}
		}
		
		return missClassified;
	}
	
	public void setSimulatedSamples() {
		for (FeaturedSignature signature : signatures) {
			signature.setSimulatedSamples();
		}
	}
	
	public String getURL() {
		return null;
	}
	
	public String getURLName() {
		return null;
	}
	
	public String getURLDescription() {
		return null;
	}
}
