package com.seleniumexpress.notetracker.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DescriptionValidation implements ConstraintValidator<NotMoreThen400Characters, String> {

	private int min;

	private int max;
	
	public void initialize(NotMoreThen400Characters desc) {

		// i can write post construct work right here i,e we will do intialization part
		// here
		// to capture default value entered in annotation
		//only once this method will be executed 2nd tym directly isValid() will be executed since intialization is already done.
		
		System.out.println("initialize method of custom desc validator");
		
		this.min = desc.min();
		this.max = desc.max();

	}
	
	
	@Override
	public boolean isValid(String desc, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub

				// write logic here
				// values entered by user in form should be taken.
				
				System.out.println("isValid method of custom desc validator");

				if (desc == null) {
					return false;
				}

				if (desc.length() < min || desc.length() > max) {
					return false;// fail
				} else

					return true;// pass
	}

}
