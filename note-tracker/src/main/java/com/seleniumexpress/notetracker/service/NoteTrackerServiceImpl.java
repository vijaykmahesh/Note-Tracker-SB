package com.seleniumexpress.notetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.notetracker.dao.NoteTrackerDAOV2;
import com.seleniumexpress.notetracker.entity.NoteEntity;
import com.seleniumexpress.notetracker.model.Note;

@Service
public class NoteTrackerServiceImpl implements NoteTrackerService{

	@Autowired
	NoteTrackerDAOV2 noteTrackerDAOV2;
	

	@Override
	public void save(Note note) {
		
		NoteEntity noteEntity = new NoteEntity();
		//noteEntity.setNote(note.getNote());
		//noteEntity.setDescription(note.getDesc());
		
		BeanUtils.copyProperties(note, noteEntity);
		
		noteTrackerDAOV2.saveNote(noteEntity);
		
		
	}

	@Override
	public List<Note> findAll() {
		
		List<Note>  noteList = new ArrayList<>();
	

		List<NoteEntity> noteEntitiesList = noteTrackerDAOV2.fetchAllNotes();
		
		for(NoteEntity noteEntity : noteEntitiesList) {
			
			Note note = new Note();
			BeanUtils.copyProperties(noteEntity, note);
			noteList.add(note);
			
		}
		
		
		return noteList;
	}

	@Override
	public Note findNoteById(int id) {
		
		Note note = new Note();
		
		NoteEntity noteEntity = noteTrackerDAOV2.getNoteById(id);
		
		BeanUtils.copyProperties(noteEntity, note);
		
		return note;
	}

	@Override
	public boolean updateNote(Note note) {
		
		NoteEntity noteEntity = new NoteEntity();
		
		BeanUtils.copyProperties(note, noteEntity);
		
		boolean isUpdated = noteTrackerDAOV2.updateNote(noteEntity);
		
		return isUpdated;
	}

	@Override
	public boolean deleteNote(int id) {
		
		boolean isDeleted = noteTrackerDAOV2.deleteNoteById(id);
		
		return isDeleted;
	}

	
}
