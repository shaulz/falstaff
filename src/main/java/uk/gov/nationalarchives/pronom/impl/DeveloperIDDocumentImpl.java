/*
 * An XML document type.
 * Localname: DeveloperID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DeveloperIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DeveloperID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DeveloperIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DeveloperIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public DeveloperIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEVELOPERID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DeveloperID");
    
    
    /**
     * Gets the "DeveloperID" element
     */
    public short getDeveloperID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "DeveloperID" element
     */
    public org.apache.xmlbeans.XmlShort xgetDeveloperID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(DEVELOPERID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DeveloperID" element
     */
    public void setDeveloperID(short developerID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEVELOPERID$0);
            }
            target.setShortValue(developerID);
        }
    }
    
    /**
     * Sets (as xml) the "DeveloperID" element
     */
    public void xsetDeveloperID(org.apache.xmlbeans.XmlShort developerID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(DEVELOPERID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(DEVELOPERID$0);
            }
            target.set(developerID);
        }
    }
}
