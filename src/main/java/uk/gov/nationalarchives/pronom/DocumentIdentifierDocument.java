/*
 * An XML document type.
 * Localname: DocumentIdentifier
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentIdentifierDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one DocumentIdentifier(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface DocumentIdentifierDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DocumentIdentifierDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("documentidentifier4dc1doctype");
    
    /**
     * Gets the "DocumentIdentifier" element
     */
    uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier getDocumentIdentifier();
    
    /**
     * Sets the "DocumentIdentifier" element
     */
    void setDocumentIdentifier(uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier documentIdentifier);
    
    /**
     * Appends and returns a new empty "DocumentIdentifier" element
     */
    uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier addNewDocumentIdentifier();
    
    /**
     * An XML DocumentIdentifier(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public interface DocumentIdentifier extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DocumentIdentifier.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("documentidentifier3ee1elemtype");
        
        /**
         * Gets the "Identifier" element
         */
        java.lang.String getIdentifier();
        
        /**
         * Gets (as xml) the "Identifier" element
         */
        org.apache.xmlbeans.XmlString xgetIdentifier();
        
        /**
         * Sets the "Identifier" element
         */
        void setIdentifier(java.lang.String identifier);
        
        /**
         * Sets (as xml) the "Identifier" element
         */
        void xsetIdentifier(org.apache.xmlbeans.XmlString identifier);
        
        /**
         * Gets the "IdentifierType" element
         */
        uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum getIdentifierType();
        
        /**
         * Gets (as xml) the "IdentifierType" element
         */
        uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType xgetIdentifierType();
        
        /**
         * Sets the "IdentifierType" element
         */
        void setIdentifierType(uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum identifierType);
        
        /**
         * Sets (as xml) the "IdentifierType" element
         */
        void xsetIdentifierType(uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType identifierType);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier newInstance() {
              return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument.DocumentIdentifier) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.DocumentIdentifierDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.DocumentIdentifierDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
