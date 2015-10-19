/*
 * An XML document type.
 * Localname: FormatName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatName");
    
    
    /**
     * Gets the "FormatName" element
     */
    public java.lang.String getFormatName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatName" element
     */
    public org.apache.xmlbeans.XmlString xgetFormatName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatName" element
     */
    public void setFormatName(java.lang.String formatName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATNAME$0);
            }
            target.setStringValue(formatName);
        }
    }
    
    /**
     * Sets (as xml) the "FormatName" element
     */
    public void xsetFormatName(org.apache.xmlbeans.XmlString formatName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATNAME$0);
            }
            target.set(formatName);
        }
    }
}
