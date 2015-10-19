/*
 * An XML document type.
 * Localname: DocumentIdentifier
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentIdentifierDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DocumentIdentifier(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DocumentIdentifierDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentIdentifierDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentIdentifierDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTIDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentIdentifier");
    
    
    /**
     * Gets the "DocumentIdentifier" element
     */
    public uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier getDocumentIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().find_element_user(DOCUMENTIDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DocumentIdentifier" element
     */
    public void setDocumentIdentifier(uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier documentIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().find_element_user(DOCUMENTIDENTIFIER$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().add_element_user(DOCUMENTIDENTIFIER$0);
            }
            target.set(documentIdentifier);
        }
    }
    
    /**
     * Appends and returns a new empty "DocumentIdentifier" element
     */
    public uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier addNewDocumentIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().add_element_user(DOCUMENTIDENTIFIER$0);
            return target;
        }
    }
    /**
     * An XML DocumentIdentifier(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class DocumentIdentifierImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier
    {
        private static final long serialVersionUID = 1L;
        
        public DocumentIdentifierImpl(org.apache.xmlbeans.SchemaType sType)
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
