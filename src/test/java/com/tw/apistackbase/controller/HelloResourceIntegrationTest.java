package com.tw.apistackbase.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(HelloResource.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloResourceIntegrationTest {
	
	@Autowired
	private HelloResource helloResource;
	
	@Autowired 
	private MockMvc mvc;
	
	@Test
	public void shouldGetHelloFromHelloResource() throws Exception {
		
		//when
		ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/hello/123"));
		
		//then
		result.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.is("Hello:123")));

	}
}
