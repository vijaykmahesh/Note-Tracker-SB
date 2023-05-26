package com.seleniumexpress.notetracker.dao;

import java.util.ArrayList;
import java.util.List;

import com.seleniumexpress.notetracker.model.Note;

//@Repository
public class NoteDAOImpl implements NoteDAO{
	
	ArrayList<Note> noteList = new ArrayList<>();

	@Override
	public void save(Note note) {
		
		//
		noteList.add(note);
		System.out.println("note saved to list..");
		
	}

	@Override
	public List<Note> findAll() {
		
		
		
		return noteList;
	}

}
