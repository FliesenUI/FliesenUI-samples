package com.bright_side_it.fluidemoandroid.contactmanager.dao;

import generated.fliesenui.core.FLUIImageStream;

public class ImageStreamDAO {
	public FLUIImageStream getCustomImageStream(String imageStreamID){
		log("ImageStreamDAO: imageStreamID = '" + imageStreamID + "' not finished yet");
//
//		FliesenUIImageStream imageStream = new FliesenUIImageStream();
//
//		String type = "png";
//
//		String imgPath;
//		if (imageStreamID.equals("blue")){
//			imgPath = "earth.png";
//		} else if (imageStreamID.equals("colors")){
//			imgPath = "earth2.png";
//		} else if (imageStreamID.equals("grey")){
//			imgPath = "earth3.png";
//		} else if (imageStreamID.equals("menu")){
//			imgPath = "menu.svg";
//			type = "svg+xml";
////			type = "svg";
//		} else if (imageStreamID.equals("smile001")){
//			imgPath = "smile001.svg";
//			type = "svg+xml";
//		} else {
//			imgPath = "earth3.png";
//		}
//
//		log("getCustomImageStream: imageStreamID = '" + imageStreamID + "', imgPath = '" + imgPath + "', type = '" + type + "'");
//
//		File file = new File(imgPath);
//		ByteArrayInputStream bytes = null;
//		try {
//			bytes = new ByteArrayInputStream(Files.readAllBytes(file.toPath()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
////		imageStream.setContentType("png");
//		imageStream.setContentType(type);
//		imageStream.setInputStream(bytes);
//		imageStream.setLength(file.length());
//
//		return imageStream;

		return null;
	}
	
	private void log(String message) {
		System.out.println("ImageStreamDAO> " + message);
	}

}
