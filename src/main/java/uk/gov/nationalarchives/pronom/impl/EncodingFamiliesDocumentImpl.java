/*
 * An XML document type.
 * Localname: EncodingFamilies
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingFamiliesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingFamilies(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingFamiliesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingFamiliesDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingFamiliesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGFAMILIES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingFamilies");
    
    
    /**
     * Gets the "EncodingFamilies" element
     */
    public java.lang.String getEncodingFamilies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFAMILIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingFamilies" element
     */
    public org.apache.xmlbeans.XmlString xgetEncodingFamilies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFAMILIES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingFamilies" element
     */
    public void setEncodingFamilies(java.lang.String encodingFamilies)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFAMILIES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGFAMILIES$0);
            }
            target.setStringValue(encodingFamilies);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingFamilies" element
     */
    public void xsetEncodingFamilies(org.apache.xmlbeans.XmlString encodingFamilies)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFAMILIES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGFAMILIES$0);
            }
            target.set(encodingFamilies);
        }
    }
}
