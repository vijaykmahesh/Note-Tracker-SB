package com.seleniumexpress.notetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpress.notetracker.dao.NoteTrackerDAOV2;
import com.seleniumexpress.notetracker.entity.NoteEntity;

@RestController
public class SampleController {

	@Autowired
	NoteTrackerDAOV2 noteTrackerDAOV2;
	
	@ResponseBody
	@GetMapping("/insert/{note}/{desc}")
	public String insertData(@PathVariable("note") String note2
			,@PathVariable("desc") String desc2) {
		
		
		noteTrackerDAOV2.saveNote(new NoteEntity(note2, desc2));
		
		return "data inserted";
	}
}



