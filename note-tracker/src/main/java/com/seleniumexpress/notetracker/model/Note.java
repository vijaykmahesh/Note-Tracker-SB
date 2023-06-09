package com.seleniumexpress.notetracker.model;

import com.seleniumexpress.notetracker.customannotation.NotMoreThen400Characters;

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
	
	@NotMoreThen400Characters(min = 10,max = 400,message = "Desc should be within 10-400 chars ")
	private String desc;
	private int id;

	



}
