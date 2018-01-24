package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest {
	@Test
	public void testValidLogin(){
		LoginPage l = new LoginPage(driver);
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		//enter username
		l.setUsername(username);
		// enter passsword
		l.setPassword(password);
		//CLick on login button
		l.clickLogin();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("acti"));
		
		
		
		}
}
