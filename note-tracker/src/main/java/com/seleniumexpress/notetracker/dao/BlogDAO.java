package com.seleniumexpress.notetracker.dao;

import java.util.List;

import com.seleniumexpress.notetracker.entity.BlogEntity;

public interface BlogDAO {

	public void save(BlogEntity blog);

	public List<BlogEntity> findAll();

}
