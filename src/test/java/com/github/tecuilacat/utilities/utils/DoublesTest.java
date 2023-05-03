package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.modes.SortMode;
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
class DoublesTest {

    @Test
    void max() {
        assertEquals(5.0, Doubles.max(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0)));
    }

    @Test
    void min() {
        assertEquals(1.0, Doubles.min(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0)));
    }

    @Test
    void sorted() {
        final List<Double> sortedDoublesAscending = (List<Double>) Doubles.sorted(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0));
        final List<Double> sortedDoublesDescending = (List<Double>) Doubles.sorted(Arrays.asList(1.0, 3.0, 4.0, 2.0, 5.0), SortMode.DESCENDING);

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
    void round() {
        assertAll("formatDouble",
                () -> assertEquals(10.112, Doubles.round(10.1117, 3)),
                () -> assertEquals(10.12, Doubles.round(10.1199, 3)),
                () -> assertEquals(10.11, Doubles.round(10.114, 2)),
                () -> assertEquals(10.5, Doubles.round(10.45, 1)),
                () -> assertEquals(19.99, Doubles.round(19.984673, 2)),
                () -> assertEquals(10.0, Doubles.round(10.45, 0))
        );
    }

    @Test
    void sum() {
        assertEquals(125.0, Doubles.sum(Arrays.asList(7.0, 9.0, 6.0, 7.0, 4.0, 1.0, 8.0, 83.0)));
    }
}