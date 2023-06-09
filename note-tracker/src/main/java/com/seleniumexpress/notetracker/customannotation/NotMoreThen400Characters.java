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

public @interface NotMoreThen400Characters {

	int min() default 18;

	int max() default 400;

	String message() default "Desc must be between 18-400";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
