/**
 * 
 */
package com.ganacharyas.ziprange.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class
 * 
 * @author Santosh Ganacharya
 *
 */
public class AppUtil {

	public static final String RANGE_REG_EXP = "^(?:\\[\\d{5}[-,]\\d{5}\\])?$";

	/**
	 * Validates values as per regular expression provided
	 * 
	 * @param regExp
	 *            regular expression to validate value
	 * @param value
	 *            value to validate
	 * @return boolean result
	 */
	public static boolean isValidRange(String value) {
		Pattern pattern = Pattern.compile(RANGE_REG_EXP);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
