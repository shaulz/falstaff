/*
 * An XML document type.
 * Localname: Lossiness
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.LossinessDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Lossiness(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class LossinessDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.LossinessDocument
{
    private static final long serialVersionUID = 1L;
    
    public LossinessDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LOSSINESS$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Lossiness");
    
    
    /**
     * Gets the "Lossiness" element
     */
    public uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum getLossiness()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOSSINESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "Lossiness" element
     */
    public uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness xgetLossiness()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness target = null;
            target = (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness)get_store().find_element_user(LOSSINESS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Lossiness" element
     */
    public void setLossiness(uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum lossiness)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOSSINESS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOSSINESS$0);
            }
            target.setEnumValue(lossiness);
        }
    }
    
    /**
     * Sets (as xml) the "Lossiness" element
     */
    public void xsetLossiness(uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness lossiness)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness target = null;
            target = (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness)get_store().find_element_user(LOSSINESS$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness)get_store().add_element_user(LOSSINESS$0);
            }
            target.set(lossiness);
        }
    }
    /**
     * An XML Lossiness(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.LossinessDocument$Lossiness.
     */
    public static class LossinessImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness
    {
        private static final long serialVersionUID = 1L;
        
        public LossinessImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected LossinessImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
