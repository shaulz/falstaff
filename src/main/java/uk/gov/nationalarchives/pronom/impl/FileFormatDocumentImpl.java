/*
 * An XML document type.
 * Localname: FileFormat
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FileFormatDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FileFormat(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FileFormatDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FileFormatDocument
{
    private static final long serialVersionUID = 1L;
    
    public FileFormatDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILEFORMAT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FileFormat");
    
    
    /**
     * Gets the "FileFormat" element
     */
    public uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat getFileFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat target = null;
            target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().find_element_user(FILEFORMAT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FileFormat" element
     */
    public void setFileFormat(uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat fileFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat target = null;
            target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().find_element_user(FILEFORMAT$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().add_element_user(FILEFORMAT$0);
            }
            target.set(fileFormat);
        }
    }
    
    /**
     * Appends and returns a new empty "FileFormat" element
     */
    public uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat addNewFileFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat target = null;
            target = (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat)get_store().add_element_user(FILEFORMAT$0);
            return target;
        }
    }
    /**
     * An XML FileFormat(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class FileFormatImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat
    {
        private static final long serialVersionUID = 1L;
        
        public FileFormatImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FORMATID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatID");
        private static final javax.xml.namespace.QName FORMATNAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatName");
        private static final javax.xml.namespace.QName FORMATVERSION$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatVersion");
        private static final javax.xml.namespace.QName FORMATALIASES$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatAliases");
        private static final javax.xml.namespace.QName FORMATFAMILIES$8 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatFamilies");
        private static final javax.xml.namespace.QName FORMATTYPES$10 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatTypes");
        private static final javax.xml.namespace.QName FORMATDISCLOSURE$12 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatDisclosure");
        private static final javax.xml.namespace.QName FORMATDESCRIPTION$14 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatDescription");
        private static final javax.xml.namespace.QName BINARYFILEFORMAT$16 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "BinaryFileFormat");
        private static final javax.xml.namespace.QName BYTEORDERS$18 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteOrders");
        private static final javax.xml.namespace.QName RELEASEDATE$20 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReleaseDate");
        private static final javax.xml.namespace.QName WITHDRAWNDATE$22 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "WithdrawnDate");
        private static final javax.xml.namespace.QName PROVENANCESOURCEID$24 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceSourceID");
        private static final javax.xml.namespace.QName PROVENANCENAME$26 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceName");
        private static final javax.xml.namespace.QName PROVENANCESOURCEDATE$28 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceSourceDate");
        private static final javax.xml.namespace.QName PROVENANCEDESCRIPTION$30 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ProvenanceDescription");
        private static final javax.xml.namespace.QName LASTUPDATEDDATE$32 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "LastUpdatedDate");
        private static final javax.xml.namespace.QName FORMATNOTE$34 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatNote");
        private static final javax.xml.namespace.QName FORMATRISK$36 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatRisk");
        private static final javax.xml.namespace.QName TECHNICALENVIRONMENT$38 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "TechnicalEnvironment");
        private static final javax.xml.namespace.QName FILEFORMATIDENTIFIER$40 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FileFormatIdentifier");
        private static final javax.xml.namespace.QName RELATEDFORMAT$42 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormat");
        private static final javax.xml.namespace.QName SUPPORT$44 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Support");
        private static final javax.xml.namespace.QName EXTERNALSIGNATURE$46 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ExternalSignature");
        private static final javax.xml.namespace.QName INTERNALSIGNATURE$48 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "InternalSignature");
        private static final javax.xml.namespace.QName CHARACTERENCODING$50 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CharacterEncoding");
        private static final javax.xml.namespace.QName FORMATPROPERTIES$52 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatProperties");
        private static final javax.xml.namespace.QName COMPRESSIONTYPE$54 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionType");
        private static final javax.xml.namespace.QName REFERENCEFILE$56 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReferenceFile");
        private static final javax.xml.namespace.QName DOCUMENT$58 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Document");
        private static final javax.xml.namespace.QName DEVELOPERS$60 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Developers");
        
        
        /**
         * Gets the "FormatID" element
         */
        public short getFormatID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatID" element
         */
        public org.apache.xmlbeans.XmlShort xgetFormatID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(FORMATID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatID" element
         */
        public void setFormatID(short formatID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATID$0);
                }
                target.setShortValue(formatID);
            }
        }
        
        /**
         * Sets (as xml) the "FormatID" element
         */
        public void xsetFormatID(org.apache.xmlbeans.XmlShort formatID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(FORMATID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(FORMATID$0);
                }
                target.set(formatID);
            }
        }
        
        /**
         * Gets the "FormatName" element
         */
        public java.lang.String getFormatName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatName" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatName" element
         */
        public void setFormatName(java.lang.String formatName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATNAME$2);
                }
                target.setStringValue(formatName);
            }
        }
        
        /**
         * Sets (as xml) the "FormatName" element
         */
        public void xsetFormatName(org.apache.xmlbeans.XmlString formatName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATNAME$2);
                }
                target.set(formatName);
            }
        }
        
        /**
         * Gets the "FormatVersion" element
         */
        public java.lang.String getFormatVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATVERSION$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatVersion" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATVERSION$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatVersion" element
         */
        public void setFormatVersion(java.lang.String formatVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATVERSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATVERSION$4);
                }
                target.setStringValue(formatVersion);
            }
        }
        
        /**
         * Sets (as xml) the "FormatVersion" element
         */
        public void xsetFormatVersion(org.apache.xmlbeans.XmlString formatVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATVERSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATVERSION$4);
                }
                target.set(formatVersion);
            }
        }
        
        /**
         * Gets the "FormatAliases" element
         */
        public java.lang.String getFormatAliases()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATALIASES$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatAliases" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatAliases()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATALIASES$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatAliases" element
         */
        public void setFormatAliases(java.lang.String formatAliases)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATALIASES$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATALIASES$6);
                }
                target.setStringValue(formatAliases);
            }
        }
        
        /**
         * Sets (as xml) the "FormatAliases" element
         */
        public void xsetFormatAliases(org.apache.xmlbeans.XmlString formatAliases)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATALIASES$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATALIASES$6);
                }
                target.set(formatAliases);
            }
        }
        
        /**
         * Gets the "FormatFamilies" element
         */
        public java.lang.String getFormatFamilies()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATFAMILIES$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatFamilies" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatFamilies()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATFAMILIES$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatFamilies" element
         */
        public void setFormatFamilies(java.lang.String formatFamilies)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATFAMILIES$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATFAMILIES$8);
                }
                target.setStringValue(formatFamilies);
            }
        }
        
        /**
         * Sets (as xml) the "FormatFamilies" element
         */
        public void xsetFormatFamilies(org.apache.xmlbeans.XmlString formatFamilies)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATFAMILIES$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATFAMILIES$8);
                }
                target.set(formatFamilies);
            }
        }
        
        /**
         * Gets the "FormatTypes" element
         */
        public java.lang.String getFormatTypes()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATTYPES$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatTypes" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatTypes()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATTYPES$10, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatTypes" element
         */
        public void setFormatTypes(java.lang.String formatTypes)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATTYPES$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATTYPES$10);
                }
                target.setStringValue(formatTypes);
            }
        }
        
        /**
         * Sets (as xml) the "FormatTypes" element
         */
        public void xsetFormatTypes(org.apache.xmlbeans.XmlString formatTypes)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATTYPES$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATTYPES$10);
                }
                target.set(formatTypes);
            }
        }
        
        /**
         * Gets the "FormatDisclosure" element
         */
        public java.lang.String getFormatDisclosure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATDISCLOSURE$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatDisclosure" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatDisclosure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATDISCLOSURE$12, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatDisclosure" element
         */
        public void setFormatDisclosure(java.lang.String formatDisclosure)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATDISCLOSURE$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATDISCLOSURE$12);
                }
                target.setStringValue(formatDisclosure);
            }
        }
        
        /**
         * Sets (as xml) the "FormatDisclosure" element
         */
        public void xsetFormatDisclosure(org.apache.xmlbeans.XmlString formatDisclosure)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATDISCLOSURE$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATDISCLOSURE$12);
                }
                target.set(formatDisclosure);
            }
        }
        
        /**
         * Gets the "FormatDescription" element
         */
        public java.lang.String getFormatDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATDESCRIPTION$14, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATDESCRIPTION$14, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatDescription" element
         */
        public void setFormatDescription(java.lang.String formatDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATDESCRIPTION$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATDESCRIPTION$14);
                }
                target.setStringValue(formatDescription);
            }
        }
        
        /**
         * Sets (as xml) the "FormatDescription" element
         */
        public void xsetFormatDescription(org.apache.xmlbeans.XmlString formatDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATDESCRIPTION$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATDESCRIPTION$14);
                }
                target.set(formatDescription);
            }
        }
        
        /**
         * Gets the "BinaryFileFormat" element
         */
        public java.lang.String getBinaryFileFormat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BINARYFILEFORMAT$16, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BINARYFILEFORMAT$16, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BINARYFILEFORMAT$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BINARYFILEFORMAT$16);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BINARYFILEFORMAT$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BINARYFILEFORMAT$16);
                }
                target.set(binaryFileFormat);
            }
        }
        
        /**
         * Gets the "ByteOrders" element
         */
        public java.lang.String getByteOrders()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTEORDERS$18, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ByteOrders" element
         */
        public org.apache.xmlbeans.XmlString xgetByteOrders()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTEORDERS$18, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ByteOrders" element
         */
        public void setByteOrders(java.lang.String byteOrders)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTEORDERS$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BYTEORDERS$18);
                }
                target.setStringValue(byteOrders);
            }
        }
        
        /**
         * Sets (as xml) the "ByteOrders" element
         */
        public void xsetByteOrders(org.apache.xmlbeans.XmlString byteOrders)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTEORDERS$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BYTEORDERS$18);
                }
                target.set(byteOrders);
            }
        }
        
        /**
         * Gets the "ReleaseDate" element
         */
        public java.lang.String getReleaseDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$20, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ReleaseDate" element
         */
        public org.apache.xmlbeans.XmlString xgetReleaseDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$20, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ReleaseDate" element
         */
        public void setReleaseDate(java.lang.String releaseDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELEASEDATE$20);
                }
                target.setStringValue(releaseDate);
            }
        }
        
        /**
         * Sets (as xml) the "ReleaseDate" element
         */
        public void xsetReleaseDate(org.apache.xmlbeans.XmlString releaseDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELEASEDATE$20);
                }
                target.set(releaseDate);
            }
        }
        
        /**
         * Gets the "WithdrawnDate" element
         */
        public java.lang.String getWithdrawnDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$22, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "WithdrawnDate" element
         */
        public org.apache.xmlbeans.XmlString xgetWithdrawnDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$22, 0);
                return target;
            }
        }
        
        /**
         * Sets the "WithdrawnDate" element
         */
        public void setWithdrawnDate(java.lang.String withdrawnDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WITHDRAWNDATE$22);
                }
                target.setStringValue(withdrawnDate);
            }
        }
        
        /**
         * Sets (as xml) the "WithdrawnDate" element
         */
        public void xsetWithdrawnDate(org.apache.xmlbeans.XmlString withdrawnDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WITHDRAWNDATE$22);
                }
                target.set(withdrawnDate);
            }
        }
        
        /**
         * Gets the "ProvenanceSourceID" element
         */
        public short getProvenanceSourceID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEID$24, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "ProvenanceSourceID" element
         */
        public uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID xgetProvenanceSourceID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID target = null;
                target = (uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID)get_store().find_element_user(PROVENANCESOURCEID$24, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ProvenanceSourceID" element
         */
        public void setProvenanceSourceID(short provenanceSourceID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEID$24, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCESOURCEID$24);
                }
                target.setShortValue(provenanceSourceID);
            }
        }
        
        /**
         * Sets (as xml) the "ProvenanceSourceID" element
         */
        public void xsetProvenanceSourceID(uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID provenanceSourceID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID target = null;
                target = (uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID)get_store().find_element_user(PROVENANCESOURCEID$24, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID)get_store().add_element_user(PROVENANCESOURCEID$24);
                }
                target.set(provenanceSourceID);
            }
        }
        
        /**
         * Gets the "ProvenanceName" element
         */
        public java.lang.String getProvenanceName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCENAME$26, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ProvenanceName" element
         */
        public org.apache.xmlbeans.XmlString xgetProvenanceName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCENAME$26, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ProvenanceName" element
         */
        public void setProvenanceName(java.lang.String provenanceName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCENAME$26, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCENAME$26);
                }
                target.setStringValue(provenanceName);
            }
        }
        
        /**
         * Sets (as xml) the "ProvenanceName" element
         */
        public void xsetProvenanceName(org.apache.xmlbeans.XmlString provenanceName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCENAME$26, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROVENANCENAME$26);
                }
                target.set(provenanceName);
            }
        }
        
        /**
         * Gets the "ProvenanceSourceDate" element
         */
        public java.lang.String getProvenanceSourceDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEDATE$28, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ProvenanceSourceDate" element
         */
        public org.apache.xmlbeans.XmlString xgetProvenanceSourceDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCESOURCEDATE$28, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ProvenanceSourceDate" element
         */
        public void setProvenanceSourceDate(java.lang.String provenanceSourceDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCESOURCEDATE$28, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCESOURCEDATE$28);
                }
                target.setStringValue(provenanceSourceDate);
            }
        }
        
        /**
         * Sets (as xml) the "ProvenanceSourceDate" element
         */
        public void xsetProvenanceSourceDate(org.apache.xmlbeans.XmlString provenanceSourceDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCESOURCEDATE$28, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROVENANCESOURCEDATE$28);
                }
                target.set(provenanceSourceDate);
            }
        }
        
        /**
         * Gets the "ProvenanceDescription" element
         */
        public java.lang.String getProvenanceDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCEDESCRIPTION$30, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ProvenanceDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetProvenanceDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCEDESCRIPTION$30, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ProvenanceDescription" element
         */
        public void setProvenanceDescription(java.lang.String provenanceDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVENANCEDESCRIPTION$30, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVENANCEDESCRIPTION$30);
                }
                target.setStringValue(provenanceDescription);
            }
        }
        
        /**
         * Sets (as xml) the "ProvenanceDescription" element
         */
        public void xsetProvenanceDescription(org.apache.xmlbeans.XmlString provenanceDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVENANCEDESCRIPTION$30, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROVENANCEDESCRIPTION$30);
                }
                target.set(provenanceDescription);
            }
        }
        
        /**
         * Gets the "LastUpdatedDate" element
         */
        public java.lang.String getLastUpdatedDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTUPDATEDDATE$32, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "LastUpdatedDate" element
         */
        public org.apache.xmlbeans.XmlString xgetLastUpdatedDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTUPDATEDDATE$32, 0);
                return target;
            }
        }
        
        /**
         * Sets the "LastUpdatedDate" element
         */
        public void setLastUpdatedDate(java.lang.String lastUpdatedDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTUPDATEDDATE$32, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LASTUPDATEDDATE$32);
                }
                target.setStringValue(lastUpdatedDate);
            }
        }
        
        /**
         * Sets (as xml) the "LastUpdatedDate" element
         */
        public void xsetLastUpdatedDate(org.apache.xmlbeans.XmlString lastUpdatedDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTUPDATEDDATE$32, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LASTUPDATEDDATE$32);
                }
                target.set(lastUpdatedDate);
            }
        }
        
        /**
         * Gets the "FormatNote" element
         */
        public java.lang.String getFormatNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNOTE$34, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNOTE$34, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATNOTE$34, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATNOTE$34);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATNOTE$34, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATNOTE$34);
                }
                target.set(formatNote);
            }
        }
        
        /**
         * Gets the "FormatRisk" element
         */
        public java.lang.String getFormatRisk()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATRISK$36, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "FormatRisk" element
         */
        public org.apache.xmlbeans.XmlString xgetFormatRisk()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATRISK$36, 0);
                return target;
            }
        }
        
        /**
         * Sets the "FormatRisk" element
         */
        public void setFormatRisk(java.lang.String formatRisk)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMATRISK$36, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMATRISK$36);
                }
                target.setStringValue(formatRisk);
            }
        }
        
        /**
         * Sets (as xml) the "FormatRisk" element
         */
        public void xsetFormatRisk(org.apache.xmlbeans.XmlString formatRisk)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FORMATRISK$36, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FORMATRISK$36);
                }
                target.set(formatRisk);
            }
        }
        
        /**
         * Gets the "TechnicalEnvironment" element
         */
        public java.lang.String getTechnicalEnvironment()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TECHNICALENVIRONMENT$38, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "TechnicalEnvironment" element
         */
        public org.apache.xmlbeans.XmlString xgetTechnicalEnvironment()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TECHNICALENVIRONMENT$38, 0);
                return target;
            }
        }
        
        /**
         * Sets the "TechnicalEnvironment" element
         */
        public void setTechnicalEnvironment(java.lang.String technicalEnvironment)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TECHNICALENVIRONMENT$38, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TECHNICALENVIRONMENT$38);
                }
                target.setStringValue(technicalEnvironment);
            }
        }
        
        /**
         * Sets (as xml) the "TechnicalEnvironment" element
         */
        public void xsetTechnicalEnvironment(org.apache.xmlbeans.XmlString technicalEnvironment)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TECHNICALENVIRONMENT$38, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TECHNICALENVIRONMENT$38);
                }
                target.set(technicalEnvironment);
            }
        }
        
        /**
         * Gets array of all "FileFormatIdentifier" elements
         */
        public uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier[] getFileFormatIdentifierArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FILEFORMATIDENTIFIER$40, targetList);
                uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier[] result = new uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "FileFormatIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier getFileFormatIdentifierArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().find_element_user(FILEFORMATIDENTIFIER$40, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "FileFormatIdentifier" element
         */
        public int sizeOfFileFormatIdentifierArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FILEFORMATIDENTIFIER$40);
            }
        }
        
        /**
         * Sets array of all "FileFormatIdentifier" element
         */
        public void setFileFormatIdentifierArray(uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier[] fileFormatIdentifierArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(fileFormatIdentifierArray, FILEFORMATIDENTIFIER$40);
            }
        }
        
        /**
         * Sets ith "FileFormatIdentifier" element
         */
        public void setFileFormatIdentifierArray(int i, uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier fileFormatIdentifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().find_element_user(FILEFORMATIDENTIFIER$40, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(fileFormatIdentifier);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "FileFormatIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier insertNewFileFormatIdentifier(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().insert_element_user(FILEFORMATIDENTIFIER$40, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "FileFormatIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier addNewFileFormatIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier)get_store().add_element_user(FILEFORMATIDENTIFIER$40);
                return target;
            }
        }
        
        /**
         * Removes the ith "FileFormatIdentifier" element
         */
        public void removeFileFormatIdentifier(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FILEFORMATIDENTIFIER$40, i);
            }
        }
        
        /**
         * Gets array of all "RelatedFormat" elements
         */
        public uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat[] getRelatedFormatArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(RELATEDFORMAT$42, targetList);
                uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat[] result = new uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "RelatedFormat" element
         */
        public uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat getRelatedFormatArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat target = null;
                target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().find_element_user(RELATEDFORMAT$42, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "RelatedFormat" element
         */
        public int sizeOfRelatedFormatArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RELATEDFORMAT$42);
            }
        }
        
        /**
         * Sets array of all "RelatedFormat" element
         */
        public void setRelatedFormatArray(uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat[] relatedFormatArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(relatedFormatArray, RELATEDFORMAT$42);
            }
        }
        
        /**
         * Sets ith "RelatedFormat" element
         */
        public void setRelatedFormatArray(int i, uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat relatedFormat)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat target = null;
                target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().find_element_user(RELATEDFORMAT$42, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(relatedFormat);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "RelatedFormat" element
         */
        public uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat insertNewRelatedFormat(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat target = null;
                target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().insert_element_user(RELATEDFORMAT$42, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "RelatedFormat" element
         */
        public uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat addNewRelatedFormat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat target = null;
                target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().add_element_user(RELATEDFORMAT$42);
                return target;
            }
        }
        
        /**
         * Removes the ith "RelatedFormat" element
         */
        public void removeRelatedFormat(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RELATEDFORMAT$42, i);
            }
        }
        
        /**
         * Gets array of all "Support" elements
         */
        public uk.gov.nationalarchives.pronom.SupportDocument.Support[] getSupportArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SUPPORT$44, targetList);
                uk.gov.nationalarchives.pronom.SupportDocument.Support[] result = new uk.gov.nationalarchives.pronom.SupportDocument.Support[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Support" element
         */
        public uk.gov.nationalarchives.pronom.SupportDocument.Support getSupportArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.SupportDocument.Support target = null;
                target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().find_element_user(SUPPORT$44, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Support" element
         */
        public int sizeOfSupportArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SUPPORT$44);
            }
        }
        
        /**
         * Sets array of all "Support" element
         */
        public void setSupportArray(uk.gov.nationalarchives.pronom.SupportDocument.Support[] supportArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(supportArray, SUPPORT$44);
            }
        }
        
        /**
         * Sets ith "Support" element
         */
        public void setSupportArray(int i, uk.gov.nationalarchives.pronom.SupportDocument.Support support)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.SupportDocument.Support target = null;
                target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().find_element_user(SUPPORT$44, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(support);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Support" element
         */
        public uk.gov.nationalarchives.pronom.SupportDocument.Support insertNewSupport(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.SupportDocument.Support target = null;
                target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().insert_element_user(SUPPORT$44, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Support" element
         */
        public uk.gov.nationalarchives.pronom.SupportDocument.Support addNewSupport()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.SupportDocument.Support target = null;
                target = (uk.gov.nationalarchives.pronom.SupportDocument.Support)get_store().add_element_user(SUPPORT$44);
                return target;
            }
        }
        
        /**
         * Removes the ith "Support" element
         */
        public void removeSupport(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SUPPORT$44, i);
            }
        }
        
        /**
         * Gets array of all "ExternalSignature" elements
         */
        public uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature[] getExternalSignatureArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(EXTERNALSIGNATURE$46, targetList);
                uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature[] result = new uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "ExternalSignature" element
         */
        public uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature getExternalSignatureArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().find_element_user(EXTERNALSIGNATURE$46, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "ExternalSignature" element
         */
        public int sizeOfExternalSignatureArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(EXTERNALSIGNATURE$46);
            }
        }
        
        /**
         * Sets array of all "ExternalSignature" element
         */
        public void setExternalSignatureArray(uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature[] externalSignatureArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(externalSignatureArray, EXTERNALSIGNATURE$46);
            }
        }
        
        /**
         * Sets ith "ExternalSignature" element
         */
        public void setExternalSignatureArray(int i, uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature externalSignature)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().find_element_user(EXTERNALSIGNATURE$46, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(externalSignature);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ExternalSignature" element
         */
        public uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature insertNewExternalSignature(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().insert_element_user(EXTERNALSIGNATURE$46, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ExternalSignature" element
         */
        public uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature addNewExternalSignature()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature)get_store().add_element_user(EXTERNALSIGNATURE$46);
                return target;
            }
        }
        
        /**
         * Removes the ith "ExternalSignature" element
         */
        public void removeExternalSignature(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(EXTERNALSIGNATURE$46, i);
            }
        }
        
        /**
         * Gets array of all "InternalSignature" elements
         */
        public uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature[] getInternalSignatureArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(INTERNALSIGNATURE$48, targetList);
                uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature[] result = new uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "InternalSignature" element
         */
        public uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature getInternalSignatureArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().find_element_user(INTERNALSIGNATURE$48, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "InternalSignature" element
         */
        public int sizeOfInternalSignatureArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(INTERNALSIGNATURE$48);
            }
        }
        
        /**
         * Sets array of all "InternalSignature" element
         */
        public void setInternalSignatureArray(uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature[] internalSignatureArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(internalSignatureArray, INTERNALSIGNATURE$48);
            }
        }
        
        /**
         * Sets ith "InternalSignature" element
         */
        public void setInternalSignatureArray(int i, uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature internalSignature)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().find_element_user(INTERNALSIGNATURE$48, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(internalSignature);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "InternalSignature" element
         */
        public uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature insertNewInternalSignature(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().insert_element_user(INTERNALSIGNATURE$48, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "InternalSignature" element
         */
        public uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature addNewInternalSignature()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature target = null;
                target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().add_element_user(INTERNALSIGNATURE$48);
                return target;
            }
        }
        
        /**
         * Removes the ith "InternalSignature" element
         */
        public void removeInternalSignature(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(INTERNALSIGNATURE$48, i);
            }
        }
        
        /**
         * Gets the "CharacterEncoding" element
         */
        public uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding getCharacterEncoding()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding target = null;
                target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().find_element_user(CHARACTERENCODING$50, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "CharacterEncoding" element
         */
        public boolean isSetCharacterEncoding()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CHARACTERENCODING$50) != 0;
            }
        }
        
        /**
         * Sets the "CharacterEncoding" element
         */
        public void setCharacterEncoding(uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding characterEncoding)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding target = null;
                target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().find_element_user(CHARACTERENCODING$50, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().add_element_user(CHARACTERENCODING$50);
                }
                target.set(characterEncoding);
            }
        }
        
        /**
         * Appends and returns a new empty "CharacterEncoding" element
         */
        public uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding addNewCharacterEncoding()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding target = null;
                target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().add_element_user(CHARACTERENCODING$50);
                return target;
            }
        }
        
        /**
         * Unsets the "CharacterEncoding" element
         */
        public void unsetCharacterEncoding()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CHARACTERENCODING$50, 0);
            }
        }
        
        /**
         * Gets the "FormatProperties" element
         */
        public uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties getFormatProperties()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties target = null;
                target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().find_element_user(FORMATPROPERTIES$52, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "FormatProperties" element
         */
        public boolean isSetFormatProperties()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FORMATPROPERTIES$52) != 0;
            }
        }
        
        /**
         * Sets the "FormatProperties" element
         */
        public void setFormatProperties(uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties formatProperties)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties target = null;
                target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().find_element_user(FORMATPROPERTIES$52, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().add_element_user(FORMATPROPERTIES$52);
                }
                target.set(formatProperties);
            }
        }
        
        /**
         * Appends and returns a new empty "FormatProperties" element
         */
        public uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties addNewFormatProperties()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties target = null;
                target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().add_element_user(FORMATPROPERTIES$52);
                return target;
            }
        }
        
        /**
         * Unsets the "FormatProperties" element
         */
        public void unsetFormatProperties()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FORMATPROPERTIES$52, 0);
            }
        }
        
        /**
         * Gets array of all "CompressionType" elements
         */
        public uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType[] getCompressionTypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(COMPRESSIONTYPE$54, targetList);
                uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType[] result = new uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "CompressionType" element
         */
        public uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType getCompressionTypeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().find_element_user(COMPRESSIONTYPE$54, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "CompressionType" element
         */
        public int sizeOfCompressionTypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(COMPRESSIONTYPE$54);
            }
        }
        
        /**
         * Sets array of all "CompressionType" element
         */
        public void setCompressionTypeArray(uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType[] compressionTypeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(compressionTypeArray, COMPRESSIONTYPE$54);
            }
        }
        
        /**
         * Sets ith "CompressionType" element
         */
        public void setCompressionTypeArray(int i, uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType compressionType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().find_element_user(COMPRESSIONTYPE$54, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(compressionType);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "CompressionType" element
         */
        public uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType insertNewCompressionType(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().insert_element_user(COMPRESSIONTYPE$54, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "CompressionType" element
         */
        public uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType addNewCompressionType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().add_element_user(COMPRESSIONTYPE$54);
                return target;
            }
        }
        
        /**
         * Removes the ith "CompressionType" element
         */
        public void removeCompressionType(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(COMPRESSIONTYPE$54, i);
            }
        }
        
        /**
         * Gets array of all "ReferenceFile" elements
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile[] getReferenceFileArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(REFERENCEFILE$56, targetList);
                uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile[] result = new uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "ReferenceFile" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile getReferenceFileArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().find_element_user(REFERENCEFILE$56, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "ReferenceFile" element
         */
        public int sizeOfReferenceFileArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(REFERENCEFILE$56);
            }
        }
        
        /**
         * Sets array of all "ReferenceFile" element
         */
        public void setReferenceFileArray(uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile[] referenceFileArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(referenceFileArray, REFERENCEFILE$56);
            }
        }
        
        /**
         * Sets ith "ReferenceFile" element
         */
        public void setReferenceFileArray(int i, uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile referenceFile)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().find_element_user(REFERENCEFILE$56, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(referenceFile);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ReferenceFile" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile insertNewReferenceFile(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().insert_element_user(REFERENCEFILE$56, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ReferenceFile" element
         */
        public uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile addNewReferenceFile()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile target = null;
                target = (uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile)get_store().add_element_user(REFERENCEFILE$56);
                return target;
            }
        }
        
        /**
         * Removes the ith "ReferenceFile" element
         */
        public void removeReferenceFile(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(REFERENCEFILE$56, i);
            }
        }
        
        /**
         * Gets array of all "Document" elements
         */
        public uk.gov.nationalarchives.pronom.DocumentDocument.Document[] getDocumentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DOCUMENT$58, targetList);
                uk.gov.nationalarchives.pronom.DocumentDocument.Document[] result = new uk.gov.nationalarchives.pronom.DocumentDocument.Document[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Document" element
         */
        public uk.gov.nationalarchives.pronom.DocumentDocument.Document getDocumentArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DocumentDocument.Document target = null;
                target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().find_element_user(DOCUMENT$58, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Document" element
         */
        public int sizeOfDocumentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DOCUMENT$58);
            }
        }
        
        /**
         * Sets array of all "Document" element
         */
        public void setDocumentArray(uk.gov.nationalarchives.pronom.DocumentDocument.Document[] documentArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(documentArray, DOCUMENT$58);
            }
        }
        
        /**
         * Sets ith "Document" element
         */
        public void setDocumentArray(int i, uk.gov.nationalarchives.pronom.DocumentDocument.Document document)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DocumentDocument.Document target = null;
                target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().find_element_user(DOCUMENT$58, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(document);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Document" element
         */
        public uk.gov.nationalarchives.pronom.DocumentDocument.Document insertNewDocument(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DocumentDocument.Document target = null;
                target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().insert_element_user(DOCUMENT$58, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Document" element
         */
        public uk.gov.nationalarchives.pronom.DocumentDocument.Document addNewDocument()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DocumentDocument.Document target = null;
                target = (uk.gov.nationalarchives.pronom.DocumentDocument.Document)get_store().add_element_user(DOCUMENT$58);
                return target;
            }
        }
        
        /**
         * Removes the ith "Document" element
         */
        public void removeDocument(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DOCUMENT$58, i);
            }
        }
        
        /**
         * Gets array of all "Developers" elements
         */
        public uk.gov.nationalarchives.pronom.DevelopersDocument.Developers[] getDevelopersArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DEVELOPERS$60, targetList);
                uk.gov.nationalarchives.pronom.DevelopersDocument.Developers[] result = new uk.gov.nationalarchives.pronom.DevelopersDocument.Developers[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Developers" element
         */
        public uk.gov.nationalarchives.pronom.DevelopersDocument.Developers getDevelopersArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DevelopersDocument.Developers target = null;
                target = (uk.gov.nationalarchives.pronom.DevelopersDocument.Developers)get_store().find_element_user(DEVELOPERS$60, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Developers" element
         */
        public int sizeOfDevelopersArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DEVELOPERS$60);
            }
        }
        
        /**
         * Sets array of all "Developers" element
         */
        public void setDevelopersArray(uk.gov.nationalarchives.pronom.DevelopersDocument.Developers[] developersArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(developersArray, DEVELOPERS$60);
            }
        }
        
        /**
         * Sets ith "Developers" element
         */
        public void setDevelopersArray(int i, uk.gov.nationalarchives.pronom.DevelopersDocument.Developers developers)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DevelopersDocument.Developers target = null;
                target = (uk.gov.nationalarchives.pronom.DevelopersDocument.Developers)get_store().find_element_user(DEVELOPERS$60, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(developers);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Developers" element
         */
        public uk.gov.nationalarchives.pronom.DevelopersDocument.Developers insertNewDevelopers(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DevelopersDocument.Developers target = null;
                target = (uk.gov.nationalarchives.pronom.DevelopersDocument.Developers)get_store().insert_element_user(DEVELOPERS$60, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Developers" element
         */
        public uk.gov.nationalarchives.pronom.DevelopersDocument.Developers addNewDevelopers()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DevelopersDocument.Developers target = null;
                target = (uk.gov.nationalarchives.pronom.DevelopersDocument.Developers)get_store().add_element_user(DEVELOPERS$60);
                return target;
            }
        }
        
        /**
         * Removes the ith "Developers" element
         */
        public void removeDevelopers(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DEVELOPERS$60, i);
            }
        }
    }
}
