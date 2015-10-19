/*
 * An XML document type.
 * Localname: ReferenceFileIdentifier
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFileIdentifier(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileIdentifierDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileIdentifierDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILEIDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileIdentifier");
    
    
    /**
     * Gets the "ReferenceFileIdentifier" element
     */
    public uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier getReferenceFileIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().find_element_user(REFERENCEFILEIDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFileIdentifier" element
     */
    public void setReferenceFileIdentifier(uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier referenceFileIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().find_element_user(REFERENCEFILEIDENTIFIER$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().add_element_user(REFERENCEFILEIDENTIFIER$0);
            }
            target.set(referenceFileIdentifier);
        }
    }
    
    /**
     * Appends and returns a new empty "ReferenceFileIdentifier" element
     */
    public uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier addNewReferenceFileIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().add_element_user(REFERENCEFILEIDENTIFIER$0);
            return target;
        }
    }
    /**
     * An XML ReferenceFileIdentifier(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class ReferenceFileIdentifierImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier
    {
        private static final long serialVersionUID = 1L;
        
        public ReferenceFileIdentifierImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDENTIFIER$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Identifier");
        private static final javax.xml.namespace.QName IDENTIFIERTYPE$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "IdentifierType");
        
        
        /**
         * Gets the "Identifier" element
         */
        public java.lang.String getIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Identifier" element
         */
        public org.apache.xmlbeans.XmlString xgetIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Identifier" element
         */
        public void setIdentifier(java.lang.String identifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IDENTIFIER$0);
                }
                target.setStringValue(identifier);
            }
        }
        
        /**
         * Sets (as xml) the "Identifier" element
         */
        public void xsetIdentifier(org.apache.xmlbeans.XmlString identifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(IDENTIFIER$0);
                }
                target.set(identifier);
            }
        }
        
        /**
         * Gets the "IdentifierType" element
         */
        public uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum getIdentifierType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIERTYPE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "IdentifierType" element
         */
        public uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType xgetIdentifierType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType target = null;
                target = (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType)get_store().find_element_user(IDENTIFIERTYPE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "IdentifierType" element
         */
        public void setIdentifierType(uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum identifierType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIERTYPE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IDENTIFIERTYPE$2);
                }
                target.setEnumValue(identifierType);
            }
        }
        
        /**
         * Sets (as xml) the "IdentifierType" element
         */
        public void xsetIdentifierType(uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType identifierType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType target = null;
                target = (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType)get_store().find_element_user(IDENTIFIERTYPE$2, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType)get_store().add_element_user(IDENTIFIERTYPE$2);
                }
                target.set(identifierType);
            }
        }
    }
}
