package com.seleniumexpress.notetracker.dao;

import java.util.List;

import com.seleniumexpress.notetracker.entity.NoteEntity;


public interface NoteTrackerDAOV2 {
	
	public void saveNote(NoteEntity noteEntity);
	
	public List<NoteEntity> fetchAllNotes();
	
	public NoteEntity getNoteById(int id);
	
	public NoteEntity getNoteByNote(String note);
	
	public boolean deleteNoteById(int id);
	
	
	public boolean updateNote(NoteEntity entity);
	
	

}











