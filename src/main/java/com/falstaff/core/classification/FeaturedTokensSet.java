package com.falstaff.core.classification;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.execution.IProcessMonitor;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.core.maxent.Datum;
import com.falstaff.core.util.IdGenerator;

public class FeaturedTokensSet implements IProcessMonitor {

	@NotEmpty(message = "Name is required.")
	protected String name;
	protected String description;
	protected FileFormat format;
	protected Calendar created;
	protected Calendar updated;
	protected Set<TokenFeature> tokens;
	protected transient int id;
	protected transient ProcessMonitor processMonitor = null;
	
	public FeaturedTokensSet() {
		tokens = new HashSet<TokenFeature>();
	}

	public FeaturedTokensSet(String name, FileFormat format) {
		super();
		this.name = name;
		this.format = format;
		created = Calendar.getInstance();
		updated = created;
		setId();
	}

	public FeaturedTokensSet(String name, Collection<TokenFeature> tokens,
			FileFormat format) {
		this(name, format);
		this.tokens = new HashSet<TokenFeature>(tokens);
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = IdGenerator.getIdGenerator().getId(FeaturedTokensSet.class.getName());
	}
		
	public void setId(int id) {
		this.id = id;
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

	public Calendar getUpdated() {
		return updated;
	}

	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public String getDescription() {
		if (description == null || description.isEmpty()) {
			return "token features created manually";
		}
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Set<TokenFeature> getTokens() {
		return tokens;
	}


	public void setTokens(Collection<TokenFeature> featuredTokens) {
		tokens = new HashSet<TokenFeature>(featuredTokens);
		for (TokenFeature token : tokens) {
			token.setFeaturedTokensSet(this);
		}
		updated = Calendar.getInstance();
	}

	public ProcessMonitor getProcessMonitor() {
		return processMonitor;
	}
	
	public TokenFeature getTokenFeature(int tokenFeatureId) {
		if (tokens == null) {
			return null;
		}
		for (TokenFeature token : tokens) {
			if (token.getId() == tokenFeatureId) {
				return token;
			}
		}
		return null;
	}
	
	public void addTokenFeature(TokenFeature tokenFeature) {
		tokens.add(tokenFeature);
		tokenFeature.setFeaturedTokensSet(this);
		updated = Calendar.getInstance();
	}
	
	public void clearTokenFeature(int tokenFeatureId) {
		if (tokens == null) {
			return;
		}
		
		Iterator<TokenFeature> iterator = tokens.iterator();
		while (iterator.hasNext()) {
			TokenFeature tokenFeature = iterator.next();
			if (tokenFeature.getId() == tokenFeatureId) {
				iterator.remove();
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
	
	public FeaturedSamplesSet getSamplesSet() {
		return format.getSamplesSet(name);
	}

}
