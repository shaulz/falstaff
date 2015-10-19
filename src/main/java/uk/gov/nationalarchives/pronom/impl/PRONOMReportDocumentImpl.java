/*
 * An XML document type.
 * Localname: PRONOM-Report
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PRONOMReportDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PRONOM-Report(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PRONOMReportDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PRONOMReportDocument
{
    private static final long serialVersionUID = 1L;
    
    public PRONOMReportDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PRONOMREPORT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PRONOM-Report");
    
    
    /**
     * Gets the "PRONOM-Report" element
     */
    public uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport getPRONOMReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport target = null;
            target = (uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport)get_store().find_element_user(PRONOMREPORT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "PRONOM-Report" element
     */
    public void setPRONOMReport(uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport pronomReport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport target = null;
            target = (uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport)get_store().find_element_user(PRONOMREPORT$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport)get_store().add_element_user(PRONOMREPORT$0);
            }
            target.set(pronomReport);
        }
    }
    
    /**
     * Appends and returns a new empty "PRONOM-Report" element
     */
    public uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport addNewPRONOMReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport target = null;
            target = (uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport)get_store().add_element_user(PRONOMREPORT$0);
            return target;
        }
    }
    /**
     * An XML PRONOM-Report(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class PRONOMReportImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PRONOMReportDocument.PRONOMReport
    {
        private static final long serialVersionUID = 1L;
        
        public PRONOMReportImpl(org.apache.xmlbeans.SchemaType sType)
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
    }
}
