/*
 * An XML document type.
 * Localname: RelatedFormatVersion
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.RelatedFormatVersionDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one RelatedFormatVersion(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class RelatedFormatVersionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.RelatedFormatVersionDocument
{
    private static final long serialVersionUID = 1L;
    
    public RelatedFormatVersionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RELATEDFORMATVERSION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormatVersion");
    
    
    /**
     * Gets the "RelatedFormatVersion" element
     */
    public java.lang.String getRelatedFormatVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATVERSION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "RelatedFormatVersion" element
     */
    public org.apache.xmlbeans.XmlString xgetRelatedFormatVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATVERSION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "RelatedFormatVersion" element
     */
    public void setRelatedFormatVersion(java.lang.String relatedFormatVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATVERSION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATEDFORMATVERSION$0);
            }
            target.setStringValue(relatedFormatVersion);
        }
    }
    
    /**
     * Sets (as xml) the "RelatedFormatVersion" element
     */
    public void xsetRelatedFormatVersion(org.apache.xmlbeans.XmlString relatedFormatVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATVERSION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELATEDFORMATVERSION$0);
            }
            target.set(relatedFormatVersion);
        }
    }
}
