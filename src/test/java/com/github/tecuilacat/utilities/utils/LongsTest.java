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
class LongsTest {

    @Test
    void max() {
        assertEquals(5L, Longs.max(Arrays.asList(1L, 3L, 4L, 2L, 5L)));
    }

    @Test
    void min() {
        assertEquals(1L, Longs.min(Arrays.asList(1L, 3L, 4L, 2L, 5L)));
    }

    @Test
    void sorted() {
        final List<Long> sortedDoublesAscending = (List<Long>) Longs.sorted(Arrays.asList(1L, 3L, 4L, 2L, 5L));
        final List<Long> sortedDoublesDescending = (List<Long>) Longs.sorted(Arrays.asList(1L, 3L, 4L, 2L, 5L), SortMode.DESCENDING);

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
        assertEquals(125L, Longs.sum(Arrays.asList(7L, 9L, 6L, 7L, 4L, 1L, 8L, 83L)));
    }

}