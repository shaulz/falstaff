package com.falstaff.core.ontology;

import java.util.HashMap;
import java.util.Map;

public enum FileFormatOntologySecondGroup {
	threeD_and_CAD_CAM_models("3D and CAD/CAM Models"),
	address_books_and_contacts("Address books and contacts"),
	archiving("Archiving"),
	audio_and_music("Audio and Music"),
	bibliographic_data("Bibliographic data"),
	binary_data("Binary Data"),
	calendars("Calendars"),
	cameras_and_digital_image_sensors("Cameras and Digital Image Sensors"),
	character_encodings("Character Encodings"),
	compression("Compression"),
	coupons_and_tickets("Coupons and Tickets"),
	culinary_arts("Culinary arts"),
	currency("Currency"),
	databases("Databases"),
	development("Development"),
	disk_image_formats("Disk Image Formats"),
	diskmagazines("Diskmagazines"),
	distributed_computing_projects("Distributed computing projects"),
	document("Document"),
	education("Education"),
	electronic_publishing_formats("Electronic Publishing formats"),
	e_mail_newsgroups_and_forums("E-Mail, newsgroups, and forums"),
	encryption("Encryption"),
	error_detection_and_correction("Error detection and correction"),
	executables("Executables"),
	filesystem("Filesystem"),
	file_transfer("File transfer"),
	finance_and_accounting("Finance and Accounting"),
	firmware("Firmware"),
	fonts("Fonts"),
	forensics_and_law_enforcement("Forensics and Law Enforcement"),
	game_data_files("Game data files"),
	genealogical_data("Genealogical data"),
	geospatial("Geospatial"),
	graphics("Graphics"),
	health_and_medicine("Health and Medicine"),
	help_files("Help files"),
	hypermedia("HyperMedia"),
	interactive_fiction("Interactive Fiction"),
	law("Law"),
	machine_embroidery("Machine Embroidery"),
	markup("Markup"),
	metadata("Metadata"),
	metaformats("Metaformats"),
	mind_maps_topic_maps_etc("Mind maps, Topic maps etc"),
	page_description_languages("Page description languages"),
	personal_digital_assistant_formats("Personal Digital Assistant formats"),
	project_management("Project management"),
	puzzles("Puzzles"),
	radio("Radio"),
	retail_sales("Retail sales"),
	rom_and_memory_images("ROM and memory images"),
	saved_games("Saved Games"),
	scientific_data_formats("Scientific Data formats"),
	scientific_data_formats_and_mathematics_related_formats("Scientific Data formats and mathematics related formats"),
	security("Security"),
	serialization("Serialization"),
	source_code("Source code"),
	system_files("System files"),
	telephony("Telephony"),
	temporary_files("Temporary files"),
	text_based_data("Text-based data"),
	transfer_encodings("Transfer Encodings"),
	transportation("Transportation"),
	video("Video"),
	web("Web"),
	programming_languages("Programming Languages"),
	undefined("Undefined");
   
   private String name;
   
   private FileFormatOntologySecondGroup(String name) {
	   this.name = name;
   }
   
   private static final Map<String, FileFormatOntologySecondGroup> map;
   static {
       map = new HashMap<String, FileFormatOntologySecondGroup>();
       for (FileFormatOntologySecondGroup v : FileFormatOntologySecondGroup.values()) {
           map.put(v.name, v);
       }
       map.put("Scientific Data formats", scientific_data_formats_and_mathematics_related_formats);
       map.put("Database", databases);
       map.put("Audio",audio_and_music);
   }
   
   public static FileFormatOntologySecondGroup findByName(String name) {
       return map.get(name);
   }

   public String getName() {
	   return name;
   }
   
   
}
