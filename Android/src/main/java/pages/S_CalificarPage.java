package pages;

import org.jfree.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class S_CalificarPage extends BasePage {

	@FindBy(id = "ar.com.portalsalud.osde:id/platformDetail")
	private WebElement inputComentario;

	@FindBy(id = "ar.com.portalsalud.osde:id/star1")
	private WebElement btnUnaEstrella;
	
	@FindBy(id = "ar.com.portalsalud.osde:id/star2")
	private WebElement btnDosEstrellas;
	
	@FindBy(id = "ar.com.portalsalud.osde:id/star3")
	private WebElement btnTresEstrellas;
	
	@FindBy(id = "ar.com.portalsalud.osde:id/star4")
	private WebElement btnCuatroEstrellas;
	
	@FindBy(id = "ar.com.portalsalud.osde:id/star5")
	private WebElement btnCincoEstrellas;

	@FindBy(id = "ar.com.portalsalud.osde:id/nextText")
	private WebElement btnCalificar;

	private void seleccionarEstrella(String estrella) {
		try 
		{ 
			switch (estrella) {
			case "uno":
					btnUnaEstrella.click();
					break;
			case "dos":
					btnDosEstrellas.click();
					break;
			case "tres":
					btnTresEstrellas.click();
					break;
			case "cuatro":
					btnCuatroEstrellas.click();
					break;
			case "cinco":
					btnCincoEstrellas.click();
					break;					
			}
			
			Log.info("Se logro seleccionar las estrellas de la VC");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo el seleccionar estrellas de las VC");
		}
	}
	
	public void calificar(String estrellas, String comentario) {
		try {
			seleccionarEstrella(estrellas);
			ingresarComentario(comentario);
			wait.until(ExpectedConditions.elementToBeClickable(btnCalificar));
			btnCalificar.click();
			Log.info("Se logro calificar la VC");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo el calificarlas VC");
		}
	}
	
	public  Boolean esVisibleBtnCalificar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnCalificar));
			esVisible = btnCalificar.isDisplayed();
			Log.info("Se obtuvo el elemento btnCalificar");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al obtener el elemento btnCalificar");
		}
		return esVisible;
	}	
	
	public  Boolean esVisibleInputComentario() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(inputComentario));
			esVisible = inputComentario.isDisplayed();
			Log.info("Se obtuvo el elemento inputComentario");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al obtener el elemento inputComentario");
		}
		return esVisible;
	}	
	
	
	public void clicCampoComentario() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inputComentario));
			inputComentario.click();
			Log.info("Se hace clic en el campo inputComentario");
		} catch (Exception e){
			Log.info(e.getMessage());
			Log.info("Falla al hacer clic en el inputComentario");
		}
		
	}
	
	public void ingresarComentario(String comentario) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inputComentario));
			inputComentario.sendKeys(comentario);
			wait.until(ExpectedConditions.textToBePresentInElement(inputComentario, comentario));
			driver.navigate().back();
			Log.info("Se carga un valor en el campo inputComentario");
		} catch (Exception e){
			Log.info(e.getMessage());
			Log.info("Falla al cargar un valor en el inputComentario");
		}
	}
}
