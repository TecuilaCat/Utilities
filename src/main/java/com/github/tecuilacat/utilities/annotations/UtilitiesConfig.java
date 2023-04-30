package com.github.tecuilacat.utilities.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface UtilitiesConfig {

    /**
     * States which class gets configured
     * @return Affected class
     */
    Class<?> affects();

    /**
     *
     * @return Short description
     */
    String description() default "";

}
