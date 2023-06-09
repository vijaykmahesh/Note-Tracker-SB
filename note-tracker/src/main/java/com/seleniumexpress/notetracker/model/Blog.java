package com.seleniumexpress.notetracker.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Blog {

	@Pattern(regexp = "^[A-Za-z ]*$", message = "Accepts only Alphabets")
	private String blogTitle;

	@Size(min = 10, max = 150, message = "Subject should be less then 150 characters")
	private String subject;

	@NotBlank
	private String writtenBy;

	private String socialMediaLink;

	@Size(min = 500, max = 10000, message = "content should be within 50-10000 words")
	private String content;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "please enter present date only")
	private Date date;

	private int id;

}
