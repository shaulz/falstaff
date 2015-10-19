/*
 * An XML document type.
 * Localname: ByteSequenceID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ByteSequenceIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ByteSequenceID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ByteSequenceIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ByteSequenceIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public ByteSequenceIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BYTESEQUENCEID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteSequenceID");
    
    
    /**
     * Gets the "ByteSequenceID" element
     */
    public short getByteSequenceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "ByteSequenceID" element
     */
    public org.apache.xmlbeans.XmlShort xgetByteSequenceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(BYTESEQUENCEID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ByteSequenceID" element
     */
    public void setByteSequenceID(short byteSequenceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BYTESEQUENCEID$0);
            }
            target.setShortValue(byteSequenceID);
        }
    }
    
    /**
     * Sets (as xml) the "ByteSequenceID" element
     */
    public void xsetByteSequenceID(org.apache.xmlbeans.XmlShort byteSequenceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(BYTESEQUENCEID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(BYTESEQUENCEID$0);
            }
            target.set(byteSequenceID);
        }
    }
}
