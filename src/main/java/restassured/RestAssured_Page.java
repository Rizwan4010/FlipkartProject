package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class RestAssured_Page {

	@Test
	public void RestAssured() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		int actualvalue = response.getStatusCode();
		Assert.assertEquals(actualvalue, 200);
	}
	
	@Test
	public void Rest2() {
		baseURI="https://reqres.in/api/";
		given().get("users?page=2")
		.then().statusCode(200);
	}
	
	public static void main(String[] args) {
		RestAssured_Page page = new RestAssured_Page();
		page.RestAssured();
		page.Rest2();
	}
}
