package com.marce.idealista.advertAPI.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.marce.idealista.advertAPI.model.AdvertJson;

@Service
public class CalculatePointService implements AdvertsService<AdvertJson, Integer>{
	
	private static final int NONE_POINTS = 0;

	private static Logger LOG = LoggerFactory.getLogger(CalculatePointService.class);
	
	private static final int WORD_POINTS = 5;
	private static final int DESCRIPTION_POINTS = 30;
	private static final int IMAGE_POINTS = 50;
	private static final int IRRELEVANT_POINTS = 40;
	private static final int MAX_POINTS = 100;
	
	private static String[] KEY_WORDS = { "luminoso", "nuevo", "céntrico", "reformado", "ático" };
	
	public Integer service(AdvertJson advert) {
		LOG.info(" > INIT CalculatePointService.service({})", advert);
		int points = this.getPointsPicture(advert) + 
				this.getPointsDescription(advert) + 
				this.getPointsWords(advert);
		
		if(points > MAX_POINTS) {
			points = MAX_POINTS;
		}
		LOG.info(" < END CalculatePointService.service({})", points);
		return points;
	}

	private int getPointsWords(AdvertJson advert) {
		int points = NONE_POINTS;
		if (null == advert.getDescription()) {
			return points;
		}
		for (int i = 0; i < KEY_WORDS.length; i++) {
			if (advert.getDescription().toLowerCase().contains(KEY_WORDS[i])) {
				points += WORD_POINTS;
			}
		}
		return points;
	}

	private int getPointsDescription(AdvertJson advert) {
		if (null != advert.getDescription() && !advert.getDescription().isEmpty()) {
			return DESCRIPTION_POINTS;
		}
		return NONE_POINTS;
	}

	private int getPointsPicture(AdvertJson advert) {
		if (null != advert.getPictures() && !advert.getPictures().isEmpty()) {
			return IMAGE_POINTS;
		}
		return NONE_POINTS;
	}
	
	public int getIrrelevantMinPoints() {
		return IRRELEVANT_POINTS;
	}
	
}
