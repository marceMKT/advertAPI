package com.marce.idealista.advertAPI.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.marce.idealista.advertAPI.model.AdvertEntity;
import com.marce.idealista.advertAPI.model.ControllerEnum;
import com.marce.idealista.advertAPI.repository.AdvertRepository;

@Service
public class RepositoryService implements AdvertsService<ControllerEnum, List<AdvertEntity>>{
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryService.class);
	
	private static final int MIN_POINTS_RELEVANT = 40;
	private static final String SORT_POINTS = "points";
	
	@Autowired
	private AdvertRepository advertRepository;

	@Override
	public List<AdvertEntity> service(ControllerEnum controllerEnum) {
		LOG.info(" > INIT CalculatePointService.RepositoryService({})", controllerEnum);
		switch (controllerEnum) {
		case ALL:
			return this.getAllSortedPoints();
		case IRRELEVANT:
			return this.getAdvertsIrrelevant();
		case USER:
			return this.getAdvertsUser();
		default:
			break;
		}
		return null;
	}

	private List<AdvertEntity> getAdvertsIrrelevant() {
		return (List<AdvertEntity>) advertRepository.findIrrelevant(MIN_POINTS_RELEVANT);
	}
	
	private List<AdvertEntity> getAdvertsUser() {
		return (List<AdvertEntity>) advertRepository.findSortRelevant(MIN_POINTS_RELEVANT, new Sort(Sort.Direction.DESC, SORT_POINTS));
	}

	private List<AdvertEntity> getAllSortedPoints() {
		return (List<AdvertEntity>) advertRepository.findAll(new Sort(Sort.Direction.DESC, SORT_POINTS));
	}

}
