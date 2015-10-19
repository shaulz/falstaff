/*
 * An XML document type.
 * Localname: DocumentID
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.DocumentIDDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one DocumentID(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class DocumentIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.DocumentIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTID$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "DocumentID");
    
    
    /**
     * Gets the "DocumentID" element
     */
    public byte getDocumentID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getByteValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentID" element
     */
    public org.apache.xmlbeans.XmlByte xgetDocumentID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(DOCUMENTID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentID" element
     */
    public void setDocumentID(byte documentID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTID$0);
            }
            target.setByteValue(documentID);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentID" element
     */
    public void xsetDocumentID(org.apache.xmlbeans.XmlByte documentID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(DOCUMENTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlByte)get_store().add_element_user(DOCUMENTID$0);
            }
            target.set(documentID);
        }
    }
}
