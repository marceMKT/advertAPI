package com.marce.idealista.advertAPI.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marce.idealista.advertAPI.model.AdvertJson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatePointServiceTest {
		
	@Autowired
	private CalculatePointService service;
	
	private AdvertJson advert;
	
	@Before
	public void before() {
		advert = new AdvertJson();
	}
	
	@Test 
	public void testServiceAllPoints() {
		advert.setDescription("Nuevo ático céntrico recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo");
		advert.addPictures("Picture1");
		assertThat(service.service(advert), is(new Integer(100)));
	}

	@Test 
	public void testServiceNonePoints() {
		assertThat(service.service(advert), is(new Integer(0)));
	}

	@Test 
	public void testServiceIrrelevantPoints() {
		advert.setDescription("Chalezaco, céntrico y reformado!!");
		assertThat(service.service(advert), is(service.getIrrelevantMinPoints()));
	}

}
