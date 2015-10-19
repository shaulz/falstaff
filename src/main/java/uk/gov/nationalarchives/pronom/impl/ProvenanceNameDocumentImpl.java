/*
 * An XML document type.
 * Localname: ProvenanceName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ProvenanceNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ProvenanceName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ProvenanceNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ProvenanceNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProvenanceNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROVENANCENAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceName");
    
    
    /**
     * Gets the "ProvenanceName" element
     */
    public java.lang.String getProvenanceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProvenanceName" element
     */
    public org.apache.xmlbeans.XmlString xgetProvenanceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ProvenanceName" element
     */
    public void setProvenanceName(java.lang.String provenanceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCENAME$0);
            }
            target.setStringValue(provenanceName);
        }
    }
    
    /**
     * Sets (as xml) the "ProvenanceName" element
     */
    public void xsetProvenanceName(org.apache.xmlbeans.XmlString provenanceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROVENANCENAME$0);
            }
            target.set(provenanceName);
        }
    }
}
