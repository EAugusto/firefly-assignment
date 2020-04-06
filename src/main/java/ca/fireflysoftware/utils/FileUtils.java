package ca.fireflysoftware.utils;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import ca.fireflysoftware.exceptions.FileNotCreatedException;
import ca.fireflysoftware.messages.Messages;

public class FileUtils {

	public static Path createFileIfNotExists(String fileName) {
		Path file = Paths.get(fileName);
		try {
			Path parent = file.getParent();
			Files.createDirectories(parent);
			Files.createFile(file);
		} catch (FileAlreadyExistsException e) {
			//Just don't create
		} catch (NoSuchFileException e) {
			Map<String, Object> map = new HashMap<>();
			map.put(MessagesEnum.PATH.name(), fileName);
			throw new FileNotCreatedException(Messages.getMessage("file.creation.exception"), map, e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return file;
	}
	
}
