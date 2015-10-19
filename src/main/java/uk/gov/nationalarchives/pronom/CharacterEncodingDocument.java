/*
 * An XML document type.
 * Localname: CharacterEncoding
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CharacterEncodingDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one CharacterEncoding(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface CharacterEncodingDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CharacterEncodingDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("characterencodinga0e7doctype");
    
    /**
     * Gets the "CharacterEncoding" element
     */
    uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding getCharacterEncoding();
    
    /**
     * Sets the "CharacterEncoding" element
     */
    void setCharacterEncoding(uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding characterEncoding);
    
    /**
     * Appends and returns a new empty "CharacterEncoding" element
     */
    uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding addNewCharacterEncoding();
    
    /**
     * An XML CharacterEncoding(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public interface CharacterEncoding extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CharacterEncoding.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("characterencoding7ccfelemtype");
        
        /**
         * Gets the "EncodingID" element
         */
        byte getEncodingID();
        
        /**
         * Gets (as xml) the "EncodingID" element
         */
        uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID xgetEncodingID();
        
        /**
         * Sets the "EncodingID" element
         */
        void setEncodingID(byte encodingID);
        
        /**
         * Sets (as xml) the "EncodingID" element
         */
        void xsetEncodingID(uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID encodingID);
        
        /**
         * Gets the "EncodingName" element
         */
        uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum getEncodingName();
        
        /**
         * Gets (as xml) the "EncodingName" element
         */
        uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName xgetEncodingName();
        
        /**
         * Sets the "EncodingName" element
         */
        void setEncodingName(uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum encodingName);
        
        /**
         * Sets (as xml) the "EncodingName" element
         */
        void xsetEncodingName(uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName encodingName);
        
        /**
         * Gets the "EncodingVersion" element
         */
        java.lang.String getEncodingVersion();
        
        /**
         * Gets (as xml) the "EncodingVersion" element
         */
        org.apache.xmlbeans.XmlString xgetEncodingVersion();
        
        /**
         * Sets the "EncodingVersion" element
         */
        void setEncodingVersion(java.lang.String encodingVersion);
        
        /**
         * Sets (as xml) the "EncodingVersion" element
         */
        void xsetEncodingVersion(org.apache.xmlbeans.XmlString encodingVersion);
        
        /**
         * Gets the "EncodingAliases" element
         */
        java.lang.String getEncodingAliases();
        
        /**
         * Gets (as xml) the "EncodingAliases" element
         */
        org.apache.xmlbeans.XmlString xgetEncodingAliases();
        
        /**
         * Sets the "EncodingAliases" element
         */
        void setEncodingAliases(java.lang.String encodingAliases);
        
        /**
         * Sets (as xml) the "EncodingAliases" element
         */
        void xsetEncodingAliases(org.apache.xmlbeans.XmlString encodingAliases);
        
        /**
         * Gets the "EncodingFamilies" element
         */
        java.lang.String getEncodingFamilies();
        
        /**
         * Gets (as xml) the "EncodingFamilies" element
         */
        org.apache.xmlbeans.XmlString xgetEncodingFamilies();
        
        /**
         * Sets the "EncodingFamilies" element
         */
        void setEncodingFamilies(java.lang.String encodingFamilies);
        
        /**
         * Sets (as xml) the "EncodingFamilies" element
         */
        void xsetEncodingFamilies(org.apache.xmlbeans.XmlString encodingFamilies);
        
        /**
         * Gets the "Description" element
         */
        java.lang.String getDescription();
        
        /**
         * Gets (as xml) the "Description" element
         */
        org.apache.xmlbeans.XmlString xgetDescription();
        
        /**
         * Sets the "Description" element
         */
        void setDescription(java.lang.String description);
        
        /**
         * Sets (as xml) the "Description" element
         */
        void xsetDescription(org.apache.xmlbeans.XmlString description);
        
        /**
         * Gets the "CodePage" element
         */
        java.lang.String getCodePage();
        
        /**
         * Gets (as xml) the "CodePage" element
         */
        org.apache.xmlbeans.XmlString xgetCodePage();
        
        /**
         * Sets the "CodePage" element
         */
        void setCodePage(java.lang.String codePage);
        
        /**
         * Sets (as xml) the "CodePage" element
         */
        void xsetCodePage(org.apache.xmlbeans.XmlString codePage);
        
        /**
         * Gets the "CodeUnitWidth" element
         */
        java.lang.String getCodeUnitWidth();
        
        /**
         * Gets (as xml) the "CodeUnitWidth" element
         */
        org.apache.xmlbeans.XmlString xgetCodeUnitWidth();
        
        /**
         * Sets the "CodeUnitWidth" element
         */
        void setCodeUnitWidth(java.lang.String codeUnitWidth);
        
        /**
         * Sets (as xml) the "CodeUnitWidth" element
         */
        void xsetCodeUnitWidth(org.apache.xmlbeans.XmlString codeUnitWidth);
        
        /**
         * Gets the "EncodingFormWidth" element
         */
        java.lang.String getEncodingFormWidth();
        
        /**
         * Gets (as xml) the "EncodingFormWidth" element
         */
        org.apache.xmlbeans.XmlString xgetEncodingFormWidth();
        
        /**
         * Sets the "EncodingFormWidth" element
         */
        void setEncodingFormWidth(java.lang.String encodingFormWidth);
        
        /**
         * Sets (as xml) the "EncodingFormWidth" element
         */
        void xsetEncodingFormWidth(org.apache.xmlbeans.XmlString encodingFormWidth);
        
        /**
         * Gets the "ReleaseDate" element
         */
        java.lang.String getReleaseDate();
        
        /**
         * Gets (as xml) the "ReleaseDate" element
         */
        org.apache.xmlbeans.XmlString xgetReleaseDate();
        
        /**
         * Sets the "ReleaseDate" element
         */
        void setReleaseDate(java.lang.String releaseDate);
        
        /**
         * Sets (as xml) the "ReleaseDate" element
         */
        void xsetReleaseDate(org.apache.xmlbeans.XmlString releaseDate);
        
        /**
         * Gets the "WithdrawnDate" element
         */
        java.lang.String getWithdrawnDate();
        
        /**
         * Gets (as xml) the "WithdrawnDate" element
         */
        org.apache.xmlbeans.XmlString xgetWithdrawnDate();
        
        /**
         * Sets the "WithdrawnDate" element
         */
        void setWithdrawnDate(java.lang.String withdrawnDate);
        
        /**
         * Sets (as xml) the "WithdrawnDate" element
         */
        void xsetWithdrawnDate(org.apache.xmlbeans.XmlString withdrawnDate);
        
        /**
         * Gets the "EncodingDocumentation" element
         */
        java.lang.String getEncodingDocumentation();
        
        /**
         * Gets (as xml) the "EncodingDocumentation" element
         */
        org.apache.xmlbeans.XmlString xgetEncodingDocumentation();
        
        /**
         * Sets the "EncodingDocumentation" element
         */
        void setEncodingDocumentation(java.lang.String encodingDocumentation);
        
        /**
         * Sets (as xml) the "EncodingDocumentation" element
         */
        void xsetEncodingDocumentation(org.apache.xmlbeans.XmlString encodingDocumentation);
        
        /**
         * Gets the "EncodingIPR" element
         */
        java.lang.String getEncodingIPR();
        
        /**
         * Gets (as xml) the "EncodingIPR" element
         */
        org.apache.xmlbeans.XmlString xgetEncodingIPR();
        
        /**
         * Sets the "EncodingIPR" element
         */
        void setEncodingIPR(java.lang.String encodingIPR);
        
        /**
         * Sets (as xml) the "EncodingIPR" element
         */
        void xsetEncodingIPR(org.apache.xmlbeans.XmlString encodingIPR);
        
        /**
         * Gets the "EncodingNote" element
         */
        java.lang.String getEncodingNote();
        
        /**
         * Gets (as xml) the "EncodingNote" element
         */
        org.apache.xmlbeans.XmlString xgetEncodingNote();
        
        /**
         * Sets the "EncodingNote" element
         */
        void setEncodingNote(java.lang.String encodingNote);
        
        /**
         * Sets (as xml) the "EncodingNote" element
         */
        void xsetEncodingNote(org.apache.xmlbeans.XmlString encodingNote);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding newInstance() {
              return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.CharacterEncodingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.CharacterEncodingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
