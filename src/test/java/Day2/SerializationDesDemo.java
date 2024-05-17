package Day2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDesDemo {

	public static void main(String[] args) throws JsonProcessingException {

		Student std = new Student();
		std.setRoll(10);
		std.setName("Rahul");
		std.setAddress("Pune");
		
		ObjectMapper obj=new ObjectMapper();
		
		String json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(std);

		System.out.println(json);
	}
	
}
