/*
 * Copyright (c) 2011 Matthew Francis
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
