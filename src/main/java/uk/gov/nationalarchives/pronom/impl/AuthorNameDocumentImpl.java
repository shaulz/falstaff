/*
 * An XML document type.
 * Localname: AuthorName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.AuthorNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one AuthorName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class AuthorNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.AuthorNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuthorNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUTHORNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AuthorName");
    
    
    /**
     * Gets the "AuthorName" element
     */
    public java.lang.String getAuthorName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AuthorName" element
     */
    public org.apache.xmlbeans.XmlString xgetAuthorName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AuthorName" element
     */
    public void setAuthorName(java.lang.String authorName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AUTHORNAME$0);
            }
            target.setStringValue(authorName);
        }
    }
    
    /**
     * Sets (as xml) the "AuthorName" element
     */
    public void xsetAuthorName(org.apache.xmlbeans.XmlString authorName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AUTHORNAME$0);
            }
            target.set(authorName);
        }
    }
}
