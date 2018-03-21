package com.tirmizee.core.commons;

/**
 * @author pratya yeekhaday
 *
 */

public class StringUtils{

	
	 /**
     * <p>Compares two String, returning {@code true} if they represent
     * equal String.</p>
     *
     * <p>{@code null}s are handled without exceptions. Two {@code null}
     * references are considered to be equal. The comparison is case sensitive.</p>
     *
     * <pre>
     * StringUtils.equals(null, null)   = true
     * StringUtils.equals(null, "abc")  = false
     * StringUtils.equals("abc", null)  = false
     * StringUtils.equals("abc", "abc") = true
     * StringUtils.equals("abc", "ABC") = false
     * </pre>
     *
     * @param str1  the first String, may be {@code null}
     * @param str1  the second String, may be {@code null}
     * @return {@code true} if the String are equal (case-sensitive), or both {@code null}
     */
	public static boolean equals(String str1 , String str2) {
		return (str1 == null) ? (str2 == null) : str1.equals(str2);
	}
	 /**
     * <p>Trim and Compares two String, returning {@code true} if they represent
     * equal sequences of String.</p>
     *
     * <p>{@code null}s are handled without exceptions. Two {@code null}
     * references are considered to be equal. The comparison is case sensitive.</p>
     *
     * <pre>
     * StringUtils.eaqualWithTrim(null, null)   = true
     * StringUtils.eaqualWithTrim(null, "abc")  = false
     * StringUtils.eaqualWithTrim("abc", null)  = false
     * StringUtils.eaqualWithTrim("abc ", "   abc") = true
     * StringUtils.eaqualWithTrim("abc ", "ABC") = false
     * </pre>
     *
     * @param str1  the first CharSequence, may be {@code null}
     * @param str2  the second CharSequence, may be {@code null}
     * @return {@code true} if the CharSequences are equal (case-sensitive), or both {@code null}
     */
	public static boolean eaqualWithTrim(String str1 , String str2){
		return (str1 == null) ? (str2 == null) : str1.trim().equals(trimToNull(str2));
	}
	
	public static String trimToNull(String string){
		return string == null ? null : string.trim();
	}
	
	public static boolean equals(String str1 , String str2 , String...strs) {
		boolean isEquals = true;
		String [] temp = new String[ 2 + strs.length ];
		temp[0] = str1;	temp[1] = str2;
		for (int i = 0; i < strs.length; i++) { temp[i + 2] = strs[i]; }
		for (int i = 1,length = temp.length; isEquals && i < length; i++) {
			isEquals &= equals(temp[0], temp[i]);
		}
		return isEquals;
	}

}
