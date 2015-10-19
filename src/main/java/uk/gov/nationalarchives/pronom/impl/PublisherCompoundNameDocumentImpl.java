/*
 * An XML document type.
 * Localname: PublisherCompoundName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PublisherCompoundNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PublisherCompoundName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PublisherCompoundNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PublisherCompoundNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public PublisherCompoundNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PUBLISHERCOMPOUNDNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublisherCompoundName");
    
    
    /**
     * Gets the "PublisherCompoundName" element
     */
    public java.lang.String getPublisherCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PublisherCompoundName" element
     */
    public org.apache.xmlbeans.XmlString xgetPublisherCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PublisherCompoundName" element
     */
    public void setPublisherCompoundName(java.lang.String publisherCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLISHERCOMPOUNDNAME$0);
            }
            target.setStringValue(publisherCompoundName);
        }
    }
    
    /**
     * Sets (as xml) the "PublisherCompoundName" element
     */
    public void xsetPublisherCompoundName(org.apache.xmlbeans.XmlString publisherCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUBLISHERCOMPOUNDNAME$0);
            }
            target.set(publisherCompoundName);
        }
    }
}
