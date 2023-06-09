package com.seleniumexpress.notetracker.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seleniumexpress.notetracker.model.Note;
import com.seleniumexpress.notetracker.service.NoteTrackerService;
import com.seleniumexpress.notetracker.utils.ExcelExporterUtils;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoteTrackerController {
	
	
	@Value("${myapp.appname}")
	private String appName;

	private NoteTrackerService noteTrackerService;
	
	 DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
     String currentDateTime = dateFormatter.format(new Date());
      
     String headerKey = "Content-Disposition";
     String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
     
     
	
	
	
	public NoteTrackerController(NoteTrackerService noteTrackerService) {

		this.noteTrackerService = noteTrackerService;
	}


	@GetMapping(value = "/note-home")
	public String showNoteTrackerHomePage(Model model) {

		if(!model.containsAttribute("noteObj")) {
			
			model.addAttribute("noteObj", new Note());
			
		}
			
		log.info("Application name : " + appName);

		return "note-home-page";
	}
	
	//@GetMapping("/blog")
	
	

	@PostMapping(value = "/submit-form")
	public String processNote(@Valid @ModelAttribute("noteObj") Note note,BindingResult errors,RedirectAttributes redirectAttributes) {


		if(errors.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("noteObj", note);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.noteObj",errors);
			errors.getAllErrors().forEach(error -> log.info("error triggered -> {}",error));
		
			
			return "redirect:/note-home";
		}
		
		//insert or update
		if (note.getId() == 0) {
			log.info("perfoming insert opration");
			
			//insert
			noteTrackerService.save(note);
		} else {
			
			log.info("perfoming update");
			
			//update
			noteTrackerService.updateNote(note);
			
		}
		
		redirectAttributes.addFlashAttribute("noteObj", note);
		
		return "redirect:/thankyou";
	}
	
	

	@GetMapping("/thankyou")
	public String thankYouPage(Model model) {
		
		return "submit-note-page";
	}
	
	
	
	
	
	
	
	@GetMapping(value = {"/","/find-all-notes"})
	public String getAllNote(Model model){
		
		//get all the note
		List<Note> allNotes = noteTrackerService.findAll();
		
		
		//send all the notes to view
		model.addAttribute("myNotes", allNotes);
		
		return "find-all-notes";
	}
	
	
	
	
	@GetMapping("/update-note")
	public String updateNote(@RequestParam("id") int id,Model model){
		
		log.info("/update-note - finding details for Id : {}",id);
		
		Note note = noteTrackerService.findNoteById(id); //1 , note,desc
		
		model.addAttribute("noteObj", note);
		
		return "note-home-page";
	}
	
	
	@GetMapping("/delete-note")
	public String deleteNote(@RequestParam int id) {
		
		log.info("deleting record for id : {}",id);
		
		//delete 
		noteTrackerService.deleteNote(id);
		
		return "redirect:/find-all-notes";
	}
	
	
	 @GetMapping("/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	       
	        response.setHeader(headerKey, headerValue);
	         
	        List<Note> allNotes = noteTrackerService.findAll();
	         
	        ExcelExporterUtils excelExporterUtils = new ExcelExporterUtils(allNotes);
	         
	        excelExporterUtils.export(response);    
	    }  
	
	
	
	
	
	
	

}


