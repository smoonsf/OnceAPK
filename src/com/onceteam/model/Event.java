package com.onceteam.model;

import java.util.List;

public class Event {
	private Integer id;
	private String title;
	private String subtitle;
	private String content;
	private String category;
	private String date;
	private String updated_at;
	private String created_at;
	private Integer hits;
	private Integer likes;
	private List<Eventimage> eventimage;
	private String image;
	private String image_pv;
	private String image_thumnail;
	private String resource_uri;
	private String homepage;
	private Boolean premium;
	
	
	public Integer getId(){ return id; }
    public String getTitle(){ return title; }
    public String getSubtitle(){ return subtitle; }
    public String getContent() { return content; }
    public String getDate() { return date; }
    public String getUpdated_at() { return updated_at; }
    public String getCategory() { return category; }
    public String getImage() { return image; }
    public String getImage_pv() { return image_pv; }
    public String getImage_thumbnail() { return image_thumnail; }
    public String getUri() { return resource_uri; }
    public String getHomepage() { return homepage; }
    public Boolean getPremium() { return premium; }
}

class Eventimage {
	private String id;
	private String image;
	private String image_pv;
	private String image_thumbnail;
	private String resource_uri;
}