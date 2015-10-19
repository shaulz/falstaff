/*
 * An XML document type.
 * Localname: ReferenceFileDescription
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFileDescription(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILEDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileDescription");
    
    
    /**
     * Gets the "ReferenceFileDescription" element
     */
    public java.lang.String getReferenceFileDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReferenceFileDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetReferenceFileDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFileDescription" element
     */
    public void setReferenceFileDescription(java.lang.String referenceFileDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEDESCRIPTION$0);
            }
            target.setStringValue(referenceFileDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ReferenceFileDescription" element
     */
    public void xsetReferenceFileDescription(org.apache.xmlbeans.XmlString referenceFileDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILEDESCRIPTION$0);
            }
            target.set(referenceFileDescription);
        }
    }
}
