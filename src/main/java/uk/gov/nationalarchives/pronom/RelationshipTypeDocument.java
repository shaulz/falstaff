/*
 * An XML document type.
 * Localname: RelationshipType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.RelationshipTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one RelationshipType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface RelationshipTypeDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RelationshipTypeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("relationshiptype06efdoctype");
    
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
     * An XML RelationshipType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.RelationshipTypeDocument$RelationshipType.
     */
    public interface RelationshipType extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RelationshipType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("relationshiptype9861elemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum CAN_BE_CONTAINED_BY = Enum.forString("Can be contained by");
        static final Enum CAN_CONTAIN = Enum.forString("Can contain");
        static final Enum EQUIVALENT_TO = Enum.forString("Equivalent to");
        static final Enum HAS_LOWER_PRIORITY_THAN = Enum.forString("Has lower priority than");
        static final Enum HAS_PRIORITY_OVER = Enum.forString("Has priority over");
        static final Enum IS_PREVIOUS_VERSION_OF = Enum.forString("Is previous version of");
        static final Enum IS_SUBSEQUENT_VERSION_OF = Enum.forString("Is subsequent version of");
        static final Enum IS_SUBTYPE_OF = Enum.forString("Is subtype of");
        static final Enum IS_SUPERTYPE_OF = Enum.forString("Is supertype of");
        
        static final int INT_CAN_BE_CONTAINED_BY = Enum.INT_CAN_BE_CONTAINED_BY;
        static final int INT_CAN_CONTAIN = Enum.INT_CAN_CONTAIN;
        static final int INT_EQUIVALENT_TO = Enum.INT_EQUIVALENT_TO;
        static final int INT_HAS_LOWER_PRIORITY_THAN = Enum.INT_HAS_LOWER_PRIORITY_THAN;
        static final int INT_HAS_PRIORITY_OVER = Enum.INT_HAS_PRIORITY_OVER;
        static final int INT_IS_PREVIOUS_VERSION_OF = Enum.INT_IS_PREVIOUS_VERSION_OF;
        static final int INT_IS_SUBSEQUENT_VERSION_OF = Enum.INT_IS_SUBSEQUENT_VERSION_OF;
        static final int INT_IS_SUBTYPE_OF = Enum.INT_IS_SUBTYPE_OF;
        static final int INT_IS_SUPERTYPE_OF = Enum.INT_IS_SUPERTYPE_OF;
        
        /**
         * Enumeration value class for uk.gov.nationalarchives.pronom.RelationshipTypeDocument$RelationshipType.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_CAN_BE_CONTAINED_BY
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
            
            static final int INT_CAN_BE_CONTAINED_BY = 1;
            static final int INT_CAN_CONTAIN = 2;
            static final int INT_EQUIVALENT_TO = 3;
            static final int INT_HAS_LOWER_PRIORITY_THAN = 4;
            static final int INT_HAS_PRIORITY_OVER = 5;
            static final int INT_IS_PREVIOUS_VERSION_OF = 6;
            static final int INT_IS_SUBSEQUENT_VERSION_OF = 7;
            static final int INT_IS_SUBTYPE_OF = 8;
            static final int INT_IS_SUPERTYPE_OF = 9;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("Can be contained by", INT_CAN_BE_CONTAINED_BY),
                    new Enum("Can contain", INT_CAN_CONTAIN),
                    new Enum("Equivalent to", INT_EQUIVALENT_TO),
                    new Enum("Has lower priority than", INT_HAS_LOWER_PRIORITY_THAN),
                    new Enum("Has priority over", INT_HAS_PRIORITY_OVER),
                    new Enum("Is previous version of", INT_IS_PREVIOUS_VERSION_OF),
                    new Enum("Is subsequent version of", INT_IS_SUBSEQUENT_VERSION_OF),
                    new Enum("Is subtype of", INT_IS_SUBTYPE_OF),
                    new Enum("Is supertype of", INT_IS_SUPERTYPE_OF),
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
            public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType newValue(java.lang.Object obj) {
              return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType) type.newValue( obj ); }
            
            public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType newInstance() {
              return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.RelationshipTypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
