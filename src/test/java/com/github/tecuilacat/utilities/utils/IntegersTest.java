package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;
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
    void getMaxValue() {
        assertEquals(5, Integers.getMaxValue(Arrays.asList(1, 3, 4, 2, 5)));
    }

    @Test
    void getMinValue() {
        assertEquals(1, Integers.getMinValue(Arrays.asList(1, 3, 4, 2, 5)));
    }

    @Test
    void getSortedCollection() {
        final List<Integer> sortedDoublesAscending = (List<Integer>) Integers.getSortedCollection(Arrays.asList(1, 3, 4, 2, 5));
        final List<Integer> sortedDoublesDescending = (List<Integer>) Integers.getSortedCollection(Arrays.asList(1, 3, 4, 2, 5), UtilitiesSortMode.DESCENDING);

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
}