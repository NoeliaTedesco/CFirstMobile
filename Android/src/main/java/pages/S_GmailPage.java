package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePageMobile;
import helpers.PageHelperMobile;
import log.LogMobile;

public class S_GmailPage extends BasePageMobile {

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

	@FindBy(xpath = "//*[@class = 'android.webkit.WebView' and @index= '0']")
	private WebElement layoutCorreo;

	@FindBy(xpath = "//*[@package = 'com.google.android.gm' and @class = 'android.view.View']")
	private List<WebElement> correosGmail;
	

	public void abrirLinkInvitacion() {
		try {
			visibleBandejaEntrada();
			visibleSeMuestraTextoCitado();
			encontrarLinkInvitacion().click();
			LogMobile.info("Se abrio correctamente el link de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al abrir el link de la invitacion");
		}
	}

	public WebElement encontrarLinkInvitacion() {
		WebElement linkInvitacion = null;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(containerCorreo));
			for (WebElement txt : txtCorreo) {
				if (txt.getText().equals("aquí")) {
					linkInvitacion = txt;
					PageHelperMobile.ScrollDown();
					LogMobile.info("Se encontro el link de la invitacion");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("No se encontro el link de la invitacion");
		}
		return linkInvitacion;
	}

	public void visibleSeMuestraTextoCitado() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(txtCitado));
			txtCitado.click();
			LogMobile.info("Se hace clic en el boton Muestra texto citado");
		} catch (Exception e) {
			LogMobile.info("No se muestra el boton para mostrar texto citado");
		}
	}

	public void visibleBandejaEntrada() {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(correosGmail));
			for (WebElement correo : correosGmail) {
				if (correo.getAttribute("name").contains("OSDE Consulta M�dica OnLine")) {
					correo.click();
					LogMobile.info("Se abre el gmail");
					break;
				}

			}
		} catch (Exception e) {
			LogMobile.info("No es visible la Bandeja de Entrada");
		}
	}

}
