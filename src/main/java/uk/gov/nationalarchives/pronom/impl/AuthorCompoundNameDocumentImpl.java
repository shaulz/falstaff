/*
 * An XML document type.
 * Localname: AuthorCompoundName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.AuthorCompoundNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one AuthorCompoundName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class AuthorCompoundNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.AuthorCompoundNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuthorCompoundNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUTHORCOMPOUNDNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AuthorCompoundName");
    
    
    /**
     * Gets the "AuthorCompoundName" element
     */
    public java.lang.String getAuthorCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AuthorCompoundName" element
     */
    public org.apache.xmlbeans.XmlString xgetAuthorCompoundName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORCOMPOUNDNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AuthorCompoundName" element
     */
    public void setAuthorCompoundName(java.lang.String authorCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AUTHORCOMPOUNDNAME$0);
            }
            target.setStringValue(authorCompoundName);
        }
    }
    
    /**
     * Sets (as xml) the "AuthorCompoundName" element
     */
    public void xsetAuthorCompoundName(org.apache.xmlbeans.XmlString authorCompoundName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORCOMPOUNDNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AUTHORCOMPOUNDNAME$0);
            }
            target.set(authorCompoundName);
        }
    }
}
