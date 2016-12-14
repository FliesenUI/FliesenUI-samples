package com.bright_side_it.fluidemo.contactmanager.dao;

import java.io.InputStream;

/**
 * Created by me on 17.11.2016.
 */

public interface ProjectImageReader {
	InputStream getImageInputStream(String imageStreamID) throws Exception;
}
