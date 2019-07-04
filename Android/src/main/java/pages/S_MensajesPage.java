package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import io.appium.java_client.MobileElement;
import log.Log;

public class S_MensajesPage<WebElements> extends BasePage {

	@FindBy(xpath = "//*[contains(text(), 'https://bpr3.test-app.link')][last()]")
	private WebElement txtMensaje;

	
	public void abrirLinkInvitacion() {
		try {
			encontrarLinkInvitacion().click();
			wait.until(ExpectedConditions.invisibilityOf(txtMensaje));
			Log.info("Se abrio correctamente el link de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al abrir el link de la invitacion");
		}
	}

	public WebElement encontrarLinkInvitacion() {
		WebElement linkInvitacion = null;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(txtMensaje));
			String txt = txtMensaje.getText().substring(36, 73);	
			WebElement link = driver.findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", txt));
			link.click();
			Log.info("Se encontro el link de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("No se encontro el link de la invitacion");
		}
		return linkInvitacion;
	}

}
