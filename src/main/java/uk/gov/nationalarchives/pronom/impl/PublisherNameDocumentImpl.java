/*
 * An XML document type.
 * Localname: PublisherName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PublisherNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PublisherName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PublisherNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PublisherNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public PublisherNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PUBLISHERNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublisherName");
    
    
    /**
     * Gets the "PublisherName" element
     */
    public java.lang.String getPublisherName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PublisherName" element
     */
    public org.apache.xmlbeans.XmlString xgetPublisherName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PublisherName" element
     */
    public void setPublisherName(java.lang.String publisherName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLISHERNAME$0);
            }
            target.setStringValue(publisherName);
        }
    }
    
    /**
     * Sets (as xml) the "PublisherName" element
     */
    public void xsetPublisherName(org.apache.xmlbeans.XmlString publisherName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUBLISHERNAME$0);
            }
            target.set(publisherName);
        }
    }
}
