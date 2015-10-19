/*
 * An XML document type.
 * Localname: ByteSequenceValue
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ByteSequenceValueDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ByteSequenceValue(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ByteSequenceValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ByteSequenceValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public ByteSequenceValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BYTESEQUENCEVALUE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteSequenceValue");
    
    
    /**
     * Gets the "ByteSequenceValue" element
     */
    public java.lang.String getByteSequenceValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ByteSequenceValue" element
     */
    public org.apache.xmlbeans.XmlString xgetByteSequenceValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTESEQUENCEVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ByteSequenceValue" element
     */
    public void setByteSequenceValue(java.lang.String byteSequenceValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BYTESEQUENCEVALUE$0);
            }
            target.setStringValue(byteSequenceValue);
        }
    }
    
    /**
     * Sets (as xml) the "ByteSequenceValue" element
     */
    public void xsetByteSequenceValue(org.apache.xmlbeans.XmlString byteSequenceValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTESEQUENCEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BYTESEQUENCEVALUE$0);
            }
            target.set(byteSequenceValue);
        }
    }
}
