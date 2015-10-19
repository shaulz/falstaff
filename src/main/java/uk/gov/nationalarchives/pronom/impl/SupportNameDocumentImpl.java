/*
 * An XML document type.
 * Localname: SupportName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SupportNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SupportName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SupportNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SupportNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public SupportNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SUPPORTNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SupportName");
    
    
    /**
     * Gets the "SupportName" element
     */
    public java.lang.String getSupportName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SupportName" element
     */
    public org.apache.xmlbeans.XmlString xgetSupportName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SupportName" element
     */
    public void setSupportName(java.lang.String supportName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUPPORTNAME$0);
            }
            target.setStringValue(supportName);
        }
    }
    
    /**
     * Sets (as xml) the "SupportName" element
     */
    public void xsetSupportName(org.apache.xmlbeans.XmlString supportName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUPPORTNAME$0);
            }
            target.set(supportName);
        }
    }
}
