package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/*
 * This file is part of the JUnit Jupiter test project.
 *
 * Licensed under the Eclipse Public License - v 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://github.com/junit-team/junit5/blob/main/LICENSE.md
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class LocalDateUtilitiesTest {

    @Test
    void getDaysBetween() {
    }

    @Test
    void getMonthsBetween() {
        assertAll("",
                () -> assertEquals(0, LocalDateUtilities.getMonthsBetween(LocalDate.of(2023,5,2), LocalDate.of(2023,5,2))),
                () -> assertEquals(1, LocalDateUtilities.getMonthsBetween(LocalDate.of(2023,5,2), LocalDate.of(2023,6,2))),
                () -> assertEquals(1, LocalDateUtilities.getMonthsBetween(LocalDate.of(2023,5,2), LocalDate.of(2023,4,2))),
                () -> assertEquals(1, LocalDateUtilities.getMonthsBetween(LocalDate.of(2022,5,2), LocalDate.of(2022,6,3))),
                () -> assertEquals(13, LocalDateUtilities.getMonthsBetween(LocalDate.of(2022,5,2), LocalDate.of(2023,6,2))),
                () -> assertEquals(24, LocalDateUtilities.getMonthsBetween(LocalDate.of(2022,5,2), LocalDate.of(2024,5,2))),
                () -> assertEquals(23, LocalDateUtilities.getMonthsBetween(LocalDate.of(2022,5,2), LocalDate.of(2024,4,2))),
                () -> assertEquals(0, LocalDateUtilities.getMonthsBetween(LocalDate.of(2022,5,2), LocalDate.of(2022,6,1)))
        );
    }

    @Test
    void getYearsBetween() {
        assertAll("LocalDateUtilities.getYearsBetween(date1: LocalDate, date2: LocalDate): int",
                () -> assertEquals(25, LocalDateUtilities.getYearsBetween(LocalDate.of(1998, 6,12), LocalDate.of(2023, 6, 12))),
                () -> assertEquals(25, LocalDateUtilities.getYearsBetween(LocalDate.of(1998, 6,12), LocalDate.of(2023, 6, 13))),
                () -> assertEquals(24, LocalDateUtilities.getYearsBetween(LocalDate.of(1998, 6,12), LocalDate.of(2023, 6, 11))),
                () -> assertEquals(24, LocalDateUtilities.getYearsBetween(LocalDate.of(1998, 6,12), LocalDate.of(2023, 5, 12))),
                () -> assertEquals(25, LocalDateUtilities.getYearsBetween(LocalDate.of(1998, 6,12), LocalDate.of(2023, 7, 12)))
        );
    }

    @Test
    void getLocalDatesSorted() {
        LocalDate date1 = LocalDate.of(2023, 5,2);
        LocalDate date2 = LocalDate.of(2023, 6,2);
        LocalDate[] resultAsc = LocalDateUtilities.getLocalDatesSorted(date1, date2, UtilitiesSortMode.ASCENDING);
        LocalDate[] resultDesc = LocalDateUtilities.getLocalDatesSorted(date1, date2, UtilitiesSortMode.DESCENDING);

        assertAll("LocalDateUtilities.getLocalDatesSorted(date1: LocalDate, date2: LocalDate): LocalDate[] -> Ascending",
                () -> assertEquals(resultAsc[0].getYear(), date1.getYear()),
                () -> assertEquals(resultAsc[0].getMonthValue(), date1.getMonthValue()),
                () -> assertEquals(resultAsc[0].getDayOfMonth(), date1.getDayOfMonth()),
                () -> assertEquals(resultAsc[1].getYear(), date2.getYear()),
                () -> assertEquals(resultAsc[1].getMonthValue(), date2.getMonthValue()),
                () -> assertEquals(resultAsc[1].getDayOfMonth(), date2.getDayOfMonth())
        );

        assertAll("LocalDateUtilities.getLocalDatesSorted(date1: LocalDate, date2: LocalDate): LocalDate[] -> Descending",
                () -> assertEquals(resultDesc[0].getYear(), date2.getYear()),
                () -> assertEquals(resultDesc[0].getMonthValue(), date2.getMonthValue()),
                () -> assertEquals(resultDesc[0].getDayOfMonth(), date2.getDayOfMonth()),
                () -> assertEquals(resultDesc[1].getYear(), date1.getYear()),
                () -> assertEquals(resultDesc[1].getMonthValue(), date1.getMonthValue()),
                () -> assertEquals(resultDesc[1].getDayOfMonth(), date1.getDayOfMonth())
        );
    }
}