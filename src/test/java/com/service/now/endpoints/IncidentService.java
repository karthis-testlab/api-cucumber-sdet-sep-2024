package com.service.now.endpoints;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.rest.assured.base.RestAssuredBase;
import com.rest.assured.lib.base.design.ResponseAPI;

import io.restassured.builder.RequestSpecBuilder;

public class IncidentService {	
	
	private ResponseAPI response;
	RestAssuredBase base = new RestAssuredBase();	
	
	public void createIncident(RequestSpecBuilder request, String requestPayload) {
		response = base.post(request, "/incident", requestPayload);
	}
	
	public void createIncident(RequestSpecBuilder request, File requestPayload) {
		response = base.post(request, "/incident", requestPayload);
	}
	
	public void createIncident(RequestSpecBuilder request, Object requestPayload) {
		response = base.post(request, "/incident", requestPayload);
	}
	
	public void getIncident(RequestSpecBuilder request) {
		response = base.get(request, "/incident");
	}
	
	public void getIncident(RequestSpecBuilder request, String sysID) {
		response = base.get(request, "/incident"+"/"+sysID);
	}
	
	public void validateResponse(int statusCode, String statusLine) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusLine));
	}

}