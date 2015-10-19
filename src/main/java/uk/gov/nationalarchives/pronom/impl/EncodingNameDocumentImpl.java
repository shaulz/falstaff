/*
 * An XML document type.
 * Localname: EncodingName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingName");
    
    
    /**
     * Gets the "EncodingName" element
     */
    public uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum getEncodingName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingName" element
     */
    public uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName xgetEncodingName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName target = null;
            target = (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName)get_store().find_element_user(ENCODINGNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingName" element
     */
    public void setEncodingName(uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum encodingName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGNAME$0);
            }
            target.setEnumValue(encodingName);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingName" element
     */
    public void xsetEncodingName(uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName encodingName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName target = null;
            target = (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName)get_store().find_element_user(ENCODINGNAME$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName)get_store().add_element_user(ENCODINGNAME$0);
            }
            target.set(encodingName);
        }
    }
    /**
     * An XML EncodingName(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.EncodingNameDocument$EncodingName.
     */
    public static class EncodingNameImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName
    {
        private static final long serialVersionUID = 1L;
        
        public EncodingNameImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected EncodingNameImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
