/*
 * An XML document type.
 * Localname: Offset
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.OffsetDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Offset(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class OffsetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.OffsetDocument
{
    private static final long serialVersionUID = 1L;
    
    public OffsetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OFFSET$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Offset");
    
    
    /**
     * Gets the "Offset" element
     */
    public java.lang.String getOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OFFSET$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Offset" element
     */
    public org.apache.xmlbeans.XmlString xgetOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OFFSET$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Offset" element
     */
    public void setOffset(java.lang.String offset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OFFSET$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OFFSET$0);
            }
            target.setStringValue(offset);
        }
    }
    
    /**
     * Sets (as xml) the "Offset" element
     */
    public void xsetOffset(org.apache.xmlbeans.XmlString offset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OFFSET$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(OFFSET$0);
            }
            target.set(offset);
        }
    }
}
