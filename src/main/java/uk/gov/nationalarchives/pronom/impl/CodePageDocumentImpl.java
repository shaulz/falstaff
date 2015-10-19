/*
 * An XML document type.
 * Localname: CodePage
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CodePageDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CodePage(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CodePageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CodePageDocument
{
    private static final long serialVersionUID = 1L;
    
    public CodePageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CODEPAGE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CodePage");
    
    
    /**
     * Gets the "CodePage" element
     */
    public java.lang.String getCodePage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEPAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CodePage" element
     */
    public org.apache.xmlbeans.XmlString xgetCodePage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEPAGE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CodePage" element
     */
    public void setCodePage(java.lang.String codePage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEPAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODEPAGE$0);
            }
            target.setStringValue(codePage);
        }
    }
    
    /**
     * Sets (as xml) the "CodePage" element
     */
    public void xsetCodePage(org.apache.xmlbeans.XmlString codePage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEPAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODEPAGE$0);
            }
            target.set(codePage);
        }
    }
}
