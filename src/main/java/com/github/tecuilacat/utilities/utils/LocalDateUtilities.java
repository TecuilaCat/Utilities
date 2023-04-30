package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.UtilityClass;
import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;

import java.time.LocalDate;

/**
 * Utility class surrounding LocalDate class
 */
@UtilityClass(forNativeClass = LocalDate.class)
public class LocalDateUtilities {

    @Deprecated
    public static Integer getDaysBetween(LocalDate date1, LocalDate date2) {
        assert date1 != null && date2 != null: "Dates must not be null";
        return 0;
    }

    @Deprecated
    public static Integer getMonthsBetween(LocalDate date1, LocalDate date2) {
        assert date1 != null && date2 != null: "Dates must not be null";
        return 0;
    }

    @Deprecated
    public static Integer getYearsBetween(LocalDate date1, LocalDate date2) {
        assert date1 != null && date2 != null: "Dates must not be null";
        if (date1.isAfter(date2)) {
            LocalDate tempDate = date1;
            date1 = date2;
            date2 = tempDate;
        }
        return date2.getYear() - date1.getYear();
    }

    /**
     * Sorts two dates
     * @param date1 First date
     * @param date2 Second date
     * @param mode SortMode
     * @return Sorted Dates
     */
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
            }
            case DESCENDING -> {
                if (date2.isBefore(date1) || date2.isEqual(date1)) {
                    result[0] = date1;
                    result[1] = date2;
                } else {
                    result[1] = date1;
                    result[0] = date2;
                }
            }
        }
        assert result[0] != null && result[1] != null: "Dates are not present in result";
        return result;
    }

}