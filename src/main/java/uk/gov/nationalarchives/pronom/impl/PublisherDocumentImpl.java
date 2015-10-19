/*
 * An XML document type.
 * Localname: Publisher
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PublisherDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Publisher(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PublisherDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PublisherDocument
{
    private static final long serialVersionUID = 1L;
    
    public PublisherDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PUBLISHER$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Publisher");
    
    
    /**
     * Gets the "Publisher" element
     */
    public uk.gov.nationalarchives.pronom.PublisherDocument.Publisher getPublisher()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PublisherDocument.Publisher target = null;
            target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().find_element_user(PUBLISHER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Publisher" element
     */
    public void setPublisher(uk.gov.nationalarchives.pronom.PublisherDocument.Publisher publisher)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PublisherDocument.Publisher target = null;
            target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().find_element_user(PUBLISHER$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().add_element_user(PUBLISHER$0);
            }
            target.set(publisher);
        }
    }
    
    /**
     * Appends and returns a new empty "Publisher" element
     */
    public uk.gov.nationalarchives.pronom.PublisherDocument.Publisher addNewPublisher()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PublisherDocument.Publisher target = null;
            target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().add_element_user(PUBLISHER$0);
            return target;
        }
    }
    /**
     * An XML Publisher(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class PublisherImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PublisherDocument.Publisher
    {
        private static final long serialVersionUID = 1L;
        
        public PublisherImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PUBLISHERID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublisherID");
        private static final javax.xml.namespace.QName PUBLISHERNAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublisherName");
        private static final javax.xml.namespace.QName ORGANISATIONNAME$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "OrganisationName");
        private static final javax.xml.namespace.QName PUBLISHERCOMPOUNDNAME$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublisherCompoundName");
        
        
        /**
         * Gets the "PublisherID" element
         */
        public short getPublisherID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "PublisherID" element
         */
        public org.apache.xmlbeans.XmlShort xgetPublisherID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(PUBLISHERID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PublisherID" element
         */
        public void setPublisherID(short publisherID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLISHERID$0);
                }
                target.setShortValue(publisherID);
            }
        }
        
        /**
         * Sets (as xml) the "PublisherID" element
         */
        public void xsetPublisherID(org.apache.xmlbeans.XmlShort publisherID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(PUBLISHERID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(PUBLISHERID$0);
                }
                target.set(publisherID);
            }
        }
        
        /**
         * Gets the "PublisherName" element
         */
        public java.lang.String getPublisherName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PublisherName" element
         */
        public org.apache.xmlbeans.XmlString xgetPublisherName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERNAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PublisherName" element
         */
        public void setPublisherName(java.lang.String publisherName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLISHERNAME$2);
                }
                target.setStringValue(publisherName);
            }
        }
        
        /**
         * Sets (as xml) the "PublisherName" element
         */
        public void xsetPublisherName(org.apache.xmlbeans.XmlString publisherName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUBLISHERNAME$2);
                }
                target.set(publisherName);
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
         * Gets the "PublisherCompoundName" element
         */
        public java.lang.String getPublisherCompoundName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PublisherCompoundName" element
         */
        public org.apache.xmlbeans.XmlString xgetPublisherCompoundName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PublisherCompoundName" element
         */
        public void setPublisherCompoundName(java.lang.String publisherCompoundName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLISHERCOMPOUNDNAME$6);
                }
                target.setStringValue(publisherCompoundName);
            }
        }
        
        /**
         * Sets (as xml) the "PublisherCompoundName" element
         */
        public void xsetPublisherCompoundName(org.apache.xmlbeans.XmlString publisherCompoundName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLISHERCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUBLISHERCOMPOUNDNAME$6);
                }
                target.set(publisherCompoundName);
            }
        }
    }
}
