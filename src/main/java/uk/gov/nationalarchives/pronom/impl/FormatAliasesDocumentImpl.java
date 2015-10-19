/*
 * An XML document type.
 * Localname: FormatAliases
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatAliasesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatAliases(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatAliasesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatAliasesDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatAliasesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATALIASES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatAliases");
    
    
    /**
     * Gets the "FormatAliases" element
     */
    public java.lang.String getFormatAliases()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATALIASES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatAliases" element
     */
    public org.apache.xmlbeans.XmlString xgetFormatAliases()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATALIASES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatAliases" element
     */
    public void setFormatAliases(java.lang.String formatAliases)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATALIASES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATALIASES$0);
            }
            target.setStringValue(formatAliases);
        }
    }
    
    /**
     * Sets (as xml) the "FormatAliases" element
     */
    public void xsetFormatAliases(org.apache.xmlbeans.XmlString formatAliases)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATALIASES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATALIASES$0);
            }
            target.set(formatAliases);
        }
    }
}
