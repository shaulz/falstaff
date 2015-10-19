package com.falstaff.core.feature;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
	    @Type(value = NFileExtensionFeature.class, name = "nfileextensionfeature"),
	    @Type(value = NFileNameRegExpFeature.class, name = "nfilenameregexpfeature"),
	    @Type(value = NFileSizeFeature.class, name = "nfilesizefeature"),
	    @Type(value = NModificationDateFeature.class, name = "nmodificationdatefeature"),
	    @Type(value = NSignatureFeature.class, name = "nsignaturefeature"),
	    @Type(value = FileContentFeature.class, name = "nfilecontentfeature")
	    })
public interface IFeature {
	public String getName();
	public FeatureType getType();
	public String getValue();
	public void setName(String name);
}
