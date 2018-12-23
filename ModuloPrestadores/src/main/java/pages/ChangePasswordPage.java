package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ChangePasswordPage extends BasePage {

	@FindBy(id = "newPassword")
	WebElement campNueva;

	@FindBy(id = "repeatNewPassword")
	WebElement campReingresar;

	@FindBy(xpath = "//*[@id='main']/div/div[2]/footer/div/div/div/div[2]/button")
	WebElement btnCambiar;

	@FindBy(xpath = "//footer[@className='container-fluid']/div/div/div/div[1]/button")
	WebElement btnCancelar;

	@FindBy(className = "toast-message")
	WebElement toastMessage;

	@FindBy(name = "changePasswordForm")
	WebElement formChangePassword;

	@FindBy(xpath = "//form[@name = 'formChangePassword']/div/div/div[2]")
	WebElement mensajeValidacion;

	@FindBy(xpath = "//form[@name = 'formChangePassword']/div[2]/div/div[2]")
	WebElement mensajeValidacionReingreso;

	public void CancelChange() {
		btnCancelar.click();

	}

	public void ChangePassword(String newPass, String reEnterPass) {
		wait.until(ExpectedConditions.elementToBeClickable(campNueva));
		campNueva.click();
		campNueva.sendKeys(newPass);
		campReingresar.click();
		campReingresar.sendKeys(reEnterPass);
		btnCambiar.click();
		wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, "Su contraseña ha sido cambiada."));
	}

	public String validateMessage(WebElement element) {
		String mensaje = element.getText();
		switch (mensaje) {
		case "El campo es muy corto":
			return "Validación de campo corto";

		case "El campo es requerido":
			return "Validación de campo requerido";

		case "Confirmación del campo debe coincidir":
			return "Validación de campo que nos coinciden";
			
		default:
			return "No hubo un mensaje de validación";
		}
	}

}
