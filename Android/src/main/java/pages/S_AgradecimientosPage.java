package pages;

import org.jfree.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePageMobile;

public class S_AgradecimientosPage extends BasePageMobile {

	@FindBy(xpath = "//*[@class ='android.widget.TextView' and @package='ar.com.portalsalud.osde']")
	private WebElement txtAgradecimiento;

	@FindBy(id = "ar.com.portalsalud.osde:id/btn_exit")
	private WebElement btnSalir;
	
	@FindBy(id = "ar.com.portalsalud.osde:id/img_toolbar")
	private WebElement imgLogo;
	
	public  Boolean esVisibleTxtAgradecimiento() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(txtAgradecimiento));
			esVisible = txtAgradecimiento.isDisplayed();
			Log.info("Se obtuvo el elemento txtAgradecimiento");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al obtener el elemento txtAgradecimiento");
		}
		return esVisible;
	}
	
	public  Boolean esVisibleBtnSalir() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnSalir));
			esVisible = btnSalir.isDisplayed();
			Log.info("Se obtuvo el elemento btnSalir");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al obtener el elemento btnSalir");
		}
		return esVisible;
	}
	
	public  Boolean esVisibleImagenLogo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(imgLogo));
			esVisible = imgLogo.isDisplayed();
			Log.info("Se obtuvo el elemento imgLogo");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al obtener el elemento imgLogo");
		}
		return esVisible;
	}
	
	public void clicBtnSalir() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSalir));
			btnSalir.click();
			Log.info("Se hace clic en el elemento btnSalir");
		} catch (Exception e){
			Log.info(e.getMessage());
			Log.info("Falla al hacer clic en el elemento btnSalir");
		}
		
	}
	
	public  String recuperarTxtAgradecimiento() {
		String texto = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(txtAgradecimiento));
			texto = txtAgradecimiento.getText();
			Log.info("Se obtuvo el elemento txtAgradecimiento");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al obtener el elemento txtAgradecimiento");
		}
		return texto;
	}	
	
}
