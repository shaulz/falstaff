/*
 * An XML document type.
 * Localname: PositionType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.PositionTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one PositionType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class PositionTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.PositionTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public PositionTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POSITIONTYPE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PositionType");
    
    
    /**
     * Gets the "PositionType" element
     */
    public uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum getPositionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "PositionType" element
     */
    public uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType xgetPositionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType target = null;
            target = (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType)get_store().find_element_user(POSITIONTYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PositionType" element
     */
    public void setPositionType(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum positionType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONTYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSITIONTYPE$0);
            }
            target.setEnumValue(positionType);
        }
    }
    
    /**
     * Sets (as xml) the "PositionType" element
     */
    public void xsetPositionType(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType positionType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType target = null;
            target = (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType)get_store().find_element_user(POSITIONTYPE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType)get_store().add_element_user(POSITIONTYPE$0);
            }
            target.set(positionType);
        }
    }
    /**
     * An XML PositionType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.PositionTypeDocument$PositionType.
     */
    public static class PositionTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType
    {
        private static final long serialVersionUID = 1L;
        
        public PositionTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected PositionTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
