/*
 * An XML document type.
 * Localname: Signature
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SignatureDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Signature(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SignatureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SignatureDocument
{
    private static final long serialVersionUID = 1L;
    
    public SignatureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SIGNATURE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Signature");
    
    
    /**
     * Gets the "Signature" element
     */
    public java.lang.String getSignature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Signature" element
     */
    public org.apache.xmlbeans.XmlString xgetSignature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Signature" element
     */
    public void setSignature(java.lang.String signature)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURE$0);
            }
            target.setStringValue(signature);
        }
    }
    
    /**
     * Sets (as xml) the "Signature" element
     */
    public void xsetSignature(org.apache.xmlbeans.XmlString signature)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SIGNATURE$0);
            }
            target.set(signature);
        }
    }
}
