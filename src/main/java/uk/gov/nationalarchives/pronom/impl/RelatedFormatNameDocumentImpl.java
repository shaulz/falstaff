/*
 * An XML document type.
 * Localname: RelatedFormatName
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.RelatedFormatNameDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one RelatedFormatName(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class RelatedFormatNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.RelatedFormatNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public RelatedFormatNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RELATEDFORMATNAME$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormatName");
    
    
    /**
     * Gets the "RelatedFormatName" element
     */
    public java.lang.String getRelatedFormatName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "RelatedFormatName" element
     */
    public org.apache.xmlbeans.XmlString xgetRelatedFormatName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "RelatedFormatName" element
     */
    public void setRelatedFormatName(java.lang.String relatedFormatName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATEDFORMATNAME$0);
            }
            target.setStringValue(relatedFormatName);
        }
    }
    
    /**
     * Sets (as xml) the "RelatedFormatName" element
     */
    public void xsetRelatedFormatName(org.apache.xmlbeans.XmlString relatedFormatName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELATEDFORMATNAME$0);
            }
            target.set(relatedFormatName);
        }
    }
}
