package ca.fireflysoftware.exceptions;

import java.util.Map;

public class FileNotWrittenException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public FileNotWrittenException(String message, Map<String, Object> params, Exception cause) {
		super(message, params, cause);
	}
}
