package com.marce.idealista.advertAPI.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.marce.idealista.advertAPI.model.AdvertJson;

@Service
public class LoadDataService implements AdvertsService<InputStream, List<AdvertJson>>{
	
	private static Logger LOG = LoggerFactory.getLogger(LoadDataService.class);
	
	private static final String PICTURES = "pictures";
	private static final String DESCRIPTION = "description";
	private static final String ID = "id";
	
	@Override
	public List<AdvertJson> service(InputStream is) throws IOException, ParseException {
		LOG.info(" > INIT LoadDataService.service({})", is);
		JSONParser parser = new JSONParser();
		JSONArray fileJson = (JSONArray) parser.parse(new InputStreamReader(is));
		List<AdvertJson> advertEntities = new ArrayList<>();
		AdvertJson advert;
		for (Object jsonObject : fileJson) {
			advert = new AdvertJson();
			JSONObject advertJson = (JSONObject) jsonObject;
			advert.setId((Long)advertJson.get(ID));
			advert.setDescription((String) advertJson.get(DESCRIPTION));
			for (Object picture : (JSONArray) advertJson.get(PICTURES)) {
				advert.addPictures(picture.toString());
			}
			LOG.info("Read [{}] ", advert);
			advertEntities.add(advert);
		}
		LOG.info(" < END LoadDataService.service({})", advertEntities);
		return advertEntities;
	}
	
}
