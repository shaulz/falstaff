/*
 * An XML document type.
 * Localname: IdentifierType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.IdentifierTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one IdentifierType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class IdentifierTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.IdentifierTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public IdentifierTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIERTYPE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "IdentifierType");
    
    
    /**
     * Gets the "IdentifierType" element
     */
    public uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum getIdentifierType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIERTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "IdentifierType" element
     */
    public uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType xgetIdentifierType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType target = null;
            target = (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType)get_store().find_element_user(IDENTIFIERTYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IdentifierType" element
     */
    public void setIdentifierType(uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType.Enum identifierType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIERTYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IDENTIFIERTYPE$0);
            }
            target.setEnumValue(identifierType);
        }
    }
    
    /**
     * Sets (as xml) the "IdentifierType" element
     */
    public void xsetIdentifierType(uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType identifierType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType target = null;
            target = (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType)get_store().find_element_user(IDENTIFIERTYPE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType)get_store().add_element_user(IDENTIFIERTYPE$0);
            }
            target.set(identifierType);
        }
    }
    /**
     * An XML IdentifierType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.IdentifierTypeDocument$IdentifierType.
     */
    public static class IdentifierTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.IdentifierTypeDocument.IdentifierType
    {
        private static final long serialVersionUID = 1L;
        
        public IdentifierTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected IdentifierTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
