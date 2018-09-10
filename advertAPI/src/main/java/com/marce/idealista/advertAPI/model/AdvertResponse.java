package com.marce.idealista.advertAPI.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvertResponse extends AdvertJson{
	private static final String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";
	private int points;
	private Date dateLastModified;
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getDateLastModified() {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return (dateLastModified!=null)?format.format(dateLastModified):null;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	@Override
	public String toString() {
		return "AdvertResponse [points=" + points + ", dateLastModified=" + dateLastModified + "]";
	}
	
}
