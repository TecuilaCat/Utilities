package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.Since;
import com.github.tecuilacat.utilities.annotations.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities surrounding the String class
 */
@Since(version = "1.0.1")
@UtilityClass(forNativeClass = String.class)
public final class Strings {

    /**
     * Checks if a string contains a certain other string while ignoring upper or lower case
     * @param str String in which a different string could be
     * @param searchStr String you search for
     * @return True if the first string does indeed contain the searched string
     */
    @Since(version = "1.0.1")
    public static boolean containsIgnoreCase(String str, String searchStr) {
        assert str != null && searchStr != null: "str and searchStr must not be null";

        str = str.toLowerCase();
        searchStr = searchStr.toLowerCase();
        return str.contains(searchStr);
    }

    static boolean containsAnyIgnoreCase(String str, Collection<String> searchList) {
        //TODO
        return false;
    }

    /**
     * Checks if a string equals another while ignoring upper and lower case
     * @param str1 First string
     * @param str2 Second string
     * @return True if the first string equals the second string
     */
    @Since(version = "1.0.1")
    public static boolean equalsIgnoreCase(String str1, String str2) {
        assert str1 != null && str2 != null: "str1 and str2 must not be null";

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
    @Since(version = "1.0.1")
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        assert str != null && prefix != null: "str and prefix must not be null";

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
    @Since(version = "1.0.1")
    public static boolean endsWithIgnoreCase(String str, String suffix) {
        assert str != null && suffix != null: "str and suffix must not be null";

        str = str.toUpperCase();
        suffix = suffix.toUpperCase();
        return str.endsWith(suffix);
    }

    /**
     * Returns a list of matching substrings
     * @param str String that gets checked
     * @param regex Regex with pattern
     * @return List of matching substrings
     */
    @Since(version = "1.0.1")
    public static List<String> getMatchingSubstringsIgnoreCase(final String str, final String regex) {
        assert str != null && regex != null: "str and regex must not be null";


        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex.toLowerCase());
        Matcher matcher = pattern.matcher(str.toLowerCase());
        while (matcher.find()) {
            result.add(str.substring(matcher.start(), matcher.end()));
        }
        return result;
    }

    static List<String> getAnyMatchingSubstrings(final String str, final Collection<String> searchList) {
        //TODO
        return null;
    }

    /**
     * Returns a matcher for a string with a regex
     * @param str String to check
     * @param regex Regex
     * @return Initialized matcher
     */
    @Since(version = "1.0.1")
    public static Matcher getMatcher(String str, final String regex) {
        assert str != null && regex != null: "str and regex must not be null";

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str);
    }

    static String format(final Double d, final int digitsAfterComma) {
        //TODO
        return null;
    }

    static String roundAndFormat(Double d, final int digitsAfterComma) {
        d = Doubles.round(d, digitsAfterComma);
        //TODO
        return null;
    }

}