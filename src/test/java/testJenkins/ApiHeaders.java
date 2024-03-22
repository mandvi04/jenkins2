package testJenkins;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiHeaders {

	@Test
	public void getmethod() {
		RestAssured.baseURI="https://reqres.in";
		//Static import concept
		//method chaining
		Response response = given()
	.when()
	.get("/api/users?page=2")
	.then()
	.extract()
	.response();
		
		System.out.println(response);
		String resp = response.asPrettyString();
		System.out.println(resp);
		JsonPath js= response.jsonPath();
		String firstNameValue=js.getString("data.first_name");
		System.out.println(firstNameValue);
		String lastNameValue=js.getString("data.last_name");
		System.out.println(lastNameValue);
}}
