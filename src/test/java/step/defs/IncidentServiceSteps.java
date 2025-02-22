package step.defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import service.now.pojos.IncidentRequestPayload;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

public class IncidentServiceSteps {

	RequestSpecification request;
	String payload;
	Response response;
	
	IncidentRequestPayload pojo = new IncidentRequestPayload();

	@Given("Set the base uri of the service now api")
	public void set_the_base_uri_of_the_service_now_api() {
		request = given().baseUri("https://dev262949.service-now.com");
	}

	@Given("Set the base path of the service now api")
	public void set_the_base_path_of_the_service_now_api() {
		request.basePath("/api/now/table");
	}

	@Given("Set the basic Auth of the service now api")
	public void set_the_basic_auth_of_the_service_now_api() {
		request.auth().basic("admin", "vW0eDfd+A0V-");
	}

	@When("Set the header {string} key and header {string} value")
	public void set_the_header_key_and_header_value(String key, String value) {
		request.header(key, value);
	}

	@When("add the create incident request body as string")
	public void add_the_create_incident_request_body_as_string() {
		payload = """
				{
				 "description": "Create a new record using Post",
				 "short_description": "SDET SEP 2024"
				}""";
	}

	@When("hit the post http method")
	public void hit_the_post_http_method() {
		response = request.when().body(payload).post("/incident");
	}

	@When("/^create the incident record with description (.*) in the request body$/")
	public void create_the_incident_record_with_description_api_session_jan_in_the_request_body(String description) {
		pojo.setDescription(description);
	}

	@When("/^create the incident record with short description (.*) in the request body$/")
	public void create_the_incident_record_with_shaort_description_adding_new_record_using_post_pojo_object_in_the_request_body(String shortDescription) {
		pojo.setShort_description(shortDescription);
	}

	@When("hit the post http method with request body as the pojo object")
	public void hit_the_post_http_method_with_request_body_as_the_pojo_object() {
		response = request.when()
				          .body(pojo)
				          .post("/incident");
	}	

	@Then("validate the status code and status line")
	public void validate_the_status_code_and_status_line() {
		response.then().assertThat().statusCode(201).statusLine(Matchers.containsString("Created"));
	}

}