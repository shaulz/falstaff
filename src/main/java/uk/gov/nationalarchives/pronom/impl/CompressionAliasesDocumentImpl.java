/*
 * An XML document type.
 * Localname: CompressionAliases
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionAliasesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionAliases(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionAliasesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionAliasesDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionAliasesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONALIASES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionAliases");
    
    
    /**
     * Gets the "CompressionAliases" element
     */
    public java.lang.String getCompressionAliases()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONALIASES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CompressionAliases" element
     */
    public org.apache.xmlbeans.XmlString xgetCompressionAliases()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONALIASES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CompressionAliases" element
     */
    public void setCompressionAliases(java.lang.String compressionAliases)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONALIASES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONALIASES$0);
            }
            target.setStringValue(compressionAliases);
        }
    }
    
    /**
     * Sets (as xml) the "CompressionAliases" element
     */
    public void xsetCompressionAliases(org.apache.xmlbeans.XmlString compressionAliases)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONALIASES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONALIASES$0);
            }
            target.set(compressionAliases);
        }
    }
}
