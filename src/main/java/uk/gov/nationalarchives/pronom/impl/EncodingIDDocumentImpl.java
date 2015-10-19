/*
 * An XML document type.
 * Localname: EncodingID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.EncodingIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one EncodingID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class EncodingIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.EncodingIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodingIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODINGID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingID");
    
    
    /**
     * Gets the "EncodingID" element
     */
    public byte getEncodingID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getByteValue();
        }
    }
    
    /**
     * Gets (as xml) the "EncodingID" element
     */
    public uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID xgetEncodingID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID target = null;
            target = (uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID)get_store().find_element_user(ENCODINGID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EncodingID" element
     */
    public void setEncodingID(byte encodingID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGID$0);
            }
            target.setByteValue(encodingID);
        }
    }
    
    /**
     * Sets (as xml) the "EncodingID" element
     */
    public void xsetEncodingID(uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID encodingID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID target = null;
            target = (uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID)get_store().find_element_user(ENCODINGID$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID)get_store().add_element_user(ENCODINGID$0);
            }
            target.set(encodingID);
        }
    }
    /**
     * An XML EncodingID(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.EncodingIDDocument$EncodingID.
     */
    public static class EncodingIDImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID
    {
        private static final long serialVersionUID = 1L;
        
        public EncodingIDImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected EncodingIDImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
