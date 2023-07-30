package com.fpoly;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws Exception {
		restTemplateClient();
	}

	private static void restTemplateClient() throws Exception {
		RestTemplate client = new RestTemplate();
		
		//1. Headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic dXNlcjE6MTIz");
		
		//2. Data
		HttpEntity<Void> request = new HttpEntity<>(null, headers);
		
		//3. Make Request & Retrieve Response
		String url = "http://localhost:8080/rest/authorities";
		ResponseEntity<String> response = client.exchange(url, HttpMethod.GET, request, String.class);
		
		//4. Response Processing
		System.out.println(response.getBody());
	}
}
