package com.marce.idealista.advertAPI.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marce.idealista.advertAPI.model.AdvertEntity;
import com.marce.idealista.advertAPI.model.ControllerEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryServiceTest {


	@Autowired
	private RepositoryService service;
	
	List<AdvertEntity> listAdverts;
	
	@Before
	public void before() {
		listAdverts = new ArrayList<>();
	}
	
	@Test
	public void testServiceAll() {
		listAdverts = service.service(ControllerEnum.ALL);
		assertThat(5, is(listAdverts.size()));
	}

	@Test
	public void testServiceIrrelevant() {
		listAdverts = service.service(ControllerEnum.IRRELEVANT);
		assertThat(1, is(listAdverts.size()));
		listAdverts.forEach(advert -> assertThat(advert.getLastUpdate(), is(notNullValue())));
	}

	@Test
	public void testServiceUser() {
		listAdverts = service.service(ControllerEnum.USER);
		assertThat(4, is(listAdverts.size()));
		listAdverts.forEach(advert -> assertThat(advert.getPoints(), greaterThan(40)));		
	}
	
}
