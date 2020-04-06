package ca.fireflysoftware.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FileReader {

	private String fullPath;
	
	public FileReader(String path, String extension) {
		this.fullPath = Repository.DEFAULT.getPath() + path + "." + extension;
	}

	public IntStream readIntegers() {
		try {
			Path file = Paths.get(fullPath);
			List<String> lines = Files.readAllLines(file, Charset.forName("UTF-8"));
			return lines.stream().filter(Predicate.not(String::isEmpty)).mapToInt(s -> Integer.valueOf(s.trim()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}