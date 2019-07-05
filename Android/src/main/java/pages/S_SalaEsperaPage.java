package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class S_SalaEsperaPage extends BasePage {

	@FindBy(id = "ar.com.portalsalud.osde:id/bannerTitle")
	private List<WebElement> txtSalaEspera;

	@FindBy(id = "ar.com.portalsalud.osde:id/callCancelWaiting")
	private WebElement btnCancelarVC;

	@FindBy(id = "android:id/message")
	private WebElement popUpCancelar;

	@FindBy(id = "android:id/button2")
	private WebElement popUpCancelarNO;

	@FindBy(id = "android:id/button1")
	private WebElement popUpCancelarSI;

	@FindBy(id = "ar.com.portalsalud.osde:id/callEnterRoom")
	private WebElement btnIngresarConsultorio;

	@FindBy(id = "ar.com.portalsalud.osde:id/callCancel")
	private WebElement btnCancelarConsulta;

	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement txtPermitirPermisos;

	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	private WebElement txtRechazarPermisos;

	public void aceptarLlamadaConsultorio() {
		try {
			wait.until(ExpectedConditions.visibilityOf(btnIngresarConsultorio));
			if (btnIngresarConsultorio.isEnabled()) {
				btnIngresarConsultorio.click();
				wait.until(ExpectedConditions.stalenessOf(btnIngresarConsultorio));
			}
			Log.info("Se ingresa correctamente al consultorio");
		} catch (Exception e) {
			Log.info("No se ingresa correctamente al consultorio");
		}
	}

	public void aceptarPermisos() {
		try {
			while (PageHelper.elementStillPresent(txtPermitirPermisos)) {
				txtPermitirPermisos.click();
			}
			Log.info("Se aceptan los permisos");
		} catch (Exception e) {
			Log.info("Falla el aceptar los permisos");
		}
	}
	
}
