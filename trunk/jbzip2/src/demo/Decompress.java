package demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.itadaki.bzip2.BZip2InputStream;

/**
 * 
 */
public class Decompress {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main (String[] args) throws IOException {

		InputStream fileInputStream = new BufferedInputStream (new FileInputStream (args[0]));
		BZip2InputStream inputStream = new BZip2InputStream (fileInputStream, false);

		byte[] decoded = new byte [524288];
		int bytesRead;
		while ((bytesRead = inputStream.read (decoded)) != -1) System.out.write (decoded, 0, bytesRead) ;
		System.out.flush();

	}

}
