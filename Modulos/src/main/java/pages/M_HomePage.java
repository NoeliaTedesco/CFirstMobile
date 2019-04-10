package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class M_HomePage extends BasePage {

	@FindBy(xpath = "//button[@ng-click='homeCtrl.guardiaAccederGo()']")
	private WebElement menuAtenderVideoconsultas;

	@FindBy(xpath = "//a[@id='btSalir']")
	private WebElement btnSalir;

	@FindBy(xpath = "//div[@id='navbar']/ul/li[2]")
	private WebElement btnCambiarContrasena;

	@FindBy(xpath = "//*[@id='navbar']/ul/li[1]")
	private WebElement labelUsuario;

	public void enterAttentions() {
		wait.until(ExpectedConditions.elementToBeClickable(menuAtenderVideoconsultas));
		menuAtenderVideoconsultas.click();
	}

	public void signOff() {
		wait.until(ExpectedConditions.visibilityOf(btnSalir));
		wait.until(ExpectedConditions.elementToBeClickable(btnSalir));
		btnSalir.click();
	}

	public String getUsserLogged() {
		return labelUsuario.getAttribute("textContent");
	}

}
