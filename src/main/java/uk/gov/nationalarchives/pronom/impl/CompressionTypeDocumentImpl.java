/*
 * An XML document type.
 * Localname: CompressionType
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.CompressionTypeDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one CompressionType(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class CompressionTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public CompressionTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPRESSIONTYPE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionType");
    
    
    /**
     * Gets the "CompressionType" element
     */
    public uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType getCompressionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType target = null;
            target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().find_element_user(COMPRESSIONTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "CompressionType" element
     */
    public void setCompressionType(uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType compressionType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType target = null;
            target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().find_element_user(COMPRESSIONTYPE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().add_element_user(COMPRESSIONTYPE$0);
            }
            target.set(compressionType);
        }
    }
    
    /**
     * Appends and returns a new empty "CompressionType" element
     */
    public uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType addNewCompressionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType target = null;
            target = (uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType)get_store().add_element_user(COMPRESSIONTYPE$0);
            return target;
        }
    }
    /**
     * An XML CompressionType(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class CompressionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType
    {
        private static final long serialVersionUID = 1L;
        
        public CompressionTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName COMPRESSIONID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionID");
        private static final javax.xml.namespace.QName COMPRESSIONNAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionName");
        private static final javax.xml.namespace.QName COMPRESSIONVERSION$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionVersion");
        private static final javax.xml.namespace.QName COMPRESSIONALIASES$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionAliases");
        private static final javax.xml.namespace.QName COMPRESSIONFAMILIES$8 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionFamilies");
        private static final javax.xml.namespace.QName DESCRIPTION$10 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Description");
        private static final javax.xml.namespace.QName LOSSINESS$12 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Lossiness");
        private static final javax.xml.namespace.QName RELEASEDATE$14 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ReleaseDate");
        private static final javax.xml.namespace.QName WITHDRAWNDATE$16 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "WithdrawnDate");
        private static final javax.xml.namespace.QName COMPRESSIONDOCUMENTATION$18 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionDocumentation");
        private static final javax.xml.namespace.QName COMPRESSIONIPR$20 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionIPR");
        private static final javax.xml.namespace.QName COMPRESSIONNOTE$22 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionNote");
        private static final javax.xml.namespace.QName COMPRESSIONIDENTIFIER$24 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "CompressionIdentifier");
        private static final javax.xml.namespace.QName DEVELOPER$26 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Developer");
        
        
        /**
         * Gets the "CompressionID" element
         */
        public byte getCompressionID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getByteValue();
            }
        }
        
        /**
         * Gets (as xml) the "CompressionID" element
         */
        public org.apache.xmlbeans.XmlByte xgetCompressionID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlByte target = null;
                target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(COMPRESSIONID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CompressionID" element
         */
        public void setCompressionID(byte compressionID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONID$0);
                }
                target.setByteValue(compressionID);
            }
        }
        
        /**
         * Sets (as xml) the "CompressionID" element
         */
        public void xsetCompressionID(org.apache.xmlbeans.XmlByte compressionID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlByte target = null;
                target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(COMPRESSIONID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlByte)get_store().add_element_user(COMPRESSIONID$0);
                }
                target.set(compressionID);
            }
        }
        
        /**
         * Gets the "CompressionName" element
         */
        public java.lang.String getCompressionName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CompressionName" element
         */
        public org.apache.xmlbeans.XmlString xgetCompressionName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CompressionName" element
         */
        public void setCompressionName(java.lang.String compressionName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONNAME$2);
                }
                target.setStringValue(compressionName);
            }
        }
        
        /**
         * Sets (as xml) the "CompressionName" element
         */
        public void xsetCompressionName(org.apache.xmlbeans.XmlString compressionName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONNAME$2);
                }
                target.set(compressionName);
            }
        }
        
        /**
         * Gets the "CompressionVersion" element
         */
        public java.lang.String getCompressionVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONVERSION$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CompressionVersion" element
         */
        public org.apache.xmlbeans.XmlString xgetCompressionVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONVERSION$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CompressionVersion" element
         */
        public void setCompressionVersion(java.lang.String compressionVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONVERSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONVERSION$4);
                }
                target.setStringValue(compressionVersion);
            }
        }
        
        /**
         * Sets (as xml) the "CompressionVersion" element
         */
        public void xsetCompressionVersion(org.apache.xmlbeans.XmlString compressionVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONVERSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONVERSION$4);
                }
                target.set(compressionVersion);
            }
        }
        
        /**
         * Gets the "CompressionAliases" element
         */
        public java.lang.String getCompressionAliases()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONALIASES$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CompressionAliases" element
         */
        public org.apache.xmlbeans.XmlString xgetCompressionAliases()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONALIASES$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CompressionAliases" element
         */
        public void setCompressionAliases(java.lang.String compressionAliases)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONALIASES$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONALIASES$6);
                }
                target.setStringValue(compressionAliases);
            }
        }
        
        /**
         * Sets (as xml) the "CompressionAliases" element
         */
        public void xsetCompressionAliases(org.apache.xmlbeans.XmlString compressionAliases)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONALIASES$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONALIASES$6);
                }
                target.set(compressionAliases);
            }
        }
        
        /**
         * Gets the "CompressionFamilies" element
         */
        public java.lang.String getCompressionFamilies()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONFAMILIES$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CompressionFamilies" element
         */
        public org.apache.xmlbeans.XmlString xgetCompressionFamilies()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONFAMILIES$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CompressionFamilies" element
         */
        public void setCompressionFamilies(java.lang.String compressionFamilies)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONFAMILIES$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONFAMILIES$8);
                }
                target.setStringValue(compressionFamilies);
            }
        }
        
        /**
         * Sets (as xml) the "CompressionFamilies" element
         */
        public void xsetCompressionFamilies(org.apache.xmlbeans.XmlString compressionFamilies)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONFAMILIES$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONFAMILIES$8);
                }
                target.set(compressionFamilies);
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
         * Gets the "Lossiness" element
         */
        public uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum getLossiness()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOSSINESS$12, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "Lossiness" element
         */
        public uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness xgetLossiness()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness target = null;
                target = (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness)get_store().find_element_user(LOSSINESS$12, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Lossiness" element
         */
        public void setLossiness(uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness.Enum lossiness)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOSSINESS$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOSSINESS$12);
                }
                target.setEnumValue(lossiness);
            }
        }
        
        /**
         * Sets (as xml) the "Lossiness" element
         */
        public void xsetLossiness(uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness lossiness)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness target = null;
                target = (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness)get_store().find_element_user(LOSSINESS$12, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.LossinessDocument.Lossiness)get_store().add_element_user(LOSSINESS$12);
                }
                target.set(lossiness);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$14, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$14, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELEASEDATE$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELEASEDATE$14);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELEASEDATE$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELEASEDATE$14);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$16, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$16, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WITHDRAWNDATE$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WITHDRAWNDATE$16);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WITHDRAWNDATE$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WITHDRAWNDATE$16);
                }
                target.set(withdrawnDate);
            }
        }
        
        /**
         * Gets the "CompressionDocumentation" element
         */
        public java.lang.String getCompressionDocumentation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONDOCUMENTATION$18, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CompressionDocumentation" element
         */
        public org.apache.xmlbeans.XmlString xgetCompressionDocumentation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONDOCUMENTATION$18, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CompressionDocumentation" element
         */
        public void setCompressionDocumentation(java.lang.String compressionDocumentation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONDOCUMENTATION$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONDOCUMENTATION$18);
                }
                target.setStringValue(compressionDocumentation);
            }
        }
        
        /**
         * Sets (as xml) the "CompressionDocumentation" element
         */
        public void xsetCompressionDocumentation(org.apache.xmlbeans.XmlString compressionDocumentation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONDOCUMENTATION$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONDOCUMENTATION$18);
                }
                target.set(compressionDocumentation);
            }
        }
        
        /**
         * Gets the "CompressionIPR" element
         */
        public java.lang.String getCompressionIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONIPR$20, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CompressionIPR" element
         */
        public org.apache.xmlbeans.XmlString xgetCompressionIPR()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONIPR$20, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CompressionIPR" element
         */
        public void setCompressionIPR(java.lang.String compressionIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONIPR$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONIPR$20);
                }
                target.setStringValue(compressionIPR);
            }
        }
        
        /**
         * Sets (as xml) the "CompressionIPR" element
         */
        public void xsetCompressionIPR(org.apache.xmlbeans.XmlString compressionIPR)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONIPR$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONIPR$20);
                }
                target.set(compressionIPR);
            }
        }
        
        /**
         * Gets the "CompressionNote" element
         */
        public java.lang.String getCompressionNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNOTE$22, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNOTE$22, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPRESSIONNOTE$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPRESSIONNOTE$22);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPRESSIONNOTE$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPRESSIONNOTE$22);
                }
                target.set(compressionNote);
            }
        }
        
        /**
         * Gets array of all "CompressionIdentifier" elements
         */
        public uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier[] getCompressionIdentifierArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(COMPRESSIONIDENTIFIER$24, targetList);
                uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier[] result = new uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "CompressionIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier getCompressionIdentifierArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier)get_store().find_element_user(COMPRESSIONIDENTIFIER$24, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "CompressionIdentifier" element
         */
        public int sizeOfCompressionIdentifierArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(COMPRESSIONIDENTIFIER$24);
            }
        }
        
        /**
         * Sets array of all "CompressionIdentifier" element
         */
        public void setCompressionIdentifierArray(uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier[] compressionIdentifierArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(compressionIdentifierArray, COMPRESSIONIDENTIFIER$24);
            }
        }
        
        /**
         * Sets ith "CompressionIdentifier" element
         */
        public void setCompressionIdentifierArray(int i, uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier compressionIdentifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier)get_store().find_element_user(COMPRESSIONIDENTIFIER$24, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(compressionIdentifier);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "CompressionIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier insertNewCompressionIdentifier(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier)get_store().insert_element_user(COMPRESSIONIDENTIFIER$24, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "CompressionIdentifier" element
         */
        public uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier addNewCompressionIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier target = null;
                target = (uk.gov.nationalarchives.pronom.CompressionIdentifierDocument.CompressionIdentifier)get_store().add_element_user(COMPRESSIONIDENTIFIER$24);
                return target;
            }
        }
        
        /**
         * Removes the ith "CompressionIdentifier" element
         */
        public void removeCompressionIdentifier(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(COMPRESSIONIDENTIFIER$24, i);
            }
        }
        
        /**
         * Gets the "Developer" element
         */
        public uk.gov.nationalarchives.pronom.DeveloperDocument.Developer getDeveloper()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DeveloperDocument.Developer target = null;
                target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().find_element_user(DEVELOPER$26, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "Developer" element
         */
        public boolean isSetDeveloper()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DEVELOPER$26) != 0;
            }
        }
        
        /**
         * Sets the "Developer" element
         */
        public void setDeveloper(uk.gov.nationalarchives.pronom.DeveloperDocument.Developer developer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DeveloperDocument.Developer target = null;
                target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().find_element_user(DEVELOPER$26, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().add_element_user(DEVELOPER$26);
                }
                target.set(developer);
            }
        }
        
        /**
         * Appends and returns a new empty "Developer" element
         */
        public uk.gov.nationalarchives.pronom.DeveloperDocument.Developer addNewDeveloper()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.DeveloperDocument.Developer target = null;
                target = (uk.gov.nationalarchives.pronom.DeveloperDocument.Developer)get_store().add_element_user(DEVELOPER$26);
                return target;
            }
        }
        
        /**
         * Unsets the "Developer" element
         */
        public void unsetDeveloper()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DEVELOPER$26, 0);
            }
        }
    }
}
