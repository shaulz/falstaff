/*
 * An XML document type.
 * Localname: DocumentNote
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentNoteDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DocumentNote(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DocumentNoteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentNoteDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentNoteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTNOTE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentNote");
    
    
    /**
     * Gets the "DocumentNote" element
     */
    public java.lang.String getDocumentNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTNOTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentNote" element
     */
    public org.apache.xmlbeans.XmlString xgetDocumentNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTNOTE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentNote" element
     */
    public void setDocumentNote(java.lang.String documentNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTNOTE$0);
            }
            target.setStringValue(documentNote);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentNote" element
     */
    public void xsetDocumentNote(org.apache.xmlbeans.XmlString documentNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCUMENTNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DOCUMENTNOTE$0);
            }
            target.set(documentNote);
        }
    }
}
