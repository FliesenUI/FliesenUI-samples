package com.bright_side_it.fluidemo.contactmanager.jettyuploadutil;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

public interface UploadCapableHandlerListener{
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response, String uploadedFilename, InputStream uploadedFileInputStream, String uploadedFileRequestJSON) throws IOException, ServletException;
}
