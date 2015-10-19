/*
 * An XML document type.
 * Localname: SignatureID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SignatureIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SignatureID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SignatureIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SignatureIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public SignatureIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SIGNATUREID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureID");
    
    
    /**
     * Gets the "SignatureID" element
     */
    public short getSignatureID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATUREID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "SignatureID" element
     */
    public org.apache.xmlbeans.XmlShort xgetSignatureID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SIGNATUREID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SignatureID" element
     */
    public void setSignatureID(short signatureID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATUREID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATUREID$0);
            }
            target.setShortValue(signatureID);
        }
    }
    
    /**
     * Sets (as xml) the "SignatureID" element
     */
    public void xsetSignatureID(org.apache.xmlbeans.XmlShort signatureID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SIGNATUREID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(SIGNATUREID$0);
            }
            target.set(signatureID);
        }
    }
}
