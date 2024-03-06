package api.endpoints;

public class Routes {
	
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store module
	 // here you will create store module urls
	public static String Storepost_url=base_url+"/store/order";
	public static String Storeget_url=base_url+"/store/order/{id}";
	public static String Storedelete_url=base_url+"/store/order/{id}";
	
	//Pet module
		// Here you will create pet module urls
	
	

}
