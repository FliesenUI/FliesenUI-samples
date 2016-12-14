package com.bright_side_it.fluidemoandroid.contactmanager.jettyuploadutil;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerWrapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import generated.fliesenui.core.FLUIScreenManagerAndroid;
import generated.fliesenui.core.HTTPMultipartRequestReader;

public class UploadCapableHandlerAndroid extends HandlerWrapper {
	public static final String MULTIPART_FORMDATA_TYPE = "multipart/form-data";
	private static final int MAXIMUM_UPLOAD_DATA_SIZE = 10 * 1024 * 1024;
	private UploadCapableHandlerListener basicHandler;
	
	public UploadCapableHandlerAndroid(UploadCapableHandlerListener basicHandler) {
		super();
		this.basicHandler = basicHandler;
	}

	public static boolean isMultipartRequest(ServletRequest request) {
		return request.getContentType() != null && request.getContentType().startsWith(MULTIPART_FORMDATA_TYPE);
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		boolean multipartRequest = "POST".equalsIgnoreCase(request.getMethod()) && isMultipartRequest(request);
		boolean fileUpload = multipartRequest;
		try {
			InputStream fileContent = null;
			String fileName = null;
			String requestJSON = null;
			if (fileUpload){
				HTTPMultipartRequestReader multipartRequestReader = new HTTPMultipartRequestReader();
				Map<String, HTTPMultipartRequestReader.RequestPart> parts = multipartRequestReader.getRequestParts(request.getInputStream(), MAXIMUM_UPLOAD_DATA_SIZE);

				HTTPMultipartRequestReader.RequestPart formRequestPart = parts.get(FLUIScreenManagerAndroid.FILE_UPLOAD_FORM_REQUEST_PARAMETER_NAME);
				requestJSON = new String(formRequestPart.getBytes(), "UTF-8");

				HTTPMultipartRequestReader.RequestPart fileRequestPart = parts.get(FLUIScreenManagerAndroid.FILE_UPLOAD_FORM_FILE_PARAMETER_NAME);
				fileName = fileRequestPart.getFilename();
				fileContent = new ByteArrayInputStream(fileRequestPart.getBytes());
			}
			try{
				basicHandler.handle(target, baseRequest, request, response, fileName, fileContent, requestJSON);
			} catch (Exception e) {
				throw e;
			} finally {
				if (fileContent != null){
					fileContent.close();
				}
			}
		} catch (HTTPMultipartRequestReader.MaximumLengthExceededException e) {
			new Exception("Too much input data", e).printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}