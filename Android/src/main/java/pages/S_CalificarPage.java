package pages;

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

	
}
