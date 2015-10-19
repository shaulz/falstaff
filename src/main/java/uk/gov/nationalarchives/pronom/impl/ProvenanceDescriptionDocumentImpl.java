/*
 * An XML document type.
 * Localname: ProvenanceDescription
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ProvenanceDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ProvenanceDescription(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ProvenanceDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ProvenanceDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProvenanceDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROVENANCEDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceDescription");
    
    
    /**
     * Gets the "ProvenanceDescription" element
     */
    public java.lang.String getProvenanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCEDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProvenanceDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetProvenanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCEDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ProvenanceDescription" element
     */
    public void setProvenanceDescription(java.lang.String provenanceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCEDESCRIPTION$0);
            }
            target.setStringValue(provenanceDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ProvenanceDescription" element
     */
    public void xsetProvenanceDescription(org.apache.xmlbeans.XmlString provenanceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROVENANCEDESCRIPTION$0);
            }
            target.set(provenanceDescription);
        }
    }
}
