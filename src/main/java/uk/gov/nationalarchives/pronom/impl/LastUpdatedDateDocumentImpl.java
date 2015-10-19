/*
 * An XML document type.
 * Localname: LastUpdatedDate
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.LastUpdatedDateDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one LastUpdatedDate(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class LastUpdatedDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.LastUpdatedDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public LastUpdatedDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LASTUPDATEDDATE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "LastUpdatedDate");
    
    
    /**
     * Gets the "LastUpdatedDate" element
     */
    public java.lang.String getLastUpdatedDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTUPDATEDDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "LastUpdatedDate" element
     */
    public org.apache.xmlbeans.XmlString xgetLastUpdatedDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTUPDATEDDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "LastUpdatedDate" element
     */
    public void setLastUpdatedDate(java.lang.String lastUpdatedDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTUPDATEDDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LASTUPDATEDDATE$0);
            }
            target.setStringValue(lastUpdatedDate);
        }
    }
    
    /**
     * Sets (as xml) the "LastUpdatedDate" element
     */
    public void xsetLastUpdatedDate(org.apache.xmlbeans.XmlString lastUpdatedDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTUPDATEDDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LASTUPDATEDDATE$0);
            }
            target.set(lastUpdatedDate);
        }
    }
}
