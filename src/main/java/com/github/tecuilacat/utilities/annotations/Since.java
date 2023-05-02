package com.github.tecuilacat.utilities.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Since {

    String version();

    String lastUpdated() default "";

}
