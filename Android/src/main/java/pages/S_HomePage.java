package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import log.Log;

public class S_HomePage extends BasePage {

	@FindBy (id = "ar.com.portalsalud.osde:id/callNow1Btt")
	private WebElement btnPrimerTelefono;

	@FindBy(id = "ar.com.portalsalud.osde:id/callNow2Btt")
	private WebElement btnSegundoTelefono;

	@FindBy(id = "ar.com.portalsalud.osde:id/tv_communicate")
	private WebElement labelTxtAcceder;

	@FindBy(id = "ar.com.portalsalud.osde:id/tv_communicate_info")
	private WebElement labelTxtServicioUrgencias;

	@FindBy(id = "ar.com.portalsalud.osde:id/versionName")
	private WebElement labelTxtVersion;
	
	@FindBy(id = "ar.com.portalsalud.osde:id/tv_rights_reserved")
	private WebElement labelTxtOSDE;
	

	public  Boolean esVisiblePrimerTelefono() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnPrimerTelefono));
			esVisible = btnPrimerTelefono.isDisplayed();
			Log.info("Se obtuvo el elemento btnPrimerTelefono");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			Log.info("Fallo al obtener el elemento btnPrimerTelefono");
		}
		return esVisible;
	}
	
	
	public void clicPrimerTelefono() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnPrimerTelefono));
			action.moveToElement(btnPrimerTelefono).click().build().perform();
			Log.info("Se hizo click en el boton btnPrimerTelefono");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnPrimerTelefono");
			e.printStackTrace();
		}
	}

	public void clicSegundoTelefono() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSegundoTelefono));
			action.moveToElement(btnSegundoTelefono).click().build().perform();
			Log.info("Se hizo click en el elemento btnSegundoTelefono");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnSegundoTelefono");
			e.printStackTrace();
		}
	}

	public  Boolean esVisibleSegundoTelefono() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnSegundoTelefono));
			esVisible = btnSegundoTelefono.isDisplayed();
			Log.info("Se obtuvo el elemento btnSegundoTelefono");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSegundoTelefono");
		}
		return esVisible;
	}



	public Boolean esVisibleLabelTxtAcceder() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(labelTxtAcceder));
			esVisible = labelTxtAcceder.isDisplayed();
			Log.info("Se obtuvo el elemento labelTxtAcceder");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento labelTxtAcceder");
		}
		return esVisible;
	}

	public Boolean esVisibleLabelTxtServicio() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(labelTxtServicioUrgencias));
			esVisible = labelTxtServicioUrgencias.isDisplayed();
			Log.info("Se obtuvo el elemento labelTxtServicioUrgencias");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento labelTxtServicioUrgencias");
		}
		return esVisible;
	}
	
	public Boolean esVisibleLabelTxtVersion() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(labelTxtVersion));
			esVisible = labelTxtVersion.isDisplayed();
			Log.info("Se obtuvo el elemento labelTxtVersion");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento labelTxtVersion");
		}
		return esVisible;
	}
	
	public Boolean esVisibleLabelTxtOSDE() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(labelTxtOSDE));
			esVisible = labelTxtOSDE.isDisplayed();
			Log.info("Se obtuvo el elemento labelTxtOSDE");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento labelTxtOSDE");
		}
		return esVisible;
	}

	public  String recuperarPrimerTelefono() {
		String texto = null;
		try {
			texto = btnPrimerTelefono.getText();
			Log.info("Se recupera texto del elemento");
		} catch (Exception e){
			Log.info("Fallo el recuperar el texto del elemento");
		}
		return texto;
	}
	
	public  String recuperarSegundoTelefono() {
		String texto = null;
		try {
			texto = btnSegundoTelefono.getText();
			Log.info("Se recupera texto del elemento");
		} catch (Exception e){
			Log.info("Fallo el recuperar el texto del elemento");
		}
		return texto;
	}
	
	public String recuperarPrimerTexto() {
		String texto = null;
		try {
			texto = labelTxtAcceder.getText();
			Log.info("Se recupera texto del elemento");
		} catch (Exception e){
			Log.info("Fallo el recuperar el texto del elemento");
		}
		return texto;
	}
	
	public String recuperarSegundoTexto() {
		String texto = null;
		try {
			texto = labelTxtServicioUrgencias.getText();
			Log.info("Se recupera texto del elemento");
		} catch (Exception e){
			Log.info("Fallo el recuperar el texto del elemento");
		}
		return texto;
	}
	
	public String recuperarVersion() {
		String texto = null;
		try {
			texto = labelTxtVersion.getText();
			Log.info("Se recupera texto del elemento");
		} catch (Exception e){
			Log.info("Fallo el recuperar el texto del elemento");
		}
		return texto;
	}
	
	public String recuperarTxtOSDE() {
		String texto = null;
		try {
			texto = labelTxtOSDE.getText();
			Log.info("Se recupera texto del elemento");
		} catch (Exception e){
			Log.info("Fallo el recuperar el texto del elemento");
		}
		return texto;
	}

}
