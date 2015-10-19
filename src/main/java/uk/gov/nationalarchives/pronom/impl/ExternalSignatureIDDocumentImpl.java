/*
 * An XML document type.
 * Localname: ExternalSignatureID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ExternalSignatureIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ExternalSignatureID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ExternalSignatureIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ExternalSignatureIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExternalSignatureIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTERNALSIGNATUREID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ExternalSignatureID");
    
    
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
}
