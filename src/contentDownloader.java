/**
 * Downloads the content from a given URL.
 * @author Andrew Knapp
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class contentDownloader {
	
	public contentDownloader(){
		
	}
	/*
	 * @param link
	 * Saves the content of a link to a file on a system. 
	 */
	public void downloadContent(String imageURL, String fileName){
		try{
			InputStream siteImageStream = new URL(imageURL).openStream();
			OutputStream fileOutputStream = new FileOutputStream(fileName);
			byte[] b = new byte[2048];
			int byteLength;
			
			while ((byteLength = siteImageStream.read(b)) != -1){
				fileOutputStream.write(b, 0, byteLength);
			}
			
			System.out.println("Downloaded content at " + imageURL);
			siteImageStream.close();
			fileOutputStream.close();
			
		} catch (IOException e) {
			System.out.println(imageURL + " is not a valid URL");
			e.printStackTrace();
		}
	}
}
