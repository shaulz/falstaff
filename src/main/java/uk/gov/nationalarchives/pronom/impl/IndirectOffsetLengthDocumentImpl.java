/*
 * An XML document type.
 * Localname: IndirectOffsetLength
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.IndirectOffsetLengthDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one IndirectOffsetLength(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class IndirectOffsetLengthDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.IndirectOffsetLengthDocument
{
    private static final long serialVersionUID = 1L;
    
    public IndirectOffsetLengthDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INDIRECTOFFSETLENGTH$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "IndirectOffsetLength");
    
    
    /**
     * Gets the "IndirectOffsetLength" element
     */
    public java.lang.String getIndirectOffsetLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLENGTH$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IndirectOffsetLength" element
     */
    public org.apache.xmlbeans.XmlString xgetIndirectOffsetLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLENGTH$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IndirectOffsetLength" element
     */
    public void setIndirectOffsetLength(java.lang.String indirectOffsetLength)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLENGTH$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDIRECTOFFSETLENGTH$0);
            }
            target.setStringValue(indirectOffsetLength);
        }
    }
    
    /**
     * Sets (as xml) the "IndirectOffsetLength" element
     */
    public void xsetIndirectOffsetLength(org.apache.xmlbeans.XmlString indirectOffsetLength)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLENGTH$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDIRECTOFFSETLENGTH$0);
            }
            target.set(indirectOffsetLength);
        }
    }
}
