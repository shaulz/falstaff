/*
 * An XML document type.
 * Localname: CodeUnitWidth
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CodeUnitWidthDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CodeUnitWidth(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CodeUnitWidthDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CodeUnitWidthDocument
{
    private static final long serialVersionUID = 1L;
    
    public CodeUnitWidthDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CODEUNITWIDTH$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CodeUnitWidth");
    
    
    /**
     * Gets the "CodeUnitWidth" element
     */
    public java.lang.String getCodeUnitWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEUNITWIDTH$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CodeUnitWidth" element
     */
    public org.apache.xmlbeans.XmlString xgetCodeUnitWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEUNITWIDTH$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CodeUnitWidth" element
     */
    public void setCodeUnitWidth(java.lang.String codeUnitWidth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEUNITWIDTH$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODEUNITWIDTH$0);
            }
            target.setStringValue(codeUnitWidth);
        }
    }
    
    /**
     * Sets (as xml) the "CodeUnitWidth" element
     */
    public void xsetCodeUnitWidth(org.apache.xmlbeans.XmlString codeUnitWidth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEUNITWIDTH$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODEUNITWIDTH$0);
            }
            target.set(codeUnitWidth);
        }
    }
}
