package com.github.tecuilacat.utilities;

import com.github.tecuilacat.utilities.annotations.Since;
import com.github.tecuilacat.utilities.annotations.UtilitiesConfig;
import com.github.tecuilacat.utilities.annotations.UtilityClass;
import com.github.tecuilacat.utilities.modes.SortMode;

import java.util.*;

/**
 * Utilities surrounding the Long class
 */
@Since(version = "1.0.1")
@UtilityClass(forNativeClass = Long.class)
public final class Longs {

    private static final Set<SortMode> SORT_MODES = Collections.unmodifiableSet(EnumSet.of(SortMode.ASCENDING, SortMode.DESCENDING));

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
    public static Long max(final Collection<Long> longs) {
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
    public static Long min(final Collection<Long> longs) {
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
    public static Collection<Long> sorted(final Collection<Long> collection, final SortMode sortMode) {
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
    public static Collection<Long> sorted(final Collection<Long> collection) {
        return sorted(collection, SortMode.ASCENDING);
    }

    /**
     * Sums up every value in the collection
     * @param collection Collection containing numbers
     * @return Sum of all values
     */
    @Since(version = "1.0.1")
    public static Long sum(Collection<Long> collection) {
        assert collection != null: "Collection must not be null";

        return collection.stream()
                .mapToLong(l -> l)
                .sum();
    }

    /**
     * Returns the greater number
     * @param a Number 1
     * @param b Number 2
     * @return max(Number1, Number2)
     */
    @Since(version = "1.0.1")
    public static Long greater(Long a, Long b) {
        assert a != null && b != null: "Numbers must not be null";

        long res = a;
        if (b > a) {
            res = b;
        }
        return res;
    }

    /**
     * Returns the smaller number
     * @param a Number 1
     * @param b Number 2
     * @return min(Number1, Number2)
     */
    @Since(version = "1.0.1")
    public static Long smaller(Long a, Long b) {
        assert a != null && b != null: "Numbers must not be null";

        long res = a;
        if (b < a) {
            res = b;
        }
        return res;
    }

    /**
     * Calculates the faculty of a number
     * @param number Number
     * @return Number!
     */
    @Since(version = "1.0.1")
    public static Long faculty(Long number) {
        assert number < 21: "Cannot calculate faculty of longs larger than 20";

        long res = 1L;
        for (int i = 1; i <= number; i++) {
            res *= i;
        }
        return res;
    }

}