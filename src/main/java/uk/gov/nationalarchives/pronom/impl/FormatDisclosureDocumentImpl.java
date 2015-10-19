/*
 * An XML document type.
 * Localname: FormatDisclosure
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatDisclosureDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatDisclosure(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatDisclosureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatDisclosureDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatDisclosureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATDISCLOSURE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatDisclosure");
    
    
    /**
     * Gets the "FormatDisclosure" element
     */
    public java.lang.String getFormatDisclosure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATDISCLOSURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatDisclosure" element
     */
    public org.apache.xmlbeans.XmlString xgetFormatDisclosure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATDISCLOSURE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatDisclosure" element
     */
    public void setFormatDisclosure(java.lang.String formatDisclosure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATDISCLOSURE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATDISCLOSURE$0);
            }
            target.setStringValue(formatDisclosure);
        }
    }
    
    /**
     * Sets (as xml) the "FormatDisclosure" element
     */
    public void xsetFormatDisclosure(org.apache.xmlbeans.XmlString formatDisclosure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATDISCLOSURE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATDISCLOSURE$0);
            }
            target.set(formatDisclosure);
        }
    }
}
