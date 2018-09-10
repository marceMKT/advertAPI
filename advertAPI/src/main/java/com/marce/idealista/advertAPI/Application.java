package com.marce.idealista.advertAPI;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.marce.idealista.advertAPI.mapper.Mapper;
import com.marce.idealista.advertAPI.model.AdvertEntity;
import com.marce.idealista.advertAPI.model.AdvertJson;
import com.marce.idealista.advertAPI.repository.AdvertRepository;
import com.marce.idealista.advertAPI.service.LoadDataService;

@SpringBootApplication
public class Application {
	private static Logger LOG = LoggerFactory.getLogger(Application.class);
	
	private static final String ADVERTS_JSON = "/adverts.json";

	@Autowired
	private Mapper<AdvertJson, AdvertEntity> mapper;

	@Autowired
	private AdvertRepository advertRepository;
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner init() {
        return args -> {
        	this.initData();
        };
    }
        
    private void initData() {
    	LOG.info(" > INIT LOAD DATA");
    	try {
    		List<AdvertJson> advertJsons = new LoadDataService().service(Application.class.getResourceAsStream(ADVERTS_JSON));
    		advertJsons.forEach(advertJson -> advertRepository.insert(mapper.mapper(advertJson)));
		} 
    	catch (IOException | ParseException e) {
			e.printStackTrace();
		}
    	LOG.info(" < END LOAD DATA");
    }
	
}
