package ca.fireflysoftware.exceptions;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> params = new HashMap<>();
	
	public BaseException(String message, Map<String, Object> params, Exception cause) {
		super(message, cause);
		this.params = params;
	}

	public Map<String, Object> getParams() {
		return params;
	}
}
