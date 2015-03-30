package com.onceteam.model;

public class Notice {
	private Integer id;
	private String title;
	private String created_at;
	private String updated_at;
	private String content;
	
	public Integer getId(){ return id; }
	public String getTitle(){ return title; }
	public String getCreated_at(){ return created_at; }
	public String getUpdated_at(){ return updated_at; }
	public String getContent(){ return content; }
}
