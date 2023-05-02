package com.github.tecuilacat.utilities.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
@DisplayName("Tests for StringUtilities")
class StringUtilitiesTest {

    @Test
    void containsIgnoreCase() {
        assertAll("containsignoreCase(String str, String searchString): boolean",
                () -> assertTrue(StringUtilities.containsIgnoreCase("", "")),
                () -> assertTrue(StringUtilities.containsIgnoreCase("das ist ein test", "test")),
                () -> assertTrue(StringUtilities.containsIgnoreCase("das ist ein test", "TEST")),
                () -> assertTrue(StringUtilities.containsIgnoreCase("DAS IST EIN TEST", "test")),
                () -> assertTrue(StringUtilities.containsIgnoreCase("DAS IST EIN TEST", "TEST")),
                () -> assertFalse(StringUtilities.containsIgnoreCase("DAS IST EIN TEST", "kein test")),
                () -> assertFalse(StringUtilities.containsIgnoreCase("DAS IST EIN TEST", "KEIN TEST"))
        );
    }

    @Test
    void equalsIgnoreCase() {
        assertAll("equalsIgnoreCase(String str1, String str2): boolean",
                () -> assertTrue(StringUtilities.equalsIgnoreCase("String", "String")),
                () -> assertTrue(StringUtilities.equalsIgnoreCase("STRING", "STRING")),
                () -> assertTrue(StringUtilities.equalsIgnoreCase("string", "STRING")),
                () -> assertTrue(StringUtilities.equalsIgnoreCase("STRING", "string")),
                () -> assertFalse(StringUtilities.equalsIgnoreCase("String 1", "String 2")),
                () -> assertFalse(StringUtilities.equalsIgnoreCase("STRING 1", "STRING 2")),
                () -> assertFalse(StringUtilities.equalsIgnoreCase("string 1", "STRING 2")),
                () -> assertFalse(StringUtilities.equalsIgnoreCase("STRING 1", "string 2"))
        );
    }

    @Test
    void startsWithIgnoreCase() {
        assertAll("startsWithIgnorecase(String str, String prefix): boolean",
                () -> assertTrue(StringUtilities.startsWithIgnoreCase("String", "STR")),
                () -> assertTrue(StringUtilities.startsWithIgnoreCase("String", "str")),
                () -> assertFalse(StringUtilities.startsWithIgnoreCase("String", "ds")),
                () -> assertFalse(StringUtilities.startsWithIgnoreCase("String", "DS"))
        );
    }

    @Test
    void endsWithIgnoreCase() {
        assertAll("endsWithIgnoreCase(String str1, String suffix): boolean",
                () -> assertTrue(StringUtilities.endsWithIgnoreCase("STRING", "NG")),
                () -> assertTrue(StringUtilities.endsWithIgnoreCase("STRING", "ng")),
                () -> assertTrue(StringUtilities.endsWithIgnoreCase("string", "ng")),
                () -> assertTrue(StringUtilities.endsWithIgnoreCase("string", "NG")),
                () -> assertFalse(StringUtilities.endsWithIgnoreCase("STRING", "STR")),
                () -> assertFalse(StringUtilities.endsWithIgnoreCase("STRING", "str")),
                () -> assertFalse(StringUtilities.endsWithIgnoreCase("string", "str")),
                () -> assertFalse(StringUtilities.endsWithIgnoreCase("string", "STR"))
        );
    }
}