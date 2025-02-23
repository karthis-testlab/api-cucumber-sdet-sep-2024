package com.rest.assured.base;

import com.rest.assured.lib.base.design.ApiClient;
import com.rest.assured.lib.base.design.ResponseAPI;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;

public class RestAssuredBase implements ApiClient {	

	@Override
	public ResponseAPI get(RequestSpecBuilder request, String endPoint) {		
		return new ResponseImpl(given().spec(request.build())
				                       .get(endPoint));
	}

	@Override
	public ResponseAPI post(RequestSpecBuilder request, String endPoint, Object body) {		
		return new ResponseImpl(given().spec(request.build())
				                        .body(body)
				                        .post(endPoint));
	}

	@Override
	public ResponseAPI put(RequestSpecBuilder request, String endPoint, Object body) {
		return new ResponseImpl(given().spec(request.build())
                                       .body(body)
                                       .put(endPoint));
	}

	@Override
	public ResponseAPI patch(RequestSpecBuilder request, String endPoint, Object body) {
		return new ResponseImpl(given().spec(request.build())
                                                    .body(body)
                                                    .patch(endPoint));
	}

	@Override
	public ResponseAPI delete(RequestSpecBuilder request, String endPoint) {
		return new ResponseImpl(given().spec(request.build())
                                       .delete(endPoint));
	}	

}