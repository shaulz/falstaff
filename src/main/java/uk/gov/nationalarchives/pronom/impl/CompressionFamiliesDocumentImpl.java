/*
 * An XML document type.
 * Localname: CompressionFamilies
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionFamiliesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionFamilies(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionFamiliesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionFamiliesDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionFamiliesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONFAMILIES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionFamilies");
    
    
    /**
     * Gets the "CompressionFamilies" element
     */
    public java.lang.String getCompressionFamilies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONFAMILIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CompressionFamilies" element
     */
    public org.apache.xmlbeans.XmlString xgetCompressionFamilies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONFAMILIES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CompressionFamilies" element
     */
    public void setCompressionFamilies(java.lang.String compressionFamilies)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONFAMILIES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONFAMILIES$0);
            }
            target.setStringValue(compressionFamilies);
        }
    }
    
    /**
     * Sets (as xml) the "CompressionFamilies" element
     */
    public void xsetCompressionFamilies(org.apache.xmlbeans.XmlString compressionFamilies)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONFAMILIES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONFAMILIES$0);
            }
            target.set(compressionFamilies);
        }
    }
}
