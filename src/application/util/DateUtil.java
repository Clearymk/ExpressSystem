package application.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {
	private static final String DATE_PATTEN = "yyyy-MM-dd";
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTEN);

	public static String format(LocalDate date) {
		if(date == null) {
			return null;
		} else {
			return DATE_FORMATTER.format(date);
		}
	}
	
	public static LocalDate parse(String dateString) {
		try{
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
	
	public static boolean validDate(String dateString) {
		return DateUtil.parse(dateString) != null;
	}
}
