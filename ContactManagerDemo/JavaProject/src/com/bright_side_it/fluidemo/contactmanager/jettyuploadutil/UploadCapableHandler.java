package com.bright_side_it.fluidemo.contactmanager.jettyuploadutil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.MultiPartInputStreamParser;

import generated.fliesenui.core.FLUIScreenManager;

public class UploadCapableHandler extends HandlerWrapper {
	public static final String MULTIPART_FORMDATA_TYPE = "multipart/form-data";
	private UploadCapableHandlerListener basicHandler;
	
	public UploadCapableHandler(UploadCapableHandlerListener basicHandler) {
		super();
		this.basicHandler = basicHandler;
	}

	private static final MultipartConfigElement MULTI_PART_CONFIG = new MultipartConfigElement(System.getProperty("java.io.tmpdir"));

	public static boolean isMultipartRequest(ServletRequest request) {
		return request.getContentType() != null && request.getContentType().startsWith(MULTIPART_FORMDATA_TYPE);
	}

	public static void enableMultipartSupport(HttpServletRequest request) {
		request.setAttribute(Request.__MULTIPART_CONFIG_ELEMENT, MULTI_PART_CONFIG);
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		boolean multipartRequest = HttpMethod.POST.is(request.getMethod()) && isMultipartRequest(request);
		if (multipartRequest) {
			enableMultipartSupport(request);
		}
		boolean fileUpload = multipartRequest;
		try {
			InputStream fileContent = null;
			String fileName = null;
			String requestJSON = null;
			if (fileUpload){
				requestJSON = request.getParameter(FLUIScreenManager.FILE_UPLOAD_FORM_REQUEST_PARAMETER_NAME);
				Part filePart = request.getPart(FLUIScreenManager.FILE_UPLOAD_FORM_FILE_PARAMETER_NAME);
				fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); //needed for MSIE
				fileContent = filePart.getInputStream();
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
		} finally {
			if (multipartRequest) {
				MultiPartInputStreamParser multipartInputStream = (MultiPartInputStreamParser) request.getAttribute(Request.__MULTIPART_INPUT_STREAM);
				if (multipartInputStream != null) {
					try {
						multipartInputStream.deleteParts();
					} catch (MultiException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void log(String message) {
		System.out.println("MultipartConfigInjectionHandler> " + message);
	}
}