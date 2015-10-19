/*
 * An XML document type.
 * Localname: AvailabilityNote
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.AvailabilityNoteDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one AvailabilityNote(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class AvailabilityNoteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.AvailabilityNoteDocument
{
    private static final long serialVersionUID = 1L;
    
    public AvailabilityNoteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AVAILABILITYNOTE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "AvailabilityNote");
    
    
    /**
     * Gets the "AvailabilityNote" element
     */
    public java.lang.String getAvailabilityNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYNOTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AvailabilityNote" element
     */
    public org.apache.xmlbeans.XmlString xgetAvailabilityNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYNOTE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AvailabilityNote" element
     */
    public void setAvailabilityNote(java.lang.String availabilityNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABILITYNOTE$0);
            }
            target.setStringValue(availabilityNote);
        }
    }
    
    /**
     * Sets (as xml) the "AvailabilityNote" element
     */
    public void xsetAvailabilityNote(org.apache.xmlbeans.XmlString availabilityNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AVAILABILITYNOTE$0);
            }
            target.set(availabilityNote);
        }
    }
}
