package com.github.tecuilacat.utilities;

import com.github.tecuilacat.utilities.annotations.Since;
import com.github.tecuilacat.utilities.annotations.UtilitiesConfig;
import com.github.tecuilacat.utilities.annotations.UtilityClass;
import com.github.tecuilacat.utilities.modes.SortMode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Utility class surrounding Double class
 */
@Since(version = "1.0.1")
@UtilityClass(forNativeClass = Double.class)
public final class Doubles {

    private static final Set<SortMode> SORT_MODES = Collections.unmodifiableSet(EnumSet.of(SortMode.ASCENDING, SortMode.DESCENDING));

    /**
     * Returns the default value of this class that gets returned if something goes sideways
     * @return Default value on error
     */
    @Since(version = "1.0.1")
    public static Double getDefaultValueOnError() {
        return DefaultValues.DEFAULT_DOUBLE_VALUE_ON_ERROR;
    }

    /**
     * Sets a new default value for this class. Note that this operation is irreversible during runtime
     * @param newDefaultValueOnError New value that gets returned on error
     */
    @Since(version = "1.0.1")
    @UtilitiesConfig(affects = DefaultValues.class, description = "Sets new global return value on error")
    public static void configureDefaultValueOnError(Double newDefaultValueOnError) {
        DefaultValues.DEFAULT_DOUBLE_VALUE_ON_ERROR = newDefaultValueOnError;
    }

    /**
     * Determines the greatest value of a collection of doubles
     * @param doubles Collection of doubles e.g.: Arraylist
     * @return Max value. If collection is empty it returns a default value
     * @see DefaultValues
     */
    @Since(version = "1.0.1")
    public static Double max(final Collection<Double> doubles) {
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
     * @see DefaultValues
     */
    @Since(version = "1.0.1")
    public static Double min(final Collection<Double> doubles) {
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
    @Since(version = "1.0.1")

    public static Collection<Double> sorted(final Collection<Double> collection, final SortMode sortMode) {
        assert SORT_MODES.contains(sortMode): "Invalid sort mode is used: " + sortMode;

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
    @Since(version = "1.0.1")
    public static Collection<Double> sorted(final Collection<Double> collection) {
        return sorted(collection, SortMode.ASCENDING);
    }

    /**
     * Rounds a double to another double with a specified amount of numbers after the komma
     * @param d Value to be formatted
     * @param digitsAfterComma Amount of numbers after the comma
     * @return Rounded double
     */
    @Since(version = "1.0.1")
    public static Double round(Double d, int digitsAfterComma) {
        assert d != null: "Parameter d must not be null";
        assert digitsAfterComma >= 0: "Parameter digitsAfterComma must be at least 0. Current is " + digitsAfterComma;

        String doubleAsString = Double.toString(d);
        if (doubleAsString.split("\\.")[1].length() > digitsAfterComma) { //Checks if amount of digits after the comma is bigger than the intended cut
            //round, but with one digit more than wanted
            d = new BigDecimal(d)
                    .setScale(digitsAfterComma + 1, RoundingMode.HALF_UP)
                    .doubleValue();
            doubleAsString = Double.toString(d);
            if (Character.getNumericValue(doubleAsString.charAt(doubleAsString.length() - 1)) == 5) { //Check if last digit (LSB) is 5
                //increase number slightly so the rounding is correct
                doubleAsString = doubleAsString.substring(0, doubleAsString.length() - 1)
                        + doubleAsString.substring(doubleAsString.length() - 1).replace("5", "6");
            }
        }
        //convert string back to double and round with the correct amount of digits behind the comma
        return new BigDecimal(doubleAsString)
                .setScale(digitsAfterComma, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * Sums up every value in the collection
     * @param collection Collection containing numbers
     * @return Sum of all values
     */
    @Since(version = "1.0.1")
    public static Double sum(Collection<Double> collection) {
        assert collection != null: "Collection must not be null";

        return collection.stream()
                .mapToDouble(d -> d)
                .sum();
    }

    /**
     * Returns the greater number
     * @param a Number 1
     * @param b Number 2
     * @return max(Number1, Number2)
     */
    @Since(version = "1.0.1")
    public static Double greater(Double a, Double b) {
        assert a != null && b != null: "Numbers must not be null";

        double res = a;
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
    public static Double smaller(Double a, Double b) {
        assert a != null && b != null: "Numbers must not be null";

        double res = a;
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
    public static Double faculty(Double number) {
        assert number < 171: "Cannot calculate faculty of doubles larger than 170";

        double res = 1;
        for (int i = 1; i <= number; i++) {
            res *= i;
        }
        return res;
    }

}