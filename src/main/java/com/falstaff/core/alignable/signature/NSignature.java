package com.falstaff.core.alignable.signature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.ByteArrayCharSequence;
import com.falstaff.core.alignable.INLookupAlignable;
import com.falstaff.core.alignable.INSequenceAlignable;
import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.alignable.signature.pattern.Pattern.KtupTreeInfo;
import com.falstaff.core.alignable.signature.pattern.Pattern.TreeInfo;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.NArrayKtup;
import com.falstaff.core.score.Alphabet;
import com.falstaff.core.util.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import dk.brics.automaton.Automaton;

public class NSignature implements INLookupAlignable<IKtup> {
	
	//"baseFeatureSignatures", "pattern", "featureSignatures", "regularExpression", "supersetFeatureSignatures"
	
	private static final Logger log = LoggerFactory.getLogger(NSignature.class.getName());
	
	protected transient int id;
	protected transient KtupTreeInfo ktupTreeInfo;
	protected transient Pattern pattern;
	protected String regularExpression;
	protected Set<NSignature> featureSignatures;
	protected transient Automaton extendedAutomaton;

	@Override
	public int getId() {
		return id;
	}

	public NSignature() {
		super();
		setSignatureId();
	}

	public NSignature(Pattern pattern) {
		super();
		this.pattern = pattern;
		regularExpression = pattern.pattern();
		setSignatureId();
	}
	
	public NSignature(NSignature anotherSignature) {
		regularExpression = new String(anotherSignature.getRegularExpression());
		pattern = getPattern();
		Set<NSignature> anotherFeatureSignatures = anotherSignature.getFeatureSignatures(false);
		if (anotherFeatureSignatures != null) {
			featureSignatures = new HashSet<NSignature>();
			for (NSignature anotherFeatureSignature : anotherFeatureSignatures) {
				NSignature featureSignature = new NSignature(anotherFeatureSignature);
				featureSignatures.add(featureSignature);
			}
		}
		setSignatureId();
	}
		
	public void setSignatureId() {
		id = IdGenerator.getIdGenerator().getId(this.getClass().getName());
	}

	public class SignatureKtupIterator implements INKtupIterator<IKtup> {
		private final int length;
		private INKtupFilter<IKtup> filter;
		private List<IKtup> ktups;
		private Iterator<IKtup> ktupsIterator;
		private int maxKtups = 1;

		public SignatureKtupIterator(int length, INKtupFilter<IKtup> filter) {
			this.length = length;
			this.filter = filter;
			ktups = new ArrayList<IKtup>();
			if (getKtupTreeInfo().getMaxBuffer() != null) {
				for (int i = 0; i <= ktupTreeInfo.getMaxBuffer().length - length; i++) {
					if (ktups.size() >= maxKtups) {
						break;
					}
					IKtup ktup = getKtup(i, length);
					if (filter == null || !filter.filter(ktup)) {
						ktups.add(ktup);
					}
				}
			}
			ktupsIterator = ktups.iterator();
		}

		@Override
		public boolean hasNext() {
			return ktupsIterator.hasNext();
		}

		@Override
		public IKtup next() {
			return ktupsIterator.next();
		}

		@Override
		public void remove() {
			ktupsIterator.remove();
		}

		@Override
		public INKtupIterator<IKtup> copy() {
			return new SignatureKtupIterator(length, filter);
		}

		@Override
		public INKtupFilter<IKtup> getFilter() {
			return filter;
		}

		@Override
		public void setFilter(INKtupFilter<IKtup> filter) {
			this.filter = filter;
			while (ktupsIterator.hasNext()) {
				IKtup ktup = ktupsIterator.next();
				if (filter != null && filter.filter(ktup)) {
					ktupsIterator.remove();
				}
			}
			ktupsIterator = ktups.iterator();
		}
	}


	@Override
	public INKtupIterator<IKtup> ktupIterator(int ktupLength) {
		return ktupIterator(ktupLength, null);
	}

	@Override
	public INKtupIterator<IKtup> ktupIterator(int ktupLength,
			INKtupFilter<IKtup> filter) {
		return new SignatureKtupIterator(ktupLength, filter);
	}

	@Override
	public IKtup getKtup(int index, int length) {
		if (getKtupTreeInfo().getMaxBuffer() == null || index + length - 1 > ktupTreeInfo.getMaxBuffer().length) {
			return null;
		}
		NArrayKtup<NSignature> ktup = new NArrayKtup<NSignature>(index, length, this, ktupTreeInfo.getMaxBuffer());
		return ktup;
	}

	@JsonIgnore
	public Pattern getPattern() {
		if (pattern == null) {
			pattern = Pattern.compile(regularExpression, Pattern.DOTALL);
		}
		return pattern;
	}

	@JsonIgnore
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
		regularExpression = pattern.pattern();
		ktupTreeInfo = pattern.getKtupTreeInfo();
	}

	public void setRegularExpression(String regularExpression) {
		this.regularExpression = regularExpression;
	}

	@JsonIgnore
	public KtupTreeInfo getKtupTreeInfo() {
		if (ktupTreeInfo == null && getPattern() != null) {
			ktupTreeInfo = getPattern().getKtupTreeInfo();
		}
		return ktupTreeInfo;
	}
	
	public boolean align(IKtup<INSequenceAlignable> alignableKtup) {
		KtupTreeInfo info = getKtupTreeInfo();
		int signatureStart = Math.max(0, alignableKtup.getOffset() - info.getHeadMaxLength());
		int signatureEnd = Math.min(alignableKtup.getAlignable().length() - 1, alignableKtup.getOffset() + info.getMaxBuffer().length - 1 + info.getTailMaxLength());
		ByteArrayCharSequence charSequence = alignableKtup.getAlignable().charSequence(new Segment(signatureStart, signatureEnd - signatureStart + 1));
		boolean isAligned = getPattern().matcher(charSequence).find();
		return isAligned;
	}
	
	public boolean align(INSequenceAlignable alignable) {
		ByteArrayCharSequence charSequence = alignable.charSequence(new Segment(0, alignable.length()));
		boolean isAligned = getPattern().matcher(charSequence).find();
		return isAligned;
	}

	@Override
	public String toString() {
		return getPattern().toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime
				+ ((getPattern() == null) ? 0 : getPattern().pattern().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		NSignature other = (NSignature) obj;
		if (getPattern() == null) {
			if (other.getPattern() != null)
				return false;
		} else if (!getPattern().pattern().equals(other.getPattern().pattern()))
			return false;
		return true;
	}

	@JsonIgnore
	public Automaton getAutomaton() {
		Automaton automaton = pattern.getAutomaton();
		return automaton;
	}

	public boolean isSubSetOf(Automaton anotherExtendedAutomaton) {
		Automaton thisAutomaton = getAutomaton();
		return thisAutomaton.subsetOf(anotherExtendedAutomaton);
	}
	
	public boolean isEqvivalent(Automaton automaton) {
		return isSubSetOf(automaton) && automaton.subsetOf(getAutomaton());
	}
	
	public boolean isSubSetOf(NSignature signature) {
		return isSubSetOf(signature.getExtendedAutomaton());
	}
	
	public boolean isEqvivalent(NSignature signature) {
		return isEqvivalent(signature.getAutomaton());
	}
	
	public boolean intersectsWith(Automaton automaton) {
		Automaton thisAutomaton = getAutomaton();
		Automaton extendedAutomaton = getExtendedAutomaton();
		Automaton intersectionAutomaton = thisAutomaton.intersection(extendedAutomaton);
		return(!intersectionAutomaton.isEmpty());
	}
	
	public boolean intersectsWith(NSignature signature) {
		return intersectsWith(signature.getAutomaton());
	}
	
	public void addFeatureSignature(NSignature featureSignature) {
		if (featureSignatures == null) {
			featureSignatures = new HashSet<NSignature>();
		}
		featureSignatures.add(featureSignature);
	}
	
	public void addFeatureSignatureAll(Collection<NSignature> featureSignaturesToAdd) {
		if (featureSignaturesToAdd.size() == 0) {
			return;
		}
		if (featureSignatures == null) {
			featureSignatures = getFeatureSignatures(true);
		}
		featureSignatures.addAll(featureSignaturesToAdd);
	}

	public Set<NSignature> getFeatureSignatures(boolean initialize) {
		if (featureSignatures == null) {
			if (initialize) {
				featureSignatures= new HashSet<NSignature>();
				featureSignatures.addAll(getBaseFeatureSignatures());
			}
		}
		return featureSignatures;
	}
	
	public Set<NSignature> getFeatureSignatures() {
		return getFeatureSignatures(false);
	}

	public void setFeatureSignatures(Set<NSignature> featureSignatures) {
		this.featureSignatures = featureSignatures;
	}
	
	public void resetFeatureSignatures() {
		featureSignatures= new HashSet<NSignature>(getBaseFeatureSignatures());
	}
	
	@JsonIgnore
	public Set<NSignature> getBaseFeatureSignatures() {
		Set<NSignature> baseFeatureSignatures = new HashSet<NSignature>();
		// > 16
		String longAnyCharacter = "\\.(\\*|\\{\\d+\\,\\}|\\{(1[7-9]|[2-9]\\d|\\d\\d\\d+)\\}|\\{\\d+\\,(1[7-9]|[2-9]\\d|\\d\\d\\d+)\\})";
		String features[] = regularExpression.split(longAnyCharacter);
		for (String feature : features) {
			Pattern featurePattern = Pattern.compile(feature);
			if (featurePattern.getTreeInfo().getMaxLength() >= 2) {
				NSignature featuredSignature = new NSignature(featurePattern);
				baseFeatureSignatures.add(featuredSignature);
			}
		}		
		return baseFeatureSignatures;
	}
	
	public Set<NSignature> getSupersetFeatureSignatures(NSignature supersetSignature) {
		Set<NSignature> supersetFeatureSignatures = new HashSet<NSignature>();
		for (NSignature featureSignature : getFeatureSignatures(true)) {
			for (NSignature supersetFeatureSignature : supersetSignature.getFeatureSignatures(true)) {
				if (featureSignature.isSubSetOf(supersetFeatureSignature)) {
					log.info("feature signature " + featureSignature.toString() + " is subset of signature " + supersetFeatureSignature.toString());
					supersetFeatureSignatures.add(supersetFeatureSignature);
				}
			}
		}
		
		return supersetFeatureSignatures;
	}
	
	public void setSupersetFeatureSignatures(NSignature supersetSignature) {
		Set<NSignature> supersetFeatureSignatures = new HashSet<NSignature>();
		for (NSignature featureSignature : getFeatureSignatures(true)) {
			for (NSignature supersetFeatureSignature : supersetSignature.getFeatureSignatures(true)) {
				if (featureSignature.isSubSetOf(supersetFeatureSignature)) {
					supersetFeatureSignatures.add(new NSignature(supersetFeatureSignature.getPattern()));
				}
			}
		}
		
		getFeatureSignatures(true).addAll(supersetFeatureSignatures);
	}
	
	public void filterFeatureSignatures(Set<NSignature> filterSignatures) {
		Iterator<NSignature> iterator = getFeatureSignatures(true).iterator();
		while (iterator.hasNext()) {
			NSignature featureSignature = iterator.next();
		    if (!filterSignatures.contains(featureSignature)) {
		        iterator.remove();
		    }
		}
	}
	
	@JsonIgnore
	public int getMaxLength() {
		TreeInfo info = pattern.getTreeInfo();
		return info.getMaxLength();
	}
	
	@JsonIgnore
	public int getMinLength() {
		TreeInfo info = pattern.getTreeInfo();
		return info.getMinLength();
	}

	@JsonIgnore
	public Automaton getExtendedAutomaton() {
		Automaton automaton = getAutomaton();
		if (extendedAutomaton == null) {
			extendedAutomaton = Automaton.makeAnyString().concatenate(automaton.concatenate(Automaton.makeAnyString()));
			extendedAutomaton.determinize();
		}
		return extendedAutomaton;
	}
	
	public String getRegularExpression() {
		return regularExpression;
	}
	
	public boolean normalizeRegularExpression() {
		char chars[] = regularExpression.toCharArray();
		StringBuilder builder = new StringBuilder();
		boolean backslash = false;
		boolean normalized = false;
		for (int i = 0; i < chars.length; i++) {
			if (!backslash && chars[i] != '\\') {
				builder.append(chars[i]);
				continue;
			}
			if (!backslash && chars[i] == '\\') {
				backslash = true;
				builder.append(chars[i]);
				continue;
			}
			if (backslash && chars[i] == '\\') {
				backslash = false;
				builder.append(chars[i]);
				continue;
			}
			if (backslash && chars[i] != 'x') {
				backslash = false;
				builder.append(chars[i]);
				continue;
			}
			// \x
			backslash = false;
			if (i + 2 > chars.length - 1) {
				throw new RuntimeException("illegal chars sequence at the end of a regular expression " + regularExpression);
			}
			
			String originalHex = "" + chars[i + 1] + chars[i + 2];
			i += 2;
			String hex = originalHex.toUpperCase();
			String normalizedHex = Alphabet.byte2chars(Alphabet.hex2byte(hex));
			// append without \ as it was already appended
			builder.deleteCharAt(builder.length() - 1);
			builder.append(normalizedHex);
			if (!("\\x" + originalHex).equals(normalizedHex)) {
				normalized = true;
			}
		}
		
		String normalizedRegularExpression = builder.toString();
		normalized = (normalized || !regularExpression.equals(normalizedRegularExpression));
		if (normalized) {
			log.info("regular expression " + regularExpression + " was normalized " + normalizedRegularExpression);
			regularExpression = normalizedRegularExpression;
			getPattern();
			resetFeatureSignatures();
		}
		
		return normalized;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
