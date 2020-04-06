package ca.fireflysoftware.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import ca.fireflysoftware.exceptions.FileNotDeletedException;
import ca.fireflysoftware.exceptions.FileNotWrittenException;
import ca.fireflysoftware.messages.Messages;
import ca.fireflysoftware.utils.FileUtils;
import ca.fireflysoftware.utils.MessagesEnum;

public class FileWriter {
	
	private String fullPath;

	public FileWriter(String path, String extension) {
		this.fullPath = Repository.DEFAULT.getPath() + path + "." + extension;		
	}
	
	public void delete() {
		try {
			Files.deleteIfExists(Paths.get(fullPath));
		} catch (IOException e) {
			Map<String,Object> map = new HashMap<>();
			throw new FileNotDeletedException(Messages.getMessage("file.delete.exception"), map, e);
		}
	}
	
	public Path write(byte[] bytes) {
		Path file = FileUtils.createFileIfNotExists(fullPath);
		try {
			file = Files.write(file, bytes, StandardOpenOption.WRITE);
		} catch (IOException e) {
			Map<String,Object> map = new HashMap<>();
			String message = Messages.getMessage("file.write.exception");
			map.put(MessagesEnum.PATH.name(), fullPath);
			map.put(MessagesEnum.LENGTH.name(), bytes.length);
			throw new FileNotWrittenException(message, map, e);
		}
		return file;
	}
	
}