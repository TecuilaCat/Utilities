package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.UtilitiesConfig;
import com.github.tecuilacat.utilities.annotations.UtilityClass;

import java.util.Collection;

/**
 * Utilities surrounding the Integer class
 */
@UtilityClass(forClass = Integer.class)
public final class IntegerUtilities {

    /**
     * Returns the default value of this class that gets returned if something goes sideways
     * @return Default value on error
     */
    public static Integer getDefaultValueOnError() {
        return DefaultValues.DEFAULT_INTEGER_VALUE_ON_ERROR;
    }

    /**
     * Sets a new default value for this class. Note that this operation is irreversible during runtime
     * @param newDefaultValueOnError New value that gets returned on error
     */
    @UtilitiesConfig(affects = DefaultValues.class, description = "Sets new global return value on error")
    public static void configureDefaultValueOnError(Integer newDefaultValueOnError) {
        DefaultValues.DEFAULT_INTEGER_VALUE_ON_ERROR = newDefaultValueOnError;
    }

    /**
     * Determines the greatest value of a collection of integers
     * @param integers Collection of integers e.g.: Arraylist
     * @return Max value. If collection is empty it returns a default value
     */
    public static Integer getMax(Collection<Integer> integers) {
        assert integers != null: "Collection must not be null";
        return integers.stream()
                .mapToInt(i -> i)
                .max()
                .orElse(DefaultValues.DEFAULT_INTEGER_VALUE_ON_ERROR);
    }

    /**
     * Determines the smallest value of a collection of integers
     * @param integers Collection of integers e.g.: Arraylist
     * @return Min value. If collection is empty it returns a default value
     */
    public static Integer getMin(Collection<Integer> integers) {
        assert integers != null: "Collection must not be null";
        return integers.stream()
                .mapToInt(i -> i)
                .min()
                .orElse(DefaultValues.DEFAULT_INTEGER_VALUE_ON_ERROR);
    }

}
