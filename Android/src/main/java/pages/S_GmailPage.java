package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class S_GmailPage extends BasePage {

	@FindBy(id = "com.google.android.gm:id/subject_and_folder_view")
	private WebElement asuntoCorreo;

	@FindBy(id = "com.google.android.gm:id/sender_name")
	private WebElement remitenteCorreo;

	@FindBy(xpath = "(//*[contains(@text, 'Mostrar texto ')])[last()]")
	private WebElement txtCitado;

	@FindBy(className = "android.view.View")
	private List<WebElement> txtCorreo;

	@FindBy(id = "com.google.android.gm:id/conversation_container")
	private WebElement containerCorreo;

	@FindBy(id = "ar.com.portalsalud.osde:id/versionName")
	private WebElement labelMostrarTextoCitado;

	@FindBy(className = "android.webkit.WebView")
	private WebElement layoutCorreo;

	@FindBy(xpath = "//*[@package = 'com.google.android.gm']")
	private List<WebElement> correosGmail;

	public void abrirLinkInvitacion() {
		try {
			visibleSeMuestraTextoCitado();
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
			visibleBandejaEntrada();
			wait.until(ExpectedConditions.elementToBeClickable(containerCorreo));
			for (WebElement txt : txtCorreo) {
				if (txt.getText().equals("aquí")) {
					linkInvitacion = txt;
					PageHelper.ScrollToElementMobile(linkInvitacion);
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

	public void visibleSeMuestraTextoCitado() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(txtCitado));
			txtCitado.click();
			Log.info("Se hace clic en el boton Muestra texto citado");
		} catch (Exception e) {
			Log.info("Falla al hacer clic en el boton muestra texto citado");
		}
	}

	public void visibleBandejaEntrada() {
		try {
			// wait.until(ExpectedConditions.attributeContains(element, attribute, value))
			wait.until(ExpectedConditions.visibilityOfAllElements(correosGmail));
			for (WebElement correo : correosGmail) {
				if (correo.getAttribute("content-desc").contains("OSDE Consulta Médica OnLine")) {
					correo.click();
				}

			}
			Log.info("Se abre el gmail");
		} catch (Exception e) {
			Log.info("No es visible la Bandeja de Entrada");
		}
	}

}
