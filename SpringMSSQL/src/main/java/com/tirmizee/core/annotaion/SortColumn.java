
package com.tirmizee.core.annotaion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for sort 
 * 
 * @author pratya yeekhaday
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })  
@Inherited
@Documented
public @interface SortColumn { 
	
	String[] value() default {}; 
	
}
