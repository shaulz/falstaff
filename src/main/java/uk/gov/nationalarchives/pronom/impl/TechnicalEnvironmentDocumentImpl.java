/*
 * An XML document type.
 * Localname: TechnicalEnvironment
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.TechnicalEnvironmentDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one TechnicalEnvironment(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class TechnicalEnvironmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.TechnicalEnvironmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public TechnicalEnvironmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TECHNICALENVIRONMENT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "TechnicalEnvironment");
    
    
    /**
     * Gets the "TechnicalEnvironment" element
     */
    public java.lang.String getTechnicalEnvironment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TECHNICALENVIRONMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TechnicalEnvironment" element
     */
    public org.apache.xmlbeans.XmlString xgetTechnicalEnvironment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TECHNICALENVIRONMENT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TechnicalEnvironment" element
     */
    public void setTechnicalEnvironment(java.lang.String technicalEnvironment)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TECHNICALENVIRONMENT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TECHNICALENVIRONMENT$0);
            }
            target.setStringValue(technicalEnvironment);
        }
    }
    
    /**
     * Sets (as xml) the "TechnicalEnvironment" element
     */
    public void xsetTechnicalEnvironment(org.apache.xmlbeans.XmlString technicalEnvironment)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TECHNICALENVIRONMENT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TECHNICALENVIRONMENT$0);
            }
            target.set(technicalEnvironment);
        }
    }
}
