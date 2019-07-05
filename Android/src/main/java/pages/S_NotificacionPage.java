package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class S_NotificacionPage extends BasePage {

	@FindBy(id = "android:id/statusBarBackground")
	private WebElement barraNotificaciones;

	@FindBy(className = "android.widget.TextView")
	private List<WebElement> txtNotificaciones;
	
	@FindBy(id = "android:id/big_text")
	private WebElement txtNotificacionesBig;

	@FindBy(id = "com.android.systemui:id/notification_stack_scroller")
	private WebElement containerNotificaciones;

	@FindBy(id = "ar.com.portalsalud.osde:id/versionName")
	private WebElement labelTxtVersion;

	@FindBy(id = "ar.com.portalsalud.osde:id/tv_rights_reserved")
	private WebElement labelTxtOSDE;

	public void abrirNotificacion() {
		try {
			encontrarNotificacionInvitacion().click();
			Log.info("Se abrio correctamente la notificacion");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al abrir la notificacion");
		}
	}
	
	public WebElement encontrarNotificacionInvitacion() {
		WebElement notificacion = null;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(containerNotificaciones));
			for (WebElement notification : txtNotificaciones) {
				Log.info(notification.getText());
				if (notification.getText().contains("OSDE Consulta") || notification.getText().contains("OSDE CMOnLine.") ) {
							notificacion = notification;
							Log.info("Se encontro la notificacion");	
							break;
						}
					}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("No se encontro la notificacion");
		}
		return notificacion;
	}
	
	
	
	public void abrirPanelNotificacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(barraNotificaciones));
			driver.openNotifications();
			Log.info("Se abre el panel de notificaciones");
		} catch (Exception e) {
			Log.info("Fallo al abrir el panel de notificaciones");
		}
	}
	
}
