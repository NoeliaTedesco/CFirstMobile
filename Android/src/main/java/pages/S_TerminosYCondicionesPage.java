package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BasePageMobile;
import log.LogMobile;

public class S_TerminosYCondicionesPage extends BasePageMobile {

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
	
	@FindBy (id = "ar.com.portalsalud.osde:id/formSignUpTitleTv")
	private WebElement txtTituloTerminos;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/etNameForm")
	private WebElement campoNombre;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/etLastNameForm")
	private WebElement campoApellido;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/etIdForm")
	private WebElement campoDNI;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/spMinorRelationship")
	private WebElement campoRelacionMenor;
	
	@FindBy (id = "ar.com.portalsalud.osde:id/txt_item")
	private List<WebElement> opcionesRelacionMenor;
	
	
	
	
	public void quitarPopUpNotificacion() {
		try {
			wait.until(ExpectedConditions.visibilityOf(popUpNotificacion));
			if (popUpNotificacion.isDisplayed()) {
				btnNotificacionNo.click();
				wait.until(ExpectedConditions.elementToBeClickable(checkTerminos));
			}
			LogMobile.info("Se quita el mensaje para habilitar notificaciones");
		} catch (Exception e){
			LogMobile.info("No se muestra el mensaje para habilitar notificaciones");
		}
	}
	
	public void aceptarTerminosYCondiciones(String nombre, String apellido,
			String dni, String relacion) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(checkTerminos));
			completarCamposRelacionMenor(nombre,apellido,dni,relacion);
			checkTerminos.click();
			LogMobile.info("Se aceptan los terminos y condiciones");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla el aceptar los terminos y condiciones");
		}
		
	}
	
	
	
	
	public void clicIngresarConsultorio() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnIngresarConsultorio));
			btnIngresarConsultorio.click();
			LogMobile.info("Se ingresa correctamente al consultorio");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla el ingresar al consultorio");
		}
		
	}
	
	public void leerTerminosCondiciones() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnTerminosCondiciones));
			btnTerminosCondiciones.click();
		} catch (Exception e) {
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla el abrir los terminos y condiciones");
		}
	}
	
	
	public  Boolean esVisibleCheckTerminosYCondiciones() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(checkTerminos));
			esVisible = checkTerminos.isDisplayed();
			LogMobile.info("Se obtuvo el elemento checkTerminos");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento checkTerminos");
		}
		return esVisible;
	}
	
	
	public  Boolean esVisibleCampoNombre() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(campoNombre));
			esVisible = campoNombre.isDisplayed();
			LogMobile.info("Se obtuvo el elemento campoNombre");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento campoNombre");
		}
		return esVisible;
	}
	
	public  Boolean esVisibleCampoApellido() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(campoApellido));
			esVisible = campoApellido.isDisplayed();
			LogMobile.info("Se obtuvo el elemento campoApellido");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento campoApellido");
		}
		return esVisible;
	}
	
	public  Boolean esVisibleCampoDNI() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(campoDNI));
			esVisible = campoDNI.isDisplayed();
			LogMobile.info("Se obtuvo el elemento campoDNI");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento campoDNI");
		}
		return esVisible;
	}
	
	public  Boolean esVisibleRelacionMenor() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(campoRelacionMenor));
			esVisible = campoRelacionMenor.isDisplayed();
			LogMobile.info("Se obtuvo el elemento campoRelacionMenor");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento campoRelacionMenor");
		}
		return esVisible;
	}
	
	
	public void clicCampoNombre() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoNombre));
			campoNombre.click();
			LogMobile.info("Se hace clic en el campo campoNombre");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el campoNombre");
		}
		
	}
	
	public void clicCampoApellido() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoApellido));
			campoApellido.click();
			LogMobile.info("Se hace clic en el campo campoApellido");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el campoApellido");
		}
		
	}
	
	public void clicCampoDNI() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoDNI));
			campoDNI.click();
			LogMobile.info("Se hace clic en el campo campoDNI");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el campoDNI");
		}
		
	}
	
	public void clicCampoRelacionMenor() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoRelacionMenor));
			campoRelacionMenor.click();
			LogMobile.info("Se hace clic en el campo campoRelacionMenor");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al hacer clic en el campoRelacionMenor");
		}
		
	}
	
	public void completarNombre(String nombre) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoNombre));
			campoNombre.sendKeys(nombre);
			driver.navigate().back();
			LogMobile.info("Se carga un valor en el campo campoNombre");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al cargar un valor en el campoNombre");
		}
	}
	
	public void completarApellido(String apellido) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoApellido));
			campoApellido.sendKeys(apellido);
			driver.navigate().back();
			LogMobile.info("Se carga un valor en el campo campoApellido");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al cargar un valor en el campoApellido");
		}
	}
	
	public void completarDNI(String dni) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoDNI));
			campoDNI.sendKeys(dni);
			driver.navigate().back();
			LogMobile.info("Se carga un valor en el campo campoDNI");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al cargar un valor en el campoDNI");
		}
	}
	
	public void seleccionarRelacionMenor(String Relacion) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoRelacionMenor));
			campoRelacionMenor.click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ar.com.portalsalud.osde:id/txt_item")));
			for (WebElement op : opcionesRelacionMenor) {
				if (op.getText().equals(Relacion)) {
					op.click();
					break;
				}
			}
			LogMobile.info("Se carga un valor en el campo campoRelacionMenor");
		} catch (Exception e){
			LogMobile.info(e.getMessage());
			LogMobile.info("Falla al cargar un valor en el campoRelacionMenor");
		}
	}
	
	
	public String recuperTituloTerminosYCondiciones() {
		String txtTitulo = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(txtTituloTerminos));
			txtTitulo = txtTituloTerminos.getText();
			LogMobile.info("Se logra recuperar el titulo de los terminos y condiciones");
		} catch (Exception e) {
			LogMobile.info("Falla el recupear el titulo de los terminos y condiciones");
		}
		return txtTitulo;
	}
	
	public  Boolean estaHabilitadoBtnIngresarConsultorio() {
		Boolean estaHbilitado = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnIngresarConsultorio));
			estaHbilitado = btnIngresarConsultorio.isDisplayed();
			LogMobile.info("Se obtuvo el elemento btnIngresarConsultorio");
		} catch (Exception e) {
			e.printStackTrace();
			LogMobile.info("Fallo al obtener el elemento btnIngresarConsultorio");
		}
		return estaHbilitado;
	}	
	
	public void completarCamposRelacionMenor(String nombre, String Apellido, String DNI, String Relacion) {
		try {
			if (campoNombre.isDisplayed()) {
				completarNombre(nombre);
				completarApellido(Apellido);
				completarDNI(DNI);
				seleccionarRelacionMenor(Relacion);
			}
			LogMobile.info("Se completan los campos de los terminos y condiciones");
		} catch (Exception e){
			LogMobile.info("No se encuentran habilitados los campos de los terminos y condiciones - Socio es mayor de 18");
		}
	}
}
