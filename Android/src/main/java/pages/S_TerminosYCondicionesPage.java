package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import log.Log;

public class S_TerminosYCondicionesPage extends BasePage {

	@FindBy (id = "android:id/message")
	private WebElement popUpNotificacion;
	
	@FindBy (id = "android:id/button2")
	private WebElement btnNotificacionNo;
	
	@FindBy (id = "android:id/button1")
	private WebElement btnNotificacionSi;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/signupTermsCheckbox")
	private WebElement checkTerminos;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/callBtt")
	private WebElement btnIngresarConsultorio;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/signupTerms")
	private WebElement btnTerminosCondiciones;
	
	public void quitarPopUpNotificacion() {
		try {
			wait.until(ExpectedConditions.visibilityOf(popUpNotificacion));
			if (popUpNotificacion.isDisplayed()) {
				btnNotificacionNo.click();
				wait.until(ExpectedConditions.elementToBeClickable(checkTerminos));
			}
			Log.info("Se quita el mensaje para habilitar notificaciones");
		} catch (Exception e){
			Log.info("No se muestra el mensaje para habilitar notificaciones");
		}
	}
	
	public void aceptarTerminosYCondiciones() {
		try {
			wait.until(ExpectedConditions.visibilityOf(checkTerminos));
			checkTerminos.click();
			Log.info("Se aceptan los terminos y condiciones");
		} catch (Exception e){
			Log.info(e.getMessage());
			Log.info("Falla el aceptar los terminos y condiciones");
		}
		
	}
	
	public void clicIngresarConsultorio() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnIngresarConsultorio));
			btnIngresarConsultorio.click();
			Log.info("Se ingresa correctamente al consultorio");
		} catch (Exception e){
			Log.info(e.getMessage());
			Log.info("Falla el ingresar al consultorio");
		}
		
	}
	
	public void leerTerminosCondiciones() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnTerminosCondiciones));
			btnTerminosCondiciones.click();
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Falla el abrir los terminos y condiciones");
		}
	}
	
}
