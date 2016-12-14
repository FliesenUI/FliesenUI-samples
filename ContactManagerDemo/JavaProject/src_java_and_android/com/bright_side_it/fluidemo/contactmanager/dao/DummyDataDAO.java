package com.bright_side_it.fluidemo.contactmanager.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bright_side_it.fluidemo.contactmanager.ContactManagerConstants;

import generated.fliesenui.core.FLUIFileStream;
import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
import generated.fliesenui.core.FLUIImageStream;
import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.dto.ContactDTOBuilder;
import generated.fliesenui.dto.ContactListDTO;
import generated.fliesenui.dto.ContactListDTOBuilder;
import generated.fliesenui.dto.ContactTypeDTO;
import generated.fliesenui.dto.ContactTypeDTOBuilder;
import generated.fliesenui.dto.ContactTypeListDTO;
import generated.fliesenui.dto.ContactTypeListDTOBuilder;

public class DummyDataDAO {
	private static Map<String, ContactTypeDTO> types = createDummyTypes();
	private static Map<String, ContactDTO> contacts = createDummyContacts();
	private static Map<String, byte[]> customProfileImages = new TreeMap<>();
	private static int lastID;
	private static final String DEFAULT_PROFILE_IMAGE = "default.png";
	private static ProjectImageReader projectImageReader = createDefaultProjectImageReader();

	public static void setProjectImageReader(ProjectImageReader projectImageReader){
		DummyDataDAO.projectImageReader = projectImageReader;
	}
	
	public ContactListDTO readContacts(String filter){
		List<ContactDTO> matches = new ArrayList<>();
		for (ContactDTO i: contacts.values()){
			if ((filter == null) || (filter.trim().isEmpty()) || (i.getFirstname().toUpperCase().contains(filter.toUpperCase())) || (i.getLastname().toUpperCase().contains(filter.toUpperCase()))){
				matches.add(i);
			}
		}
		return ContactListDTOBuilder.construct(matches);
	}

	private static Map<String, ContactTypeDTO> createDummyTypes() {
		Map<String, ContactTypeDTO> result = new TreeMap<>();
		result.put("fam", ContactTypeDTOBuilder.construct("fam", "Family", ImageAsset.FAMILY.getID()));
		result.put("fri", ContactTypeDTOBuilder.construct("fri", "Friend", ImageAsset.FRIEND.getID()));
		result.put("com", ContactTypeDTOBuilder.construct("com", "Company", ImageAsset.COMPANY.getID()));
		result.put("col", ContactTypeDTOBuilder.construct("col", "Colleague", ImageAsset.COLLEAGUE.getID()));
		return result;
	}

	private static Map<String, ContactDTO> createDummyContacts() {
		Map<String, ContactDTO> result = new TreeMap<>();
		
		List<ContactDTO> contactList = new ArrayList<>();
		contactList.add(ContactDTOBuilder.construct("" + (lastID ++), "fam", "star.png", null, "Mary", "Smith", "+1 123 0000", "+1 456 1234", "My Street", "USA", "Mystate", "Mycity", "1234", ""));
		contactList.add(ContactDTOBuilder.construct("" + (lastID ++), "fam", "triangle.png", null, "Tom", "Smith", "+1 123 0000", "+1 456 1222", "My Street", "USA", "Mystate", "Mycity", "1234", ""));
		contactList.add(ContactDTOBuilder.construct("" + (lastID ++), "fri", DEFAULT_PROFILE_IMAGE, null, "Ronald", "Lee", "+1 453 2346", "+1 456 1666", "Long Street", "USA", "Mystate", "Mycity", "1234", ""));
		contactList.add(ContactDTOBuilder.construct("" + (lastID ++), "com", "painted-globe.jpg", null, "", "Wiki Corp", "+1 300 34342", "+1 342 3554", "New Street", "Web-Land", "Web-State", "Webcity", "1234", "http://www.wikipedia.org"));
		contactList.add(ContactDTOBuilder.construct("" + (lastID ++), "col", DEFAULT_PROFILE_IMAGE, null, "John", "Miller", "+1 300 1111", "+1 456 444", "Some Street", "USA", "Mystate", "Mycity", "1234", ""));
		contactList.add(ContactDTOBuilder.construct("" + (lastID ++), "col", DEFAULT_PROFILE_IMAGE, null, "Robert", "Meyer", "+1 300 2222", "+1 456 555", "New Street", "USA", "Mystate", "Mycity", "3456", ""));
		contactList.add(ContactDTOBuilder.construct("" + (lastID ++), "fam", DEFAULT_PROFILE_IMAGE, null, "Bob", "Smith", "+1 123 0000", "+1 456 1333", "My Street", "USA", "Mystate", "Mycity", "1234", ""));
		
		for (ContactDTO i: contactList){
			updateTypeImage(i);
			result.put(i.getId(), i);
		}
		
		return result;
	}
	
	private static void updateTypeImage(ContactDTO contact){
		ContactTypeDTO type = types.get(contact.getTypeID());
		if (type != null){
			contact.setTypeImageAsset(type.getImageAssetID());
		}
	}
	
	public static ContactTypeListDTO getTypes(){
		return ContactTypeListDTOBuilder.construct(new ArrayList<>(types.values()));
	}

	public static ContactTypeDTO getType(String id){
		return types.get(id);
	}
	
	public void saveContact(ContactDTO contact) {
		if ((contact.getId() == null) || (contact.getId().isEmpty())){
			contact.setId("" + (lastID++));
			contact.setProfileImage("");
		}
		updateTypeImage(contact);
		contacts.put(contact.getId(), contact);
	}

	public ContactDTO getContact(String contactID) {
		return contacts.get(contactID);
	}

	public void deleteContact(String contactID) {
		contacts.remove(contactID);
	}
	
	private long getSize(InputStream inputStream) throws IOException{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int amountRead;
		byte[] data = new byte[10000];
		while ((amountRead = inputStream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, amountRead);
		}
		inputStream.close();
		return buffer.size();
	}
	
	public FLUIImageStream getImageStream(String imageStreamID){
		FLUIImageStream imageStream = new FLUIImageStream();
		log("getImageStream '" + imageStreamID + "'");
		try{
			if (customProfileImages.containsKey(imageStreamID)){
				log("getImageStream: found in custom profile images");
				imageStream.setContentType("png");
				byte[] imageData = customProfileImages.get(imageStreamID);
				imageStream.setInputStream(new ByteArrayInputStream(imageData));
				imageStream.setLength(imageData.length);
			} else {
				InputStream inputStream;
				inputStream = projectImageReader.getImageInputStream(imageStreamID);
				long size = getSize(inputStream);
				inputStream = projectImageReader.getImageInputStream(imageStreamID);

				imageStream.setContentType("png");
				imageStream.setInputStream(inputStream);
				imageStream.setLength(size);
			}
			return imageStream;
		} catch (Exception e){
			new Exception("Could not read image '" + imageStreamID + "'").printStackTrace();
			return null;
		}
	}
	
	private static ProjectImageReader createDefaultProjectImageReader() {
		return new ProjectImageReader() {
			@Override
			public InputStream getImageInputStream(String imageStreamID) throws Exception {
				String location = "/com/bright_side_it/fluidemo/contactmanager/img/" + imageStreamID;
				return this.getClass().getResourceAsStream(location);
			}
		};
	}


	

	public void updateContactProfileImage(ContactDTO contact, byte[] byteArray) {
		log("updateContactProfileImage");
		String customProfileImageID = "customProfileImage_" + (customProfileImages.size() + 1);
		customProfileImages.put(customProfileImageID, byteArray);
		contact.setProfileImage(customProfileImageID);
		log("updateContactProfileImage: set profile image id to '" + customProfileImageID + "'");
		saveContact(contact);
	}

	private static void log(String message) {
		System.out.println("DummyDataDAO> " + message);
	}

	public FLUIFileStream getFileStream(String fileStreamID) {
		FLUIFileStream result = new FLUIFileStream(); 
		if (ContactManagerConstants.CONTACT_EXPORT_FILE_STREAM_ID.equals(fileStreamID)){
			try {
				byte[] data;
				result.setFilename("ContactData.txt");
				data = createExportData();
				result.setLength(new Long(data.length));
				result.setInputStream(new ByteArrayInputStream(data));
			} catch (Exception e) {
				result.setErrorMessage("Error while creating export data: " + e);
			}
		} else {
			result.setErrorMessage("Unkonwn file stream ID: " + fileStreamID);
		}
		return result;
	}

	private byte[] createExportData() throws Exception {
		StringBuilder sb = new StringBuilder("#Contacts export " + new Date() + "\n");
		for (ContactDTO i: contacts.values()){
			sb.append(i.getFirstname() + ";" + i.getLastname() + ";" + i.getMobile() + "\n");
		}
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		result.write(sb.toString().getBytes("UTF-8"));
		return result.toByteArray();
	}

}
