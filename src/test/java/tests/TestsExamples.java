package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.json.JSONObject.*;

import org.json.simple.JSONObject;

public class TestsExamples {

	@Test
	public void test_1() {

		Response response = get("https://reqres.in/api/users/23");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		Assert.assertEquals(response.getStatusCode(), 404);

	}

	@Test
	public void test_2() {

		Response response = get("https://reqres.in/api/users?page=1");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getHeader("content-type"));
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void test_3() {

		given().get("https://reqres.in/api/users?page=2").then().assertThat().body("data[1].email",
				equalToIgnoringCase("lindsay.ferguson@reqres.in"));

	}

	@Test

	public void postexample_test_4() {

		JSONObject req = new JSONObject();
		req.put("name", "Raghav");
		req.put("job", "Teacher");
		String res= given().body(req.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).and()
				.extract().response().asPrettyString();
		System.out.println(res);

	}

	@Test

	public void putexample_test_5() {

		JSONObject req = new JSONObject();
		req.put("name", "Raghav");
		req.put("job", "Teacher");
		given().body(req.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();

	}
}
