package com.lyq3.Hibernate.HelloWorld;

import java.util.Date;
public class News {
	private Integer id;
	private String title;
	private String author;
	private Date date;
	
	public News() {
		super();
	}

	public News(String title, String author, Date date) {
		super();
		this.title = title;
		this.author = author;
		this.date = date;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", author=" + author + ", date=" + date
				+ "]";
	}

	
	
}
