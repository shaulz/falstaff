/*
 * An XML document type.
 * Localname: FormatProperty
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FormatPropertyDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom.impl;
/**
 * A document containing one FormatProperty(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public class FormatPropertyDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatPropertyDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormatPropertyDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMATPROPERTY$0 = 
        new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "FormatProperty");
    
    
    /**
     * Gets the "FormatProperty" element
     */
    public uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty getFormatProperty()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty target = null;
            target = (uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty)get_store().find_element_user(FORMATPROPERTY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FormatProperty" element
     */
    public void setFormatProperty(uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty formatProperty)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty target = null;
            target = (uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty)get_store().find_element_user(FORMATPROPERTY$0, 0);
            if (target == null)
            {
                target = (uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty)get_store().add_element_user(FORMATPROPERTY$0);
            }
            target.set(formatProperty);
        }
    }
    
    /**
     * Appends and returns a new empty "FormatProperty" element
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
     * An XML FormatProperty(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public static class FormatPropertyImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.gov.nationalarchives.pronom.FormatPropertyDocument.FormatProperty
    {
        private static final long serialVersionUID = 1L;
        
        public FormatPropertyImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROPERTYNAME$0 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyName");
        private static final javax.xml.namespace.QName PROPERTYDESCRIPTION$2 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyDescription");
        private static final javax.xml.namespace.QName PROPERTYTYPE$4 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyType");
        private static final javax.xml.namespace.QName PROPERTYRISKSCORE$6 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyRiskScore");
        private static final javax.xml.namespace.QName PROPERTYHIGHRISK$8 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyHighRisk");
        private static final javax.xml.namespace.QName PROPERTYVALUEDESCRIPTION$10 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyValueDescription");
        private static final javax.xml.namespace.QName PROPERTYRISKS$12 = 
            new javax.xml.namespace.QName("http://pronom.nationalarchives.gov.uk", "PropertyRisks");
        
        
        /**
         * Gets the "PropertyName" element
         */
        public java.lang.String getPropertyName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYNAME$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PropertyName" element
         */
        public org.apache.xmlbeans.XmlString xgetPropertyName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYNAME$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PropertyName" element
         */
        public void setPropertyName(java.lang.String propertyName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYNAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYNAME$0);
                }
                target.setStringValue(propertyName);
            }
        }
        
        /**
         * Sets (as xml) the "PropertyName" element
         */
        public void xsetPropertyName(org.apache.xmlbeans.XmlString propertyName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYNAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYNAME$0);
                }
                target.set(propertyName);
            }
        }
        
        /**
         * Gets the "PropertyDescription" element
         */
        public java.lang.String getPropertyDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYDESCRIPTION$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PropertyDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetPropertyDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYDESCRIPTION$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PropertyDescription" element
         */
        public void setPropertyDescription(java.lang.String propertyDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYDESCRIPTION$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYDESCRIPTION$2);
                }
                target.setStringValue(propertyDescription);
            }
        }
        
        /**
         * Sets (as xml) the "PropertyDescription" element
         */
        public void xsetPropertyDescription(org.apache.xmlbeans.XmlString propertyDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYDESCRIPTION$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYDESCRIPTION$2);
                }
                target.set(propertyDescription);
            }
        }
        
        /**
         * Gets the "PropertyType" element
         */
        public uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType.Enum getPropertyType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYTYPE$4, 0);
                if (target == null)
                {
                    return null;
                }
                return (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "PropertyType" element
         */
        public uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType xgetPropertyType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType target = null;
                target = (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType)get_store().find_element_user(PROPERTYTYPE$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PropertyType" element
         */
        public void setPropertyType(uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType.Enum propertyType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYTYPE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYTYPE$4);
                }
                target.setEnumValue(propertyType);
            }
        }
        
        /**
         * Sets (as xml) the "PropertyType" element
         */
        public void xsetPropertyType(uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType propertyType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType target = null;
                target = (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType)get_store().find_element_user(PROPERTYTYPE$4, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.PropertyTypeDocument.PropertyType)get_store().add_element_user(PROPERTYTYPE$4);
                }
                target.set(propertyType);
            }
        }
        
        /**
         * Gets the "PropertyRiskScore" element
         */
        public java.lang.String getPropertyRiskScore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYRISKSCORE$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PropertyRiskScore" element
         */
        public org.apache.xmlbeans.XmlString xgetPropertyRiskScore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYRISKSCORE$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PropertyRiskScore" element
         */
        public void setPropertyRiskScore(java.lang.String propertyRiskScore)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYRISKSCORE$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYRISKSCORE$6);
                }
                target.setStringValue(propertyRiskScore);
            }
        }
        
        /**
         * Sets (as xml) the "PropertyRiskScore" element
         */
        public void xsetPropertyRiskScore(org.apache.xmlbeans.XmlString propertyRiskScore)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYRISKSCORE$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYRISKSCORE$6);
                }
                target.set(propertyRiskScore);
            }
        }
        
        /**
         * Gets the "PropertyHighRisk" element
         */
        public java.lang.String getPropertyHighRisk()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYHIGHRISK$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PropertyHighRisk" element
         */
        public org.apache.xmlbeans.XmlString xgetPropertyHighRisk()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYHIGHRISK$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PropertyHighRisk" element
         */
        public void setPropertyHighRisk(java.lang.String propertyHighRisk)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYHIGHRISK$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYHIGHRISK$8);
                }
                target.setStringValue(propertyHighRisk);
            }
        }
        
        /**
         * Sets (as xml) the "PropertyHighRisk" element
         */
        public void xsetPropertyHighRisk(org.apache.xmlbeans.XmlString propertyHighRisk)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYHIGHRISK$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYHIGHRISK$8);
                }
                target.set(propertyHighRisk);
            }
        }
        
        /**
         * Gets the "PropertyValueDescription" element
         */
        public java.lang.String getPropertyValueDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PropertyValueDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetPropertyValueDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$10, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PropertyValueDescription" element
         */
        public void setPropertyValueDescription(java.lang.String propertyValueDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROPERTYVALUEDESCRIPTION$10);
                }
                target.setStringValue(propertyValueDescription);
            }
        }
        
        /**
         * Sets (as xml) the "PropertyValueDescription" element
         */
        public void xsetPropertyValueDescription(org.apache.xmlbeans.XmlString propertyValueDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROPERTYVALUEDESCRIPTION$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROPERTYVALUEDESCRIPTION$10);
                }
                target.set(propertyValueDescription);
            }
        }
        
        /**
         * Gets the "PropertyRisks" element
         */
        public uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks getPropertyRisks()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks target = null;
                target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().find_element_user(PROPERTYRISKS$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "PropertyRisks" element
         */
        public void setPropertyRisks(uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks propertyRisks)
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks target = null;
                target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().find_element_user(PROPERTYRISKS$12, 0);
                if (target == null)
                {
                    target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().add_element_user(PROPERTYRISKS$12);
                }
                target.set(propertyRisks);
            }
        }
        
        /**
         * Appends and returns a new empty "PropertyRisks" element
         */
        public uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks addNewPropertyRisks()
        {
            synchronized (monitor())
            {
                check_orphaned();
                uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks target = null;
                target = (uk.gov.nationalarchives.pronom.PropertyRisksDocument.PropertyRisks)get_store().add_element_user(PROPERTYRISKS$12);
                return target;
            }
        }
    }
}
