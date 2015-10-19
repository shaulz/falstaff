/*
 * An XML document type.
 * Localname: PropertyValueDescription
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PropertyValueDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PropertyValueDescription(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PropertyValueDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyValueDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropertyValueDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYVALUEDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyValueDescription");
    
    
    /**
     * Gets the "PropertyValueDescription" element
     */
    public java.lang.String getPropertyValueDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PropertyValueDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetPropertyValueDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PropertyValueDescription" element
     */
    public void setPropertyValueDescription(java.lang.String propertyValueDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYVALUEDESCRIPTION$0);
            }
            target.setStringValue(propertyValueDescription);
        }
    }
    
    /**
     * Sets (as xml) the "PropertyValueDescription" element
     */
    public void xsetPropertyValueDescription(org.apache.xmlbeans.XmlString propertyValueDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYVALUEDESCRIPTION$0);
            }
            target.set(propertyValueDescription);
        }
    }
}
