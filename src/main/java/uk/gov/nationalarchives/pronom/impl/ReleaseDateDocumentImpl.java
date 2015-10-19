/*
 * An XML document type.
 * Localname: ReleaseDate
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReleaseDateDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReleaseDate(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReleaseDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReleaseDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReleaseDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RELEASEDATE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReleaseDate");
    
    
    /**
     * Gets the "ReleaseDate" element
     */
    public java.lang.String getReleaseDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReleaseDate" element
     */
    public org.apache.xmlbeans.XmlString xgetReleaseDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReleaseDate" element
     */
    public void setReleaseDate(java.lang.String releaseDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELEASEDATE$0);
            }
            target.setStringValue(releaseDate);
        }
    }
    
    /**
     * Sets (as xml) the "ReleaseDate" element
     */
    public void xsetReleaseDate(org.apache.xmlbeans.XmlString releaseDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELEASEDATE$0);
            }
            target.set(releaseDate);
        }
    }
}
