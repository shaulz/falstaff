/*
 * An XML document type.
 * Localname: SearchCriteria
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SearchCriteriaDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SearchCriteria(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SearchCriteriaDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SearchCriteriaDocument
{
    private static final long serialVersionUID = 1L;
    
    public SearchCriteriaDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SEARCHCRITERIA$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SearchCriteria");
    
    
    /**
     * Gets the "SearchCriteria" element
     */
    public uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria.Enum getSearchCriteria()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEARCHCRITERIA$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "SearchCriteria" element
     */
    public uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria xgetSearchCriteria()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria target = null;
            target = (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria)get_store().find_element_user(SEARCHCRITERIA$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SearchCriteria" element
     */
    public void setSearchCriteria(uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria.Enum searchCriteria)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEARCHCRITERIA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SEARCHCRITERIA$0);
            }
            target.setEnumValue(searchCriteria);
        }
    }
    
    /**
     * Sets (as xml) the "SearchCriteria" element
     */
    public void xsetSearchCriteria(uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria searchCriteria)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria target = null;
            target = (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria)get_store().find_element_user(SEARCHCRITERIA$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria)get_store().add_element_user(SEARCHCRITERIA$0);
            }
            target.set(searchCriteria);
        }
    }
    /**
     * An XML SearchCriteria(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.SearchCriteriaDocument$SearchCriteria.
     */
    public static class SearchCriteriaImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria
    {
        private static final long serialVersionUID = 1L;
        
        public SearchCriteriaImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected SearchCriteriaImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
