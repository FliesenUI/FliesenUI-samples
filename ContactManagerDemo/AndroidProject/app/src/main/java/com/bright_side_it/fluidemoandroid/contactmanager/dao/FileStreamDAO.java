package com.bright_side_it.fluidemoandroid.contactmanager.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import generated.fliesenui.core.FLUIFileStream;

public class FileStreamDAO {
	public FLUIFileStream getFileStream(String fileStreamID){
		log("FileStreamDAO: getFileStream = '" + fileStreamID + "'");
		
		FLUIFileStream fileStream = new FLUIFileStream();
		String filePath = null;
		if (fileStreamID.equals("excel1")){
			filePath = "excel1.xlsx";
		} else if (fileStreamID.equals("text")){
			filePath = "text.txt";
		}
		
		if (filePath == null){
			fileStream.setErrorMessage("Unknown file stream id: " + fileStreamID);
			return fileStream;
		}
		File file = new File(filePath);
		fileStream.setFilename(file.getName());
		fileStream.setLength(file.length());
		try {
			fileStream.setInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fileStream.setErrorMessage("Error: " + e);
		}
		return fileStream;
	}
	
	private void log(String message) {
		System.out.println("ImageStreamDAO> " + message);
	}

}
