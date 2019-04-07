package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import log.Log;

public class M_LoginPage extends BasePage {

	@FindBy (id = "email")
	private WebElement fieldUsser;
	
	@FindBy (id = "password")
	private WebElement fieldPass;
	
	@FindBy (id = "submit")
	private WebElement btnIngresar;
	
	
	public void loginUsser(String usser, String password) {
		try {
			fieldUsser.click();
			fieldUsser.sendKeys(usser);
			fieldPass.click();
			fieldPass.sendKeys(password);
			btnIngresar.click();
		Log.info("Se inicio sesión correctamente");
		} catch (Exception e) {
			Log.info("Fallo el inicio de sesión, usuario o contraseña incorrecta");
			e.printStackTrace();
		}
		

	}
	
	
}
