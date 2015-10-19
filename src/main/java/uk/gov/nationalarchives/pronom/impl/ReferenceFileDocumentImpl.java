/*
 * An XML document type.
 * Localname: ReferenceFile
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ReferenceFileDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ReferenceFile(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ReferenceFileDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceFileDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEFILE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFile");
    
    
    /**
     * Gets the "ReferenceFile" element
     */
    public uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile getReferenceFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().find_element_user(REFERENCEFILE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceFile" element
     */
    public void setReferenceFile(uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile referenceFile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().find_element_user(REFERENCEFILE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().add_element_user(REFERENCEFILE$0);
            }
            target.set(referenceFile);
        }
    }
    
    /**
     * Appends and returns a new empty "ReferenceFile" element
     */
    public uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile addNewReferenceFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile target = null;
            target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().add_element_user(REFERENCEFILE$0);
            return target;
        }
    }
    /**
     * An XML ReferenceFile(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class ReferenceFileImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile
    {
        private static final long serialVersionUID = 1L;
        
        public ReferenceFileImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName REFERENCEFILEID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileID");
        private static final javax.xml.namespace.QName REFERENCEFILENAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileName");
        private static final javax.xml.namespace.QName REFERENCEFILEDESCRIPTION$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileDescription");
        private static final javax.xml.namespace.QName REFERENCEFILEDOCUMENTATION$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileDocumentation");
        private static final javax.xml.namespace.QName REFERENCEFILEIPR$8 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileIPR");
        private static final javax.xml.namespace.QName REFERENCEFILENOTE$10 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileNote");
        private static final javax.xml.namespace.QName REFERENCEFILEIDENTIFIER$12 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFileIdentifier");
        
        
        /**
         * Gets the "ReferenceFileID" element
         */
        public byte getReferenceFileID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getByteValue();
            }
        }
        
        /**
         * Gets (as xml) the "ReferenceFileID" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID xgetReferenceFileID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID)get_store().find_element_user(REFERENCEFILEID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ReferenceFileID" element
         */
        public void setReferenceFileID(byte referenceFileID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEID$0);
                }
                target.setByteValue(referenceFileID);
            }
        }
        
        /**
         * Sets (as xml) the "ReferenceFileID" element
         */
        public void xsetReferenceFileID(uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID referenceFileID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID)get_store().find_element_user(REFERENCEFILEID$0, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.ReferenceFileIDDocument.ReferenceFileID)get_store().add_element_user(REFERENCEFILEID$0);
                }
                target.set(referenceFileID);
            }
        }
        
        /**
         * Gets the "ReferenceFileName" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName.Enum getReferenceFileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "ReferenceFileName" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName xgetReferenceFileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName)get_store().find_element_user(REFERENCEFILENAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ReferenceFileName" element
         */
        public void setReferenceFileName(uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName.Enum referenceFileName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILENAME$2);
                }
                target.setEnumValue(referenceFileName);
            }
        }
        
        /**
         * Sets (as xml) the "ReferenceFileName" element
         */
        public void xsetReferenceFileName(uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName referenceFileName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName)get_store().find_element_user(REFERENCEFILENAME$2, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.ReferenceFileNameDocument.ReferenceFileName)get_store().add_element_user(REFERENCEFILENAME$2);
                }
                target.set(referenceFileName);
            }
        }
        
        /**
         * Gets the "ReferenceFileDescription" element
         */
        public java.lang.String getReferenceFileDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDESCRIPTION$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ReferenceFileDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetReferenceFileDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDESCRIPTION$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ReferenceFileDescription" element
         */
        public void setReferenceFileDescription(java.lang.String referenceFileDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDESCRIPTION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEDESCRIPTION$4);
                }
                target.setStringValue(referenceFileDescription);
            }
        }
        
        /**
         * Sets (as xml) the "ReferenceFileDescription" element
         */
        public void xsetReferenceFileDescription(org.apache.xmlbeans.XmlString referenceFileDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDESCRIPTION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILEDESCRIPTION$4);
                }
                target.set(referenceFileDescription);
            }
        }
        
        /**
         * Gets the "ReferenceFileDocumentation" element
         */
        public java.lang.String getReferenceFileDocumentation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ReferenceFileDocumentation" element
         */
        public org.apache.xmlbeans.XmlString xgetReferenceFileDocumentation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ReferenceFileDocumentation" element
         */
        public void setReferenceFileDocumentation(java.lang.String referenceFileDocumentation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEDOCUMENTATION$6);
                }
                target.setStringValue(referenceFileDocumentation);
            }
        }
        
        /**
         * Sets (as xml) the "ReferenceFileDocumentation" element
         */
        public void xsetReferenceFileDocumentation(org.apache.xmlbeans.XmlString referenceFileDocumentation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEDOCUMENTATION$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILEDOCUMENTATION$6);
                }
                target.set(referenceFileDocumentation);
            }
        }
        
        /**
         * Gets the "ReferenceFileIPR" element
         */
        public java.lang.String getReferenceFileIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEIPR$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ReferenceFileIPR" element
         */
        public org.apache.xmlbeans.XmlString xgetReferenceFileIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEIPR$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ReferenceFileIPR" element
         */
        public void setReferenceFileIPR(java.lang.String referenceFileIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILEIPR$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILEIPR$8);
                }
                target.setStringValue(referenceFileIPR);
            }
        }
        
        /**
         * Sets (as xml) the "ReferenceFileIPR" element
         */
        public void xsetReferenceFileIPR(org.apache.xmlbeans.XmlString referenceFileIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILEIPR$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILEIPR$8);
                }
                target.set(referenceFileIPR);
            }
        }
        
        /**
         * Gets the "ReferenceFileNote" element
         */
        public java.lang.String getReferenceFileNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENOTE$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ReferenceFileNote" element
         */
        public org.apache.xmlbeans.XmlString xgetReferenceFileNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILENOTE$10, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ReferenceFileNote" element
         */
        public void setReferenceFileNote(java.lang.String referenceFileNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCEFILENOTE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCEFILENOTE$10);
                }
                target.setStringValue(referenceFileNote);
            }
        }
        
        /**
         * Sets (as xml) the "ReferenceFileNote" element
         */
        public void xsetReferenceFileNote(org.apache.xmlbeans.XmlString referenceFileNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCEFILENOTE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCEFILENOTE$10);
                }
                target.set(referenceFileNote);
            }
        }
        
        /**
         * Gets the "ReferenceFileIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier getReferenceFileIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().find_element_user(REFERENCEFILEIDENTIFIER$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "ReferenceFileIdentifier" element
         */
        public void setReferenceFileIdentifier(uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier referenceFileIdentifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().find_element_user(REFERENCEFILEIDENTIFIER$12, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().add_element_user(REFERENCEFILEIDENTIFIER$12);
                }
                target.set(referenceFileIdentifier);
            }
        }
        
        /**
         * Appends and returns a new empty "ReferenceFileIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier addNewReferenceFileIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileIdentifierDocument.ReferenceFileIdentifier)get_store().add_element_user(REFERENCEFILEIDENTIFIER$12);
                return target;
            }
        }
    }
}
