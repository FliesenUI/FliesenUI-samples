package com.bright_side_it.fluidemo.contactmanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import generated.fliesenui.core.FLUIScreenManager;
import generated.fliesenui.core.FLUIWebCall;

public class ContactManagerWebServer extends AbstractHandler{
	private FLUIScreenManager screenManager = new ContactManagerBase(false).createScreenManager();
	
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
			screenManager.handleWebCall(webCall, request.getMethod(), request.getPathInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new ContactManagerWebServer());
		server.start();
		server.join();
	}
	
}
