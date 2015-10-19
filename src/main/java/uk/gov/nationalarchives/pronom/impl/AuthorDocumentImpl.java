/*
 * An XML document type.
 * Localname: Author
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.AuthorDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Author(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class AuthorDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.AuthorDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuthorDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUTHOR$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Author");
    
    
    /**
     * Gets the "Author" element
     */
    public uk.gov.nationalarchives.pronom.AuthorDocument.Author getAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.AuthorDocument.Author target = null;
            target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().find_element_user(AUTHOR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Author" element
     */
    public void setAuthor(uk.gov.nationalarchives.pronom.AuthorDocument.Author author)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.AuthorDocument.Author target = null;
            target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().find_element_user(AUTHOR$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().add_element_user(AUTHOR$0);
            }
            target.set(author);
        }
    }
    
    /**
     * Appends and returns a new empty "Author" element
     */
    public uk.gov.nationalarchives.pronom.AuthorDocument.Author addNewAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.AuthorDocument.Author target = null;
            target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().add_element_user(AUTHOR$0);
            return target;
        }
    }
    /**
     * An XML Author(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class AuthorImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.AuthorDocument.Author
    {
        private static final long serialVersionUID = 1L;
        
        public AuthorImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AUTHORID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AuthorID");
        private static final javax.xml.namespace.QName AUTHORNAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AuthorName");
        private static final javax.xml.namespace.QName ORGANISATIONNAME$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "OrganisationName");
        private static final javax.xml.namespace.QName AUTHORCOMPOUNDNAME$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AuthorCompoundName");
        
        
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
        
        /**
         * Gets the "AuthorName" element
         */
        public java.lang.String getAuthorName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORNAME$2, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORNAME$2, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AUTHORNAME$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AUTHORNAME$2);
                }
                target.set(authorName);
            }
        }
        
        /**
         * Gets the "OrganisationName" element
         */
        public java.lang.String getOrganisationName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "OrganisationName" element
         */
        public org.apache.xmlbeans.XmlString xgetOrganisationName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "OrganisationName" element
         */
        public void setOrganisationName(java.lang.String organisationName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORGANISATIONNAME$4);
                }
                target.setStringValue(organisationName);
            }
        }
        
        /**
         * Sets (as xml) the "OrganisationName" element
         */
        public void xsetOrganisationName(org.apache.xmlbeans.XmlString organisationName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORGANISATIONNAME$4);
                }
                target.set(organisationName);
            }
        }
        
        /**
         * Gets the "AuthorCompoundName" element
         */
        public java.lang.String getAuthorCompoundName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORCOMPOUNDNAME$6, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORCOMPOUNDNAME$6, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AUTHORCOMPOUNDNAME$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AUTHORCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AUTHORCOMPOUNDNAME$6);
                }
                target.set(authorCompoundName);
            }
        }
    }
}
