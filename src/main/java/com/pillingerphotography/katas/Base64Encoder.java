package com.pillingerphotography.katas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Base64 Encoder
 * 
 */
public class Base64Encoder {
	private static byte[] base64Index = new byte[] { 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9', '+', '/' };


	/**
	 * Encode a string into Base 64 encoding
	 * @param input string input
	 * @return base 64 encoded string
	 * @throws IOException
	 */
	public String base64Encode(String input) throws IOException {
		byte[] bytes = input.getBytes("UTF-8");
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		base64Encode(bais, baos);
		String encodedString = baos.toString("UTF-8");
		return encodedString;
	}


	/**
	 * Encode input from input stream into base 64 and write to output stream
	 * @param is
	 * @param os
	 * @throws IOException
	 */
	public void base64Encode(InputStream is, OutputStream os)
			throws IOException {
		byte[] buffer = new byte[3];
		while (true) {
			Arrays.fill(buffer, (byte) 0x00);
			int read = is.read(buffer);
			if (read == -1) {
				break;
			}
			int toDecode = (buffer[0] << 16) + (buffer[1] << 8) + buffer[2];
			
			// mask 000000000000000000111111
			int mask = 0x00003F; 
			byte[] encoded = new byte[4];
			Arrays.fill(encoded, (byte) '=');
			encoded[0] = base64Index[((toDecode >> 18) & mask)];
			encoded[1] = base64Index[((toDecode >> 12) & mask)];
			if (read > 1) {
				encoded[2] = base64Index[((toDecode >> 6) & mask)];
			}
			if (read > 2) {
				encoded[3] = base64Index[(toDecode & mask)];
			}
			os.write(encoded);
		}
	}
}
