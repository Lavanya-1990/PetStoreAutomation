package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform Create, Read, Update, Delete requests the user API 
public class UserEndPoints2 {
	
	//method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load Properties File
		return routes;
	}
	
	
	
	public static Response createUser(User payload) {
		
		String posturl = getURL().getString("post_url");
		Response response=given()
			.contentType("application/json")
			.accept("application/json")
			.body(payload)
			
		.when()
			.post(posturl);
		
		return response;
	}

	
	public static Response readUser(String username) {
		
		
		String geturl = getURL().getString("get_url");
		Response response=given()
			  .contentType("application/json")
			    .accept("application/json")
				.pathParam("username",username)
			
		.when()
			.get(geturl);
		
		return response;
	}

	public static Response updateUser(String username,User payload) {
		
		String updateurl = getURL().getString("update_url");
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",username)
			.body(payload)
			
		.when()
			.put(updateurl);
		
		return response;
	}
	
public static Response deleteUser(String username) {
		
	String deleteurl = getURL().getString("delete_url");	
	Response response=given()
				.pathParam("username",username)
			
		.when()
			.delete(deleteurl);
		
		return response;
	}
	
	
	
}
