/*
 * An XML document type.
 * Localname: ProvenanceSourceDate
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ProvenanceSourceDateDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ProvenanceSourceDate(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ProvenanceSourceDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ProvenanceSourceDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProvenanceSourceDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROVENANCESOURCEDATE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceSourceDate");
    
    
    /**
     * Gets the "ProvenanceSourceDate" element
     */
    public java.lang.String getProvenanceSourceDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProvenanceSourceDate" element
     */
    public org.apache.xmlbeans.XmlString xgetProvenanceSourceDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCESOURCEDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ProvenanceSourceDate" element
     */
    public void setProvenanceSourceDate(java.lang.String provenanceSourceDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCESOURCEDATE$0);
            }
            target.setStringValue(provenanceSourceDate);
        }
    }
    
    /**
     * Sets (as xml) the "ProvenanceSourceDate" element
     */
    public void xsetProvenanceSourceDate(org.apache.xmlbeans.XmlString provenanceSourceDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCESOURCEDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROVENANCESOURCEDATE$0);
            }
            target.set(provenanceSourceDate);
        }
    }
}
