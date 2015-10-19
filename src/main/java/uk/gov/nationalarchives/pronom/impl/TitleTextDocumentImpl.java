/*
 * An XML document type.
 * Localname: TitleText
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.TitleTextDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one TitleText(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class TitleTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.TitleTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public TitleTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TITLETEXT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "TitleText");
    
    
    /**
     * Gets the "TitleText" element
     */
    public java.lang.String getTitleText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLETEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TitleText" element
     */
    public org.apache.xmlbeans.XmlString xgetTitleText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLETEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TitleText" element
     */
    public void setTitleText(java.lang.String titleText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLETEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TITLETEXT$0);
            }
            target.setStringValue(titleText);
        }
    }
    
    /**
     * Sets (as xml) the "TitleText" element
     */
    public void xsetTitleText(org.apache.xmlbeans.XmlString titleText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLETEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLETEXT$0);
            }
            target.set(titleText);
        }
    }
}
