/*
 * An XML document type.
 * Localname: EncodingVersion
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingVersionDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingVersion(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingVersionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingVersionDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingVersionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGVERSION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingVersion");
    
    
    /**
     * Gets the "EncodingVersion" element
     */
    public java.lang.String getEncodingVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGVERSION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingVersion" element
     */
    public org.apache.xmlbeans.XmlString xgetEncodingVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGVERSION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingVersion" element
     */
    public void setEncodingVersion(java.lang.String encodingVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGVERSION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGVERSION$0);
            }
            target.setStringValue(encodingVersion);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingVersion" element
     */
    public void xsetEncodingVersion(org.apache.xmlbeans.XmlString encodingVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGVERSION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGVERSION$0);
            }
            target.set(encodingVersion);
        }
    }
}
