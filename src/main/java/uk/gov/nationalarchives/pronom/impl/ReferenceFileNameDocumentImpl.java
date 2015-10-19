/*
 * An XML document type.
 * Localname: ReferenceFileName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFileName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILENAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileName");
    
    
    /**
     * Gets the "ReferenceFileName" element
     */
    public uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName.Enum getReferenceFileName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReferenceFileName" element
     */
    public uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName xgetReferenceFileName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName)get_store().find_element_user(REFERENCEFILENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFileName" element
     */
    public void setReferenceFileName(uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName.Enum referenceFileName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILENAME$0);
            }
            target.setEnumValue(referenceFileName);
        }
    }
    
    /**
     * Sets (as xml) the "ReferenceFileName" element
     */
    public void xsetReferenceFileName(uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName referenceFileName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName)get_store().find_element_user(REFERENCEFILENAME$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName)get_store().add_element_user(REFERENCEFILENAME$0);
            }
            target.set(referenceFileName);
        }
    }
    /**
     * An XML ReferenceFileName(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.ReferenceFileNameDocument$ReferenceFileName.
     */
    public static class ReferenceFileNameImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName
    {
        private static final long serialVersionUID = 1L;
        
        public ReferenceFileNameImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ReferenceFileNameImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
