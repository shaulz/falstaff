/*
 * An XML document type.
 * Localname: RelatedFormatID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.RelatedFormatIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one RelatedFormatID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class RelatedFormatIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.RelatedFormatIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public RelatedFormatIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RELATEDFORMATID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormatID");
    
    
    /**
     * Gets the "RelatedFormatID" element
     */
    public short getRelatedFormatID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "RelatedFormatID" element
     */
    public org.apache.xmlbeans.XmlShort xgetRelatedFormatID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(RELATEDFORMATID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "RelatedFormatID" element
     */
    public void setRelatedFormatID(short relatedFormatID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATEDFORMATID$0);
            }
            target.setShortValue(relatedFormatID);
        }
    }
    
    /**
     * Sets (as xml) the "RelatedFormatID" element
     */
    public void xsetRelatedFormatID(org.apache.xmlbeans.XmlShort relatedFormatID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(RELATEDFORMATID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(RELATEDFORMATID$0);
            }
            target.set(relatedFormatID);
        }
    }
}
