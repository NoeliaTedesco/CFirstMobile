package pages;

import org.jfree.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	public void calificar(String estrellas) {
		try {
			seleccionarEstrella(estrellas);
			btnCalificar.click();
			Log.info("Se logro calificar la VC");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo el calificarlas VC");
		}
	}
	
}
