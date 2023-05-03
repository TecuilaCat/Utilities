package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.DefaultValue;
import com.github.tecuilacat.utilities.annotations.PrivateClass;

@PrivateClass(usage = "Default values centralized for utility classes")
final class DefaultValues {

    @DefaultValue(description = "Value that gets returned if in an integer method occurs an error")
    static Integer DEFAULT_INTEGER_VALUE_ON_ERROR = 0;

    @DefaultValue(description = "Value that gets returned if in a double method occurs an error")
    static Double DEFAULT_DOUBLE_VALUE_ON_ERROR = 0.0;

    @DefaultValue(description = "Value that gets returned if in a long method occurs an error")
    static Long DEFAULT_LONG_VALUE_ON_ERROR = 0L;

    @DefaultValue(description = "Root folder from which every path will be relative to")
    static String DEFAULT_ROOT_FOLDER = "";

}