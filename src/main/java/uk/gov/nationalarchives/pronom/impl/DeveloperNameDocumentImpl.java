/*
 * An XML document type.
 * Localname: DeveloperName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DeveloperNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DeveloperName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DeveloperNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DeveloperNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public DeveloperNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEVELOPERNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DeveloperName");
    
    
    /**
     * Gets the "DeveloperName" element
     */
    public java.lang.String getDeveloperName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DeveloperName" element
     */
    public org.apache.xmlbeans.XmlString xgetDeveloperName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DeveloperName" element
     */
    public void setDeveloperName(java.lang.String developerName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEVELOPERNAME$0);
            }
            target.setStringValue(developerName);
        }
    }
    
    /**
     * Sets (as xml) the "DeveloperName" element
     */
    public void xsetDeveloperName(org.apache.xmlbeans.XmlString developerName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DEVELOPERNAME$0);
            }
            target.set(developerName);
        }
    }
}
