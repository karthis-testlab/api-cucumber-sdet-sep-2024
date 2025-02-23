package com.rest.assured.base;

import java.util.HashMap;
import java.util.Map;

import com.rest.assured.lib.base.design.ResponseAPI;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ResponseImpl implements ResponseAPI {
	
	private Response response;
	
	public ResponseImpl(Response response) {
		this.response = response;
	}

	@Override
	public int getStatusCode() {		
		return response.getStatusCode();
	}

	@Override
	public String getStatusMessage() {
		// HTTP1.1 200 OK --> ["HTTP1.1", "200", "OK"]
		// HTTP1.1 201 Created --> ["HTTP1.1", "200", "Created"]
		// HTTP1.1 404 Not Found --> ["HTTP1.1", "404", "Not Found"]		
		return response.getStatusLine().split(" ", 3)[2];
	}

	@Override
	public String getBody() {		
		return response.getBody().asPrettyString();
	}

	@Override
	public Map<String, String> getHeaders() {
		Map<String, String> headerMap = new HashMap<>();
		Headers headers = response.headers();
		for (Header header: headers) {
			headerMap.put(header.getName(), header.getValue());
		}
		return headerMap;
	}

	@Override
	public String getContentType() {
		// application/json;charaset=UTC-8
		return response.getContentType().split(";", 2)[0];
	}

}