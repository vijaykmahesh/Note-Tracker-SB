package com.seleniumexpress.notetracker.entity;

import java.util.Date;

public class BlogEntity {

	private String blogTitle;

	private String subject;

	private String writtenBy;

	private String socialMediaLink;

	private String content;

	private Date date;

	private int id;

	public BlogEntity() {
		// TODO Auto-generated constructor stub
	}

	public BlogEntity(String blogTitle, String subject, String writtenBy, String socialMediaLink, String content,
			Date date, int id) {
		super();
		this.blogTitle = blogTitle;
		this.subject = subject;
		this.writtenBy = writtenBy;
		this.socialMediaLink = socialMediaLink;
		this.content = content;
		this.date = date;
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWrittenBy() {
		return writtenBy;
	}

	public void setWrittenBy(String writtenBy) {
		this.writtenBy = writtenBy;
	}

	public String getSocialMediaLink() {
		return socialMediaLink;
	}

	public void setSocialMediaLink(String socialMediaLink) {
		this.socialMediaLink = socialMediaLink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BlogEntity [blogTitle=" + blogTitle + ", subject=" + subject + ", writtenBy=" + writtenBy
				+ ", socialMediaLink=" + socialMediaLink + ", content=" + content + ", date=" + date + ", id=" + id
				+ "]";
	}

}
