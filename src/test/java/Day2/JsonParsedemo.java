package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonParsedemo {
	
	@Test
	void parseJsonObject()
	{
		Response res=given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/data");
//		.then()
//			.statusCode(200)
//			.header("Content-Type", "application/json")
//			.log().all();
//			.body("data[2].year", equalTo(2002));
	
		JSONObject jo = new JSONObject(res.asString());
		
		for(int i=0; i<jo.getJSONArray("data").length();i++)
		{
			String nameofdata= jo.getJSONArray("data").getJSONObject(i).get("name").toString();
			System.out.println(nameofdata);
		}
				
	
	}
}
