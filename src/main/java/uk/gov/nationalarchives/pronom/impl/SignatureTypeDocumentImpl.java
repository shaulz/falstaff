/*
 * An XML document type.
 * Localname: SignatureType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SignatureTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SignatureType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SignatureTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SignatureTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public SignatureTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SIGNATURETYPE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureType");
    
    
    /**
     * Gets the "SignatureType" element
     */
    public uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType.Enum getSignatureType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURETYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "SignatureType" element
     */
    public uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType xgetSignatureType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType target = null;
            target = (uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType)get_store().find_element_user(SIGNATURETYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SignatureType" element
     */
    public void setSignatureType(uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType.Enum signatureType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURETYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURETYPE$0);
            }
            target.setEnumValue(signatureType);
        }
    }
    
    /**
     * Sets (as xml) the "SignatureType" element
     */
    public void xsetSignatureType(uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType signatureType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType target = null;
            target = (uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType)get_store().find_element_user(SIGNATURETYPE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType)get_store().add_element_user(SIGNATURETYPE$0);
            }
            target.set(signatureType);
        }
    }
    /**
     * An XML SignatureType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.SignatureTypeDocument$SignatureType.
     */
    public static class SignatureTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType
    {
        private static final long serialVersionUID = 1L;
        
        public SignatureTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected SignatureTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
