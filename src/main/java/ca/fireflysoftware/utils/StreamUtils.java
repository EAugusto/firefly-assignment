package ca.fireflysoftware.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class StreamUtils {

	public static byte[] getBytes(List<Integer> numbers) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Iterator<Integer> iterator = numbers.iterator();
			return getBytes(baos, iterator);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static byte[] getBytes(IntStream numbers) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Iterator<Integer> iterator = numbers.iterator();
			return getBytes(baos, iterator);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static byte[] getBytes(ByteArrayOutputStream baos, Iterator<Integer> iterator) throws IOException {
		while(iterator.hasNext()) {
			baos.write((iterator.next() + System.lineSeparator()).getBytes(Charset.forName("UTF-8")));
		}
		return baos.toByteArray();
	}
	
}