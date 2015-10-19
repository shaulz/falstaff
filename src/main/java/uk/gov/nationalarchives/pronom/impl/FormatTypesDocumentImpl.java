/*
 * An XML document type.
 * Localname: FormatTypes
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatTypesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatTypes(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatTypesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatTypesDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatTypesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATTYPES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatTypes");
    
    
    /**
     * Gets the "FormatTypes" element
     */
    public java.lang.String getFormatTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATTYPES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatTypes" element
     */
    public org.apache.xmlbeans.XmlString xgetFormatTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATTYPES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatTypes" element
     */
    public void setFormatTypes(java.lang.String formatTypes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATTYPES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATTYPES$0);
            }
            target.setStringValue(formatTypes);
        }
    }
    
    /**
     * Sets (as xml) the "FormatTypes" element
     */
    public void xsetFormatTypes(org.apache.xmlbeans.XmlString formatTypes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATTYPES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATTYPES$0);
            }
            target.set(formatTypes);
        }
    }
}
