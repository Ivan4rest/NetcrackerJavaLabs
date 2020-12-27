package Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marks in which packages the search will be performed
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Configuration {
    String[] packages();
}
