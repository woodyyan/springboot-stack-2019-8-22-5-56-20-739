package com.tw.apistackbase.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class HelloResourceTest {
	@Test
	public void test() {
		HelloResource resource = new HelloResource();
		ResponseEntity<String> entity = resource.getAll("name");
		Assert.assertEquals(200, entity.getStatusCodeValue());
		Assert.assertEquals("Hello:name", entity.getBody());
	}

}
