package com.seleniumexpress.notetracker.customannotation;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TodaysDateValidator implements ConstraintValidator<TodaysDate, LocalDate> {

	public void initialize(TodaysDate date) {

		System.out.println("initialize method of custom TodaysDateValidator");

	}

	@Override
	public boolean isValid(LocalDate todayDate, ConstraintValidatorContext context) {

		System.out.println("INSIDE  method of isValid TodaysDateValidator");

		LocalDate current = LocalDate.now();

		System.out.println("Todays Date " + todayDate);

		System.out.println("Current Date " + current);

		if (todayDate.equals(current)) {

			System.out.println("Equal");

			return true;
		} else
			System.out.println("Not Equal");
		return false;

	}

}
