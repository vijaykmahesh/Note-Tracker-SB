package com.seleniumexpress.notetracker.service;

import java.util.List;

import com.seleniumexpress.notetracker.model.Note;

public interface NoteTrackerService {

	public void save(Note note);
	public List<Note> findAll();
	public Note findNoteById(int id);
	public boolean updateNote(Note note);
	
	public boolean deleteNote(int id);
}
