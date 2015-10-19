/*
 * An XML document type.
 * Localname: ExternalSignature
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ExternalSignatureDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ExternalSignature(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ExternalSignatureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ExternalSignatureDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExternalSignatureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTERNALSIGNATURE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ExternalSignature");
    
    
    /**
     * Gets the "ExternalSignature" element
     */
    public uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature getExternalSignature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature target = null;
            target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().find_element_user(EXTERNALSIGNATURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ExternalSignature" element
     */
    public void setExternalSignature(uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature externalSignature)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature target = null;
            target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().find_element_user(EXTERNALSIGNATURE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().add_element_user(EXTERNALSIGNATURE$0);
            }
            target.set(externalSignature);
        }
    }
    
    /**
     * Appends and returns a new empty "ExternalSignature" element
     */
    public uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature addNewExternalSignature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature target = null;
            target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().add_element_user(EXTERNALSIGNATURE$0);
            return target;
        }
    }
    /**
     * An XML ExternalSignature(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class ExternalSignatureImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature
    {
        private static final long serialVersionUID = 1L;
        
        public ExternalSignatureImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName EXTERNALSIGNATUREID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ExternalSignatureID");
        private static final javax.xml.namespace.QName SIGNATURE$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Signature");
        private static final javax.xml.namespace.QName SIGNATURETYPE$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureType");
        
        
        /**
         * Gets the "ExternalSignatureID" element
         */
        public short getExternalSignatureID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSIGNATUREID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "ExternalSignatureID" element
         */
        public org.apache.xmlbeans.XmlShort xgetExternalSignatureID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(EXTERNALSIGNATUREID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ExternalSignatureID" element
         */
        public void setExternalSignatureID(short externalSignatureID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSIGNATUREID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALSIGNATUREID$0);
                }
                target.setShortValue(externalSignatureID);
            }
        }
        
        /**
         * Sets (as xml) the "ExternalSignatureID" element
         */
        public void xsetExternalSignatureID(org.apache.xmlbeans.XmlShort externalSignatureID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(EXTERNALSIGNATUREID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(EXTERNALSIGNATUREID$0);
                }
                target.set(externalSignatureID);
            }
        }
        
        /**
         * Gets the "Signature" element
         */
        public java.lang.String getSignature()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURE$2, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURE$2, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURE$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SIGNATURE$2);
                }
                target.set(signature);
            }
        }
        
        /**
         * Gets the "SignatureType" element
         */
        public uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType.Enum getSignatureType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURETYPE$4, 0);
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
                target = (uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType)get_store().find_element_user(SIGNATURETYPE$4, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURETYPE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURETYPE$4);
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
                target = (uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType)get_store().find_element_user(SIGNATURETYPE$4, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.SignatureTypeDocument.SignatureType)get_store().add_element_user(SIGNATURETYPE$4);
                }
                target.set(signatureType);
            }
        }
    }
}
