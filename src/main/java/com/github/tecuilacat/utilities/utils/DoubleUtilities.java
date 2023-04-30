package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.UtilitiesConfig;
import com.github.tecuilacat.utilities.annotations.UtilityClass;

import java.util.Collection;

/**
 * Utility class surrounding Double class
 */
@UtilityClass(forClass = Double.class)
public final class DoubleUtilities {

    /**
     * Returns the default value of this class that gets returned if something goes sideways
     * @return Default value on error
     */
    public static Double getDefaultValueOnError() {
        return DefaultValues.DEFAULT_DOUBLE_VALUE_ON_ERROR;
    }

    /**
     * Sets a new default value for this class. Note that this operation is irreversible during runtime
     * @param newDefaultValueOnError New value that gets returned on error
     */
    @UtilitiesConfig(affects = DefaultValues.class, description = "Sets new global return value on error")
    public static void configureDefaultValueOnError(Double newDefaultValueOnError) {
        DefaultValues.DEFAULT_DOUBLE_VALUE_ON_ERROR = newDefaultValueOnError;
    }

    /**
     * Determines the greatest value of a collection of doubles
     * @param doubles Collection of doubles e.g.: Arraylist
     * @return Max value. If collection is empty it returns a default value
     */
    public static Double getMax(Collection<Double> doubles) {
        assert doubles != null: "Collection must not be null";
        return doubles.stream()
                .mapToDouble(d -> d)
                .max()
                .orElse(DefaultValues.DEFAULT_DOUBLE_VALUE_ON_ERROR);
    }

    /**
     * Determines the smallest value of a collection of doubles
     * @param doubles Collection of doubles e.g.: Arraylist
     * @return Min value. If collection is empty it returns a default value
     */
    public static Double getMin(Collection<Double> doubles) {
        assert doubles != null: "Collection must not be null";
        return doubles.stream()
                .mapToDouble(d -> d)
                .min()
                .orElse(DefaultValues.DEFAULT_DOUBLE_VALUE_ON_ERROR);
    }

}
