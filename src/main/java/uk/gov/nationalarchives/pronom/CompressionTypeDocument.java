/*
 * An XML document type.
 * Localname: CompressionType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one CompressionType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface CompressionTypeDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CompressionTypeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("compressiontype31cbdoctype");
    
    /**
     * Gets the "CompressionType" element
     */
    uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType getCompressionType();
    
    /**
     * Sets the "CompressionType" element
     */
    void setCompressionType(uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType compressionType);
    
    /**
     * Appends and returns a new empty "CompressionType" element
     */
    uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType addNewCompressionType();
    
    /**
     * An XML CompressionType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public interface CompressionType extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CompressionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("compressiontype43d7elemtype");
        
        /**
         * Gets the "CompressionID" element
         */
        byte getCompressionID();
        
        /**
         * Gets (as xml) the "CompressionID" element
         */
        org.apache.xmlbeans.XmlByte xgetCompressionID();
        
        /**
         * Sets the "CompressionID" element
         */
        void setCompressionID(byte compressionID);
        
        /**
         * Sets (as xml) the "CompressionID" element
         */
        void xsetCompressionID(org.apache.xmlbeans.XmlByte compressionID);
        
        /**
         * Gets the "CompressionName" element
         */
        java.lang.String getCompressionName();
        
        /**
         * Gets (as xml) the "CompressionName" element
         */
        org.apache.xmlbeans.XmlString xgetCompressionName();
        
        /**
         * Sets the "CompressionName" element
         */
        void setCompressionName(java.lang.String compressionName);
        
        /**
         * Sets (as xml) the "CompressionName" element
         */
        void xsetCompressionName(org.apache.xmlbeans.XmlString compressionName);
        
        /**
         * Gets the "CompressionVersion" element
         */
        java.lang.String getCompressionVersion();
        
        /**
         * Gets (as xml) the "CompressionVersion" element
         */
        org.apache.xmlbeans.XmlString xgetCompressionVersion();
        
        /**
         * Sets the "CompressionVersion" element
         */
        void setCompressionVersion(java.lang.String compressionVersion);
        
        /**
         * Sets (as xml) the "CompressionVersion" element
         */
        void xsetCompressionVersion(org.apache.xmlbeans.XmlString compressionVersion);
        
        /**
         * Gets the "CompressionAliases" element
         */
        java.lang.String getCompressionAliases();
        
        /**
         * Gets (as xml) the "CompressionAliases" element
         */
        org.apache.xmlbeans.XmlString xgetCompressionAliases();
        
        /**
         * Sets the "CompressionAliases" element
         */
        void setCompressionAliases(java.lang.String compressionAliases);
        
        /**
         * Sets (as xml) the "CompressionAliases" element
         */
        void xsetCompressionAliases(org.apache.xmlbeans.XmlString compressionAliases);
        
        /**
         * Gets the "CompressionFamilies" element
         */
        java.lang.String getCompressionFamilies();
        
        /**
         * Gets (as xml) the "CompressionFamilies" element
         */
        org.apache.xmlbeans.XmlString xgetCompressionFamilies();
        
        /**
         * Sets the "CompressionFamilies" element
         */
        void setCompressionFamilies(java.lang.String compressionFamilies);
        
        /**
         * Sets (as xml) the "CompressionFamilies" element
         */
        void xsetCompressionFamilies(org.apache.xmlbeans.XmlString compressionFamilies);
        
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
         * Gets the "Lossiness" element
         */
        uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum getLossiness();
        
        /**
         * Gets (as xml) the "Lossiness" element
         */
        uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness xgetLossiness();
        
        /**
         * Sets the "Lossiness" element
         */
        void setLossiness(uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum lossiness);
        
        /**
         * Sets (as xml) the "Lossiness" element
         */
        void xsetLossiness(uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness lossiness);
        
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
         * Gets the "CompressionDocumentation" element
         */
        java.lang.String getCompressionDocumentation();
        
        /**
         * Gets (as xml) the "CompressionDocumentation" element
         */
        org.apache.xmlbeans.XmlString xgetCompressionDocumentation();
        
        /**
         * Sets the "CompressionDocumentation" element
         */
        void setCompressionDocumentation(java.lang.String compressionDocumentation);
        
        /**
         * Sets (as xml) the "CompressionDocumentation" element
         */
        void xsetCompressionDocumentation(org.apache.xmlbeans.XmlString compressionDocumentation);
        
        /**
         * Gets the "CompressionIPR" element
         */
        java.lang.String getCompressionIPR();
        
        /**
         * Gets (as xml) the "CompressionIPR" element
         */
        org.apache.xmlbeans.XmlString xgetCompressionIPR();
        
        /**
         * Sets the "CompressionIPR" element
         */
        void setCompressionIPR(java.lang.String compressionIPR);
        
        /**
         * Sets (as xml) the "CompressionIPR" element
         */
        void xsetCompressionIPR(org.apache.xmlbeans.XmlString compressionIPR);
        
        /**
         * Gets the "CompressionNote" element
         */
        java.lang.String getCompressionNote();
        
        /**
         * Gets (as xml) the "CompressionNote" element
         */
        org.apache.xmlbeans.XmlString xgetCompressionNote();
        
        /**
         * Sets the "CompressionNote" element
         */
        void setCompressionNote(java.lang.String compressionNote);
        
        /**
         * Sets (as xml) the "CompressionNote" element
         */
        void xsetCompressionNote(org.apache.xmlbeans.XmlString compressionNote);
        
        /**
         * Gets array of all "CompressionIdentifier" elements
         */
        uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier[] getCompressionIdentifierArray();
        
        /**
         * Gets ith "CompressionIdentifier" element
         */
        uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier getCompressionIdentifierArray(int i);
        
        /**
         * Returns number of "CompressionIdentifier" element
         */
        int sizeOfCompressionIdentifierArray();
        
        /**
         * Sets array of all "CompressionIdentifier" element
         */
        void setCompressionIdentifierArray(uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier[] compressionIdentifierArray);
        
        /**
         * Sets ith "CompressionIdentifier" element
         */
        void setCompressionIdentifierArray(int i, uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier compressionIdentifier);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "CompressionIdentifier" element
         */
        uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier insertNewCompressionIdentifier(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "CompressionIdentifier" element
         */
        uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier addNewCompressionIdentifier();
        
        /**
         * Removes the ith "CompressionIdentifier" element
         */
        void removeCompressionIdentifier(int i);
        
        /**
         * Gets the "Developer" element
         */
        uk.gov.nationalarchives.pronom.DeveloperDocument.Developer getDeveloper();
        
        /**
         * True if has "Developer" element
         */
        boolean isSetDeveloper();
        
        /**
         * Sets the "Developer" element
         */
        void setDeveloper(uk.gov.nationalarchives.pronom.DeveloperDocument.Developer developer);
        
        /**
         * Appends and returns a new empty "Developer" element
         */
        uk.gov.nationalarchives.pronom.DeveloperDocument.Developer addNewDeveloper();
        
        /**
         * Unsets the "Developer" element
         */
        void unsetDeveloper();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType newInstance() {
              return (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.CompressionTypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.CompressionTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
