/*
 * An XML document type.
 * Localname: CompressionDocumentation
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionDocumentationDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionDocumentation(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionDocumentationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionDocumentationDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionDocumentationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONDOCUMENTATION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionDocumentation");
    
    
    /**
     * Gets the "CompressionDocumentation" element
     */
    public java.lang.String getCompressionDocumentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONDOCUMENTATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CompressionDocumentation" element
     */
    public org.apache.xmlbeans.XmlString xgetCompressionDocumentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONDOCUMENTATION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CompressionDocumentation" element
     */
    public void setCompressionDocumentation(java.lang.String compressionDocumentation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONDOCUMENTATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONDOCUMENTATION$0);
            }
            target.setStringValue(compressionDocumentation);
        }
    }
    
    /**
     * Sets (as xml) the "CompressionDocumentation" element
     */
    public void xsetCompressionDocumentation(org.apache.xmlbeans.XmlString compressionDocumentation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONDOCUMENTATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONDOCUMENTATION$0);
            }
            target.set(compressionDocumentation);
        }
    }
}
