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
@Constraint(validatedBy = DescriptionValidation.class)

public @interface ValidDescrption {

	int min() default 18;

	int max() default 60;

	String message() default "Desc must be between 18-60";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
