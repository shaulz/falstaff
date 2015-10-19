/*
 * An XML document type.
 * Localname: CompressionName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionName");
    
    
    /**
     * Gets the "CompressionName" element
     */
    public java.lang.String getCompressionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CompressionName" element
     */
    public org.apache.xmlbeans.XmlString xgetCompressionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CompressionName" element
     */
    public void setCompressionName(java.lang.String compressionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONNAME$0);
            }
            target.setStringValue(compressionName);
        }
    }
    
    /**
     * Sets (as xml) the "CompressionName" element
     */
    public void xsetCompressionName(org.apache.xmlbeans.XmlString compressionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONNAME$0);
            }
            target.set(compressionName);
        }
    }
}
