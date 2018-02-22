package com.meh.example.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleRestControllerIT {

	@LocalServerPort
	private int port;
	
	private  TestRestTemplate restTemplate ;
	private  HttpEntity<String> requestEntity;
	private HttpHeaders headers ;
	
	
	@Before
	public void setUp() throws Exception {
		createBasicHeaders();
		restTemplate = new TestRestTemplate();
		requestEntity = new HttpEntity<String>(headers);
	}
	
	@Test
	public void listadoClientes_thenStatus200listadoClientes() throws Exception {
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(getUrlWithPort("/users"), Object[].class);
		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));	
		assertNotNull(responseEntity.getBody());
	}
	
	private String getUrlWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	private HttpHeaders createBasicHeaders() {
		headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    return headers;
	}
}
