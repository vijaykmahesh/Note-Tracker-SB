package com.seleniumexpress.notetracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.notetracker.entity.BlogEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(BlogEntity blogEntity) {

		// insert query
		String sql = "insert into notetracker.blog (blogTitle,subject,writtenBy,socialMediaLink,content,date) values (?,?,?,?,?,?)";

		Object argsArr[] = { blogEntity.getBlogTitle(), blogEntity.getSubject(), blogEntity.getWrittenBy(),
				blogEntity.getSocialMediaLink(), blogEntity.getContent(), blogEntity.getDate() };

		jdbcTemplate.update(sql, argsArr);

		log.info("query executed sucesfuly");

	}

	@Override
	public List<BlogEntity> findAll() {

		String sql = "select id,blogTitle from notetracker.blog";

		List<BlogEntity> blogEntityList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<BlogEntity>(BlogEntity.class));

		return blogEntityList;

	}

}
