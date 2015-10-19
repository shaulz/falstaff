/*
 * An XML document type.
 * Localname: ByteOrders
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ByteOrdersDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ByteOrders(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ByteOrdersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ByteOrdersDocument
{
    private static final long serialVersionUID = 1L;
    
    public ByteOrdersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BYTEORDERS$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteOrders");
    
    
    /**
     * Gets the "ByteOrders" element
     */
    public java.lang.String getByteOrders()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTEORDERS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ByteOrders" element
     */
    public org.apache.xmlbeans.XmlString xgetByteOrders()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTEORDERS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ByteOrders" element
     */
    public void setByteOrders(java.lang.String byteOrders)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTEORDERS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BYTEORDERS$0);
            }
            target.setStringValue(byteOrders);
        }
    }
    
    /**
     * Sets (as xml) the "ByteOrders" element
     */
    public void xsetByteOrders(org.apache.xmlbeans.XmlString byteOrders)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTEORDERS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BYTEORDERS$0);
            }
            target.set(byteOrders);
        }
    }
}
