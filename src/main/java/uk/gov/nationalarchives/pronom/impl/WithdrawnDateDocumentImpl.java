/*
 * An XML document type.
 * Localname: WithdrawnDate
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.WithdrawnDateDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one WithdrawnDate(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class WithdrawnDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.WithdrawnDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public WithdrawnDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WITHDRAWNDATE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "WithdrawnDate");
    
    
    /**
     * Gets the "WithdrawnDate" element
     */
    public java.lang.String getWithdrawnDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WithdrawnDate" element
     */
    public org.apache.xmlbeans.XmlString xgetWithdrawnDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WithdrawnDate" element
     */
    public void setWithdrawnDate(java.lang.String withdrawnDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WITHDRAWNDATE$0);
            }
            target.setStringValue(withdrawnDate);
        }
    }
    
    /**
     * Sets (as xml) the "WithdrawnDate" element
     */
    public void xsetWithdrawnDate(org.apache.xmlbeans.XmlString withdrawnDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WITHDRAWNDATE$0);
            }
            target.set(withdrawnDate);
        }
    }
}
