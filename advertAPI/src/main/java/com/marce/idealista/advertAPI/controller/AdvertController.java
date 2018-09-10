package com.marce.idealista.advertAPI.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marce.idealista.advertAPI.model.AdvertResponse;
import com.marce.idealista.advertAPI.model.ControllerEnum;
import com.marce.idealista.advertAPI.service.RepositoryService;
import com.marce.idealista.advertAPI.service.ResponseService;

@RestController
public class AdvertController {
	
	private static Logger LOG = LoggerFactory.getLogger(AdvertController.class);
	
	@Autowired
	private RepositoryService advertsService;

	@Autowired
	private ResponseService responseService;
	
	@RequestMapping("/adverts")
    public List<AdvertResponse> adverts(){
		LOG.info(" > INIT adverts");
        return responseService.service(advertsService.service(ControllerEnum.ALL));
    }

	@RequestMapping("/adverts/irrelevant")
    public List<AdvertResponse> advertsIrrelevant() {
		LOG.info(" > INIT advertsIrrelevant");
        return responseService.service(advertsService.service(ControllerEnum.IRRELEVANT));
    }

	@RequestMapping("/adverts/user")
    public List<AdvertResponse> advertUsers() {
		LOG.info(" > INIT advertUsers");
        return responseService.service(advertsService.service(ControllerEnum.USER));
    }
}
