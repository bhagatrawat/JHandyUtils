package com.github.bhagatsingh.jhandyutils.test.jarchive;

import java.util.zip.GZIPInputStream;
import org.junit.Test;

import com.github.bhagatsingh.jhandyutils.jarchive.JavaArchiveConstants;
import com.github.bhagatsingh.jhandyutils.jarchive.JavaArchiveEntry;
import com.github.bhagatsingh.jhandyutils.jarchive.JavaArchiveInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 
 * JTar Util Test Case
 *
 */
public class JavaArchiveTest{
	@Test
    public void test() {
        BufferedOutputStream destStream = null;
        JavaArchiveEntry jArchiveEntry = null;
        JavaArchiveInputStream jTarInputStream = null;
        try{
        	// get GZ file
            File archiveFile = new File("C:\\tmp\\javaarchive\\popcorn.gz");
            
            if(!archiveFile.exists()){
            	throw new RuntimeException("gz/tar file doesn't exist.");
            }
            
            File destFolder = new File("C:\\tmp\\javaarchive\\dest");
            
            jTarInputStream = new JavaArchiveInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(archiveFile))));
            
            while ((jArchiveEntry = jTarInputStream.getNextEntry()) != null) {
              System.out.println("Extracting: " + jArchiveEntry.getName());
              int count = 0;
              byte[] data = new byte[JavaArchiveConstants.BUFFER];
              if (jArchiveEntry.isDirectory()) {
                  new File(destFolder + "/" + jArchiveEntry.getName()).mkdirs();
                  continue;
              } else {
                  int di = jArchiveEntry.getName().lastIndexOf('/');
                  if (di != -1) {
                      new File(destFolder + "/"+ jArchiveEntry.getName().substring(0, di)).mkdirs();
                  }
              }
              FileOutputStream fos = null;
              try{
                fos = new FileOutputStream(destFolder + "/"+ jArchiveEntry.getName());
                destStream = new BufferedOutputStream(fos);

                while ((count = jTarInputStream.read(data)) != -1) {
                	destStream.write(data, 0, count);
                }
              }catch(Exception exp){
                  throw exp;
              }finally{
                if(destStream!=null){
                	destStream.flush();
                	destStream.close();
                }
                if(fos!=null){fos.close();}
               }
            }
        }catch(Exception exp){
          exp.printStackTrace();
        }finally{
            try{
	        	if(destStream!=null){destStream.close();}
	            if(jTarInputStream!=null){jTarInputStream.close();}
            }catch(Exception exp){
            	exp.printStackTrace();
            }
        }
	}
}
