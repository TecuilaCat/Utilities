package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
class DoubleUtilitiesTest {

    @Test
    void getMaxValue() {
        assertEquals(5.0, DoubleUtilities.getMaxValue(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0)));
    }

    @Test
    void getMinValue() {
        assertEquals(1.0, DoubleUtilities.getMinValue(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0)));
    }

    @Test
    void getSortedCollection() {
        final List<Double> sortedDoublesAscending = (List<Double>) DoubleUtilities.getSortedCollection(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0));
        final List<Double> sortedDoublesDescending = (List<Double>) DoubleUtilities.getSortedCollection(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0), UtilitiesSortMode.DESCENDING);

        assertAll("Checking Ascending",
                () -> assertTrue(sortedDoublesAscending.get(0) <= sortedDoublesAscending.get(1)),
                () -> assertTrue(sortedDoublesAscending.get(1) <= sortedDoublesAscending.get(2)),
                () -> assertTrue(sortedDoublesAscending.get(2) <= sortedDoublesAscending.get(3)),
                () -> assertTrue(sortedDoublesAscending.get(3) <= sortedDoublesAscending.get(4))
        );

        assertAll("Checking Descending",
                () -> assertTrue(sortedDoublesDescending.get(0) >= sortedDoublesDescending.get(1)),
                () -> assertTrue(sortedDoublesDescending.get(1) >= sortedDoublesDescending.get(2)),
                () -> assertTrue(sortedDoublesDescending.get(2) >= sortedDoublesDescending.get(3)),
                () -> assertTrue(sortedDoublesDescending.get(3) >= sortedDoublesDescending.get(4))
        );
    }

    @Test
    void formatDouble() {
        assertAll("formatDouble",
                () -> assertEquals(10.112, DoubleUtilities.round(10.1117, 3)),
                () -> assertEquals(10.12, DoubleUtilities.round(10.1199, 3)),
                () -> assertEquals(10.11, DoubleUtilities.round(10.114, 2)),
                () -> assertEquals(10.5, DoubleUtilities.round(10.45, 1)),
                () -> assertEquals(19.99, DoubleUtilities.round(19.984673, 2)),
                () -> assertEquals(10.0, DoubleUtilities.round(10.45, 0))
        );
    }
}