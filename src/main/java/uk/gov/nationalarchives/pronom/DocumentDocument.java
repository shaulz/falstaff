/*
 * An XML document type.
 * Localname: Document
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one Document(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface DocumentDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DocumentDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("document34b8doctype");
    
    /**
     * Gets the "Document" element
     */
    uk.gov.nationalarchives.pronom.DocumentDocument.Document getDocument();
    
    /**
     * Sets the "Document" element
     */
    void setDocument(uk.gov.nationalarchives.pronom.DocumentDocument.Document document);
    
    /**
     * Appends and returns a new empty "Document" element
     */
    uk.gov.nationalarchives.pronom.DocumentDocument.Document addNewDocument();
    
    /**
     * An XML Document(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public interface Document extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Document.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("document33c1elemtype");
        
        /**
         * Gets the "DocumentID" element
         */
        byte getDocumentID();
        
        /**
         * Gets (as xml) the "DocumentID" element
         */
        org.apache.xmlbeans.XmlByte xgetDocumentID();
        
        /**
         * Sets the "DocumentID" element
         */
        void setDocumentID(byte documentID);
        
        /**
         * Sets (as xml) the "DocumentID" element
         */
        void xsetDocumentID(org.apache.xmlbeans.XmlByte documentID);
        
        /**
         * Gets the "DisplayText" element
         */
        java.lang.String getDisplayText();
        
        /**
         * Gets (as xml) the "DisplayText" element
         */
        org.apache.xmlbeans.XmlString xgetDisplayText();
        
        /**
         * Sets the "DisplayText" element
         */
        void setDisplayText(java.lang.String displayText);
        
        /**
         * Sets (as xml) the "DisplayText" element
         */
        void xsetDisplayText(org.apache.xmlbeans.XmlString displayText);
        
        /**
         * Gets the "DocumentType" element
         */
        uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum getDocumentType();
        
        /**
         * Gets (as xml) the "DocumentType" element
         */
        uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType xgetDocumentType();
        
        /**
         * Sets the "DocumentType" element
         */
        void setDocumentType(uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum documentType);
        
        /**
         * Sets (as xml) the "DocumentType" element
         */
        void xsetDocumentType(uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType documentType);
        
        /**
         * Gets the "AvailabilityDescription" element
         */
        uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum getAvailabilityDescription();
        
        /**
         * Gets (as xml) the "AvailabilityDescription" element
         */
        uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription xgetAvailabilityDescription();
        
        /**
         * Sets the "AvailabilityDescription" element
         */
        void setAvailabilityDescription(uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum availabilityDescription);
        
        /**
         * Sets (as xml) the "AvailabilityDescription" element
         */
        void xsetAvailabilityDescription(uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription availabilityDescription);
        
        /**
         * Gets the "AvailabilityNote" element
         */
        java.lang.String getAvailabilityNote();
        
        /**
         * Gets (as xml) the "AvailabilityNote" element
         */
        org.apache.xmlbeans.XmlString xgetAvailabilityNote();
        
        /**
         * Sets the "AvailabilityNote" element
         */
        void setAvailabilityNote(java.lang.String availabilityNote);
        
        /**
         * Sets (as xml) the "AvailabilityNote" element
         */
        void xsetAvailabilityNote(org.apache.xmlbeans.XmlString availabilityNote);
        
        /**
         * Gets the "PublicationDate" element
         */
        java.lang.String getPublicationDate();
        
        /**
         * Gets (as xml) the "PublicationDate" element
         */
        org.apache.xmlbeans.XmlString xgetPublicationDate();
        
        /**
         * Sets the "PublicationDate" element
         */
        void setPublicationDate(java.lang.String publicationDate);
        
        /**
         * Sets (as xml) the "PublicationDate" element
         */
        void xsetPublicationDate(org.apache.xmlbeans.XmlString publicationDate);
        
        /**
         * Gets the "TitleText" element
         */
        java.lang.String getTitleText();
        
        /**
         * Gets (as xml) the "TitleText" element
         */
        org.apache.xmlbeans.XmlString xgetTitleText();
        
        /**
         * Sets the "TitleText" element
         */
        void setTitleText(java.lang.String titleText);
        
        /**
         * Sets (as xml) the "TitleText" element
         */
        void xsetTitleText(org.apache.xmlbeans.XmlString titleText);
        
        /**
         * Gets the "DocumentIPR" element
         */
        java.lang.String getDocumentIPR();
        
        /**
         * Gets (as xml) the "DocumentIPR" element
         */
        org.apache.xmlbeans.XmlString xgetDocumentIPR();
        
        /**
         * Sets the "DocumentIPR" element
         */
        void setDocumentIPR(java.lang.String documentIPR);
        
        /**
         * Sets (as xml) the "DocumentIPR" element
         */
        void xsetDocumentIPR(org.apache.xmlbeans.XmlString documentIPR);
        
        /**
         * Gets the "DocumentNote" element
         */
        java.lang.String getDocumentNote();
        
        /**
         * Gets (as xml) the "DocumentNote" element
         */
        org.apache.xmlbeans.XmlString xgetDocumentNote();
        
        /**
         * Sets the "DocumentNote" element
         */
        void setDocumentNote(java.lang.String documentNote);
        
        /**
         * Sets (as xml) the "DocumentNote" element
         */
        void xsetDocumentNote(org.apache.xmlbeans.XmlString documentNote);
        
        /**
         * Gets the "DocumentIdentifier" element
         */
        uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier getDocumentIdentifier();
        
        /**
         * True if has "DocumentIdentifier" element
         */
        boolean isSetDocumentIdentifier();
        
        /**
         * Sets the "DocumentIdentifier" element
         */
        void setDocumentIdentifier(uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier documentIdentifier);
        
        /**
         * Appends and returns a new empty "DocumentIdentifier" element
         */
        uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier addNewDocumentIdentifier();
        
        /**
         * Unsets the "DocumentIdentifier" element
         */
        void unsetDocumentIdentifier();
        
        /**
         * Gets array of all "Author" elements
         */
        uk.gov.nationalarchives.pronom.AuthorDocument.Author[] getAuthorArray();
        
        /**
         * Gets ith "Author" element
         */
        uk.gov.nationalarchives.pronom.AuthorDocument.Author getAuthorArray(int i);
        
        /**
         * Returns number of "Author" element
         */
        int sizeOfAuthorArray();
        
        /**
         * Sets array of all "Author" element
         */
        void setAuthorArray(uk.gov.nationalarchives.pronom.AuthorDocument.Author[] authorArray);
        
        /**
         * Sets ith "Author" element
         */
        void setAuthorArray(int i, uk.gov.nationalarchives.pronom.AuthorDocument.Author author);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Author" element
         */
        uk.gov.nationalarchives.pronom.AuthorDocument.Author insertNewAuthor(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Author" element
         */
        uk.gov.nationalarchives.pronom.AuthorDocument.Author addNewAuthor();
        
        /**
         * Removes the ith "Author" element
         */
        void removeAuthor(int i);
        
        /**
         * Gets the "Publisher" element
         */
        uk.gov.nationalarchives.pronom.PublisherDocument.Publisher getPublisher();
        
        /**
         * True if has "Publisher" element
         */
        boolean isSetPublisher();
        
        /**
         * Sets the "Publisher" element
         */
        void setPublisher(uk.gov.nationalarchives.pronom.PublisherDocument.Publisher publisher);
        
        /**
         * Appends and returns a new empty "Publisher" element
         */
        uk.gov.nationalarchives.pronom.PublisherDocument.Publisher addNewPublisher();
        
        /**
         * Unsets the "Publisher" element
         */
        void unsetPublisher();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.DocumentDocument.Document newInstance() {
              return (uk.gov.nationalarchives.pronom.DocumentDocument.Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.DocumentDocument.Document newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.DocumentDocument.Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.DocumentDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.DocumentDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.DocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
