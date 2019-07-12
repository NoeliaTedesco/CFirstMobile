package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePageMobile;
import helpers.PageHelperMobile;
import log.LogMobile;

public class S_NotificacionPage extends BasePageMobile {

	@FindBy(id = "android:id/statusBarBackground")
	private WebElement barraNotificaciones;

	@FindBy(className = "android.widget.TextView")
	private List<WebElement> txtNotificaciones;
	
	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and contains(@text, 'OSDE')]")
	private WebElement notificacionOSDE;

	@FindBy(id = "com.android.systemui:id/notification_stack_scroller")
	private WebElement containerNotificaciones;


	public void abrirNotificacion() {
		try {
			encontrarNotificacionInvitacion().click();
			LogMobile.info("Se abrio correctamente la notificacion");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al abrir la notificacion");
		}
	}

	@SuppressWarnings("unchecked")
	public WebElement encontrarNotificacionInvitacion() {
		WebElement notificacion = null;
		waitFluent.until(ExpectedConditions.elementToBeClickable(notificacionOSDE));
		List<WebElement> element = new ArrayList<WebElement>();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(containerNotificaciones));
				for (WebElement notification : txtNotificaciones) {
					if (notification.getText().contains("OSDE Consulta")
							|| notification.getText().contains("OSDE CMOnLine.")) {
						element.add(notification);
						LogMobile.info("Se encontro la notificacion");
						break;
					}
				}
				
				if (!element.isEmpty()) {
					notificacion = element.get(element.size() - 1);
				}
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("No se encontro la notificacion");
		}
		return notificacion;
	}

	public void abrirPanelNotificacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(barraNotificaciones));
			driver.openNotifications();
			LogMobile.info("Se abre el panel de notificaciones");
		} catch (Exception e) {
			LogMobile.info("Fallo al abrir el panel de notificaciones");
		}
	}

}
