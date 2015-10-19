/*
 * An XML document type.
 * Localname: Endianness
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EndiannessDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Endianness(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EndiannessDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EndiannessDocument
{
    private static final long serialVersionUID = 1L;
    
    public EndiannessDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENDIANNESS$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Endianness");
    
    
    /**
     * Gets the "Endianness" element
     */
    public java.lang.String getEndianness()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENDIANNESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Endianness" element
     */
    public org.apache.xmlbeans.XmlString xgetEndianness()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENDIANNESS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Endianness" element
     */
    public void setEndianness(java.lang.String endianness)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENDIANNESS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENDIANNESS$0);
            }
            target.setStringValue(endianness);
        }
    }
    
    /**
     * Sets (as xml) the "Endianness" element
     */
    public void xsetEndianness(org.apache.xmlbeans.XmlString endianness)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENDIANNESS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENDIANNESS$0);
            }
            target.set(endianness);
        }
    }
}
