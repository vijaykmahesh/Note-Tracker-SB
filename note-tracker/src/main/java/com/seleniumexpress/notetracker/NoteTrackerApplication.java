package com.seleniumexpress.notetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seleniumexpress.notetracker.dao.NoteTrackerDAOV2;
import com.seleniumexpress.notetracker.entity.NoteEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NoteTrackerApplication implements CommandLineRunner {

	@Autowired
	NoteTrackerDAOV2 noteDAO;

	public static void main(String[] args) {

		SpringApplication.run(NoteTrackerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		NoteEntity noteEntity = new NoteEntity();
		noteEntity.setNote("do homeowrk - note 1111 - updated !!!!");
		noteEntity.setDesc("desc - updated 111!!!");

		noteDAO.saveNote(noteEntity);

	}

}
