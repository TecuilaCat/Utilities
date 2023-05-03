package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.Since;
import com.github.tecuilacat.utilities.annotations.UtilitiesConfig;
import com.github.tecuilacat.utilities.annotations.UtilityClass;
import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;

import java.util.*;

/**
 * Utilities surrounding the Long class
 */
@Since(version = "1.0.1")
@UtilityClass(forNativeClass = Long.class)
public class LongUtilities {

    private static final Set<UtilitiesSortMode> SORT_MODES = Collections.unmodifiableSet(EnumSet.of(UtilitiesSortMode.ASCENDING, UtilitiesSortMode.DESCENDING));

    /**
     * Returns the default value of this class that gets returned if something goes sideways
     * @return Default value on error
     */
    @Since(version = "1.0.1")
    public static Long getDefaultValueOnError() {
        return DefaultValues.DEFAULT_LONG_VALUE_ON_ERROR;
    }

    /**
     * Sets a new default value for this class. Note that this operation is irreversible during runtime
     * @param newDefaultValueOnError New value that gets returned on error
     */
    @Since(version = "1.0.1")
    @UtilitiesConfig(affects = DefaultValues.class, description = "Sets new global return value on error")
    public static void configureDefaultValueOnError(final Long newDefaultValueOnError) {
        DefaultValues.DEFAULT_LONG_VALUE_ON_ERROR = newDefaultValueOnError;
    }

    /**
     * Determines the greatest value of a collection of longs
     * @param longs Collection of longs e.g.: Arraylist
     * @return Max value. If collection is empty it returns a default value
     * @see DefaultValues
     */
    @Since(version = "1.0.1")
    public static Long getMaxValue(final Collection<Long> longs) {
        assert longs != null: "Collection must not be null";
        return longs.stream()
                .mapToLong(l -> l)
                .max()
                .orElse(DefaultValues.DEFAULT_LONG_VALUE_ON_ERROR);
    }

    /**
     * Determines the smallest value of a collection of longs
     * @param longs Collection of longs e.g.: Arraylist
     * @return Min value. If collection is empty it returns a default value
     * @see DefaultValues
     */
    @Since(version = "1.0.1")
    public static Long getMinValue(final Collection<Long> longs) {
        assert longs != null: "Collection must not be null";
        return longs.stream()
                .mapToLong(l -> l)
                .min()
                .orElse(DefaultValues.DEFAULT_INTEGER_VALUE_ON_ERROR);
    }

    /**
     * Sorts a collection (does not matter which type - you have to cast it back later) either descending or ascending
     * @param collection Collection that has to be sorted
     * @param sortMode Sort mode
     * @return Sorted collection (must be cast back to the original type)
     */
    @Since(version = "1.0.1")
    public static Collection<Long> getSortedCollection(final Collection<Long> collection, final UtilitiesSortMode sortMode) {
        assert collection != null: "Collection must not be null";
        assert SORT_MODES.contains(sortMode): "Invalid sort mode is used: " + sortMode;

        final Comparator<Long> comparator = (o1, o2) -> switch (sortMode) {
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
    @Since(version = "1.0.1")
    public static Collection<Long> getSortedCollection(final Collection<Long> collection) {
        return getSortedCollection(collection, UtilitiesSortMode.ASCENDING);
    }

}
