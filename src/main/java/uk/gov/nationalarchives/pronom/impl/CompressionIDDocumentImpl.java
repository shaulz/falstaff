/*
 * An XML document type.
 * Localname: CompressionID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionID");
    
    
    /**
     * Gets the "CompressionID" element
     */
    public byte getCompressionID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getByteValue();
        }
    }
    
    /**
     * Gets (as xml) the "CompressionID" element
     */
    public org.apache.xmlbeans.XmlByte xgetCompressionID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(COMPRESSIONID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CompressionID" element
     */
    public void setCompressionID(byte compressionID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONID$0);
            }
            target.setByteValue(compressionID);
        }
    }
    
    /**
     * Sets (as xml) the "CompressionID" element
     */
    public void xsetCompressionID(org.apache.xmlbeans.XmlByte compressionID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(COMPRESSIONID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlByte)get_store().add_element_user(COMPRESSIONID$0);
            }
            target.set(compressionID);
        }
    }
}
