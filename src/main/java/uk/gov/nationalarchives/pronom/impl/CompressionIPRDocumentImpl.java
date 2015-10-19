/*
 * An XML document type.
 * Localname: CompressionIPR
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionIPRDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionIPR(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionIPRDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionIPRDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionIPRDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONIPR$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionIPR");
    
    
    /**
     * Gets the "CompressionIPR" element
     */
    public java.lang.String getCompressionIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONIPR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CompressionIPR" element
     */
    public org.apache.xmlbeans.XmlString xgetCompressionIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONIPR$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CompressionIPR" element
     */
    public void setCompressionIPR(java.lang.String compressionIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONIPR$0);
            }
            target.setStringValue(compressionIPR);
        }
    }
    
    /**
     * Sets (as xml) the "CompressionIPR" element
     */
    public void xsetCompressionIPR(org.apache.xmlbeans.XmlString compressionIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONIPR$0);
            }
            target.set(compressionIPR);
        }
    }
}
