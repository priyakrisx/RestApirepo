package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;

public class lotto {

	@Test
	public void testLotto_1() {
		
		expect().statusCode(HttpStatus.SC_OK). //Status code = 200
		given().get("https://lotto.ter.app/api/latest-results").

				then().assertThat()
				.body("data['2021-03-01'].first[0]", equalTo("835538"));
		

	}

	@Test
	public void testLotto_2() {
	
		String res = given().
		get("https://lotto.ter.app/api/latest-results").

				then().extract().body().asPrettyString();
		
		System.out.println("res="+res);
				
		

	}
	@Test
	public void AuthenticationBasics()
	{
		given().auth()
		  .basic("user1", "user1Pass")
		  .when()
		  .get("http://localhost:8080/spring-security-rest-basic-auth/api/foos/1")
		  .then()
		  .assertThat()
		  .statusCode(HttpStatus.SC_OK);
	}



}
