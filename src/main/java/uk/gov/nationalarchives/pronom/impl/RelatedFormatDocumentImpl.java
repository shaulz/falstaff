/*
 * An XML document type.
 * Localname: RelatedFormat
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.RelatedFormatDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one RelatedFormat(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class RelatedFormatDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.RelatedFormatDocument
{
    private static final long serialVersionUID = 1L;
    
    public RelatedFormatDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RELATEDFORMAT$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormat");
    
    
    /**
     * Gets the "RelatedFormat" element
     */
    public uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat getRelatedFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat target = null;
            target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().find_element_user(RELATEDFORMAT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "RelatedFormat" element
     */
    public void setRelatedFormat(uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat relatedFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat target = null;
            target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().find_element_user(RELATEDFORMAT$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().add_element_user(RELATEDFORMAT$0);
            }
            target.set(relatedFormat);
        }
    }
    
    /**
     * Appends and returns a new empty "RelatedFormat" element
     */
    public uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat addNewRelatedFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat target = null;
            target = (uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat)get_store().add_element_user(RELATEDFORMAT$0);
            return target;
        }
    }
    /**
     * An XML RelatedFormat(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class RelatedFormatImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat
    {
        private static final long serialVersionUID = 1L;
        
        public RelatedFormatImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RELATIONSHIPTYPE$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelationshipType");
        private static final javax.xml.namespace.QName RELATEDFORMATID$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormatID");
        private static final javax.xml.namespace.QName RELATEDFORMATNAME$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormatName");
        private static final javax.xml.namespace.QName RELATEDFORMATVERSION$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "RelatedFormatVersion");
        
        
        /**
         * Gets the "RelationshipType" element
         */
        public uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum getRelationshipType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "RelationshipType" element
         */
        public uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType xgetRelationshipType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType target = null;
                target = (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "RelationshipType" element
         */
        public void setRelationshipType(uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType.Enum relationshipType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATIONSHIPTYPE$0);
                }
                target.setEnumValue(relationshipType);
            }
        }
        
        /**
         * Sets (as xml) the "RelationshipType" element
         */
        public void xsetRelationshipType(uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType relationshipType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType target = null;
                target = (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType)get_store().find_element_user(RELATIONSHIPTYPE$0, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.RelationshipTypeDocument.RelationshipType)get_store().add_element_user(RELATIONSHIPTYPE$0);
                }
                target.set(relationshipType);
            }
        }
        
        /**
         * Gets the "RelatedFormatID" element
         */
        public short getRelatedFormatID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATID$2, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "RelatedFormatID" element
         */
        public org.apache.xmlbeans.XmlShort xgetRelatedFormatID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(RELATEDFORMATID$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "RelatedFormatID" element
         */
        public void setRelatedFormatID(short relatedFormatID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATID$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATEDFORMATID$2);
                }
                target.setShortValue(relatedFormatID);
            }
        }
        
        /**
         * Sets (as xml) the "RelatedFormatID" element
         */
        public void xsetRelatedFormatID(org.apache.xmlbeans.XmlShort relatedFormatID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(RELATEDFORMATID$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(RELATEDFORMATID$2);
                }
                target.set(relatedFormatID);
            }
        }
        
        /**
         * Gets the "RelatedFormatName" element
         */
        public java.lang.String getRelatedFormatName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATNAME$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "RelatedFormatName" element
         */
        public org.apache.xmlbeans.XmlString xgetRelatedFormatName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATNAME$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "RelatedFormatName" element
         */
        public void setRelatedFormatName(java.lang.String relatedFormatName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATEDFORMATNAME$4);
                }
                target.setStringValue(relatedFormatName);
            }
        }
        
        /**
         * Sets (as xml) the "RelatedFormatName" element
         */
        public void xsetRelatedFormatName(org.apache.xmlbeans.XmlString relatedFormatName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELATEDFORMATNAME$4);
                }
                target.set(relatedFormatName);
            }
        }
        
        /**
         * Gets the "RelatedFormatVersion" element
         */
        public java.lang.String getRelatedFormatVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATVERSION$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "RelatedFormatVersion" element
         */
        public org.apache.xmlbeans.XmlString xgetRelatedFormatVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATVERSION$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "RelatedFormatVersion" element
         */
        public void setRelatedFormatVersion(java.lang.String relatedFormatVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATEDFORMATVERSION$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATEDFORMATVERSION$6);
                }
                target.setStringValue(relatedFormatVersion);
            }
        }
        
        /**
         * Sets (as xml) the "RelatedFormatVersion" element
         */
        public void xsetRelatedFormatVersion(org.apache.xmlbeans.XmlString relatedFormatVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RELATEDFORMATVERSION$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RELATEDFORMATVERSION$6);
                }
                target.set(relatedFormatVersion);
            }
        }
    }
}
