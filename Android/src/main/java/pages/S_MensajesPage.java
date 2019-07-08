package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class S_MensajesPage<WebElements> extends BasePage {

	@FindBy (xpath = "(//*[contains(@text, 'https://bpr3.test-app.link')])[last()]")
	private WebElement txtMensaje;
	
	public void abrirLinkInvitacion() {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtMensaje));
			txtMensaje.click();
			Log.info("Se abrio correctamente el link de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al abrir el link de la invitacion");
		}
	}
}
