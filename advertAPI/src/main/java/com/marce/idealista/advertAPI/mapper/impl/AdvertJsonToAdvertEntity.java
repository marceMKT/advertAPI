package com.marce.idealista.advertAPI.mapper.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marce.idealista.advertAPI.mapper.Mapper;
import com.marce.idealista.advertAPI.model.AdvertEntity;
import com.marce.idealista.advertAPI.model.AdvertJson;
import com.marce.idealista.advertAPI.service.CalculatePointService;

@Service
public class AdvertJsonToAdvertEntity implements Mapper<AdvertJson, AdvertEntity>{
	private static Logger LOG = LoggerFactory.getLogger(AdvertJsonToAdvertEntity.class);
	
	@Autowired
	CalculatePointService calculatePoints;
	
	public AdvertEntity mapper(AdvertJson source) {
		LOG.info(" > INIT AdvertJsonToAdvertEntity.mapper [{}]", source);
		AdvertEntity advertEntity = new AdvertEntity();
		advertEntity.setId(source.getId());
		advertEntity.setDescription(source.getDescription());
		advertEntity.setPictures(source.getPictures());
		int points = calculatePoints.service(source);
		advertEntity.setPoints(points);
		if(points <= calculatePoints.getIrrelevantMinPoints()) {
			advertEntity.setLastUpdate(new Date());
		}
		LOG.info(" < END AdvertJsonToAdvertEntity.mapper [{}]", advertEntity);
		return advertEntity;
	}
	
}
