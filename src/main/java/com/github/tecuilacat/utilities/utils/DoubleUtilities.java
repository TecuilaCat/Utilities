package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.UtilitiesConfig;
import com.github.tecuilacat.utilities.annotations.UtilityClass;
import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;

import java.util.Collection;
import java.util.Comparator;

/**
 * Utility class surrounding Double class
 */
@UtilityClass(forNativeClass = Double.class)
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
    public static Double getMaxValue(final Collection<Double> doubles) {
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
    public static Double getMinValue(final Collection<Double> doubles) {
        assert doubles != null: "Collection must not be null";
        return doubles.stream()
                .mapToDouble(d -> d)
                .min()
                .orElse(DefaultValues.DEFAULT_DOUBLE_VALUE_ON_ERROR);
    }

    /**
     * Sorts a collection (does not matter which type - you have to cast it back later) either descending or ascending
     * @param collection Collection that has to be sorted
     * @param sortMode Sort mode
     * @return Sorted collection (must be cast back to the original type)
     */
    public static Collection<Double> getSortedCollection(final Collection<Double> collection, final UtilitiesSortMode sortMode) {
        final Comparator<Double> comparator = (o1, o2) -> switch (sortMode) {
            case DESCENDING -> o2.compareTo(o1);
            case ASCENDING -> o1.compareTo(o2);
        };
        return collection.stream()
                .sorted(comparator)
                .toList();
    }

    /**
     * Sorts a collection (does not matter which type - you have to cast it back later) ascending
     * @param collection Collection that has to be sorted
     * @return Sorted collection (must be cast back to the original type)
     */
    public static Collection<Double> getSortedCollection(final Collection<Double> collection) {
        return getSortedCollection(collection, UtilitiesSortMode.ASCENDING);
    }

}