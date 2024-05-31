package datadriven;

public class DataProviderUtility {

	public static Object [][] dwsLogin() {
		Object [][] obj = new Object[2][2];
		obj[0][0] = "admin01@gmail.com";
		obj[0][1] = "admin01";
		obj[1][0] = "admin02@gmail.com";
		obj[1][1] = "admin02";
		
		return obj;
	}
}
