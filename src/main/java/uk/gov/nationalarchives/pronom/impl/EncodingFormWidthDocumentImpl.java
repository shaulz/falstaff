/*
 * An XML document type.
 * Localname: EncodingFormWidth
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingFormWidthDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingFormWidth(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingFormWidthDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingFormWidthDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingFormWidthDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGFORMWIDTH$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingFormWidth");
    
    
    /**
     * Gets the "EncodingFormWidth" element
     */
    public java.lang.String getEncodingFormWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFORMWIDTH$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingFormWidth" element
     */
    public org.apache.xmlbeans.XmlString xgetEncodingFormWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFORMWIDTH$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingFormWidth" element
     */
    public void setEncodingFormWidth(java.lang.String encodingFormWidth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFORMWIDTH$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGFORMWIDTH$0);
            }
            target.setStringValue(encodingFormWidth);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingFormWidth" element
     */
    public void xsetEncodingFormWidth(org.apache.xmlbeans.XmlString encodingFormWidth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFORMWIDTH$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGFORMWIDTH$0);
            }
            target.set(encodingFormWidth);
        }
    }
}
