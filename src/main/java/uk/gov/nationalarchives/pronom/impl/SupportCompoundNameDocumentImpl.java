/*
 * An XML document type.
 * Localname: SupportCompoundName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SupportCompoundNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SupportCompoundName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SupportCompoundNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SupportCompoundNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public SupportCompoundNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SUPPORTCOMPOUNDNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SupportCompoundName");
    
    
    /**
     * Gets the "SupportCompoundName" element
     */
    public java.lang.String getSupportCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SupportCompoundName" element
     */
    public org.apache.xmlbeans.XmlString xgetSupportCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTCOMPOUNDNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SupportCompoundName" element
     */
    public void setSupportCompoundName(java.lang.String supportCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUPPORTCOMPOUNDNAME$0);
            }
            target.setStringValue(supportCompoundName);
        }
    }
    
    /**
     * Sets (as xml) the "SupportCompoundName" element
     */
    public void xsetSupportCompoundName(org.apache.xmlbeans.XmlString supportCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUPPORTCOMPOUNDNAME$0);
            }
            target.set(supportCompoundName);
        }
    }
}
