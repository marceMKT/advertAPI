package com.marce.idealista.advertAPI.config;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoConfigTest {
	
	@Autowired
	private MongoConfig mongoConfig;
	
	@Test
	public void testMongoTemplate() throws IOException{
		MongoTemplate mongoTemplate = mongoConfig.mongoTemplate();
		assertNotNull(mongoTemplate.getDb());
	}

}
