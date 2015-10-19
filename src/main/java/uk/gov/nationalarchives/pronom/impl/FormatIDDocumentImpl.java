/*
 * An XML document type.
 * Localname: FormatID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatID");
    
    
    /**
     * Gets the "FormatID" element
     */
    public short getFormatID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatID" element
     */
    public org.apache.xmlbeans.XmlShort xgetFormatID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(FORMATID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatID" element
     */
    public void setFormatID(short formatID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATID$0);
            }
            target.setShortValue(formatID);
        }
    }
    
    /**
     * Sets (as xml) the "FormatID" element
     */
    public void xsetFormatID(org.apache.xmlbeans.XmlShort formatID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(FORMATID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(FORMATID$0);
            }
            target.set(formatID);
        }
    }
}
