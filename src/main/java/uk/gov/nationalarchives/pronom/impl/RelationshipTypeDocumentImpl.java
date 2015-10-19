/*
 * An XML document type.
 * Localname: RelationshipType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.RelationshipTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one RelationshipType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class RelationshipTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.RelationshipTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public RelationshipTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RELATIONSHIPTYPE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelationshipType");
    
    
    /**
     * Gets the "RelationshipType" element
     */
    public uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum getRelationshipType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "RelationshipType" element
     */
    public uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType xgetRelationshipType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType target = null;
            target = (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "RelationshipType" element
     */
    public void setRelationshipType(uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum relationshipType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATIONSHIPTYPE$0);
            }
            target.setEnumValue(relationshipType);
        }
    }
    
    /**
     * Sets (as xml) the "RelationshipType" element
     */
    public void xsetRelationshipType(uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType relationshipType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType target = null;
            target = (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType)get_store().add_element_user(RELATIONSHIPTYPE$0);
            }
            target.set(relationshipType);
        }
    }
    /**
     * An XML RelationshipType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.RelationshipTypeDocument$RelationshipType.
     */
    public static class RelationshipTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType
    {
        private static final long serialVersionUID = 1L;
        
        public RelationshipTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected RelationshipTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
