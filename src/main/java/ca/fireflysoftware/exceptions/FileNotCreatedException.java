package ca.fireflysoftware.exceptions;

import java.util.Map;

public class FileNotCreatedException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public FileNotCreatedException(String message, Map<String, Object> params, Exception cause) {
		super(message, params, cause);
	}
}
