package Day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class byUsingPathURL {

	@Test
	void verifyByPathQueryParameter()
	{
		given()
			.pathParam("mypath", "users")
			.queryParam("page", "2")
			.queryParam("id", "5")
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
