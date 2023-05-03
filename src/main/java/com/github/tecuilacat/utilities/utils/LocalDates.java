package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.Since;
import com.github.tecuilacat.utilities.annotations.UtilityClass;
import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;

import java.time.LocalDate;

/**
 * Utility class surrounding LocalDate class
 */
@Since(version = "1.0.1")
@UtilityClass(forNativeClass = LocalDate.class)
public final class LocalDates {

    /**
     * Returns the number of days between two dates
     * @param date1 Date 1
     * @param date2 Date 2
     * @return Number of days between dates
     */
    static Integer getDaysBetween(LocalDate date1, LocalDate date2) {
        assert date1 != null && date2 != null: "Dates must not be null";
        return 0; //TODO
    }

    /**
     * Returns the number of months between two dates
     * @param date1 Date 1
     * @param date2 Date 2
     * @return Months between dates
     */
    @Since(version = "1.0.1")
    public static Integer getMonthsBetween(LocalDate date1, LocalDate date2) {
        assert date1 != null && date2 != null: "Dates must not be null";
        LocalDate[] sorted = getLocalDatesSorted(date1, date2);
        date1 = sorted[0];
        date2 = sorted[1];
        int result = date2.getMonthValue() - date1.getMonthValue() + getYearsBetween(date1, date2) * 12;
        if (date2.getMonthValue() < date1.getMonthValue()) {
            result += 12;
        }
        if (date2.getDayOfMonth() < date1.getDayOfMonth()) {
            result--;
        }
        return result;
    }

    /**
     * Returns the number of full years between two local dates
     * @param date1 Local date 1
     * @param date2 Local date 2
     * @return Full years between dates
     */
    @Since(version = "1.0.1")
    public static Integer getYearsBetween(LocalDate date1, LocalDate date2) {
        assert date1 != null && date2 != null: "Dates must not be null";
        LocalDate[] sorted = getLocalDatesSorted(date1, date2);
        date1 = sorted[0];
        date2 = sorted[1];
        int result = date2.getYear() - date1.getYear();
        if (date2.getMonthValue() < date1.getMonthValue()) {
            result--;
        } else if (date2.getMonthValue() == date1.getMonthValue() && date2.getDayOfMonth() < date1.getDayOfMonth()) {
            result--;
        }
        return result;
    }

    /**
     * Sorts two dates ascending
     * @param date1 First date
     * @param date2 Second date
     * @return Sorted Dates (ascending)
     */
    @Since(version = "1.0.1")
    public static LocalDate[] getLocalDatesSorted(final LocalDate date1, final LocalDate date2) {
        return getLocalDatesSorted(date1, date2, UtilitiesSortMode.ASCENDING);
    }

    /**
     * Sorts two dates
     * @param date1 First date
     * @param date2 Second date
     * @param mode SortMode
     * @return Sorted Dates. First one is at index 0, second one at index 1
     */
    @Since(version = "1.0.1")
    public static LocalDate[] getLocalDatesSorted(final LocalDate date1, final LocalDate date2, final UtilitiesSortMode mode) {
        assert date1 != null && date2 != null: "Dates must not be null";
        assert mode != null: "Sort mode must not be null";
        LocalDate[] result = new LocalDate[2];
        switch (mode) {
            case ASCENDING -> {
                if (date1.isBefore(date2) || date1.isEqual(date2)) {
                    result[0] = date1;
                    result[1] = date2;
                } else {
                    result[1] = date1;
                    result[0] = date2;
                }
                assert result[0].isBefore(result[1]) || result[0].isEqual(result[1]): "Dates are still not in the right order";
            }
            case DESCENDING -> {
                if (date2.isBefore(date1) || date2.isEqual(date1)) {
                    result[0] = date1;
                    result[1] = date2;
                } else {
                    result[1] = date1;
                    result[0] = date2;
                }
                assert result[1].isBefore(result[0]) || result[0].isEqual(result[1]): "Dates are still not in the right order";
            }
        }
        assert result[0] != null && result[1] != null: "Dates are not present in result";

        return result;
    }

}