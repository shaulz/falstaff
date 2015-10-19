/*
 * An XML document type.
 * Localname: ReferenceFileNote
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileNoteDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFileNote(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileNoteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileNoteDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileNoteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILENOTE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileNote");
    
    
    /**
     * Gets the "ReferenceFileNote" element
     */
    public java.lang.String getReferenceFileNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENOTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReferenceFileNote" element
     */
    public org.apache.xmlbeans.XmlString xgetReferenceFileNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILENOTE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFileNote" element
     */
    public void setReferenceFileNote(java.lang.String referenceFileNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILENOTE$0);
            }
            target.setStringValue(referenceFileNote);
        }
    }
    
    /**
     * Sets (as xml) the "ReferenceFileNote" element
     */
    public void xsetReferenceFileNote(org.apache.xmlbeans.XmlString referenceFileNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILENOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILENOTE$0);
            }
            target.set(referenceFileNote);
        }
    }
}
