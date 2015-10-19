/*
 * An XML document type.
 * Localname: EncodingDocumentation
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingDocumentationDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingDocumentation(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingDocumentationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingDocumentationDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingDocumentationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGDOCUMENTATION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingDocumentation");
    
    
    /**
     * Gets the "EncodingDocumentation" element
     */
    public java.lang.String getEncodingDocumentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGDOCUMENTATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingDocumentation" element
     */
    public org.apache.xmlbeans.XmlString xgetEncodingDocumentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGDOCUMENTATION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingDocumentation" element
     */
    public void setEncodingDocumentation(java.lang.String encodingDocumentation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGDOCUMENTATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGDOCUMENTATION$0);
            }
            target.setStringValue(encodingDocumentation);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingDocumentation" element
     */
    public void xsetEncodingDocumentation(org.apache.xmlbeans.XmlString encodingDocumentation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGDOCUMENTATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGDOCUMENTATION$0);
            }
            target.set(encodingDocumentation);
        }
    }
}
