/*
 * An XML document type.
 * Localname: Identifier
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.IdentifierDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one Identifier(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class IdentifierDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.IdentifierDocument
{
    private static final long serialVersionUID = 1L;
    
    public IdentifierDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Identifier");
    
    
    /**
     * Gets the "Identifier" element
     */
    public java.lang.String getIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Identifier" element
     */
    public org.apache.xmlbeans.XmlString xgetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Identifier" element
     */
    public void setIdentifier(java.lang.String identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IDENTIFIER$0);
            }
            target.setStringValue(identifier);
        }
    }
    
    /**
     * Sets (as xml) the "Identifier" element
     */
    public void xsetIdentifier(org.apache.xmlbeans.XmlString identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(IDENTIFIER$0);
            }
            target.set(identifier);
        }
    }
}
