package com.marce.idealista.advertAPI.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marce.idealista.advertAPI.Application;
import com.marce.idealista.advertAPI.model.AdvertJson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadDataTest {
	
	@Autowired
	private LoadDataService service;
	
	@Test
	public void testService() throws IOException, ParseException {
		List<AdvertJson> advertJsons = service.service(Application.class.getResourceAsStream("/advertsTest.json"));
		assertThat(advertJsons.size(), is(10));
	
	}

}
