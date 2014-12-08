package Controller;
import JsonClasses.*;

public class login {

	public void loginToJson(String username, String password, boolean admin){
		
		AuthUser auth = new AuthUser();
		
		auth.setAuthUserEmail(username);
		auth.setAuthUserPassword(password);
		auth.setAuthUserIsAdmin(admin);

	}
	
}