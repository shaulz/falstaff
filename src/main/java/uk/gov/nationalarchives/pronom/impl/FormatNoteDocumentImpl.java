/*
 * An XML document type.
 * Localname: FormatNote
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatNoteDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatNote(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatNoteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatNoteDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatNoteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATNOTE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatNote");
    
    
    /**
     * Gets the "FormatNote" element
     */
    public java.lang.String getFormatNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNOTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FormatNote" element
     */
    public org.apache.xmlbeans.XmlString xgetFormatNote()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNOTE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FormatNote" element
     */
    public void setFormatNote(java.lang.String formatNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATNOTE$0);
            }
            target.setStringValue(formatNote);
        }
    }
    
    /**
     * Sets (as xml) the "FormatNote" element
     */
    public void xsetFormatNote(org.apache.xmlbeans.XmlString formatNote)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNOTE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATNOTE$0);
            }
            target.set(formatNote);
        }
    }
}
