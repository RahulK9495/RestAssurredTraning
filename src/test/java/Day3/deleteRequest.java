package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteRequest {
	

	@Test
	void deletRecords(ITestContext context)
	{
		int id = (Integer) context.getAttribute("id");

		
		given()
			.pathParam("Order_id", id)
		.when()
			.delete("https://petstore.swagger.io/v2/store/order/{Order_id}")
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
