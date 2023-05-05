package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.modes.SortMode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * This file is part of the JUnit Jupiter test project.
 *
 * Licensed under the Eclipse Public License - v 2 (the "License");
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
class IntegersTest {

    @Test
    void max() {
        assertEquals(5, Integers.max(Arrays.asList(1, 3, 4, 2, 5)));
    }

    @Test
    void min() {
        assertEquals(1, Integers.min(Arrays.asList(1, 3, 4, 2, 5)));
    }

    @Test
    void sorted() {
        final List<Integer> sortedDoublesAscending = (List<Integer>) Integers.sorted(Arrays.asList(1, 3, 4, 2, 5));
        final List<Integer> sortedDoublesDescending = (List<Integer>) Integers.sorted(Arrays.asList(1, 3, 4, 2, 5), SortMode.DESCENDING);

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
    void sum() {
        assertEquals(125, Integers.sum(Arrays.asList(7, 9, 6, 7, 4, 1, 8, 83)));
    }

    @Test
    void greater() {
        assertAll("Doubles: greater(a,b)",
                () -> assertEquals(5, Integers.greater(5, 2)),
                () -> assertEquals(5, Integers.greater(2, 5))
        );
    }

    @Test
    void smaller() {
        assertAll("Doubles: smaller(a,b)",
                () -> assertEquals(2, Integers.smaller(5, 2)),
                () -> assertEquals(2, Integers.smaller(2, 5))
        );
    }

    @Test
    void faculty() {
        assertAll("Doubles: faculty(number)",
                () -> assertEquals(1, Integers.faculty(0)),
                () -> assertEquals(3628800, Integers.faculty(10))
        );
    }
}