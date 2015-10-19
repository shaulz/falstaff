/*
 * An XML document type.
 * Localname: ReferenceFileDocumentation
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileDocumentationDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFileDocumentation(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileDocumentationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileDocumentationDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileDocumentationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILEDOCUMENTATION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileDocumentation");
    
    
    /**
     * Gets the "ReferenceFileDocumentation" element
     */
    public java.lang.String getReferenceFileDocumentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReferenceFileDocumentation" element
     */
    public org.apache.xmlbeans.XmlString xgetReferenceFileDocumentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFileDocumentation" element
     */
    public void setReferenceFileDocumentation(java.lang.String referenceFileDocumentation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEDOCUMENTATION$0);
            }
            target.setStringValue(referenceFileDocumentation);
        }
    }
    
    /**
     * Sets (as xml) the "ReferenceFileDocumentation" element
     */
    public void xsetReferenceFileDocumentation(org.apache.xmlbeans.XmlString referenceFileDocumentation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILEDOCUMENTATION$0);
            }
            target.set(referenceFileDocumentation);
        }
    }
}
