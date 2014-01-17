package com.github.bhagatsingh.jhandyutils.test.jtar;

import java.util.zip.GZIPInputStream;
import java.util.Iterator;
import org.junit.Test;

public class JTarUtilTest{
	@Test
    public void test() {
		    int BUFFER = 2048
        BufferedOutputStream dest
        TarEntry entry
        TarInputStream tis
        try{
            file = toResource(file)
            toDir = toResource(toDir)
            //create dirs only when it does not exist
            if(!toDir.exists()){
                mkdirs(toDir)
            }
            //get destination folder location
            String destFolder = toDir.getFile().getPath();
            // get GZ file
            File gzFile = new File("c:/jtartest/test.gz");

            tis = new TarInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(gzFile))))
            while ((entry = tis.getNextEntry()) != null) {
              log.info("Extracting: " + entry.getName())
              int count
              byte[] data = new byte[BUFFER]
              if (entry.isDirectory()) {
                  new File(destFolder + "/" + entry.getName()).mkdirs()
                  continue;
              } else {
                  int di = entry.getName().lastIndexOf('/')
                  if (di != -1) {
                      new File(destFolder + "/"+ entry.getName().substring(0, di)).mkdirs()
                  }
              }
              FileOutputStream fos = null
              try{
                fos = new FileOutputStream(destFolder + "/"+ entry.getName())
                dest = new BufferedOutputStream(fos)

                while ((count = tis.read(data)) != -1) {
                    dest.write(data, 0, count)
                }
              }catch(Exception exp){
                  throw exp;
              }finally{
                if(dest!=null){
                    dest.flush()
                    dest.close()
                }
                if(fos!=null){fos.close()}
               }
            }
        }catch(Exception exp){
            throw exp;
        }finally{
            if(dest!=null){dest.close()}
            if(tis!=null){tis.close()}
        }
	}
}
