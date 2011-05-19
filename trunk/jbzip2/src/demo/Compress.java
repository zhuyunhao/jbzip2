package demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.itadaki.bzip2.BZip2OutputStream;

/**
 * A BZip2 file compressor
 */
public class Compress {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException {

		InputStream fileInputStream = new BufferedInputStream (new FileInputStream (args[0]));
		OutputStream fileOutputStream = new BufferedOutputStream (new FileOutputStream (args[0] + ".bz2"), 524288);
		BZip2OutputStream outputStream = new BZip2OutputStream (fileOutputStream);

		byte[] buffer = new byte [524288];
		int bytesRead;
		while ((bytesRead = fileInputStream.read (buffer)) != -1) {
			outputStream.write (buffer, 0, bytesRead);
		}
		outputStream.close();

	}

}
