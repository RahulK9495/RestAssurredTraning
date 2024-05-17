package Day2;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class methodsOfPost {

	@Test(priority=1)
	void postAPIusingJSONobject()
	{
		JSONObject jb=new JSONObject();
		jb.put("name", "Rahul");
		jb.put("job","Trainer");
				
		given()
			.contentType("application/json")
			.body(jb.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.body("name",equalTo("Rahul"));
	}
}
