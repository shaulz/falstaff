/*
 * An XML document type.
 * Localname: AvailabilityDescription
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one AvailabilityDescription(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class AvailabilityDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public AvailabilityDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AVAILABILITYDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AvailabilityDescription");
    
    
    /**
     * Gets the "AvailabilityDescription" element
     */
    public uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum getAvailabilityDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "AvailabilityDescription" element
     */
    public uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription xgetAvailabilityDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription target = null;
            target = (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription)get_store().find_element_user(AVAILABILITYDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AvailabilityDescription" element
     */
    public void setAvailabilityDescription(uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription.Enum availabilityDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABILITYDESCRIPTION$0);
            }
            target.setEnumValue(availabilityDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AvailabilityDescription" element
     */
    public void xsetAvailabilityDescription(uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription availabilityDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription target = null;
            target = (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription)get_store().find_element_user(AVAILABILITYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription)get_store().add_element_user(AVAILABILITYDESCRIPTION$0);
            }
            target.set(availabilityDescription);
        }
    }
    /**
     * An XML AvailabilityDescription(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument$AvailabilityDescription.
     */
    public static class AvailabilityDescriptionImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.AvailabilityDescriptionDocument.AvailabilityDescription
    {
        private static final long serialVersionUID = 1L;
        
        public AvailabilityDescriptionImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected AvailabilityDescriptionImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
