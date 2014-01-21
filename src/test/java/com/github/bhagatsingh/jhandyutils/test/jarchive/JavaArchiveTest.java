package com.github.bhagatsingh.jhandyutils.test.jarchive;


import org.junit.Test;

import com.github.bhagatsingh.jhandyutils.jarchive.JavaArchiveUtils;

import java.io.File;

/**
 *  - Archive File Test Case - 
 * extract a .tar.gz or zip file
 * @author Bhagat Singh
 */
public class JavaArchiveTest{
	
	@Test
    public void testExtractTarFile() {
        File archivedFile = new File("C:\\tmp\\javaarchive\\tar\\test.tar.gz");
        if(!archivedFile.exists()){
        	throw new RuntimeException("gz file doesn't exist.");
        }
        File destFolder = new File("C:\\tmp\\javaarchive\\tar\\dest");
        JavaArchiveUtils.extractTarFile(archivedFile, destFolder);
	}
	
	@Test
    public void testExtractZipFile() {
        File archivedFile = new File("C:\\tmp\\javaarchive\\zip\\test.zip");
        File destFolder = new File("C:\\tmp\\javaarchive\\zip\\dest");
        JavaArchiveUtils.extractZipFile(archivedFile, destFolder);
	}
	
}
