/*
 * An XML document type.
 * Localname: InternalSignature
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.InternalSignatureDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one InternalSignature(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class InternalSignatureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.InternalSignatureDocument
{
    private static final long serialVersionUID = 1L;
    
    public InternalSignatureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INTERNALSIGNATURE$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "InternalSignature");
    
    
    /**
     * Gets the "InternalSignature" element
     */
    public uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature getInternalSignature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature target = null;
            target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().find_element_user(INTERNALSIGNATURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "InternalSignature" element
     */
    public void setInternalSignature(uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature internalSignature)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature target = null;
            target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().find_element_user(INTERNALSIGNATURE$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().add_element_user(INTERNALSIGNATURE$0);
            }
            target.set(internalSignature);
        }
    }
    
    /**
     * Appends and returns a new empty "InternalSignature" element
     */
    public uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature addNewInternalSignature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature target = null;
            target = (uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature)get_store().add_element_user(INTERNALSIGNATURE$0);
            return target;
        }
    }
    /**
     * An XML InternalSignature(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class InternalSignatureImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature
    {
        private static final long serialVersionUID = 1L;
        
        public InternalSignatureImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SIGNATUREID$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureID");
        private static final javax.xml.namespace.QName SIGNATURENAME$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureName");
        private static final javax.xml.namespace.QName SIGNATURENOTE$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "SignatureNote");
        private static final javax.xml.namespace.QName BYTESEQUENCE$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "ByteSequence");
        
        
        /**
         * Gets the "SignatureID" element
         */
        public short getSignatureID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATUREID$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getShortValue();
            }
        }
        
        /**
         * Gets (as xml) the "SignatureID" element
         */
        public org.apache.xmlbeans.XmlShort xgetSignatureID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SIGNATUREID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SignatureID" element
         */
        public void setSignatureID(short signatureID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATUREID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATUREID$0);
                }
                target.setShortValue(signatureID);
            }
        }
        
        /**
         * Sets (as xml) the "SignatureID" element
         */
        public void xsetSignatureID(org.apache.xmlbeans.XmlShort signatureID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlShort target = null;
                target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(SIGNATUREID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(SIGNATUREID$0);
                }
                target.set(signatureID);
            }
        }
        
        /**
         * Gets the "SignatureName" element
         */
        public java.lang.String getSignatureName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "SignatureName" element
         */
        public org.apache.xmlbeans.XmlString xgetSignatureName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SignatureName" element
         */
        public void setSignatureName(java.lang.String signatureName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURENAME$2);
                }
                target.setStringValue(signatureName);
            }
        }
        
        /**
         * Sets (as xml) the "SignatureName" element
         */
        public void xsetSignatureName(org.apache.xmlbeans.XmlString signatureName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SIGNATURENAME$2);
                }
                target.set(signatureName);
            }
        }
        
        /**
         * Gets the "SignatureNote" element
         */
        public java.lang.String getSignatureNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENOTE$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "SignatureNote" element
         */
        public org.apache.xmlbeans.XmlString xgetSignatureNote()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENOTE$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SignatureNote" element
         */
        public void setSignatureNote(java.lang.String signatureNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIGNATURENOTE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIGNATURENOTE$4);
                }
                target.setStringValue(signatureNote);
            }
        }
        
        /**
         * Sets (as xml) the "SignatureNote" element
         */
        public void xsetSignatureNote(org.apache.xmlbeans.XmlString signatureNote)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIGNATURENOTE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SIGNATURENOTE$4);
                }
                target.set(signatureNote);
            }
        }
        
        /**
         * Gets array of all "ByteSequence" elements
         */
        public uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence[] getByteSequenceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(BYTESEQUENCE$6, targetList);
                uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence[] result = new uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "ByteSequence" element
         */
        public uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence getByteSequenceArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence target = null;
                target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().find_element_user(BYTESEQUENCE$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "ByteSequence" element
         */
        public int sizeOfByteSequenceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(BYTESEQUENCE$6);
            }
        }
        
        /**
         * Sets array of all "ByteSequence" element
         */
        public void setByteSequenceArray(uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence[] byteSequenceArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(byteSequenceArray, BYTESEQUENCE$6);
            }
        }
        
        /**
         * Sets ith "ByteSequence" element
         */
        public void setByteSequenceArray(int i, uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence byteSequence)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence target = null;
                target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().find_element_user(BYTESEQUENCE$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(byteSequence);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ByteSequence" element
         */
        public uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence insertNewByteSequence(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence target = null;
                target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().insert_element_user(BYTESEQUENCE$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ByteSequence" element
         */
        public uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence addNewByteSequence()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence target = null;
                target = (uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence)get_store().add_element_user(BYTESEQUENCE$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "ByteSequence" element
         */
        public void removeByteSequence(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(BYTESEQUENCE$6, i);
            }
        }
    }
}
