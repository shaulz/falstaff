/*
 * An XML document type.
 * Localname: AuthorID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.AuthorIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one AuthorID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class AuthorIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.AuthorIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuthorIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUTHORID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AuthorID");
    
    
    /**
     * Gets the "AuthorID" element
     */
    public short getAuthorID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "AuthorID" element
     */
    public org.apache.xmlbeans.XmlShort xgetAuthorID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(AUTHORID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AuthorID" element
     */
    public void setAuthorID(short authorID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AUTHORID$0);
            }
            target.setShortValue(authorID);
        }
    }
    
    /**
     * Sets (as xml) the "AuthorID" element
     */
    public void xsetAuthorID(org.apache.xmlbeans.XmlShort authorID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(AUTHORID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(AUTHORID$0);
            }
            target.set(authorID);
        }
    }
}
