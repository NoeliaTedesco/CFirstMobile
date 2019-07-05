package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import io.appium.java_client.android.AndroidElement;
import log.Log;

public class S_GmailPage extends BasePage {

	@FindBy(id = "com.google.android.gm:id/subject_and_folder_view")
	private WebElement asuntoCorreo;

	@FindBy(id = "com.google.android.gm:id/sender_name")
	private WebElement remitenteCorreo;

	@FindBy(className = "android.view.View")
	private List<WebElement> txtCorreo;

	@FindBy(id = "com.google.android.gm:id/conversation_container")
	private WebElement containerCorreo;

	@FindBy(id = "ar.com.portalsalud.osde:id/versionName")
	private WebElement labelMostrarTextoCitado;

	@FindBy(className = "android.webkit.WebView")
	private WebElement layoutCorreo;
	
	public void abrirLinkInvitacion() {
		try {
			visibleMostrarTextoCitado();
			encontrarLinkInvitacion().click();
			wait.until(ExpectedConditions.invisibilityOf(containerCorreo));
			Log.info("Se abrio correctamente el link de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al abrir el link de la invitacion");
		}
	}

	public WebElement encontrarLinkInvitacion() {
		WebElement linkInvitacion = null;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(containerCorreo));
			for (WebElement txt : txtCorreo) {
				if (txt.getText().equals("aquí")) {
					linkInvitacion = txt;
					PageHelper.ScrollToBottomMobile(linkInvitacion);
					break;
				}
			}
			Log.info("Se encontro el link de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("No se encontro el link de la invitacion");
		}
		return linkInvitacion;
	}

	public void visibleMostrarTextoCitado() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(containerCorreo));
			for (WebElement txt : txtCorreo) {
				if (txt.getText().equals("Mostrar texto citado")) {
					txt.click();
				}
			}
			Log.info("Se hizo clic en el texto Mostrar Texto citado");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("No se encontro el texto Mostrar Texto citado");

		}
	}

}
