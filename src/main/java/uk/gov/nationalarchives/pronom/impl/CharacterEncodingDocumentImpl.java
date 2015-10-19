/*
 * An XML document type.
 * Localname: CharacterEncoding
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CharacterEncodingDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CharacterEncoding(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CharacterEncodingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CharacterEncodingDocument
{
    private static final long serialVersionUID = 1L;
    
    public CharacterEncodingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHARACTERENCODING$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CharacterEncoding");
    
    
    /**
     * Gets the "CharacterEncoding" element
     */
    public uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding getCharacterEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding target = null;
            target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().find_element_user(CHARACTERENCODING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
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
            target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().find_element_user(CHARACTERENCODING$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().add_element_user(CHARACTERENCODING$0);
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
            target = (uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding)get_store().add_element_user(CHARACTERENCODING$0);
            return target;
        }
    }
    /**
     * An XML CharacterEncoding(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class CharacterEncodingImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding
    {
        private static final long serialVersionUID = 1L;
        
        public CharacterEncodingImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ENCODINGID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingID");
        private static final javax.xml.namespace.QName ENCODINGNAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingName");
        private static final javax.xml.namespace.QName ENCODINGVERSION$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingVersion");
        private static final javax.xml.namespace.QName ENCODINGALIASES$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingAliases");
        private static final javax.xml.namespace.QName ENCODINGFAMILIES$8 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingFamilies");
        private static final javax.xml.namespace.QName DESCRIPTION$10 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Description");
        private static final javax.xml.namespace.QName CODEPAGE$12 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CodePage");
        private static final javax.xml.namespace.QName CODEUNITWIDTH$14 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CodeUnitWidth");
        private static final javax.xml.namespace.QName ENCODINGFORMWIDTH$16 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingFormWidth");
        private static final javax.xml.namespace.QName RELEASEDATE$18 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReleaseDate");
        private static final javax.xml.namespace.QName WITHDRAWNDATE$20 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "WithdrawnDate");
        private static final javax.xml.namespace.QName ENCODINGDOCUMENTATION$22 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingDocumentation");
        private static final javax.xml.namespace.QName ENCODINGIPR$24 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingIPR");
        private static final javax.xml.namespace.QName ENCODINGNOTE$26 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "EncodingNote");
        
        
        /**
         * Gets the "EncodingID" element
         */
        public byte getEncodingID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getByteValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingID" element
         */
        public uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID xgetEncodingID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID target = null;
                target = (uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID)get_store().find_element_user(ENCODINGID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingID" element
         */
        public void setEncodingID(byte encodingID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGID$0);
                }
                target.setByteValue(encodingID);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingID" element
         */
        public void xsetEncodingID(uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID encodingID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID target = null;
                target = (uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID)get_store().find_element_user(ENCODINGID$0, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.EncodingIDDocument.EncodingID)get_store().add_element_user(ENCODINGID$0);
                }
                target.set(encodingID);
            }
        }
        
        /**
         * Gets the "EncodingName" element
         */
        public uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum getEncodingName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingName" element
         */
        public uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName xgetEncodingName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName target = null;
                target = (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName)get_store().find_element_user(ENCODINGNAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingName" element
         */
        public void setEncodingName(uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName.Enum encodingName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGNAME$2);
                }
                target.setEnumValue(encodingName);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingName" element
         */
        public void xsetEncodingName(uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName encodingName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName target = null;
                target = (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName)get_store().find_element_user(ENCODINGNAME$2, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.EncodingNameDocument.EncodingName)get_store().add_element_user(ENCODINGNAME$2);
                }
                target.set(encodingName);
            }
        }
        
        /**
         * Gets the "EncodingVersion" element
         */
        public java.lang.String getEncodingVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGVERSION$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingVersion" element
         */
        public org.apache.xmlbeans.XmlString xgetEncodingVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGVERSION$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingVersion" element
         */
        public void setEncodingVersion(java.lang.String encodingVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGVERSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGVERSION$4);
                }
                target.setStringValue(encodingVersion);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingVersion" element
         */
        public void xsetEncodingVersion(org.apache.xmlbeans.XmlString encodingVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGVERSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGVERSION$4);
                }
                target.set(encodingVersion);
            }
        }
        
        /**
         * Gets the "EncodingAliases" element
         */
        public java.lang.String getEncodingAliases()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGALIASES$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingAliases" element
         */
        public org.apache.xmlbeans.XmlString xgetEncodingAliases()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGALIASES$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingAliases" element
         */
        public void setEncodingAliases(java.lang.String encodingAliases)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGALIASES$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGALIASES$6);
                }
                target.setStringValue(encodingAliases);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingAliases" element
         */
        public void xsetEncodingAliases(org.apache.xmlbeans.XmlString encodingAliases)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGALIASES$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGALIASES$6);
                }
                target.set(encodingAliases);
            }
        }
        
        /**
         * Gets the "EncodingFamilies" element
         */
        public java.lang.String getEncodingFamilies()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFAMILIES$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingFamilies" element
         */
        public org.apache.xmlbeans.XmlString xgetEncodingFamilies()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFAMILIES$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingFamilies" element
         */
        public void setEncodingFamilies(java.lang.String encodingFamilies)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFAMILIES$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGFAMILIES$8);
                }
                target.setStringValue(encodingFamilies);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingFamilies" element
         */
        public void xsetEncodingFamilies(org.apache.xmlbeans.XmlString encodingFamilies)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFAMILIES$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGFAMILIES$8);
                }
                target.set(encodingFamilies);
            }
        }
        
        /**
         * Gets the "Description" element
         */
        public java.lang.String getDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Description" element
         */
        public org.apache.xmlbeans.XmlString xgetDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$10, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Description" element
         */
        public void setDescription(java.lang.String description)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$10);
                }
                target.setStringValue(description);
            }
        }
        
        /**
         * Sets (as xml) the "Description" element
         */
        public void xsetDescription(org.apache.xmlbeans.XmlString description)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$10);
                }
                target.set(description);
            }
        }
        
        /**
         * Gets the "CodePage" element
         */
        public java.lang.String getCodePage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEPAGE$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CodePage" element
         */
        public org.apache.xmlbeans.XmlString xgetCodePage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEPAGE$12, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CodePage" element
         */
        public void setCodePage(java.lang.String codePage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEPAGE$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODEPAGE$12);
                }
                target.setStringValue(codePage);
            }
        }
        
        /**
         * Sets (as xml) the "CodePage" element
         */
        public void xsetCodePage(org.apache.xmlbeans.XmlString codePage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEPAGE$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODEPAGE$12);
                }
                target.set(codePage);
            }
        }
        
        /**
         * Gets the "CodeUnitWidth" element
         */
        public java.lang.String getCodeUnitWidth()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEUNITWIDTH$14, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CodeUnitWidth" element
         */
        public org.apache.xmlbeans.XmlString xgetCodeUnitWidth()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEUNITWIDTH$14, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CodeUnitWidth" element
         */
        public void setCodeUnitWidth(java.lang.String codeUnitWidth)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEUNITWIDTH$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODEUNITWIDTH$14);
                }
                target.setStringValue(codeUnitWidth);
            }
        }
        
        /**
         * Sets (as xml) the "CodeUnitWidth" element
         */
        public void xsetCodeUnitWidth(org.apache.xmlbeans.XmlString codeUnitWidth)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEUNITWIDTH$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODEUNITWIDTH$14);
                }
                target.set(codeUnitWidth);
            }
        }
        
        /**
         * Gets the "EncodingFormWidth" element
         */
        public java.lang.String getEncodingFormWidth()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFORMWIDTH$16, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingFormWidth" element
         */
        public org.apache.xmlbeans.XmlString xgetEncodingFormWidth()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFORMWIDTH$16, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingFormWidth" element
         */
        public void setEncodingFormWidth(java.lang.String encodingFormWidth)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGFORMWIDTH$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGFORMWIDTH$16);
                }
                target.setStringValue(encodingFormWidth);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingFormWidth" element
         */
        public void xsetEncodingFormWidth(org.apache.xmlbeans.XmlString encodingFormWidth)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGFORMWIDTH$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGFORMWIDTH$16);
                }
                target.set(encodingFormWidth);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$18, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$18, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELEASEDATE$18);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELEASEDATE$18);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$20, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$20, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WITHDRAWNDATE$20);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WITHDRAWNDATE$20);
                }
                target.set(withdrawnDate);
            }
        }
        
        /**
         * Gets the "EncodingDocumentation" element
         */
        public java.lang.String getEncodingDocumentation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGDOCUMENTATION$22, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingDocumentation" element
         */
        public org.apache.xmlbeans.XmlString xgetEncodingDocumentation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGDOCUMENTATION$22, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingDocumentation" element
         */
        public void setEncodingDocumentation(java.lang.String encodingDocumentation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGDOCUMENTATION$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGDOCUMENTATION$22);
                }
                target.setStringValue(encodingDocumentation);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingDocumentation" element
         */
        public void xsetEncodingDocumentation(org.apache.xmlbeans.XmlString encodingDocumentation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGDOCUMENTATION$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGDOCUMENTATION$22);
                }
                target.set(encodingDocumentation);
            }
        }
        
        /**
         * Gets the "EncodingIPR" element
         */
        public java.lang.String getEncodingIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGIPR$24, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingIPR" element
         */
        public org.apache.xmlbeans.XmlString xgetEncodingIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGIPR$24, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingIPR" element
         */
        public void setEncodingIPR(java.lang.String encodingIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGIPR$24, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGIPR$24);
                }
                target.setStringValue(encodingIPR);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingIPR" element
         */
        public void xsetEncodingIPR(org.apache.xmlbeans.XmlString encodingIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGIPR$24, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGIPR$24);
                }
                target.set(encodingIPR);
            }
        }
        
        /**
         * Gets the "EncodingNote" element
         */
        public java.lang.String getEncodingNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNOTE$26, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "EncodingNote" element
         */
        public org.apache.xmlbeans.XmlString xgetEncodingNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGNOTE$26, 0);
                return target;
            }
        }
        
        /**
         * Sets the "EncodingNote" element
         */
        public void setEncodingNote(java.lang.String encodingNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNOTE$26, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGNOTE$26);
                }
                target.setStringValue(encodingNote);
            }
        }
        
        /**
         * Sets (as xml) the "EncodingNote" element
         */
        public void xsetEncodingNote(org.apache.xmlbeans.XmlString encodingNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENCODINGNOTE$26, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENCODINGNOTE$26);
                }
                target.set(encodingNote);
            }
        }
    }
}
