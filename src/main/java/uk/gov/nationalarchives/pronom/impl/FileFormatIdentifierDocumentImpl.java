/*
 * An XML document type.
 * Localname: FileFormatIdentifier
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FileFormatIdentifier(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FileFormatIdentifierDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument
{
    private static final long serialVersionUID = 1L;
    
    public FileFormatIdentifierDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILEFORMATIDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FileFormatIdentifier");
    
    
    /**
     * Gets the "FileFormatIdentifier" element
     */
    public uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier getFileFormatIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().find_element_user(FILEFORMATIDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FileFormatIdentifier" element
     */
    public void setFileFormatIdentifier(uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier fileFormatIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().find_element_user(FILEFORMATIDENTIFIER$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().add_element_user(FILEFORMATIDENTIFIER$0);
            }
            target.set(fileFormatIdentifier);
        }
    }
    
    /**
     * Appends and returns a new empty "FileFormatIdentifier" element
     */
    public uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier addNewFileFormatIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier target = null;
            target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().add_element_user(FILEFORMATIDENTIFIER$0);
            return target;
        }
    }
    /**
     * An XML FileFormatIdentifier(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class FileFormatIdentifierImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier
    {
        private static final long serialVersionUID = 1L;
        
        public FileFormatIdentifierImpl(org.apache.xmlbeans.SchemaType sType)
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
