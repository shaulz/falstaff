/*
 * An XML document type.
 * Localname: PublisherID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PublisherIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PublisherID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PublisherIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PublisherIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public PublisherIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PUBLISHERID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublisherID");
    
    
    /**
     * Gets the "PublisherID" element
     */
    public short getPublisherID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "PublisherID" element
     */
    public org.apache.xmlbeans.XmlShort xgetPublisherID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(PUBLISHERID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PublisherID" element
     */
    public void setPublisherID(short publisherID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLISHERID$0);
            }
            target.setShortValue(publisherID);
        }
    }
    
    /**
     * Sets (as xml) the "PublisherID" element
     */
    public void xsetPublisherID(org.apache.xmlbeans.XmlShort publisherID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(PUBLISHERID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(PUBLISHERID$0);
            }
            target.set(publisherID);
        }
    }
}
