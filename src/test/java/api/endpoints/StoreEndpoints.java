package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndpoints {

	public static Response PlaceOrder(Store payload)
	{	
		Response response =given()
			.contentType("application/json")
			.accept("application/json")
			.body(payload)
			
		.when()
			.post(Routes.Storepost_url);
		
		return response ;
	}
	
	public static Response GetOrder(int id) {
		
		Response response=given()
			  .contentType("application/json")
			    .accept("application/json")
				.pathParam("id",id)
			
		.when()
			.get(Routes.Storeget_url);
		
		return response;
	}
	
	public static Response DeleteOrder(int id){
			
			Response response = given()
				.accept("application/json")
				.pathParam("id",id)
				
			.when()
				.delete(Routes.Storedelete_url);
				
			return response;
			
		}
}
