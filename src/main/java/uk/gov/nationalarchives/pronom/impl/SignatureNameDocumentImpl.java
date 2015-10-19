/*
 * An XML document type.
 * Localname: SignatureName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SignatureNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SignatureName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SignatureNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SignatureNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public SignatureNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SIGNATURENAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureName");
    
    
    /**
     * Gets the "SignatureName" element
     */
    public java.lang.String getSignatureName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SignatureName" element
     */
    public org.apache.xmlbeans.XmlString xgetSignatureName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SignatureName" element
     */
    public void setSignatureName(java.lang.String signatureName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURENAME$0);
            }
            target.setStringValue(signatureName);
        }
    }
    
    /**
     * Sets (as xml) the "SignatureName" element
     */
    public void xsetSignatureName(org.apache.xmlbeans.XmlString signatureName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SIGNATURENAME$0);
            }
            target.set(signatureName);
        }
    }
}
