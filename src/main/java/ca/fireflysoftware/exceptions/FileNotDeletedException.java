package ca.fireflysoftware.exceptions;

import java.util.Map;

public class FileNotDeletedException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public FileNotDeletedException(String message, Map<String, Object> params, Exception cause) {
		super(message, params, cause);
	}
}
