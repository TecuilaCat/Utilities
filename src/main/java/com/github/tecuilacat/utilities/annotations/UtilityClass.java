package com.github.tecuilacat.utilities.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface UtilityClass {

    Class<?> forNativeClass();

}
