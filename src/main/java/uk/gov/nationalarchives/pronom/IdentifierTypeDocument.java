/*
 * An XML document type.
 * Localname: IdentifierType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.IdentifierTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one IdentifierType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface IdentifierTypeDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(IdentifierTypeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("identifiertypec260doctype");
    
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
     * An XML IdentifierType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.IdentifierTypeDocument$IdentifierType.
     */
    public interface IdentifierType extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(IdentifierType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("identifiertype4941elemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum APPLE_UNIFORM_TYPE_IDENTIFIER = Enum.forString("Apple Uniform Type Identifier");
        static final Enum GDFR_FORMAT_IDENTIFIER = Enum.forString("GDFR Format Identifier");
        static final Enum ISBN = Enum.forString("ISBN");
        static final Enum MIME = Enum.forString("MIME");
        static final Enum PUID = Enum.forString("PUID");
        static final Enum URL = Enum.forString("URL");
        static final Enum WAVE_FORMAT_GUID = Enum.forString("WAVE Format GUID");
        
        static final int INT_APPLE_UNIFORM_TYPE_IDENTIFIER = Enum.INT_APPLE_UNIFORM_TYPE_IDENTIFIER;
        static final int INT_GDFR_FORMAT_IDENTIFIER = Enum.INT_GDFR_FORMAT_IDENTIFIER;
        static final int INT_ISBN = Enum.INT_ISBN;
        static final int INT_MIME = Enum.INT_MIME;
        static final int INT_PUID = Enum.INT_PUID;
        static final int INT_URL = Enum.INT_URL;
        static final int INT_WAVE_FORMAT_GUID = Enum.INT_WAVE_FORMAT_GUID;
        
        /**
         * Enumeration value class for uk.gov.nationalarchives.pronom.IdentifierTypeDocument$IdentifierType.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_APPLE_UNIFORM_TYPE_IDENTIFIER
         * Enum.forString(s); // returns the enum value for a string
         * Enum.forInt(i); // returns the enum value for an int
         * </pre>
         * Enumeration objects are immutable singleton objects that
         * can be compared using == object equality. They have no
         * public constructor. See the constants defined within this
         * class for all the valid values.
         */
        static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
        {
            /**
             * Returns the enum value for a string, or null if none.
             */
            public static Enum forString(java.lang.String s)
                { return (Enum)table.forString(s); }
            /**
             * Returns the enum value corresponding to an int, or null if none.
             */
            public static Enum forInt(int i)
                { return (Enum)table.forInt(i); }
            
            private Enum(java.lang.String s, int i)
                { super(s, i); }
            
            static final int INT_APPLE_UNIFORM_TYPE_IDENTIFIER = 1;
            static final int INT_GDFR_FORMAT_IDENTIFIER = 2;
            static final int INT_ISBN = 3;
            static final int INT_MIME = 4;
            static final int INT_PUID = 5;
            static final int INT_URL = 6;
            static final int INT_WAVE_FORMAT_GUID = 7;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("Apple Uniform Type Identifier", INT_APPLE_UNIFORM_TYPE_IDENTIFIER),
                    new Enum("GDFR Format Identifier", INT_GDFR_FORMAT_IDENTIFIER),
                    new Enum("ISBN", INT_ISBN),
                    new Enum("MIME", INT_MIME),
                    new Enum("PUID", INT_PUID),
                    new Enum("URL", INT_URL),
                    new Enum("WAVE Format GUID", INT_WAVE_FORMAT_GUID),
                }
            );
            private static final long serialVersionUID = 1L;
            private java.lang.Object readResolve() { return forInt(intValue()); } 
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType newValue(java.lang.Object obj) {
              return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType) type.newValue( obj ); }
            
            public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType newInstance() {
              return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.IdentifierTypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
