package com.seleniumexpress.notetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.notetracker.dao.BlogDAO;
import com.seleniumexpress.notetracker.entity.BlogEntity;
import com.seleniumexpress.notetracker.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDAO blogDAO;

	@Override
	public void save(Blog blog) {

		BlogEntity BlogEntity = new BlogEntity();

		BeanUtils.copyProperties(blog, BlogEntity);

		blogDAO.save(BlogEntity);

	}

	@Override
	public List<Blog> findAll() {

		List<Blog> list = new ArrayList<>();

		List<BlogEntity> blogList = blogDAO.findAll();

		for (BlogEntity blogEntity : blogList) {

			Blog blog = new Blog();
			BeanUtils.copyProperties(blogEntity, blog);
			list.add(blog);

		}

		return list;
	}

	@Override
	public Blog findBlogById(int id) {
		// TODO Auto-generated method stub
		
		BlogEntity blogEntity = blogDAO.findBlogById(id);
		
		Blog blog = new Blog();
		
		BeanUtils.copyProperties(blogEntity, blog);
		
		return blog;
	}

}
