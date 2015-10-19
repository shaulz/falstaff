/*
 * An XML document type.
 * Localname: DisplayText
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DisplayTextDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DisplayText(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DisplayTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DisplayTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public DisplayTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DISPLAYTEXT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DisplayText");
    
    
    /**
     * Gets the "DisplayText" element
     */
    public java.lang.String getDisplayText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISPLAYTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DisplayText" element
     */
    public org.apache.xmlbeans.XmlString xgetDisplayText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DISPLAYTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DisplayText" element
     */
    public void setDisplayText(java.lang.String displayText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISPLAYTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DISPLAYTEXT$0);
            }
            target.setStringValue(displayText);
        }
    }
    
    /**
     * Sets (as xml) the "DisplayText" element
     */
    public void xsetDisplayText(org.apache.xmlbeans.XmlString displayText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DISPLAYTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DISPLAYTEXT$0);
            }
            target.set(displayText);
        }
    }
}
