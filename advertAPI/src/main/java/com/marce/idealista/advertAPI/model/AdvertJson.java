package com.marce.idealista.advertAPI.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class AdvertJson {
	@Id
	private Long id;
	private String description;
	private List<String> pictures = new ArrayList<>();
	
	public AdvertJson() {}
	
	public AdvertJson(Long id, String description, List<String> pictures) {
		this.id = id;
		this.description = description;
		this.pictures = pictures;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
	
	public void addPictures(String picture) {
		this.pictures.add(picture);
	}
	
	@Override
	public String toString() {
		return "Advert [id=" + id + ", description=" + description + ", pictures=" + pictures + "]";
	}
	
}
