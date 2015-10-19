/*
 * An XML document type.
 * Localname: DeveloperCompoundName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DeveloperCompoundNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DeveloperCompoundName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DeveloperCompoundNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DeveloperCompoundNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public DeveloperCompoundNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEVELOPERCOMPOUNDNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DeveloperCompoundName");
    
    
    /**
     * Gets the "DeveloperCompoundName" element
     */
    public java.lang.String getDeveloperCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DeveloperCompoundName" element
     */
    public org.apache.xmlbeans.XmlString xgetDeveloperCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DeveloperCompoundName" element
     */
    public void setDeveloperCompoundName(java.lang.String developerCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEVELOPERCOMPOUNDNAME$0);
            }
            target.setStringValue(developerCompoundName);
        }
    }
    
    /**
     * Sets (as xml) the "DeveloperCompoundName" element
     */
    public void xsetDeveloperCompoundName(org.apache.xmlbeans.XmlString developerCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DEVELOPERCOMPOUNDNAME$0);
            }
            target.set(developerCompoundName);
        }
    }
}
