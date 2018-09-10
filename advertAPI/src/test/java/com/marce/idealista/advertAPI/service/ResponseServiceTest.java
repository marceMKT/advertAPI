package com.marce.idealista.advertAPI.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marce.idealista.advertAPI.model.AdvertEntity;
import com.marce.idealista.advertAPI.model.AdvertResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseServiceTest {

	@Autowired
	private ResponseService service;
	
	@Test
	public void testService() {
		AdvertEntity adverEntity = new AdvertEntity(10, new Date());
		adverEntity.setId((long) 1111);
		adverEntity.setDescription("description");
		List<AdvertEntity> advertEntities = new ArrayList<>(Arrays.asList(adverEntity));
		List<AdvertResponse> advertResponses = service.service(advertEntities);
		assertThat(advertResponses.size(), is(advertEntities.size()));
		assertThat(advertResponses.get(0).getId(), is(advertEntities.get(0).getId()));
	}
	
}
