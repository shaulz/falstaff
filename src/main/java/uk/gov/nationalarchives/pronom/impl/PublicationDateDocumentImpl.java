/*
 * An XML document type.
 * Localname: PublicationDate
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PublicationDateDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PublicationDate(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PublicationDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PublicationDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public PublicationDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PUBLICATIONDATE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublicationDate");
    
    
    /**
     * Gets the "PublicationDate" element
     */
    public java.lang.String getPublicationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLICATIONDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PublicationDate" element
     */
    public org.apache.xmlbeans.XmlString xgetPublicationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLICATIONDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PublicationDate" element
     */
    public void setPublicationDate(java.lang.String publicationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLICATIONDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLICATIONDATE$0);
            }
            target.setStringValue(publicationDate);
        }
    }
    
    /**
     * Sets (as xml) the "PublicationDate" element
     */
    public void xsetPublicationDate(org.apache.xmlbeans.XmlString publicationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLICATIONDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUBLICATIONDATE$0);
            }
            target.set(publicationDate);
        }
    }
}
