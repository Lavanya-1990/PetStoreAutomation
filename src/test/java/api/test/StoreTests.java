package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoints;
import api.payload.Store;
import api.payload.User;

public class StoreTests {

	Faker faker;
	Store storePayload;
	public Logger logger;
	
	@BeforeClass
	public void SetUpdata()
	{
		
		faker =new Faker();
		storePayload = new Store();
		
		storePayload.setId(2);
		storePayload.setPetId(6);
		storePayload.setQuantity(20);
		storePayload.setShipDate("2024-03-05T11:47:52.365Z");
		storePayload.setStatus("placed");
		storePayload.setComplete(true);
		
		//logs
				logger = LogManager.getLogger(this.getClass());
		
	}
				@Test(priority=1)
				public void	testPlaceOrder()
				{
					logger.info("**********Placing the order*********");
					Response response=StoreEndpoints.PlaceOrder(storePayload);
					response.then().log().all();
					Assert.assertEquals(response.getStatusCode(),200);
					logger.info("**********order is placed*********");
					}
				
				@Test(priority=2)
				public void	testGetOrder()
				{
					logger.info("*********Getting the order details**********");
					Response response = StoreEndpoints.GetOrder(this.storePayload.getId());
					response.then().log().all();
					Assert.assertEquals(response.getStatusCode(),200);
					logger.info("*********order details fetched**********");
					}
				
				@Test(priority=3)
				public void	testDeleteOrder()
				{
					logger.info("*********deleting the order**********");
					Response response=	StoreEndpoints.DeleteOrder(this.storePayload.getId());
					response.then().log().all();
					Assert.assertEquals(response.getStatusCode(),200);
					logger.info("*********order deleted**********");
					}				
}
