package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePageMobile;
import helpers.PageHelperMobile;
import log.LogMobile;

public class S_VideoconsultaPage extends BasePageMobile {

	@FindBy(id = "ar.com.portalsalud.osde:id/btn_chat")
	private WebElement btnChat;

	@FindBy(id = "ar.com.portalsalud.osde:id/btn_more")
	private WebElement btnMas;

	@FindBy(id = "ar.com.portalsalud.osde:id/hideCameraBtt")
	private WebElement btnCamara;

	@FindBy(id = "ar.com.portalsalud.osde:id/mutePublisherBtt")
	private WebElement btnMicrofono;

	@FindBy(id = "ar.com.portalsalud.osde:id/hangupBtt")
	private WebElement btnFinalizar;

	@FindBy(id = "android:id/button2")
	private WebElement btnCancelarFinalizar;

	@FindBy(id = "android:id/button1")
	private WebElement btnAceptarFinalizar;

	@FindBy(id = "android:id/message")
	private WebElement popUpFinalizar;

	@FindBy(id= "ar.com.portalsalud.osde:id/callView")
	private WebElement screenView;
	
	
	public void clicIBtnChat() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChat));
			btnChat.click();
			LogMobile.info("Se hace clic en el elemento btnChat");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el elemento btnChat");
		}
		
	}
	
	public void clicIBtnMas() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnMas));
			btnMas.click();
			LogMobile.info("Se hace clic en el elemento btnMas");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el elemento btnMas");
		}
		
	}
	
	public void clicIBtnMicrofono() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnMicrofono));
			btnMicrofono.click();
			LogMobile.info("Se hace clic en el elemento btnMicrofono");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el elemento btnMicrofono");
		}
		
	}
	
	public void clicIBtnCamara() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCamara));
			btnCamara.click();
			LogMobile.info("Se hace clic en el elemento btnCamara");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el elemento btnCamara");
		}
		
	}
	
	public void clicIBtnFinalizar() {
		try {
			PageHelperMobile.tapScreen(btnFinalizar,screenView);
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
			btnFinalizar.click();
			LogMobile.info("Se hace clic en el elemento btnFinalizar");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el elemento btnFinalizar");
		}
		
	}
	
	public void aceptarFinalizarPopUp() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAceptarFinalizar));
			btnAceptarFinalizar.click();
			LogMobile.info("Se hace clic en el elemento btnAceptarFinalizar");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el elemento btnAceptarFinalizar");
		}
		
	}
	
	public void rechazarFinalizarPopUp() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelarFinalizar));
			btnCancelarFinalizar.click();
			LogMobile.info("Se hace clic en el elemento btnCancelarFinalizar");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el elemento btnCancelarFinalizar");
		}
		
	}
	
	public  Boolean esVisibleBtnChat() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnChat));
			esVisible = btnChat.isDisplayed();
			LogMobile.info("Se obtuvo el elemento btnChat");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento btnChat");
		}
		return esVisible;
	}	
	
	
	
	public  Boolean esVisibleBtnMas() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnMas));
			esVisible = btnMas.isDisplayed();
			LogMobile.info("Se obtuvo el elemento btnMas");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento btnMas");
		}
		return esVisible;
	}	
	
	public  Boolean esVisibleBtnMicrofono() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnMicrofono));
			esVisible = btnMicrofono.isDisplayed();
			LogMobile.info("Se obtuvo el elemento btnMicrofono");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento btnMicrofono");
		}
		return esVisible;
	}	

	public  Boolean esVisibleBtnCamara() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnCamara));
			esVisible = btnCamara.isDisplayed();
			LogMobile.info("Se obtuvo el elemento btnCamara");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento btnCamara");
		}
		return esVisible;
	}	
	
	public  Boolean esVisibleBtnFinalizar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnFinalizar));
			esVisible = btnFinalizar.isDisplayed();
			LogMobile.info("Se obtuvo el elemento btnFinalizar");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento btnFinalizar");
		}
		return esVisible;
	}	
}
