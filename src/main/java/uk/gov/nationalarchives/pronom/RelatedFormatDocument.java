/*
 * An XML document type.
 * Localname: RelatedFormat
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.RelatedFormatDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one RelatedFormat(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface RelatedFormatDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RelatedFormatDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("relatedformat404ddoctype");
    
    /**
     * Gets the "RelatedFormat" element
     */
    uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat getRelatedFormat();
    
    /**
     * Sets the "RelatedFormat" element
     */
    void setRelatedFormat(uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat relatedFormat);
    
    /**
     * Appends and returns a new empty "RelatedFormat" element
     */
    uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat addNewRelatedFormat();
    
    /**
     * An XML RelatedFormat(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public interface RelatedFormat extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RelatedFormat.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("relatedformat0c1belemtype");
        
        /**
         * Gets the "RelationshipType" element
         */
        uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum getRelationshipType();
        
        /**
         * Gets (as xml) the "RelationshipType" element
         */
        uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType xgetRelationshipType();
        
        /**
         * Sets the "RelationshipType" element
         */
        void setRelationshipType(uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum relationshipType);
        
        /**
         * Sets (as xml) the "RelationshipType" element
         */
        void xsetRelationshipType(uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType relationshipType);
        
        /**
         * Gets the "RelatedFormatID" element
         */
        short getRelatedFormatID();
        
        /**
         * Gets (as xml) the "RelatedFormatID" element
         */
        org.apache.xmlbeans.XmlShort xgetRelatedFormatID();
        
        /**
         * Sets the "RelatedFormatID" element
         */
        void setRelatedFormatID(short relatedFormatID);
        
        /**
         * Sets (as xml) the "RelatedFormatID" element
         */
        void xsetRelatedFormatID(org.apache.xmlbeans.XmlShort relatedFormatID);
        
        /**
         * Gets the "RelatedFormatName" element
         */
        java.lang.String getRelatedFormatName();
        
        /**
         * Gets (as xml) the "RelatedFormatName" element
         */
        org.apache.xmlbeans.XmlString xgetRelatedFormatName();
        
        /**
         * Sets the "RelatedFormatName" element
         */
        void setRelatedFormatName(java.lang.String relatedFormatName);
        
        /**
         * Sets (as xml) the "RelatedFormatName" element
         */
        void xsetRelatedFormatName(org.apache.xmlbeans.XmlString relatedFormatName);
        
        /**
         * Gets the "RelatedFormatVersion" element
         */
        java.lang.String getRelatedFormatVersion();
        
        /**
         * Gets (as xml) the "RelatedFormatVersion" element
         */
        org.apache.xmlbeans.XmlString xgetRelatedFormatVersion();
        
        /**
         * Sets the "RelatedFormatVersion" element
         */
        void setRelatedFormatVersion(java.lang.String relatedFormatVersion);
        
        /**
         * Sets (as xml) the "RelatedFormatVersion" element
         */
        void xsetRelatedFormatVersion(org.apache.xmlbeans.XmlString relatedFormatVersion);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat newInstance() {
              return (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.RelatedFormatDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.RelatedFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
