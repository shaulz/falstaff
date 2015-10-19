/*
 * An XML document type.
 * Localname: SignatureNote
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.SignatureNoteDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one SignatureNote(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class SignatureNoteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.SignatureNoteDocument
{
    private static final long serialVersionUID = 1L;
    
    public SignatureNoteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SIGNATURENOTE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureNote");
    
    
    /**
     * Gets the "SignatureNote" element
     */
    public java.lang.String getSignatureNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENOTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SignatureNote" element
     */
    public org.apache.xmlbeans.XmlString xgetSignatureNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENOTE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SignatureNote" element
     */
    public void setSignatureNote(java.lang.String signatureNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURENOTE$0);
            }
            target.setStringValue(signatureNote);
        }
    }
    
    /**
     * Sets (as xml) the "SignatureNote" element
     */
    public void xsetSignatureNote(org.apache.xmlbeans.XmlString signatureNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SIGNATURENOTE$0);
            }
            target.set(signatureNote);
        }
    }
}
