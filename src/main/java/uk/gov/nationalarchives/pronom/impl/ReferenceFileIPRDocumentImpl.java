/*
 * An XML document type.
 * Localname: ReferenceFileIPR
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileIPRDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFileIPR(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileIPRDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileIPRDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileIPRDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILEIPR$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileIPR");
    
    
    /**
     * Gets the "ReferenceFileIPR" element
     */
    public java.lang.String getReferenceFileIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEIPR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReferenceFileIPR" element
     */
    public org.apache.xmlbeans.XmlString xgetReferenceFileIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEIPR$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFileIPR" element
     */
    public void setReferenceFileIPR(java.lang.String referenceFileIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEIPR$0);
            }
            target.setStringValue(referenceFileIPR);
        }
    }
    
    /**
     * Sets (as xml) the "ReferenceFileIPR" element
     */
    public void xsetReferenceFileIPR(org.apache.xmlbeans.XmlString referenceFileIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILEIPR$0);
            }
            target.set(referenceFileIPR);
        }
    }
}
