package com.bright_side_it.fluidemo.contactmanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

import com.bright_side_it.fluidemo.contactmanager.jettyuploadutil.UploadCapableHandler;
import com.bright_side_it.fluidemo.contactmanager.jettyuploadutil.UploadCapableHandlerListener;

import generated.fliesenui.core.FLUIScreenManager;
import generated.fliesenui.core.FLUIWebCall;

public class ContactManagerWebServerUploadCapable implements UploadCapableHandlerListener{
	private FLUIScreenManager screenManager = new ContactManagerBase(true).createScreenManager();
	
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response, String uploadedFilename, InputStream uploadedFileInputStream,
			String uploadedFileRequestJSON) throws IOException, ServletException {
		baseRequest.setHandled(true);
		response.setStatus(HttpServletResponse.SC_OK);
		FLUIWebCall webCall = new FLUIWebCall() {
			@Override
			public void log(String message) {
				System.out.println("webCall> " + message);
			}
			@Override
			public void setReponseContentLength(long length) {
				response.setContentLengthLong(length);
			}
			@Override
			public void setResponseContentType(String contentType) {
				response.setContentType(contentType);
			}
			@Override
			public OutputStream getResponseOutputStream() throws Exception{
				return response.getOutputStream();
			}
			@Override
			public InputStream getRequestInputStream() throws Exception {
				return request.getInputStream();
			}
			@Override
			public long getRequestContentLength() {
				return request.getContentLengthLong();
			}
			@Override
			public void setReponseHeader(String name, String value) {
				response.setHeader(name, value);
			}
		};
		try {
			if (uploadedFileInputStream == null){
				screenManager.handleWebCall(webCall, request.getMethod(), request.getPathInfo());
			} else {
				screenManager.handleWebUpload(webCall, uploadedFileRequestJSON, uploadedFilename, uploadedFileInputStream);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new UploadCapableHandler(new ContactManagerWebServerUploadCapable()));
		server.start();
		System.out.println("Running. Go to http://localhost:8080/ in your browser.");
		server.join();
	}

	
}
