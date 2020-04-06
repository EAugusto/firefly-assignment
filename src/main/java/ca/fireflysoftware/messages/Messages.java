package ca.fireflysoftware.messages;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

	private static final Locale DEFAULT_LOCALE = Locale.CANADA;
	private static final String MESSAGE_BASENAME = "messages";
	
	public static String getMessage(String key, Object... params) {
		return getMessage(DEFAULT_LOCALE, key, params);
	}
	
	public static String getMessage(Locale locale, String key, Object... params) {
		ResourceBundle bundle = ResourceBundle.getBundle(MESSAGE_BASENAME, locale);
		String message = bundle.getString(key);
		MessageFormat messageFormat = new MessageFormat("");
		messageFormat.applyPattern(message);
		return messageFormat.format(params);
	}
	
	
	
}