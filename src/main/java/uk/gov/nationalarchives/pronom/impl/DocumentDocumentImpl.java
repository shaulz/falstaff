/*
 * An XML document type.
 * Localname: Document
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Document(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DocumentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Document");
    
    
    /**
     * Gets the "Document" element
     */
    public uk.gov.nationalarchives.pronom.DocumentDocument.Document getDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentDocument.Document target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().find_element_user(DOCUMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Document" element
     */
    public void setDocument(uk.gov.nationalarchives.pronom.DocumentDocument.Document document)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentDocument.Document target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().find_element_user(DOCUMENT$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().add_element_user(DOCUMENT$0);
            }
            target.set(document);
        }
    }
    
    /**
     * Appends and returns a new empty "Document" element
     */
    public uk.gov.nationalarchives.pronom.DocumentDocument.Document addNewDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentDocument.Document target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().add_element_user(DOCUMENT$0);
            return target;
        }
    }
    /**
     * An XML Document(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentDocument.Document
    {
        private static final long serialVersionUID = 1L;
        
        public DocumentImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DOCUMENTID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentID");
        private static final javax.xml.namespace.QName DISPLAYTEXT$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DisplayText");
        private static final javax.xml.namespace.QName DOCUMENTTYPE$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentType");
        private static final javax.xml.namespace.QName AVAILABILITYDESCRIPTION$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AvailabilityDescription");
        private static final javax.xml.namespace.QName AVAILABILITYNOTE$8 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AvailabilityNote");
        private static final javax.xml.namespace.QName PUBLICATIONDATE$10 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PublicationDate");
        private static final javax.xml.namespace.QName TITLETEXT$12 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "TitleText");
        private static final javax.xml.namespace.QName DOCUMENTIPR$14 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentIPR");
        private static final javax.xml.namespace.QName DOCUMENTNOTE$16 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentNote");
        private static final javax.xml.namespace.QName DOCUMENTIDENTIFIER$18 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentIdentifier");
        private static final javax.xml.namespace.QName AUTHOR$20 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Author");
        private static final javax.xml.namespace.QName PUBLISHER$22 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Publisher");
        
        
        /**
         * Gets the "DocumentID" element
         */
        public byte getDocumentID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getByteValue();
            }
        }
        
        /**
         * Gets (as xml) the "DocumentID" element
         */
        public org.apache.xmlbeans.XmlByte xgetDocumentID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlByte target = null;
                target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(DOCUMENTID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "DocumentID" element
         */
        public void setDocumentID(byte documentID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTID$0);
                }
                target.setByteValue(documentID);
            }
        }
        
        /**
         * Sets (as xml) the "DocumentID" element
         */
        public void xsetDocumentID(org.apache.xmlbeans.XmlByte documentID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlByte target = null;
                target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(DOCUMENTID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlByte)get_store().add_element_user(DOCUMENTID$0);
                }
                target.set(documentID);
            }
        }
        
        /**
         * Gets the "DisplayText" element
         */
        public java.lang.String getDisplayText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISPLAYTEXT$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "DisplayText" element
         */
        public org.apache.xmlbeans.XmlString xgetDisplayText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DISPLAYTEXT$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "DisplayText" element
         */
        public void setDisplayText(java.lang.String displayText)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISPLAYTEXT$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DISPLAYTEXT$2);
                }
                target.setStringValue(displayText);
            }
        }
        
        /**
         * Sets (as xml) the "DisplayText" element
         */
        public void xsetDisplayText(org.apache.xmlbeans.XmlString displayText)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DISPLAYTEXT$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DISPLAYTEXT$2);
                }
                target.set(displayText);
            }
        }
        
        /**
         * Gets the "DocumentType" element
         */
        public uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum getDocumentType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTTYPE$4, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "DocumentType" element
         */
        public uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType xgetDocumentType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType target = null;
                target = (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType)get_store().find_element_user(DOCUMENTTYPE$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "DocumentType" element
         */
        public void setDocumentType(uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum documentType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTTYPE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTTYPE$4);
                }
                target.setEnumValue(documentType);
            }
        }
        
        /**
         * Sets (as xml) the "DocumentType" element
         */
        public void xsetDocumentType(uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType documentType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType target = null;
                target = (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType)get_store().find_element_user(DOCUMENTTYPE$4, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType)get_store().add_element_user(DOCUMENTTYPE$4);
                }
                target.set(documentType);
            }
        }
        
        /**
         * Gets the "AvailabilityDescription" element
         */
        public uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum getAvailabilityDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYDESCRIPTION$6, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "AvailabilityDescription" element
         */
        public uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription xgetAvailabilityDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription target = null;
                target = (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription)get_store().find_element_user(AVAILABILITYDESCRIPTION$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "AvailabilityDescription" element
         */
        public void setAvailabilityDescription(uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum availabilityDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYDESCRIPTION$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABILITYDESCRIPTION$6);
                }
                target.setEnumValue(availabilityDescription);
            }
        }
        
        /**
         * Sets (as xml) the "AvailabilityDescription" element
         */
        public void xsetAvailabilityDescription(uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription availabilityDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription target = null;
                target = (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription)get_store().find_element_user(AVAILABILITYDESCRIPTION$6, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription)get_store().add_element_user(AVAILABILITYDESCRIPTION$6);
                }
                target.set(availabilityDescription);
            }
        }
        
        /**
         * Gets the "AvailabilityNote" element
         */
        public java.lang.String getAvailabilityNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYNOTE$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "AvailabilityNote" element
         */
        public org.apache.xmlbeans.XmlString xgetAvailabilityNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYNOTE$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "AvailabilityNote" element
         */
        public void setAvailabilityNote(java.lang.String availabilityNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYNOTE$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABILITYNOTE$8);
                }
                target.setStringValue(availabilityNote);
            }
        }
        
        /**
         * Sets (as xml) the "AvailabilityNote" element
         */
        public void xsetAvailabilityNote(org.apache.xmlbeans.XmlString availabilityNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYNOTE$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AVAILABILITYNOTE$8);
                }
                target.set(availabilityNote);
            }
        }
        
        /**
         * Gets the "PublicationDate" element
         */
        public java.lang.String getPublicationDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLICATIONDATE$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PublicationDate" element
         */
        public org.apache.xmlbeans.XmlString xgetPublicationDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLICATIONDATE$10, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PublicationDate" element
         */
        public void setPublicationDate(java.lang.String publicationDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBLICATIONDATE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBLICATIONDATE$10);
                }
                target.setStringValue(publicationDate);
            }
        }
        
        /**
         * Sets (as xml) the "PublicationDate" element
         */
        public void xsetPublicationDate(org.apache.xmlbeans.XmlString publicationDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBLICATIONDATE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUBLICATIONDATE$10);
                }
                target.set(publicationDate);
            }
        }
        
        /**
         * Gets the "TitleText" element
         */
        public java.lang.String getTitleText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLETEXT$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "TitleText" element
         */
        public org.apache.xmlbeans.XmlString xgetTitleText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLETEXT$12, 0);
                return target;
            }
        }
        
        /**
         * Sets the "TitleText" element
         */
        public void setTitleText(java.lang.String titleText)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLETEXT$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TITLETEXT$12);
                }
                target.setStringValue(titleText);
            }
        }
        
        /**
         * Sets (as xml) the "TitleText" element
         */
        public void xsetTitleText(org.apache.xmlbeans.XmlString titleText)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLETEXT$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLETEXT$12);
                }
                target.set(titleText);
            }
        }
        
        /**
         * Gets the "DocumentIPR" element
         */
        public java.lang.String getDocumentIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTIPR$14, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "DocumentIPR" element
         */
        public org.apache.xmlbeans.XmlString xgetDocumentIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTIPR$14, 0);
                return target;
            }
        }
        
        /**
         * Sets the "DocumentIPR" element
         */
        public void setDocumentIPR(java.lang.String documentIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTIPR$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTIPR$14);
                }
                target.setStringValue(documentIPR);
            }
        }
        
        /**
         * Sets (as xml) the "DocumentIPR" element
         */
        public void xsetDocumentIPR(org.apache.xmlbeans.XmlString documentIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTIPR$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DOCUMENTIPR$14);
                }
                target.set(documentIPR);
            }
        }
        
        /**
         * Gets the "DocumentNote" element
         */
        public java.lang.String getDocumentNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTNOTE$16, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "DocumentNote" element
         */
        public org.apache.xmlbeans.XmlString xgetDocumentNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTNOTE$16, 0);
                return target;
            }
        }
        
        /**
         * Sets the "DocumentNote" element
         */
        public void setDocumentNote(java.lang.String documentNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTNOTE$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTNOTE$16);
                }
                target.setStringValue(documentNote);
            }
        }
        
        /**
         * Sets (as xml) the "DocumentNote" element
         */
        public void xsetDocumentNote(org.apache.xmlbeans.XmlString documentNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTNOTE$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DOCUMENTNOTE$16);
                }
                target.set(documentNote);
            }
        }
        
        /**
         * Gets the "DocumentIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier getDocumentIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().find_element_user(DOCUMENTIDENTIFIER$18, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "DocumentIdentifier" element
         */
        public boolean isSetDocumentIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DOCUMENTIDENTIFIER$18) != 0;
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
                target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().find_element_user(DOCUMENTIDENTIFIER$18, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().add_element_user(DOCUMENTIDENTIFIER$18);
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
                target = (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier)get_store().add_element_user(DOCUMENTIDENTIFIER$18);
                return target;
            }
        }
        
        /**
         * Unsets the "DocumentIdentifier" element
         */
        public void unsetDocumentIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DOCUMENTIDENTIFIER$18, 0);
            }
        }
        
        /**
         * Gets array of all "Author" elements
         */
        public uk.gov.nationalarchives.pronom.AuthorDocument.Author[] getAuthorArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(AUTHOR$20, targetList);
                uk.gov.nationalarchives.pronom.AuthorDocument.Author[] result = new uk.gov.nationalarchives.pronom.AuthorDocument.Author[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Author" element
         */
        public uk.gov.nationalarchives.pronom.AuthorDocument.Author getAuthorArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.AuthorDocument.Author target = null;
                target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().find_element_user(AUTHOR$20, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Author" element
         */
        public int sizeOfAuthorArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AUTHOR$20);
            }
        }
        
        /**
         * Sets array of all "Author" element
         */
        public void setAuthorArray(uk.gov.nationalarchives.pronom.AuthorDocument.Author[] authorArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(authorArray, AUTHOR$20);
            }
        }
        
        /**
         * Sets ith "Author" element
         */
        public void setAuthorArray(int i, uk.gov.nationalarchives.pronom.AuthorDocument.Author author)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.AuthorDocument.Author target = null;
                target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().find_element_user(AUTHOR$20, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(author);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Author" element
         */
        public uk.gov.nationalarchives.pronom.AuthorDocument.Author insertNewAuthor(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.AuthorDocument.Author target = null;
                target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().insert_element_user(AUTHOR$20, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Author" element
         */
        public uk.gov.nationalarchives.pronom.AuthorDocument.Author addNewAuthor()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.AuthorDocument.Author target = null;
                target = (uk.gov.nationalarchives.pronom.AuthorDocument.Author)get_store().add_element_user(AUTHOR$20);
                return target;
            }
        }
        
        /**
         * Removes the ith "Author" element
         */
        public void removeAuthor(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AUTHOR$20, i);
            }
        }
        
        /**
         * Gets the "Publisher" element
         */
        public uk.gov.nationalarchives.pronom.PublisherDocument.Publisher getPublisher()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PublisherDocument.Publisher target = null;
                target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().find_element_user(PUBLISHER$22, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "Publisher" element
         */
        public boolean isSetPublisher()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PUBLISHER$22) != 0;
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
                target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().find_element_user(PUBLISHER$22, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().add_element_user(PUBLISHER$22);
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
                target = (uk.gov.nationalarchives.pronom.PublisherDocument.Publisher)get_store().add_element_user(PUBLISHER$22);
                return target;
            }
        }
        
        /**
         * Unsets the "Publisher" element
         */
        public void unsetPublisher()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PUBLISHER$22, 0);
            }
        }
    }
}
