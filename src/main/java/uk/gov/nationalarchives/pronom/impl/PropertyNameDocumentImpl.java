/*
 * An XML document type.
 * Localname: PropertyName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PropertyNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PropertyName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PropertyNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropertyNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyName");
    
    
    /**
     * Gets the "PropertyName" element
     */
    public java.lang.String getPropertyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PropertyName" element
     */
    public org.apache.xmlbeans.XmlString xgetPropertyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PropertyName" element
     */
    public void setPropertyName(java.lang.String propertyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYNAME$0);
            }
            target.setStringValue(propertyName);
        }
    }
    
    /**
     * Sets (as xml) the "PropertyName" element
     */
    public void xsetPropertyName(org.apache.xmlbeans.XmlString propertyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYNAME$0);
            }
            target.set(propertyName);
        }
    }
}
