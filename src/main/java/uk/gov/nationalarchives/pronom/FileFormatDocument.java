/*
 * An XML document type.
 * Localname: FileFormat
 * Namespace: http://pronom.nationalarchives.gov.uk
 * Java type: uk.gov.nationalarchives.pronom.FileFormatDocument
 *
 * Automatically generated - do not modify.
 */
package uk.gov.nationalarchives.pronom;


/**
 * A document containing one FileFormat(@http://pronom.nationalarchives.gov.uk) element.
 *
 * This is a complex type.
 */
public interface FileFormatDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FileFormatDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("fileformat03f0doctype");
    
    /**
     * Gets the "FileFormat" element
     */
    uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat getFileFormat();
    
    /**
     * Sets the "FileFormat" element
     */
    void setFileFormat(uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat fileFormat);
    
    /**
     * Appends and returns a new empty "FileFormat" element
     */
    uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat addNewFileFormat();
    
    /**
     * An XML FileFormat(@http://pronom.nationalarchives.gov.uk).
     *
     * This is a complex type.
     */
    public interface FileFormat extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FileFormat.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCB70FF474BC4306766FF41A97EBCD453").resolveHandle("fileformatf441elemtype");
        
        /**
         * Gets the "FormatID" element
         */
        short getFormatID();
        
        /**
         * Gets (as xml) the "FormatID" element
         */
        org.apache.xmlbeans.XmlShort xgetFormatID();
        
        /**
         * Sets the "FormatID" element
         */
        void setFormatID(short formatID);
        
        /**
         * Sets (as xml) the "FormatID" element
         */
        void xsetFormatID(org.apache.xmlbeans.XmlShort formatID);
        
        /**
         * Gets the "FormatName" element
         */
        java.lang.String getFormatName();
        
        /**
         * Gets (as xml) the "FormatName" element
         */
        org.apache.xmlbeans.XmlString xgetFormatName();
        
        /**
         * Sets the "FormatName" element
         */
        void setFormatName(java.lang.String formatName);
        
        /**
         * Sets (as xml) the "FormatName" element
         */
        void xsetFormatName(org.apache.xmlbeans.XmlString formatName);
        
        /**
         * Gets the "FormatVersion" element
         */
        java.lang.String getFormatVersion();
        
        /**
         * Gets (as xml) the "FormatVersion" element
         */
        org.apache.xmlbeans.XmlString xgetFormatVersion();
        
        /**
         * Sets the "FormatVersion" element
         */
        void setFormatVersion(java.lang.String formatVersion);
        
        /**
         * Sets (as xml) the "FormatVersion" element
         */
        void xsetFormatVersion(org.apache.xmlbeans.XmlString formatVersion);
        
        /**
         * Gets the "FormatAliases" element
         */
        java.lang.String getFormatAliases();
        
        /**
         * Gets (as xml) the "FormatAliases" element
         */
        org.apache.xmlbeans.XmlString xgetFormatAliases();
        
        /**
         * Sets the "FormatAliases" element
         */
        void setFormatAliases(java.lang.String formatAliases);
        
        /**
         * Sets (as xml) the "FormatAliases" element
         */
        void xsetFormatAliases(org.apache.xmlbeans.XmlString formatAliases);
        
        /**
         * Gets the "FormatFamilies" element
         */
        java.lang.String getFormatFamilies();
        
        /**
         * Gets (as xml) the "FormatFamilies" element
         */
        org.apache.xmlbeans.XmlString xgetFormatFamilies();
        
        /**
         * Sets the "FormatFamilies" element
         */
        void setFormatFamilies(java.lang.String formatFamilies);
        
        /**
         * Sets (as xml) the "FormatFamilies" element
         */
        void xsetFormatFamilies(org.apache.xmlbeans.XmlString formatFamilies);
        
        /**
         * Gets the "FormatTypes" element
         */
        java.lang.String getFormatTypes();
        
        /**
         * Gets (as xml) the "FormatTypes" element
         */
        org.apache.xmlbeans.XmlString xgetFormatTypes();
        
        /**
         * Sets the "FormatTypes" element
         */
        void setFormatTypes(java.lang.String formatTypes);
        
        /**
         * Sets (as xml) the "FormatTypes" element
         */
        void xsetFormatTypes(org.apache.xmlbeans.XmlString formatTypes);
        
        /**
         * Gets the "FormatDisclosure" element
         */
        java.lang.String getFormatDisclosure();
        
        /**
         * Gets (as xml) the "FormatDisclosure" element
         */
        org.apache.xmlbeans.XmlString xgetFormatDisclosure();
        
        /**
         * Sets the "FormatDisclosure" element
         */
        void setFormatDisclosure(java.lang.String formatDisclosure);
        
        /**
         * Sets (as xml) the "FormatDisclosure" element
         */
        void xsetFormatDisclosure(org.apache.xmlbeans.XmlString formatDisclosure);
        
        /**
         * Gets the "FormatDescription" element
         */
        java.lang.String getFormatDescription();
        
        /**
         * Gets (as xml) the "FormatDescription" element
         */
        org.apache.xmlbeans.XmlString xgetFormatDescription();
        
        /**
         * Sets the "FormatDescription" element
         */
        void setFormatDescription(java.lang.String formatDescription);
        
        /**
         * Sets (as xml) the "FormatDescription" element
         */
        void xsetFormatDescription(org.apache.xmlbeans.XmlString formatDescription);
        
        /**
         * Gets the "BinaryFileFormat" element
         */
        java.lang.String getBinaryFileFormat();
        
        /**
         * Gets (as xml) the "BinaryFileFormat" element
         */
        org.apache.xmlbeans.XmlString xgetBinaryFileFormat();
        
        /**
         * Sets the "BinaryFileFormat" element
         */
        void setBinaryFileFormat(java.lang.String binaryFileFormat);
        
        /**
         * Sets (as xml) the "BinaryFileFormat" element
         */
        void xsetBinaryFileFormat(org.apache.xmlbeans.XmlString binaryFileFormat);
        
        /**
         * Gets the "ByteOrders" element
         */
        java.lang.String getByteOrders();
        
        /**
         * Gets (as xml) the "ByteOrders" element
         */
        org.apache.xmlbeans.XmlString xgetByteOrders();
        
        /**
         * Sets the "ByteOrders" element
         */
        void setByteOrders(java.lang.String byteOrders);
        
        /**
         * Sets (as xml) the "ByteOrders" element
         */
        void xsetByteOrders(org.apache.xmlbeans.XmlString byteOrders);
        
        /**
         * Gets the "ReleaseDate" element
         */
        java.lang.String getReleaseDate();
        
        /**
         * Gets (as xml) the "ReleaseDate" element
         */
        org.apache.xmlbeans.XmlString xgetReleaseDate();
        
        /**
         * Sets the "ReleaseDate" element
         */
        void setReleaseDate(java.lang.String releaseDate);
        
        /**
         * Sets (as xml) the "ReleaseDate" element
         */
        void xsetReleaseDate(org.apache.xmlbeans.XmlString releaseDate);
        
        /**
         * Gets the "WithdrawnDate" element
         */
        java.lang.String getWithdrawnDate();
        
        /**
         * Gets (as xml) the "WithdrawnDate" element
         */
        org.apache.xmlbeans.XmlString xgetWithdrawnDate();
        
        /**
         * Sets the "WithdrawnDate" element
         */
        void setWithdrawnDate(java.lang.String withdrawnDate);
        
        /**
         * Sets (as xml) the "WithdrawnDate" element
         */
        void xsetWithdrawnDate(org.apache.xmlbeans.XmlString withdrawnDate);
        
        /**
         * Gets the "ProvenanceSourceID" element
         */
        short getProvenanceSourceID();
        
        /**
         * Gets (as xml) the "ProvenanceSourceID" element
         */
        uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID xgetProvenanceSourceID();
        
        /**
         * Sets the "ProvenanceSourceID" element
         */
        void setProvenanceSourceID(short provenanceSourceID);
        
        /**
         * Sets (as xml) the "ProvenanceSourceID" element
         */
        void xsetProvenanceSourceID(uk.gov.nationalarchives.pronom.ProvenanceSourceIDDocument.ProvenanceSourceID provenanceSourceID);
        
        /**
         * Gets the "ProvenanceName" element
         */
        java.lang.String getProvenanceName();
        
        /**
         * Gets (as xml) the "ProvenanceName" element
         */
        org.apache.xmlbeans.XmlString xgetProvenanceName();
        
        /**
         * Sets the "ProvenanceName" element
         */
        void setProvenanceName(java.lang.String provenanceName);
        
        /**
         * Sets (as xml) the "ProvenanceName" element
         */
        void xsetProvenanceName(org.apache.xmlbeans.XmlString provenanceName);
        
        /**
         * Gets the "ProvenanceSourceDate" element
         */
        java.lang.String getProvenanceSourceDate();
        
        /**
         * Gets (as xml) the "ProvenanceSourceDate" element
         */
        org.apache.xmlbeans.XmlString xgetProvenanceSourceDate();
        
        /**
         * Sets the "ProvenanceSourceDate" element
         */
        void setProvenanceSourceDate(java.lang.String provenanceSourceDate);
        
        /**
         * Sets (as xml) the "ProvenanceSourceDate" element
         */
        void xsetProvenanceSourceDate(org.apache.xmlbeans.XmlString provenanceSourceDate);
        
        /**
         * Gets the "ProvenanceDescription" element
         */
        java.lang.String getProvenanceDescription();
        
        /**
         * Gets (as xml) the "ProvenanceDescription" element
         */
        org.apache.xmlbeans.XmlString xgetProvenanceDescription();
        
        /**
         * Sets the "ProvenanceDescription" element
         */
        void setProvenanceDescription(java.lang.String provenanceDescription);
        
        /**
         * Sets (as xml) the "ProvenanceDescription" element
         */
        void xsetProvenanceDescription(org.apache.xmlbeans.XmlString provenanceDescription);
        
        /**
         * Gets the "LastUpdatedDate" element
         */
        java.lang.String getLastUpdatedDate();
        
        /**
         * Gets (as xml) the "LastUpdatedDate" element
         */
        org.apache.xmlbeans.XmlString xgetLastUpdatedDate();
        
        /**
         * Sets the "LastUpdatedDate" element
         */
        void setLastUpdatedDate(java.lang.String lastUpdatedDate);
        
        /**
         * Sets (as xml) the "LastUpdatedDate" element
         */
        void xsetLastUpdatedDate(org.apache.xmlbeans.XmlString lastUpdatedDate);
        
        /**
         * Gets the "FormatNote" element
         */
        java.lang.String getFormatNote();
        
        /**
         * Gets (as xml) the "FormatNote" element
         */
        org.apache.xmlbeans.XmlString xgetFormatNote();
        
        /**
         * Sets the "FormatNote" element
         */
        void setFormatNote(java.lang.String formatNote);
        
        /**
         * Sets (as xml) the "FormatNote" element
         */
        void xsetFormatNote(org.apache.xmlbeans.XmlString formatNote);
        
        /**
         * Gets the "FormatRisk" element
         */
        java.lang.String getFormatRisk();
        
        /**
         * Gets (as xml) the "FormatRisk" element
         */
        org.apache.xmlbeans.XmlString xgetFormatRisk();
        
        /**
         * Sets the "FormatRisk" element
         */
        void setFormatRisk(java.lang.String formatRisk);
        
        /**
         * Sets (as xml) the "FormatRisk" element
         */
        void xsetFormatRisk(org.apache.xmlbeans.XmlString formatRisk);
        
        /**
         * Gets the "TechnicalEnvironment" element
         */
        java.lang.String getTechnicalEnvironment();
        
        /**
         * Gets (as xml) the "TechnicalEnvironment" element
         */
        org.apache.xmlbeans.XmlString xgetTechnicalEnvironment();
        
        /**
         * Sets the "TechnicalEnvironment" element
         */
        void setTechnicalEnvironment(java.lang.String technicalEnvironment);
        
        /**
         * Sets (as xml) the "TechnicalEnvironment" element
         */
        void xsetTechnicalEnvironment(org.apache.xmlbeans.XmlString technicalEnvironment);
        
        /**
         * Gets array of all "FileFormatIdentifier" elements
         */
        uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier[] getFileFormatIdentifierArray();
        
        /**
         * Gets ith "FileFormatIdentifier" element
         */
        uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier getFileFormatIdentifierArray(int i);
        
        /**
         * Returns number of "FileFormatIdentifier" element
         */
        int sizeOfFileFormatIdentifierArray();
        
        /**
         * Sets array of all "FileFormatIdentifier" element
         */
        void setFileFormatIdentifierArray(uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier[] fileFormatIdentifierArray);
        
        /**
         * Sets ith "FileFormatIdentifier" element
         */
        void setFileFormatIdentifierArray(int i, uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier fileFormatIdentifier);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "FileFormatIdentifier" element
         */
        uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier insertNewFileFormatIdentifier(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "FileFormatIdentifier" element
         */
        uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier addNewFileFormatIdentifier();
        
        /**
         * Removes the ith "FileFormatIdentifier" element
         */
        void removeFileFormatIdentifier(int i);
        
        /**
         * Gets array of all "RelatedFormat" elements
         */
        uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat[] getRelatedFormatArray();
        
        /**
         * Gets ith "RelatedFormat" element
         */
        uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat getRelatedFormatArray(int i);
        
        /**
         * Returns number of "RelatedFormat" element
         */
        int sizeOfRelatedFormatArray();
        
        /**
         * Sets array of all "RelatedFormat" element
         */
        void setRelatedFormatArray(uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat[] relatedFormatArray);
        
        /**
         * Sets ith "RelatedFormat" element
         */
        void setRelatedFormatArray(int i, uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat relatedFormat);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "RelatedFormat" element
         */
        uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat insertNewRelatedFormat(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "RelatedFormat" element
         */
        uk.gov.nationalarchives.pronom.RelatedFormatDocument.RelatedFormat addNewRelatedFormat();
        
        /**
         * Removes the ith "RelatedFormat" element
         */
        void removeRelatedFormat(int i);
        
        /**
         * Gets array of all "Support" elements
         */
        uk.gov.nationalarchives.pronom.SupportDocument.Support[] getSupportArray();
        
        /**
         * Gets ith "Support" element
         */
        uk.gov.nationalarchives.pronom.SupportDocument.Support getSupportArray(int i);
        
        /**
         * Returns number of "Support" element
         */
        int sizeOfSupportArray();
        
        /**
         * Sets array of all "Support" element
         */
        void setSupportArray(uk.gov.nationalarchives.pronom.SupportDocument.Support[] supportArray);
        
        /**
         * Sets ith "Support" element
         */
        void setSupportArray(int i, uk.gov.nationalarchives.pronom.SupportDocument.Support support);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Support" element
         */
        uk.gov.nationalarchives.pronom.SupportDocument.Support insertNewSupport(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Support" element
         */
        uk.gov.nationalarchives.pronom.SupportDocument.Support addNewSupport();
        
        /**
         * Removes the ith "Support" element
         */
        void removeSupport(int i);
        
        /**
         * Gets array of all "ExternalSignature" elements
         */
        uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature[] getExternalSignatureArray();
        
        /**
         * Gets ith "ExternalSignature" element
         */
        uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature getExternalSignatureArray(int i);
        
        /**
         * Returns number of "ExternalSignature" element
         */
        int sizeOfExternalSignatureArray();
        
        /**
         * Sets array of all "ExternalSignature" element
         */
        void setExternalSignatureArray(uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature[] externalSignatureArray);
        
        /**
         * Sets ith "ExternalSignature" element
         */
        void setExternalSignatureArray(int i, uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature externalSignature);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ExternalSignature" element
         */
        uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature insertNewExternalSignature(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ExternalSignature" element
         */
        uk.gov.nationalarchives.pronom.ExternalSignatureDocument.ExternalSignature addNewExternalSignature();
        
        /**
         * Removes the ith "ExternalSignature" element
         */
        void removeExternalSignature(int i);
        
        /**
         * Gets array of all "InternalSignature" elements
         */
        uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature[] getInternalSignatureArray();
        
        /**
         * Gets ith "InternalSignature" element
         */
        uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature getInternalSignatureArray(int i);
        
        /**
         * Returns number of "InternalSignature" element
         */
        int sizeOfInternalSignatureArray();
        
        /**
         * Sets array of all "InternalSignature" element
         */
        void setInternalSignatureArray(uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature[] internalSignatureArray);
        
        /**
         * Sets ith "InternalSignature" element
         */
        void setInternalSignatureArray(int i, uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature internalSignature);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "InternalSignature" element
         */
        uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature insertNewInternalSignature(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "InternalSignature" element
         */
        uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature addNewInternalSignature();
        
        /**
         * Removes the ith "InternalSignature" element
         */
        void removeInternalSignature(int i);
        
        /**
         * Gets the "CharacterEncoding" element
         */
        uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding getCharacterEncoding();
        
        /**
         * True if has "CharacterEncoding" element
         */
        boolean isSetCharacterEncoding();
        
        /**
         * Sets the "CharacterEncoding" element
         */
        void setCharacterEncoding(uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding characterEncoding);
        
        /**
         * Appends and returns a new empty "CharacterEncoding" element
         */
        uk.gov.nationalarchives.pronom.CharacterEncodingDocument.CharacterEncoding addNewCharacterEncoding();
        
        /**
         * Unsets the "CharacterEncoding" element
         */
        void unsetCharacterEncoding();
        
        /**
         * Gets the "FormatProperties" element
         */
        uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties getFormatProperties();
        
        /**
         * True if has "FormatProperties" element
         */
        boolean isSetFormatProperties();
        
        /**
         * Sets the "FormatProperties" element
         */
        void setFormatProperties(uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties formatProperties);
        
        /**
         * Appends and returns a new empty "FormatProperties" element
         */
        uk.gov.nationalarchives.pronom.FormatPropertiesDocument.FormatProperties addNewFormatProperties();
        
        /**
         * Unsets the "FormatProperties" element
         */
        void unsetFormatProperties();
        
        /**
         * Gets array of all "CompressionType" elements
         */
        uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType[] getCompressionTypeArray();
        
        /**
         * Gets ith "CompressionType" element
         */
        uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType getCompressionTypeArray(int i);
        
        /**
         * Returns number of "CompressionType" element
         */
        int sizeOfCompressionTypeArray();
        
        /**
         * Sets array of all "CompressionType" element
         */
        void setCompressionTypeArray(uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType[] compressionTypeArray);
        
        /**
         * Sets ith "CompressionType" element
         */
        void setCompressionTypeArray(int i, uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType compressionType);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "CompressionType" element
         */
        uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType insertNewCompressionType(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "CompressionType" element
         */
        uk.gov.nationalarchives.pronom.CompressionTypeDocument.CompressionType addNewCompressionType();
        
        /**
         * Removes the ith "CompressionType" element
         */
        void removeCompressionType(int i);
        
        /**
         * Gets array of all "ReferenceFile" elements
         */
        uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile[] getReferenceFileArray();
        
        /**
         * Gets ith "ReferenceFile" element
         */
        uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile getReferenceFileArray(int i);
        
        /**
         * Returns number of "ReferenceFile" element
         */
        int sizeOfReferenceFileArray();
        
        /**
         * Sets array of all "ReferenceFile" element
         */
        void setReferenceFileArray(uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile[] referenceFileArray);
        
        /**
         * Sets ith "ReferenceFile" element
         */
        void setReferenceFileArray(int i, uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile referenceFile);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ReferenceFile" element
         */
        uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile insertNewReferenceFile(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ReferenceFile" element
         */
        uk.gov.nationalarchives.pronom.ReferenceFileDocument.ReferenceFile addNewReferenceFile();
        
        /**
         * Removes the ith "ReferenceFile" element
         */
        void removeReferenceFile(int i);
        
        /**
         * Gets array of all "Document" elements
         */
        uk.gov.nationalarchives.pronom.DocumentDocument.Document[] getDocumentArray();
        
        /**
         * Gets ith "Document" element
         */
        uk.gov.nationalarchives.pronom.DocumentDocument.Document getDocumentArray(int i);
        
        /**
         * Returns number of "Document" element
         */
        int sizeOfDocumentArray();
        
        /**
         * Sets array of all "Document" element
         */
        void setDocumentArray(uk.gov.nationalarchives.pronom.DocumentDocument.Document[] documentArray);
        
        /**
         * Sets ith "Document" element
         */
        void setDocumentArray(int i, uk.gov.nationalarchives.pronom.DocumentDocument.Document document);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Document" element
         */
        uk.gov.nationalarchives.pronom.DocumentDocument.Document insertNewDocument(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Document" element
         */
        uk.gov.nationalarchives.pronom.DocumentDocument.Document addNewDocument();
        
        /**
         * Removes the ith "Document" element
         */
        void removeDocument(int i);
        
        /**
         * Gets array of all "Developers" elements
         */
        uk.gov.nationalarchives.pronom.DevelopersDocument.Developers[] getDevelopersArray();
        
        /**
         * Gets ith "Developers" element
         */
        uk.gov.nationalarchives.pronom.DevelopersDocument.Developers getDevelopersArray(int i);
        
        /**
         * Returns number of "Developers" element
         */
        int sizeOfDevelopersArray();
        
        /**
         * Sets array of all "Developers" element
         */
        void setDevelopersArray(uk.gov.nationalarchives.pronom.DevelopersDocument.Developers[] developersArray);
        
        /**
         * Sets ith "Developers" element
         */
        void setDevelopersArray(int i, uk.gov.nationalarchives.pronom.DevelopersDocument.Developers developers);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Developers" element
         */
        uk.gov.nationalarchives.pronom.DevelopersDocument.Developers insertNewDevelopers(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Developers" element
         */
        uk.gov.nationalarchives.pronom.DevelopersDocument.Developers addNewDevelopers();
        
        /**
         * Removes the ith "Developers" element
         */
        void removeDevelopers(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat newInstance() {
              return (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static uk.gov.nationalarchives.pronom.FileFormatDocument newInstance() {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static uk.gov.nationalarchives.pronom.FileFormatDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (uk.gov.nationalarchives.pronom.FileFormatDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
