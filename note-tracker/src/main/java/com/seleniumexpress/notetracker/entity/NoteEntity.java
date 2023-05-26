package com.seleniumexpress.notetracker.entity;

public class NoteEntity {
	
	private int id;
	private String note;
	private String desc;
	
	public NoteEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	public NoteEntity(String note, String description) {
		this.note = note;
		this.desc = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String description) {
		this.desc = description;
	}

	@Override
	public String toString() {
		return "NoteEntity [id=" + id + ", note=" + note + ", description=" + desc + "]";
	}
	
	
	

}
