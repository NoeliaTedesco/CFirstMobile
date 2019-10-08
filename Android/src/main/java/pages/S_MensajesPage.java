package pages;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePageMobile;
import helpers.PageHelper;
import helpers.PageHelperMobile;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import log.LogMobile;

public class S_MensajesPage<WebElements> extends BasePageMobile {

	@FindBy (xpath = "(//*[contains(@text, 'https://bpr3.test-app.link/')])[last()]")
	private WebElement txtMensaje;

	@FindBy (className = "android.widget.LinearLayout")
	private List<WebElement> divMensaje;
	
	
	public void abrirLinkInvitacion() {
		try {
			PageHelper.waitImplicit();
			if (driver.getCurrentPackage().equals("com.google.android.apps.messaging")) {
				wait.until(ExpectedConditions.elementToBeClickable(txtMensaje));
				txtMensaje.click();
				if (txtMensaje.isDisplayed()) {
					actionTouch.tap(PointOption.point(366, 1459)).perform();
					
				}
			}
			LogMobile.info("Se abrio correctamente el link de la invitacion.");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al abrir el link de la invitacion");
		}
	}
}
