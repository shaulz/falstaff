/*
 * An XML document type.
 * Localname: report_format_detail
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReportFormatDetailDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one report_format_detail(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReportFormatDetailDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReportFormatDetailDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReportFormatDetailDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REPORTFORMATDETAIL$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "report_format_detail");
    
    
    /**
     * Gets the "report_format_detail" element
     */
    public uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail getReportFormatDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail target = null;
            target = (uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail)get_store().find_element_user(REPORTFORMATDETAIL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "report_format_detail" element
     */
    public void setReportFormatDetail(uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail reportFormatDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail target = null;
            target = (uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail)get_store().find_element_user(REPORTFORMATDETAIL$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail)get_store().add_element_user(REPORTFORMATDETAIL$0);
            }
            target.set(reportFormatDetail);
        }
    }
    
    /**
     * Appends and returns a new empty "report_format_detail" element
     */
    public uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail addNewReportFormatDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail target = null;
            target = (uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail)get_store().add_element_user(REPORTFORMATDETAIL$0);
            return target;
        }
    }
    /**
     * An XML report_format_detail(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class ReportFormatDetailImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReportFormatDetailDocument.ReportFormatDetail
    {
        private static final long serialVersionUID = 1L;
        
        public ReportFormatDetailImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FILEFORMAT$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FileFormat");
        private static final javax.xml.namespace.QName SEARCHCRITERIA$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SearchCriteria");
        
        
        /**
         * Gets the "FileFormat" element
         */
        public uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat getFileFormat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat target = null;
                target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().find_element_user(FILEFORMAT$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "FileFormat" element
         */
        public void setFileFormat(uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat fileFormat)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat target = null;
                target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().find_element_user(FILEFORMAT$0, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().add_element_user(FILEFORMAT$0);
                }
                target.set(fileFormat);
            }
        }
        
        /**
         * Appends and returns a new empty "FileFormat" element
         */
        public uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat addNewFileFormat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat target = null;
                target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().add_element_user(FILEFORMAT$0);
                return target;
            }
        }
        
        /**
         * Gets the "SearchCriteria" element
         */
        public uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria.Enum getSearchCriteria()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEARCHCRITERIA$2, 0);
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
                target = (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria)get_store().find_element_user(SEARCHCRITERIA$2, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEARCHCRITERIA$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SEARCHCRITERIA$2);
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
                target = (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria)get_store().find_element_user(SEARCHCRITERIA$2, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.SearchCriteriaDocument.SearchCriteria)get_store().add_element_user(SEARCHCRITERIA$2);
                }
                target.set(searchCriteria);
            }
        }
    }
}
