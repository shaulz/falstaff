/*
 * An XML document type.
 * Localname: DocumentIPR
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentIPRDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DocumentIPR(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DocumentIPRDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentIPRDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentIPRDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTIPR$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentIPR");
    
    
    /**
     * Gets the "DocumentIPR" element
     */
    public java.lang.String getDocumentIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTIPR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentIPR" element
     */
    public org.apache.xmlbeans.XmlString xgetDocumentIPR()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTIPR$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentIPR" element
     */
    public void setDocumentIPR(java.lang.String documentIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTIPR$0);
            }
            target.setStringValue(documentIPR);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentIPR" element
     */
    public void xsetDocumentIPR(org.apache.xmlbeans.XmlString documentIPR)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTIPR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DOCUMENTIPR$0);
            }
            target.set(documentIPR);
        }
    }
}
