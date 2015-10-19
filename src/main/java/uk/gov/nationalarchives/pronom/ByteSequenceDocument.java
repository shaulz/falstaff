/*
 * An XML document type.
 * Localname: ByteSequence
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ByteSequenceDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one ByteSequence(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface ByteSequenceDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ByteSequenceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("bytesequenceb986doctype");
    
    /**
     * Gets the "ByteSequence" element
     */
    uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence getByteSequence();
    
    /**
     * Sets the "ByteSequence" element
     */
    void setByteSequence(uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence byteSequence);
    
    /**
     * Appends and returns a new empty "ByteSequence" element
     */
    uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence addNewByteSequence();
    
    /**
     * An XML ByteSequence(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public interface ByteSequence extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ByteSequence.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("bytesequence8901elemtype");
        
        /**
         * Gets the "ByteSequenceID" element
         */
        short getByteSequenceID();
        
        /**
         * Gets (as xml) the "ByteSequenceID" element
         */
        org.apache.xmlbeans.XmlShort xgetByteSequenceID();
        
        /**
         * Sets the "ByteSequenceID" element
         */
        void setByteSequenceID(short byteSequenceID);
        
        /**
         * Sets (as xml) the "ByteSequenceID" element
         */
        void xsetByteSequenceID(org.apache.xmlbeans.XmlShort byteSequenceID);
        
        /**
         * Gets the "PositionType" element
         */
        uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum getPositionType();
        
        /**
         * Gets (as xml) the "PositionType" element
         */
        uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType xgetPositionType();
        
        /**
         * Sets the "PositionType" element
         */
        void setPositionType(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum positionType);
        
        /**
         * Sets (as xml) the "PositionType" element
         */
        void xsetPositionType(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType positionType);
        
        /**
         * Gets the "Offset" element
         */
        java.lang.String getOffset();
        
        /**
         * Gets (as xml) the "Offset" element
         */
        org.apache.xmlbeans.XmlString xgetOffset();
        
        /**
         * Sets the "Offset" element
         */
        void setOffset(java.lang.String offset);
        
        /**
         * Sets (as xml) the "Offset" element
         */
        void xsetOffset(org.apache.xmlbeans.XmlString offset);
        
        /**
         * Gets the "MaxOffset" element
         */
        java.lang.String getMaxOffset();
        
        /**
         * Gets (as xml) the "MaxOffset" element
         */
        org.apache.xmlbeans.XmlString xgetMaxOffset();
        
        /**
         * Sets the "MaxOffset" element
         */
        void setMaxOffset(java.lang.String maxOffset);
        
        /**
         * Sets (as xml) the "MaxOffset" element
         */
        void xsetMaxOffset(org.apache.xmlbeans.XmlString maxOffset);
        
        /**
         * Gets the "IndirectOffsetLocation" element
         */
        java.lang.String getIndirectOffsetLocation();
        
        /**
         * Gets (as xml) the "IndirectOffsetLocation" element
         */
        org.apache.xmlbeans.XmlString xgetIndirectOffsetLocation();
        
        /**
         * Sets the "IndirectOffsetLocation" element
         */
        void setIndirectOffsetLocation(java.lang.String indirectOffsetLocation);
        
        /**
         * Sets (as xml) the "IndirectOffsetLocation" element
         */
        void xsetIndirectOffsetLocation(org.apache.xmlbeans.XmlString indirectOffsetLocation);
        
        /**
         * Gets the "IndirectOffsetLength" element
         */
        java.lang.String getIndirectOffsetLength();
        
        /**
         * Gets (as xml) the "IndirectOffsetLength" element
         */
        org.apache.xmlbeans.XmlString xgetIndirectOffsetLength();
        
        /**
         * Sets the "IndirectOffsetLength" element
         */
        void setIndirectOffsetLength(java.lang.String indirectOffsetLength);
        
        /**
         * Sets (as xml) the "IndirectOffsetLength" element
         */
        void xsetIndirectOffsetLength(org.apache.xmlbeans.XmlString indirectOffsetLength);
        
        /**
         * Gets the "Endianness" element
         */
        java.lang.String getEndianness();
        
        /**
         * Gets (as xml) the "Endianness" element
         */
        org.apache.xmlbeans.XmlString xgetEndianness();
        
        /**
         * Sets the "Endianness" element
         */
        void setEndianness(java.lang.String endianness);
        
        /**
         * Sets (as xml) the "Endianness" element
         */
        void xsetEndianness(org.apache.xmlbeans.XmlString endianness);
        
        /**
         * Gets the "ByteSequenceValue" element
         */
        java.lang.String getByteSequenceValue();
        
        /**
         * Gets (as xml) the "ByteSequenceValue" element
         */
        org.apache.xmlbeans.XmlString xgetByteSequenceValue();
        
        /**
         * Sets the "ByteSequenceValue" element
         */
        void setByteSequenceValue(java.lang.String byteSequenceValue);
        
        /**
         * Sets (as xml) the "ByteSequenceValue" element
         */
        void xsetByteSequenceValue(org.apache.xmlbeans.XmlString byteSequenceValue);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence newInstance() {
              return (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.ByteSequenceDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.ByteSequenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
