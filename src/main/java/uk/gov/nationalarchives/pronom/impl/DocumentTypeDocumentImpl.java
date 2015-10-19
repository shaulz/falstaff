/*
 * An XML document type.
 * Localname: DocumentType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DocumentType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DocumentTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTTYPE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentType");
    
    
    /**
     * Gets the "DocumentType" element
     */
    public uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum getDocumentType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentType" element
     */
    public uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType xgetDocumentType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType)get_store().find_element_user(DOCUMENTTYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentType" element
     */
    public void setDocumentType(uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType.Enum documentType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTTYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTTYPE$0);
            }
            target.setEnumValue(documentType);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentType" element
     */
    public void xsetDocumentType(uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType documentType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType target = null;
            target = (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType)get_store().find_element_user(DOCUMENTTYPE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType)get_store().add_element_user(DOCUMENTTYPE$0);
            }
            target.set(documentType);
        }
    }
    /**
     * An XML DocumentType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is an atomic type that is a restriction of uk.gov.nationalarchives.pronom.DocumentTypeDocument$DocumentType.
     */
    public static class DocumentTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements uk.gov.nationalarchives.pronom.DocumentTypeDocument.DocumentType
    {
        private static final long serialVersionUID = 1L;
        
        public DocumentTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected DocumentTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
