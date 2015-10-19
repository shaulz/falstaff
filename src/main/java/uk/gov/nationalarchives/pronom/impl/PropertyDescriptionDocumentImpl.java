/*
 * An XML document type.
 * Localname: PropertyDescription
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PropertyDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PropertyDescription(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PropertyDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropertyDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyDescription");
    
    
    /**
     * Gets the "PropertyDescription" element
     */
    public java.lang.String getPropertyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PropertyDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetPropertyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PropertyDescription" element
     */
    public void setPropertyDescription(java.lang.String propertyDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYDESCRIPTION$0);
            }
            target.setStringValue(propertyDescription);
        }
    }
    
    /**
     * Sets (as xml) the "PropertyDescription" element
     */
    public void xsetPropertyDescription(org.apache.xmlbeans.XmlString propertyDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYDESCRIPTION$0);
            }
            target.set(propertyDescription);
        }
    }
}
