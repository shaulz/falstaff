/*
 * An XML document type.
 * Localname: CompressionNote
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionNoteDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionNote(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionNoteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionNoteDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionNoteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONNOTE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionNote");
    
    
    /**
     * Gets the "CompressionNote" element
     */
    public java.lang.String getCompressionNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNOTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CompressionNote" element
     */
    public org.apache.xmlbeans.XmlString xgetCompressionNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNOTE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CompressionNote" element
     */
    public void setCompressionNote(java.lang.String compressionNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONNOTE$0);
            }
            target.setStringValue(compressionNote);
        }
    }
    
    /**
     * Sets (as xml) the "CompressionNote" element
     */
    public void xsetCompressionNote(org.apache.xmlbeans.XmlString compressionNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONNOTE$0);
            }
            target.set(compressionNote);
        }
    }
}
