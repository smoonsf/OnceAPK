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
	private String image_pv;
	private String image_thumbnail;
	private String resource_uri;
	private String homepage;
	private Boolean premium;
	private Double latitude;
	private Double longitude;
	private String location;
	
	
	
	public Integer getId(){ return id; }
	public Integer getHits(){ return hits; }
	public Integer getLikes(){ return likes; }
    public String getTitle(){ return title; }
    public String getSubtitle(){ return subtitle; }
    public String getContent() { return content; }
    public String getDate() { return date; }
    public String getUpdated_at() { return updated_at; }
    public String getCreated_at() { return created_at; }
    public String getCategory() { return category; }
    public String getImage_pv() { return image_pv; }
    public String getImage_thumbnail() { return image_thumbnail; }
    public String getUri() { return resource_uri; }
    public String getHomepage() { return homepage; }
    public Boolean getPremium() { return premium; }
    public List<Eventimage> getEventimage(){ return eventimage; }
    public double getLat(){ return latitude; }
    public double getLong(){ return longitude; }
    public String getLocation() { return location; }
}