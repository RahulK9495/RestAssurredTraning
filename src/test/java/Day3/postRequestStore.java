package Day3;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.json.JSONObject;

public class postRequestStore {

	
	@Test
	public void addOrder(ITestContext context)
	{
		Random rand = new Random();
		int ran1 = rand.nextInt(50);
		
		JSONObject data = new JSONObject();
		data.put("id", ran1);
		data.put("petId", "3");
		data.put("quantity", "2");
		data.put("shipDate", "2024-03-20T09:42:53.510Z");
		data.put("status", "placed");
		data.put("complete", "true");
		
		Response resp =given()
			.body(data.toString())
			.contentType("application/json")
		.when()
			.post("https://petstore.swagger.io/v2/store/order");
		
		System.out.println(resp.statusCode());
		int id= resp.jsonPath().get("id");
		System.out.println(id);
		
		context.setAttribute("id", id);
		
		
	}
}
