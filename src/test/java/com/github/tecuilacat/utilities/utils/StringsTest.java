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
class StringsTest {

    @Test
    void containsIgnoreCase() {
        assertAll("containsignoreCase(String str, String searchString): boolean",
                () -> assertTrue(Strings.containsIgnoreCase("", "")),
                () -> assertTrue(Strings.containsIgnoreCase("das ist ein test", "test")),
                () -> assertTrue(Strings.containsIgnoreCase("das ist ein test", "TEST")),
                () -> assertTrue(Strings.containsIgnoreCase("DAS IST EIN TEST", "test")),
                () -> assertTrue(Strings.containsIgnoreCase("DAS IST EIN TEST", "TEST")),
                () -> assertFalse(Strings.containsIgnoreCase("DAS IST EIN TEST", "kein test")),
                () -> assertFalse(Strings.containsIgnoreCase("DAS IST EIN TEST", "KEIN TEST"))
        );
    }

    @Test
    void equalsIgnoreCase() {
        assertAll("equalsIgnoreCase(String str1, String str2): boolean",
                () -> assertTrue(Strings.equalsIgnoreCase("String", "String")),
                () -> assertTrue(Strings.equalsIgnoreCase("STRING", "STRING")),
                () -> assertTrue(Strings.equalsIgnoreCase("string", "STRING")),
                () -> assertTrue(Strings.equalsIgnoreCase("STRING", "string")),
                () -> assertFalse(Strings.equalsIgnoreCase("String 1", "String 2")),
                () -> assertFalse(Strings.equalsIgnoreCase("STRING 1", "STRING 2")),
                () -> assertFalse(Strings.equalsIgnoreCase("string 1", "STRING 2")),
                () -> assertFalse(Strings.equalsIgnoreCase("STRING 1", "string 2"))
        );
    }

    @Test
    void startsWithIgnoreCase() {
        assertAll("startsWithIgnorecase(String str, String prefix): boolean",
                () -> assertTrue(Strings.startsWithIgnoreCase("String", "STR")),
                () -> assertTrue(Strings.startsWithIgnoreCase("String", "str")),
                () -> assertFalse(Strings.startsWithIgnoreCase("String", "ds")),
                () -> assertFalse(Strings.startsWithIgnoreCase("String", "DS"))
        );
    }

    @Test
    void endsWithIgnoreCase() {
        assertAll("endsWithIgnoreCase(String str1, String suffix): boolean",
                () -> assertTrue(Strings.endsWithIgnoreCase("STRING", "NG")),
                () -> assertTrue(Strings.endsWithIgnoreCase("STRING", "ng")),
                () -> assertTrue(Strings.endsWithIgnoreCase("string", "ng")),
                () -> assertTrue(Strings.endsWithIgnoreCase("string", "NG")),
                () -> assertFalse(Strings.endsWithIgnoreCase("STRING", "STR")),
                () -> assertFalse(Strings.endsWithIgnoreCase("STRING", "str")),
                () -> assertFalse(Strings.endsWithIgnoreCase("string", "str")),
                () -> assertFalse(Strings.endsWithIgnoreCase("string", "STR"))
        );
    }
}