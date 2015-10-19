/*
 * An XML document type.
 * Localname: Support
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SupportDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Support(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SupportDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SupportDocument
{
    private static final long serialVersionUID = 1L;
    
    public SupportDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SUPPORT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Support");
    
    
    /**
     * Gets the "Support" element
     */
    public uk.gov.nationalarchives.pronom.SupportDocument.Support getSupport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.SupportDocument.Support target = null;
            target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().find_element_user(SUPPORT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Support" element
     */
    public void setSupport(uk.gov.nationalarchives.pronom.SupportDocument.Support support)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.SupportDocument.Support target = null;
            target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().find_element_user(SUPPORT$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().add_element_user(SUPPORT$0);
            }
            target.set(support);
        }
    }
    
    /**
     * Appends and returns a new empty "Support" element
     */
    public uk.gov.nationalarchives.pronom.SupportDocument.Support addNewSupport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.SupportDocument.Support target = null;
            target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().add_element_user(SUPPORT$0);
            return target;
        }
    }
    /**
     * An XML Support(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class SupportImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SupportDocument.Support
    {
        private static final long serialVersionUID = 1L;
        
        public SupportImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SUPPORTID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SupportID");
        private static final javax.xml.namespace.QName SUPPORTNAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SupportName");
        private static final javax.xml.namespace.QName ORGANISATIONNAME$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "OrganisationName");
        private static final javax.xml.namespace.QName SUPPORTCOMPOUNDNAME$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SupportCompoundName");
        
        
        /**
         * Gets the "SupportID" element
         */
        public short getSupportID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "SupportID" element
         */
        public org.apache.xmlbeans.XmlShort xgetSupportID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SUPPORTID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SupportID" element
         */
        public void setSupportID(short supportID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUPPORTID$0);
                }
                target.setShortValue(supportID);
            }
        }
        
        /**
         * Sets (as xml) the "SupportID" element
         */
        public void xsetSupportID(org.apache.xmlbeans.XmlShort supportID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SUPPORTID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(SUPPORTID$0);
                }
                target.set(supportID);
            }
        }
        
        /**
         * Gets the "SupportName" element
         */
        public java.lang.String getSupportName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "SupportName" element
         */
        public org.apache.xmlbeans.XmlString xgetSupportName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTNAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SupportName" element
         */
        public void setSupportName(java.lang.String supportName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUPPORTNAME$2);
                }
                target.setStringValue(supportName);
            }
        }
        
        /**
         * Sets (as xml) the "SupportName" element
         */
        public void xsetSupportName(org.apache.xmlbeans.XmlString supportName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUPPORTNAME$2);
                }
                target.set(supportName);
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
         * Gets the "SupportCompoundName" element
         */
        public java.lang.String getSupportCompoundName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "SupportCompoundName" element
         */
        public org.apache.xmlbeans.XmlString xgetSupportCompoundName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTCOMPOUNDNAME$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SupportCompoundName" element
         */
        public void setSupportCompoundName(java.lang.String supportCompoundName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUPPORTCOMPOUNDNAME$6);
                }
                target.setStringValue(supportCompoundName);
            }
        }
        
        /**
         * Sets (as xml) the "SupportCompoundName" element
         */
        public void xsetSupportCompoundName(org.apache.xmlbeans.XmlString supportCompoundName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUPPORTCOMPOUNDNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUPPORTCOMPOUNDNAME$6);
                }
                target.set(supportCompoundName);
            }
        }
    }
}
