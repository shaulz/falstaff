/*
 * An XML document type.
 * Localname: FormatProperties
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatPropertiesDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatProperties(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatPropertiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatPropertiesDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatPropertiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATPROPERTIES$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatProperties");
    
    
    /**
     * Gets the "FormatProperties" element
     */
    public uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties getFormatProperties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties target = null;
            target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().find_element_user(FORMATPROPERTIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
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
            target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().find_element_user(FORMATPROPERTIES$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().add_element_user(FORMATPROPERTIES$0);
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
            target = (uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties)get_store().add_element_user(FORMATPROPERTIES$0);
            return target;
        }
    }
    /**
     * An XML FormatProperties(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class FormatPropertiesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties
    {
        private static final long serialVersionUID = 1L;
        
        public FormatPropertiesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FORMATPROPERTY$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatProperty");
        
        
        /**
         * Gets array of all "FormatProperty" elements
         */
        public uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty[] getFormatPropertyArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FORMATPROPERTY$0, targetList);
                uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty[] result = new uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "FormatProperty" element
         */
        public uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty getFormatPropertyArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty target = null;
                target = (uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty)get_store().find_element_user(FORMATPROPERTY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "FormatProperty" element
         */
        public int sizeOfFormatPropertyArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FORMATPROPERTY$0);
            }
        }
        
        /**
         * Sets array of all "FormatProperty" element
         */
        public void setFormatPropertyArray(uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty[] formatPropertyArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(formatPropertyArray, FORMATPROPERTY$0);
            }
        }
        
        /**
         * Sets ith "FormatProperty" element
         */
        public void setFormatPropertyArray(int i, uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty formatProperty)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty target = null;
                target = (uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty)get_store().find_element_user(FORMATPROPERTY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(formatProperty);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "FormatProperty" element
         */
        public uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty insertNewFormatProperty(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty target = null;
                target = (uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty)get_store().insert_element_user(FORMATPROPERTY$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "FormatProperty" element
         */
        public uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty addNewFormatProperty()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty target = null;
                target = (uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty)get_store().add_element_user(FORMATPROPERTY$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "FormatProperty" element
         */
        public void removeFormatProperty(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FORMATPROPERTY$0, i);
            }
        }
    }
}
