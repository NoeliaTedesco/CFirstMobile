package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

	@FindBy(id = "ar.com.portalsalud.osde:id/btn_accept_waiting_time")
	private WebElement btnAceptarTiempo;

	public void aceptarLlamadaConsultorio() {
		try {
			while (!PageHelper.elementStillPresent(btnIngresarConsultorio)) {
				waitFluent.until(ExpectedConditions.elementToBeClickable(btnIngresarConsultorio));
			}
			if (btnIngresarConsultorio.isEnabled()) {
				btnIngresarConsultorio.click();
				aceptarPermisos();
			}
			Log.info("Se ingresa correctamente al consultorio");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("No se ingresa correctamente al consultorio");
		}
	}
	
	public boolean esVisibleBtnIngresar() {
		boolean esVisible = false;
		try {
			esVisible = btnIngresarConsultorio.isEnabled();
			Log.info("Se encontro el elemento btnIngresarConsultorio");
		}catch (Exception e) {
			Log.info("No se encontro el elemento btnIngresarConsultorio");
		}
		return esVisible;
	}

	public void aceptarPermisos() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(txtPermitirPermisos));
			while (PageHelper.elementStillPresent(txtPermitirPermisos)) {
				txtPermitirPermisos.click();
			}
			Log.info("Se aceptan los permisos");
		} catch (Exception e) {
			Log.info("Falla el aceptar los permisos");
		}
	}

	public void aceptarTiempoEspera() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAceptarTiempo));
			btnAceptarTiempo.click();
			Log.info("Se acepta el tiempo de espera");
		} catch (Exception e) {
			Log.info("Falla el aceptar el tiempo de espera");
		}

	}
}
