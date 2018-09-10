package com.marce.idealista.advertAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marce.idealista.advertAPI.mapper.Mapper;
import com.marce.idealista.advertAPI.model.AdvertEntity;
import com.marce.idealista.advertAPI.model.AdvertResponse;

@Service
public class ResponseService implements AdvertsService<List<AdvertEntity>, List<AdvertResponse>>{
	
	private static Logger LOG = LoggerFactory.getLogger(ResponseService.class);
	
	@Autowired
	Mapper<AdvertEntity, AdvertResponse> mapper;
	
	public List<AdvertResponse> service(List<AdvertEntity> adverts) {
		LOG.info(" > INIT ResponseService.service({})", adverts);
		List<AdvertResponse> advertsResponse = new ArrayList<>();
		adverts.forEach(advert -> advertsResponse.add(mapper.mapper(advert)));
		LOG.info(" < END ResponseService.service({})", advertsResponse);
		return advertsResponse;
	}
}
