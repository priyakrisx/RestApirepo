package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class GetCallBDD {
	
	
	
	@Test
	public void test_numberofCircuitsfor2017Season() {
		
		/*
		 * given(). when(). then(). assert()
		 */
		given().	
		
		when().
		get("https://ergast.com/api/f1/2017/circuits.json").
		
		then().
		assertThat().
		statusCode(200).
		and().
		assertThat().body("MRData.CircuitTable.Circuits[12].circuitId", equalTo("sepang")).
		and().
		header("content-length",equalToCompressingWhiteSpace("4551"));
	}
	

}
