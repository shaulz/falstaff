/*
 * An XML document type.
 * Localname: ProvenanceSourceID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ProvenanceSourceID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ProvenanceSourceIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProvenanceSourceIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROVENANCESOURCEID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceSourceID");
    
    
    /**
     * Gets the "ProvenanceSourceID" element
     */
    public short getProvenanceSourceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProvenanceSourceID" element
     */
    public uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID xgetProvenanceSourceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID target = null;
            target = (uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID)get_store().find_element_user(PROVENANCESOURCEID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ProvenanceSourceID" element
     */
    public void setProvenanceSourceID(short provenanceSourceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCESOURCEID$0);
            }
            target.setShortValue(provenanceSourceID);
        }
    }
    
    /**
     * Sets (as xml) the "ProvenanceSourceID" element
     */
    public void xsetProvenanceSourceID(uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID provenanceSourceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID target = null;
            target = (uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID)get_store().find_element_user(PROVENANCESOURCEID$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID)get_store().add_element_user(PROVENANCESOURCEID$0);
            }
            target.set(provenanceSourceID);
        }
    }
    /**
     * An XML ProvenanceSourceID(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument$ProvenanceSourceID.
     */
    public static class ProvenanceSourceIDImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID
    {
        private static final long serialVersionUID = 1L;
        
        public ProvenanceSourceIDImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ProvenanceSourceIDImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
