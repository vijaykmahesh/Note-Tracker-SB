package com.seleniumexpress.notetracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.notetracker.entity.NoteEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class NoteTrackerDAOImplV2 implements NoteTrackerDAOV2{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveNote(NoteEntity noteEntity) {
		
		//insert query
		String sql = "insert into notetracker.notes (note,`desc`) values (?,?)";

		Object argsArr[] = {noteEntity.getNote(),noteEntity.getDesc()};

		jdbcTemplate.update(sql,argsArr);
		
		log.info("query executed sucesfuly");
		
	}

	@Override
	public List<NoteEntity> fetchAllNotes() {
		
		String sql = "select id,note as note,`desc` from notetracker.notes";
		
		List<NoteEntity> NoteList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<NoteEntity>(NoteEntity.class));
		
		return NoteList;
	}

	@Override
	public NoteEntity getNoteById(int id) {
		
		String sql = "SELECT  id,note,`desc` FROM notetracker.notes where id = ?";
		
		NoteEntity noteEntity = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<NoteEntity>(NoteEntity.class), id);
		
		return noteEntity;
	}
	
    public NoteEntity getNoteByNote(String note) {
		
		String sql = "SELECT  id,note,desc FROM notetracker.notes where note = ?";
		
		NoteEntity noteEntity = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<NoteEntity>(NoteEntity.class), note);
		
		return noteEntity;
	}

	@Override
	public boolean deleteNoteById(int id) {
		
		String sql = "delete from notetracker.notes where id = ?";
		
		int noOfRowsImpacted = jdbcTemplate.update(sql,id); 
		
		return noOfRowsImpacted == 1;
	}

	@Override
	public boolean updateNote(NoteEntity entity) {
		
		String sql = "update notetracker.notes set note = ?, `desc` = ? where id =?";
		
		Object[] args = {entity.getNote(),entity.getDesc(),entity.getId()};
		
		int noOfRowsUpdated = jdbcTemplate.update(sql,args);
		
		return noOfRowsUpdated==1;
	}
	
	

}
























