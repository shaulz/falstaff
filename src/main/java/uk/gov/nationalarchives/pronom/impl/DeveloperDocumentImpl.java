/*
 * An XML document type.
 * Localname: Developer
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DeveloperDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Developer(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DeveloperDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DeveloperDocument
{
    private static final long serialVersionUID = 1L;
    
    public DeveloperDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEVELOPER$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Developer");
    
    
    /**
     * Gets the "Developer" element
     */
    public uk.gov.nationalarchives.pronom.DeveloperDocument.Developer getDeveloper()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DeveloperDocument.Developer target = null;
            target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().find_element_user(DEVELOPER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Developer" element
     */
    public void setDeveloper(uk.gov.nationalarchives.pronom.DeveloperDocument.Developer developer)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DeveloperDocument.Developer target = null;
            target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().find_element_user(DEVELOPER$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().add_element_user(DEVELOPER$0);
            }
            target.set(developer);
        }
    }
    
    /**
     * Appends and returns a new empty "Developer" element
     */
    public uk.gov.nationalarchives.pronom.DeveloperDocument.Developer addNewDeveloper()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DeveloperDocument.Developer target = null;
            target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().add_element_user(DEVELOPER$0);
            return target;
        }
    }
    /**
     * An XML Developer(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class DeveloperImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DeveloperDocument.Developer
    {
        private static final long serialVersionUID = 1L;
        
        public DeveloperImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DEVELOPERID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DeveloperID");
        private static final javax.xml.namespace.QName DEVELOPERNAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DeveloperName");
        private static final javax.xml.namespace.QName ORGANISATIONNAME$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "OrganisationName");
        private static final javax.xml.namespace.QName DEVELOPERCOMPOUNDNAME$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DeveloperCompoundName");
        
        
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
        
        /**
         * Gets the "DeveloperName" element
         */
        public java.lang.String getDeveloperName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "DeveloperName" element
         */
        public org.apache.xmlbeans.XmlString xgetDeveloperName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERNAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "DeveloperName" element
         */
        public void setDeveloperName(java.lang.String developerName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEVELOPERNAME$2);
                }
                target.setStringValue(developerName);
            }
        }
        
        /**
         * Sets (as xml) the "DeveloperName" element
         */
        public void xsetDeveloperName(org.apache.xmlbeans.XmlString developerName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DEVELOPERNAME$2);
                }
                target.set(developerName);
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
         * Gets the "DeveloperCompoundName" element
         */
        public java.lang.String getDeveloperCompoundName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "DeveloperCompoundName" element
         */
        public org.apache.xmlbeans.XmlString xgetDeveloperCompoundName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "DeveloperCompoundName" element
         */
        public void setDeveloperCompoundName(java.lang.String developerCompoundName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEVELOPERCOMPOUNDNAME$6);
                }
                target.setStringValue(developerCompoundName);
            }
        }
        
        /**
         * Sets (as xml) the "DeveloperCompoundName" element
         */
        public void xsetDeveloperCompoundName(org.apache.xmlbeans.XmlString developerCompoundName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEVELOPERCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DEVELOPERCOMPOUNDNAME$6);
                }
                target.set(developerCompoundName);
            }
        }
    }
}
