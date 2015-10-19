/*
 * An XML document type.
 * Localname: MaxOffset
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.MaxOffsetDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one MaxOffset(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class MaxOffsetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.MaxOffsetDocument
{
    private static final long serialVersionUID = 1L;
    
    public MaxOffsetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MAXOFFSET$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "MaxOffset");
    
    
    /**
     * Gets the "MaxOffset" element
     */
    public java.lang.String getMaxOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXOFFSET$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "MaxOffset" element
     */
    public org.apache.xmlbeans.XmlString xgetMaxOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MAXOFFSET$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MaxOffset" element
     */
    public void setMaxOffset(java.lang.String maxOffset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXOFFSET$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MAXOFFSET$0);
            }
            target.setStringValue(maxOffset);
        }
    }
    
    /**
     * Sets (as xml) the "MaxOffset" element
     */
    public void xsetMaxOffset(org.apache.xmlbeans.XmlString maxOffset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MAXOFFSET$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MAXOFFSET$0);
            }
            target.set(maxOffset);
        }
    }
}
