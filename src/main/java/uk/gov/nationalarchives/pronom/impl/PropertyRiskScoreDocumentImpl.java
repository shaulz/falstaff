/*
 * An XML document type.
 * Localname: PropertyRiskScore
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PropertyRiskScoreDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PropertyRiskScore(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PropertyRiskScoreDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyRiskScoreDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropertyRiskScoreDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYRISKSCORE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyRiskScore");
    
    
    /**
     * Gets the "PropertyRiskScore" element
     */
    public java.lang.String getPropertyRiskScore()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYRISKSCORE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PropertyRiskScore" element
     */
    public org.apache.xmlbeans.XmlString xgetPropertyRiskScore()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYRISKSCORE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PropertyRiskScore" element
     */
    public void setPropertyRiskScore(java.lang.String propertyRiskScore)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYRISKSCORE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYRISKSCORE$0);
            }
            target.setStringValue(propertyRiskScore);
        }
    }
    
    /**
     * Sets (as xml) the "PropertyRiskScore" element
     */
    public void xsetPropertyRiskScore(org.apache.xmlbeans.XmlString propertyRiskScore)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYRISKSCORE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYRISKSCORE$0);
            }
            target.set(propertyRiskScore);
        }
    }
}
