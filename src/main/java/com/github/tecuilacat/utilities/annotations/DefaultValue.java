package com.github.tecuilacat.utilities.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface DefaultValue {

    String description() default "";

}
