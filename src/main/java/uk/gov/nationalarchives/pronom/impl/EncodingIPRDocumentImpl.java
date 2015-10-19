/*
 * An XML document type.
 * Localname: EncodingIPR
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingIPRDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingIPR(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingIPRDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingIPRDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingIPRDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGIPR$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingIPR");
    
    
    /**
     * Gets the "EncodingIPR" element
     */
    public java.lang.String getEncodingIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGIPR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingIPR" element
     */
    public org.apache.xmlbeans.XmlString xgetEncodingIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGIPR$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingIPR" element
     */
    public void setEncodingIPR(java.lang.String encodingIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGIPR$0);
            }
            target.setStringValue(encodingIPR);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingIPR" element
     */
    public void xsetEncodingIPR(org.apache.xmlbeans.XmlString encodingIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGIPR$0);
            }
            target.set(encodingIPR);
        }
    }
}
