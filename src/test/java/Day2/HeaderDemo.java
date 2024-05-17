package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {
	@Test
	void testHeader()
	{
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip");
//			.log().all();
	}
	
	@Test
	void getHeaders()
	{
		Response resp=given()
		.when()
			.get("https://www.google.com/");
	
//		String header=resp.getHeader("Content-Type");
//		System.out.println(header);
		
		Headers allheaders=resp.getHeaders();
		
		for(Header hd:allheaders)
		{
			System.out.println(hd.getName()+"          "+hd.getValue());
		}
	}

	
}
