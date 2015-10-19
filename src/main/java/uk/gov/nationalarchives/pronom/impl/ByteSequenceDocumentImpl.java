/*
 * An XML document type.
 * Localname: ByteSequence
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.ByteSequenceDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one ByteSequence(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class ByteSequenceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ByteSequenceDocument
{
    private static final long serialVersionUID = 1L;
    
    public ByteSequenceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BYTESEQUENCE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteSequence");
    
    
    /**
     * Gets the "ByteSequence" element
     */
    public uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence getByteSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence target = null;
            target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().find_element_user(BYTESEQUENCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ByteSequence" element
     */
    public void setByteSequence(uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence byteSequence)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence target = null;
            target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().find_element_user(BYTESEQUENCE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().add_element_user(BYTESEQUENCE$0);
            }
            target.set(byteSequence);
        }
    }
    
    /**
     * Appends and returns a new empty "ByteSequence" element
     */
    public uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence addNewByteSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence target = null;
            target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().add_element_user(BYTESEQUENCE$0);
            return target;
        }
    }
    /**
     * An XML ByteSequence(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class ByteSequenceImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence
    {
        private static final long serialVersionUID = 1L;
        
        public ByteSequenceImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName BYTESEQUENCEID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteSequenceID");
        private static final javax.xml.namespace.QName POSITIONTYPE$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PositionType");
        private static final javax.xml.namespace.QName OFFSET$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Offset");
        private static final javax.xml.namespace.QName MAXOFFSET$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "MaxOffset");
        private static final javax.xml.namespace.QName INDIRECTOFFSETLOCATION$8 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "IndirectOffsetLocation");
        private static final javax.xml.namespace.QName INDIRECTOFFSETLENGTH$10 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "IndirectOffsetLength");
        private static final javax.xml.namespace.QName ENDIANNESS$12 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "Endianness");
        private static final javax.xml.namespace.QName BYTESEQUENCEVALUE$14 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteSequenceValue");
        
        
        /**
         * Gets the "ByteSequenceID" element
         */
        public short getByteSequenceID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "ByteSequenceID" element
         */
        public org.apache.xmlbeans.XmlShort xgetByteSequenceID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(BYTESEQUENCEID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ByteSequenceID" element
         */
        public void setByteSequenceID(short byteSequenceID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BYTESEQUENCEID$0);
                }
                target.setShortValue(byteSequenceID);
            }
        }
        
        /**
         * Sets (as xml) the "ByteSequenceID" element
         */
        public void xsetByteSequenceID(org.apache.xmlbeans.XmlShort byteSequenceID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(BYTESEQUENCEID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(BYTESEQUENCEID$0);
                }
                target.set(byteSequenceID);
            }
        }
        
        /**
         * Gets the "PositionType" element
         */
        public uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum getPositionType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONTYPE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "PositionType" element
         */
        public uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType xgetPositionType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType target = null;
                target = (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType)get_store().find_element_user(POSITIONTYPE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PositionType" element
         */
        public void setPositionType(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum positionType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONTYPE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSITIONTYPE$2);
                }
                target.setEnumValue(positionType);
            }
        }
        
        /**
         * Sets (as xml) the "PositionType" element
         */
        public void xsetPositionType(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType positionType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType target = null;
                target = (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType)get_store().find_element_user(POSITIONTYPE$2, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType)get_store().add_element_user(POSITIONTYPE$2);
                }
                target.set(positionType);
            }
        }
        
        /**
         * Gets the "Offset" element
         */
        public java.lang.String getOffset()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OFFSET$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Offset" element
         */
        public org.apache.xmlbeans.XmlString xgetOffset()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OFFSET$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Offset" element
         */
        public void setOffset(java.lang.String offset)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OFFSET$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OFFSET$4);
                }
                target.setStringValue(offset);
            }
        }
        
        /**
         * Sets (as xml) the "Offset" element
         */
        public void xsetOffset(org.apache.xmlbeans.XmlString offset)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OFFSET$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(OFFSET$4);
                }
                target.set(offset);
            }
        }
        
        /**
         * Gets the "MaxOffset" element
         */
        public java.lang.String getMaxOffset()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXOFFSET$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "MaxOffset" element
         */
        public org.apache.xmlbeans.XmlString xgetMaxOffset()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MAXOFFSET$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "MaxOffset" element
         */
        public void setMaxOffset(java.lang.String maxOffset)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXOFFSET$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MAXOFFSET$6);
                }
                target.setStringValue(maxOffset);
            }
        }
        
        /**
         * Sets (as xml) the "MaxOffset" element
         */
        public void xsetMaxOffset(org.apache.xmlbeans.XmlString maxOffset)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MAXOFFSET$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MAXOFFSET$6);
                }
                target.set(maxOffset);
            }
        }
        
        /**
         * Gets the "IndirectOffsetLocation" element
         */
        public java.lang.String getIndirectOffsetLocation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLOCATION$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "IndirectOffsetLocation" element
         */
        public org.apache.xmlbeans.XmlString xgetIndirectOffsetLocation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLOCATION$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "IndirectOffsetLocation" element
         */
        public void setIndirectOffsetLocation(java.lang.String indirectOffsetLocation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLOCATION$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDIRECTOFFSETLOCATION$8);
                }
                target.setStringValue(indirectOffsetLocation);
            }
        }
        
        /**
         * Sets (as xml) the "IndirectOffsetLocation" element
         */
        public void xsetIndirectOffsetLocation(org.apache.xmlbeans.XmlString indirectOffsetLocation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLOCATION$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDIRECTOFFSETLOCATION$8);
                }
                target.set(indirectOffsetLocation);
            }
        }
        
        /**
         * Gets the "IndirectOffsetLength" element
         */
        public java.lang.String getIndirectOffsetLength()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLENGTH$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "IndirectOffsetLength" element
         */
        public org.apache.xmlbeans.XmlString xgetIndirectOffsetLength()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLENGTH$10, 0);
                return target;
            }
        }
        
        /**
         * Sets the "IndirectOffsetLength" element
         */
        public void setIndirectOffsetLength(java.lang.String indirectOffsetLength)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIRECTOFFSETLENGTH$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDIRECTOFFSETLENGTH$10);
                }
                target.setStringValue(indirectOffsetLength);
            }
        }
        
        /**
         * Sets (as xml) the "IndirectOffsetLength" element
         */
        public void xsetIndirectOffsetLength(org.apache.xmlbeans.XmlString indirectOffsetLength)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIRECTOFFSETLENGTH$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDIRECTOFFSETLENGTH$10);
                }
                target.set(indirectOffsetLength);
            }
        }
        
        /**
         * Gets the "Endianness" element
         */
        public java.lang.String getEndianness()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENDIANNESS$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Endianness" element
         */
        public org.apache.xmlbeans.XmlString xgetEndianness()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENDIANNESS$12, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Endianness" element
         */
        public void setEndianness(java.lang.String endianness)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENDIANNESS$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENDIANNESS$12);
                }
                target.setStringValue(endianness);
            }
        }
        
        /**
         * Sets (as xml) the "Endianness" element
         */
        public void xsetEndianness(org.apache.xmlbeans.XmlString endianness)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENDIANNESS$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENDIANNESS$12);
                }
                target.set(endianness);
            }
        }
        
        /**
         * Gets the "ByteSequenceValue" element
         */
        public java.lang.String getByteSequenceValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEVALUE$14, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ByteSequenceValue" element
         */
        public org.apache.xmlbeans.XmlString xgetByteSequenceValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTESEQUENCEVALUE$14, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ByteSequenceValue" element
         */
        public void setByteSequenceValue(java.lang.String byteSequenceValue)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BYTESEQUENCEVALUE$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BYTESEQUENCEVALUE$14);
                }
                target.setStringValue(byteSequenceValue);
            }
        }
        
        /**
         * Sets (as xml) the "ByteSequenceValue" element
         */
        public void xsetByteSequenceValue(org.apache.xmlbeans.XmlString byteSequenceValue)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BYTESEQUENCEVALUE$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BYTESEQUENCEVALUE$14);
                }
                target.set(byteSequenceValue);
            }
        }
    }
}
