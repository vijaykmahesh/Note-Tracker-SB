package com.seleniumexpress.notetracker.service;

import java.util.List;

import com.seleniumexpress.notetracker.model.Blog;

public interface BlogService {

	public void save(Blog blog);

	public List<Blog> findAll();

	public Blog findBlogById(int id);

}
