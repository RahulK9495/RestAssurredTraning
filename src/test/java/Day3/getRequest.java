package Day3;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class getRequest {

	
	@Test
	void getRecord(ITestContext context)
	{
		int id = (Integer) context.getAttribute("id");
		
		given()
			.pathParam("Order_id", id)
		.when()
			.get("https://petstore.swagger.io/v2/store/order/{Order_id}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
