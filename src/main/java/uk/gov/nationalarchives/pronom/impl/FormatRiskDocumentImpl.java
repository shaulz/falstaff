/*
 * An XML document type.
 * Localname: FormatRisk
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatRiskDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatRisk(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatRiskDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatRiskDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatRiskDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATRISK$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatRisk");
    
    
    /**
     * Gets the "FormatRisk" element
     */
    public java.lang.String getFormatRisk()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATRISK$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatRisk" element
     */
    public org.apache.xmlbeans.XmlString xgetFormatRisk()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATRISK$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatRisk" element
     */
    public void setFormatRisk(java.lang.String formatRisk)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATRISK$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATRISK$0);
            }
            target.setStringValue(formatRisk);
        }
    }
    
    /**
     * Sets (as xml) the "FormatRisk" element
     */
    public void xsetFormatRisk(org.apache.xmlbeans.XmlString formatRisk)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATRISK$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATRISK$0);
            }
            target.set(formatRisk);
        }
    }
}
