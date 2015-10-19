/*
 * An XML document type.
 * Localname: SearchCriteria
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SearchCriteriaDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one SearchCriteria(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface SearchCriteriaDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SearchCriteriaDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("searchcriteriab504doctype");
    
    /**
     * Gets the "SearchCriteria" element
     */
    uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria.Enum getSearchCriteria();
    
    /**
     * Gets (as xml) the "SearchCriteria" element
     */
    uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria xgetSearchCriteria();
    
    /**
     * Sets the "SearchCriteria" element
     */
    void setSearchCriteria(uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria.Enum searchCriteria);
    
    /**
     * Sets (as xml) the "SearchCriteria" element
     */
    void xsetSearchCriteria(uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria searchCriteria);
    
    /**
     * An XML SearchCriteria(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.SearchCriteriaDocument$SearchCriteria.
     */
    public interface SearchCriteria extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SearchCriteria.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("searchcriteria65c1elemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum CRITERIA = Enum.forString("Criteria");
        
        static final int INT_CRITERIA = Enum.INT_CRITERIA;
        
        /**
         * Enumeration value class for uk.gov.nationalarchives.pronom.SearchCriteriaDocument$SearchCriteria.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_CRITERIA
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
            
            static final int INT_CRITERIA = 1;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("Criteria", INT_CRITERIA),
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
            public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria newValue(java.lang.Object obj) {
              return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria) type.newValue( obj ); }
            
            public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria newInstance() {
              return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.SearchCriteriaDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
