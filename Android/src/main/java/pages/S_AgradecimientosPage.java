package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class S_AgradecimientosPage extends BasePage {

	@FindBy(className = "android.widget.TextView")
	private WebElement txtAgradecimiento;

	@FindBy(id = "ar.com.portalsalud.osde:id/btn_exit")
	private WebElement btnSalir;
	
	@FindBy(id = "ar.com.portalsalud.osde:id/img_toolbar")
	private WebElement imgLogo;
	
	
}
