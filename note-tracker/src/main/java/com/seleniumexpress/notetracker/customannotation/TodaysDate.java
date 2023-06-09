package com.seleniumexpress.notetracker.customannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TodaysDateValidator.class)

public @interface TodaysDate  {
	
	String message() default "Date must be today's";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
