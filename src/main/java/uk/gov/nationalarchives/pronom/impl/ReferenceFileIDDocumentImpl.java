/*
 * An XML document type.
 * Localname: ReferenceFileID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFileID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILEID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileID");
    
    
    /**
     * Gets the "ReferenceFileID" element
     */
    public byte getReferenceFileID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getByteValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReferenceFileID" element
     */
    public uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID xgetReferenceFileID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID)get_store().find_element_user(REFERENCEFILEID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFileID" element
     */
    public void setReferenceFileID(byte referenceFileID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEID$0);
            }
            target.setByteValue(referenceFileID);
        }
    }
    
    /**
     * Sets (as xml) the "ReferenceFileID" element
     */
    public void xsetReferenceFileID(uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID referenceFileID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID)get_store().find_element_user(REFERENCEFILEID$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID)get_store().add_element_user(REFERENCEFILEID$0);
            }
            target.set(referenceFileID);
        }
    }
    /**
     * An XML ReferenceFileID(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.ReferenceFileIDDocument$ReferenceFileID.
     */
    public static class ReferenceFileIDImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID
    {
        private static final long serialVersionUID = 1L;
        
        public ReferenceFileIDImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ReferenceFileIDImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
