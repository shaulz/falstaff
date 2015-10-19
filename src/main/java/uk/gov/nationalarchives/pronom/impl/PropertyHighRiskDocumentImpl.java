/*
 * An XML document type.
 * Localname: PropertyHighRisk
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PropertyHighRiskDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PropertyHighRisk(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PropertyHighRiskDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyHighRiskDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropertyHighRiskDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYHIGHRISK$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyHighRisk");
    
    
    /**
     * Gets the "PropertyHighRisk" element
     */
    public java.lang.String getPropertyHighRisk()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYHIGHRISK$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PropertyHighRisk" element
     */
    public org.apache.xmlbeans.XmlString xgetPropertyHighRisk()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYHIGHRISK$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PropertyHighRisk" element
     */
    public void setPropertyHighRisk(java.lang.String propertyHighRisk)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYHIGHRISK$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYHIGHRISK$0);
            }
            target.setStringValue(propertyHighRisk);
        }
    }
    
    /**
     * Sets (as xml) the "PropertyHighRisk" element
     */
    public void xsetPropertyHighRisk(org.apache.xmlbeans.XmlString propertyHighRisk)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYHIGHRISK$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYHIGHRISK$0);
            }
            target.set(propertyHighRisk);
        }
    }
}
