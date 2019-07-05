package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class S_VideoConsultaPage extends BasePage {

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

	
}
