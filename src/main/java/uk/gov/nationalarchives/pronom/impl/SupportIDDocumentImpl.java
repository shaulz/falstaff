/*
 * An XML document type.
 * Localname: SupportID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SupportIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SupportID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SupportIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SupportIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public SupportIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SUPPORTID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SupportID");
    
    
    /**
     * Gets the "SupportID" element
     */
    public short getSupportID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "SupportID" element
     */
    public org.apache.xmlbeans.XmlShort xgetSupportID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SUPPORTID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SupportID" element
     */
    public void setSupportID(short supportID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUPPORTID$0);
            }
            target.setShortValue(supportID);
        }
    }
    
    /**
     * Sets (as xml) the "SupportID" element
     */
    public void xsetSupportID(org.apache.xmlbeans.XmlShort supportID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SUPPORTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(SUPPORTID$0);
            }
            target.set(supportID);
        }
    }
}
