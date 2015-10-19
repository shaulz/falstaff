/*
 * An XML document type.
 * Localname: PropertyRisks
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PropertyRisksDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PropertyRisks(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PropertyRisksDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyRisksDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropertyRisksDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYRISKS$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyRisks");
    
    
    /**
     * Gets the "PropertyRisks" element
     */
    public uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks getPropertyRisks()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks target = null;
            target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().find_element_user(PROPERTYRISKS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "PropertyRisks" element
     */
    public void setPropertyRisks(uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks propertyRisks)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks target = null;
            target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().find_element_user(PROPERTYRISKS$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().add_element_user(PROPERTYRISKS$0);
            }
            target.set(propertyRisks);
        }
    }
    
    /**
     * Appends and returns a new empty "PropertyRisks" element
     */
    public uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks addNewPropertyRisks()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks target = null;
            target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().add_element_user(PROPERTYRISKS$0);
            return target;
        }
    }
    /**
     * An XML PropertyRisks(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class PropertyRisksImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks
    {
        private static final long serialVersionUID = 1L;
        
        public PropertyRisksImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}
