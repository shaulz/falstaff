/*
 * An XML document type.
 * Localname: IndirectOffsetLocation
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.IndirectOffsetLocationDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one IndirectOffsetLocation(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class IndirectOffsetLocationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.IndirectOffsetLocationDocument
{
    private static final long serialVersionUID = 1L;
    
    public IndirectOffsetLocationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INDIRECTOFFSETLOCATION$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "IndirectOffsetLocation");
    
    
    /**
     * Gets the "IndirectOffsetLocation" element
     */
    public java.lang.String getIndirectOffsetLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLOCATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IndirectOffsetLocation" element
     */
    public org.apache.xmlbeans.XmlString xgetIndirectOffsetLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLOCATION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IndirectOffsetLocation" element
     */
    public void setIndirectOffsetLocation(java.lang.String indirectOffsetLocation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLOCATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDIRECTOFFSETLOCATION$0);
            }
            target.setStringValue(indirectOffsetLocation);
        }
    }
    
    /**
     * Sets (as xml) the "IndirectOffsetLocation" element
     */
    public void xsetIndirectOffsetLocation(org.apache.xmlbeans.XmlString indirectOffsetLocation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLOCATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDIRECTOFFSETLOCATION$0);
            }
            target.set(indirectOffsetLocation);
        }
    }
}
