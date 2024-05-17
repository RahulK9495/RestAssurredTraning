import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPrequests {

	int id;
//	@Test(priority=1)
	void getUsers()
	{
			given()
			
			.when()
				.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(200)
				.body("page", equalTo(2))
				.log().all();
	}
	
	@Test(priority=2)
	void createUser()
	{
		HashMap data1 =new HashMap();
		data1.put("name", "Rahul");
		data1.put("job","Trainer");
		
		id=given()
			.contentType("application/json")
			.body(data1)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	@Test(priority=3, dependsOnMethods= {"createUser"})
	void updateUser()

	{
		HashMap data2 =new HashMap();
		data2.put("name", "akshay");
		data2.put("job","professional");
		
		given()
			.contentType("application/json")													
			.body(data2)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	
	}
	@Test(priority=3)
	void deletUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
}
