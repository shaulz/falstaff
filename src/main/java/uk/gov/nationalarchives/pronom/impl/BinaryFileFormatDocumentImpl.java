/*
 * An XML document type.
 * Localname: BinaryFileFormat
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.BinaryFileFormatDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one BinaryFileFormat(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class BinaryFileFormatDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.BinaryFileFormatDocument
{
    private static final long serialVersionUID = 1L;
    
    public BinaryFileFormatDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BINARYFILEFORMAT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "BinaryFileFormat");
    
    
    /**
     * Gets the "BinaryFileFormat" element
     */
    public java.lang.String getBinaryFileFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BINARYFILEFORMAT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "BinaryFileFormat" element
     */
    public org.apache.xmlbeans.XmlString xgetBinaryFileFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BINARYFILEFORMAT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "BinaryFileFormat" element
     */
    public void setBinaryFileFormat(java.lang.String binaryFileFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BINARYFILEFORMAT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BINARYFILEFORMAT$0);
            }
            target.setStringValue(binaryFileFormat);
        }
    }
    
    /**
     * Sets (as xml) the "BinaryFileFormat" element
     */
    public void xsetBinaryFileFormat(org.apache.xmlbeans.XmlString binaryFileFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BINARYFILEFORMAT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BINARYFILEFORMAT$0);
            }
            target.set(binaryFileFormat);
        }
    }
}
