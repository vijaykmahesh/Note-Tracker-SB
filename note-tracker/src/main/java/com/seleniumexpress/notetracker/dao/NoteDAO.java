package com.seleniumexpress.notetracker.dao;

import java.util.List;

import com.seleniumexpress.notetracker.model.Note;

public interface NoteDAO {

	public void save(Note note);
	public List<Note> findAll();
}
