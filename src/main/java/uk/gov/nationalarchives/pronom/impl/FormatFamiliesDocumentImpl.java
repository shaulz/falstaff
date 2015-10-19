/*
 * An XML document type.
 * Localname: FormatFamilies
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatFamiliesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatFamilies(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatFamiliesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatFamiliesDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatFamiliesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATFAMILIES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatFamilies");
    
    
    /**
     * Gets the "FormatFamilies" element
     */
    public java.lang.String getFormatFamilies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATFAMILIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatFamilies" element
     */
    public org.apache.xmlbeans.XmlString xgetFormatFamilies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATFAMILIES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatFamilies" element
     */
    public void setFormatFamilies(java.lang.String formatFamilies)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATFAMILIES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATFAMILIES$0);
            }
            target.setStringValue(formatFamilies);
        }
    }
    
    /**
     * Sets (as xml) the "FormatFamilies" element
     */
    public void xsetFormatFamilies(org.apache.xmlbeans.XmlString formatFamilies)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATFAMILIES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATFAMILIES$0);
            }
            target.set(formatFamilies);
        }
    }
}
