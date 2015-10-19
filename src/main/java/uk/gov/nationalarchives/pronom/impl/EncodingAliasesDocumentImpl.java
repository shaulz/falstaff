/*
 * An XML document type.
 * Localname: EncodingAliases
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingAliasesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingAliases(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingAliasesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingAliasesDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingAliasesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGALIASES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingAliases");
    
    
    /**
     * Gets the "EncodingAliases" element
     */
    public java.lang.String getEncodingAliases()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGALIASES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingAliases" element
     */
    public org.apache.xmlbeans.XmlString xgetEncodingAliases()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGALIASES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingAliases" element
     */
    public void setEncodingAliases(java.lang.String encodingAliases)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGALIASES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGALIASES$0);
            }
            target.setStringValue(encodingAliases);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingAliases" element
     */
    public void xsetEncodingAliases(org.apache.xmlbeans.XmlString encodingAliases)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGALIASES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGALIASES$0);
            }
            target.set(encodingAliases);
        }
    }
}
