package Day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesTesting {

	//@Test
	void checkCookies()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.statusCode(200)
			.cookie("AEC","Ae3NU9Ne6BLEC-ihQksjWuxTIau0mg8dyYe7Nv75u0JkgVAMEJmx7emK3w")
			.log().all();
		
		
	}
	@Test
	void getCookies()
	{
		Response resp=given()
		
		.when()
			.get("https://www.google.com/");
		
		String cookie=resp.getCookie("AEC");
		System.out.println(cookie);
		
		Map<String,String> cookies=resp.getCookies();
	
		
		for(String K:cookies.keySet())
		{
			String values=resp.getCookie(K);
			System.out.println(K +"        "+values);
		}
	}
	
	
}
