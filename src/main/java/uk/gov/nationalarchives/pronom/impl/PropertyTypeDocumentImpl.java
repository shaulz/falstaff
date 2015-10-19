/*
 * An XML document type.
 * Localname: PropertyType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PropertyTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PropertyType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PropertyTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropertyTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYTYPE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyType");
    
    
    /**
     * Gets the "PropertyType" element
     */
    public uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType.Enum getPropertyType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "PropertyType" element
     */
    public uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType xgetPropertyType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType target = null;
            target = (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType)get_store().find_element_user(PROPERTYTYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PropertyType" element
     */
    public void setPropertyType(uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType.Enum propertyType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYTYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYTYPE$0);
            }
            target.setEnumValue(propertyType);
        }
    }
    
    /**
     * Sets (as xml) the "PropertyType" element
     */
    public void xsetPropertyType(uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType propertyType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType target = null;
            target = (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType)get_store().find_element_user(PROPERTYTYPE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType)get_store().add_element_user(PROPERTYTYPE$0);
            }
            target.set(propertyType);
        }
    }
    /**
     * An XML PropertyType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.PropertyTypeDocument$PropertyType.
     */
    public static class PropertyTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType
    {
        private static final long serialVersionUID = 1L;
        
        public PropertyTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected PropertyTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
