package com.seleniumexpress.notetracker.model;

import com.seleniumexpress.notetracker.customannotation.ValidDescrption;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Note {

	@NotBlank(message = "note can't be blank")
	@Size(min = 3,max = 100, message = "Note char's should be between 3-15")
	private String note;
	
	@ValidDescrption(min = 10,max = 15,message = "Desc should be within 10-15 chars ")
	private String desc;
	private int id;

	



}
