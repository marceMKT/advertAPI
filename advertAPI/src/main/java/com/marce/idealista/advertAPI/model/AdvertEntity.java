package com.marce.idealista.advertAPI.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvertEntity extends AdvertJson{
	private int points;
	private Date lastUpdate;
	
	public AdvertEntity() {
		super();
	}
	
	public AdvertEntity(int points, Date lastUpdate) {
		this.points = points;
		this.lastUpdate = lastUpdate;
	}

	public void addPictures(String picture) {
		super.getPictures().add(picture);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Override
	public String toString() {
		return "AdvertEntity [points=" + points + ", lastUpdate=" + lastUpdate + "]";
	}
	
}
