package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.UtilityClass;

/**
 * Utilities surrounding the String class
 */
@UtilityClass
public class StringUtilities {

    /**
     * Checks if a string contains a certain other string while ignoring upper or lower case
     * @param str String in which a different string could be
     * @param searchStr String you search for
     * @return True if the first string does indeed contain the searched string
     */
    public static boolean containsIgnoreCase(String str, String searchStr) {
        str = str.toLowerCase();
        searchStr = searchStr.toLowerCase();
        return str.contains(searchStr);
    }

    /**
     * Checks if a string equals another while ignoring upper and lower case
     * @param str1 First string
     * @param str2 Second string
     * @return True if the first string equals the second string
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        return str1.equals(str2);
    }

    /**
     * Checks if a string starts with a certain prefix while ignoring upper and lower case
     * @param str String that you want to check
     * @param prefix Prefix the other string could start with
     * @return True if the first string starts with the prefix
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        str = str.toUpperCase();
        prefix = prefix.toUpperCase();
        return str.startsWith(prefix);
    }

    /**
     * Checks if a certain string ends with a certain suffix while ignoring upper and lower case
     * @param str String you want to check
     * @param suffix Suffix on which you want to check
     * @return True if the string ends with the suffix
     */
    public static boolean endsWithIgnoreCase(String str, String suffix) {
        str = str.toUpperCase();
        suffix = suffix.toUpperCase();
        return str.endsWith(suffix);
    }

}
