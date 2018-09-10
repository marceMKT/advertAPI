package com.marce.idealista.advertAPI.mapper.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marce.idealista.advertAPI.mapper.Mapper;
import com.marce.idealista.advertAPI.model.AdvertEntity;
import com.marce.idealista.advertAPI.model.AdvertResponse;
import com.marce.idealista.advertAPI.service.CalculatePointService;

@Service
public class AdvertEntityToAdvertResponse implements Mapper<AdvertEntity, AdvertResponse>{
	private static Logger LOG = LoggerFactory.getLogger(AdvertEntityToAdvertResponse.class);
	
	@Autowired
	CalculatePointService calculatePoints;
	
	public AdvertResponse mapper(AdvertEntity source) {
		LOG.info(" > INIT AdvertEntityToAdvertResponse.mapper [{}]", source);
		AdvertResponse advertResponse = new AdvertResponse();
		advertResponse.setId(source.getId());
		advertResponse.setDescription(source.getDescription());
		advertResponse.setPictures(source.getPictures());
		advertResponse.setPoints(source.getPoints());
		advertResponse.setDateLastModified(source.getLastUpdate());
		LOG.info(" < END AdvertEntityToAdvertResponse.mapper [{}]", advertResponse);
		return advertResponse;
	}
	
}
