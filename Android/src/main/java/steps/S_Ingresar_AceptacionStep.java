package steps;


import java.io.IOException;
import org.testng.Assert;
import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import helpers.ExcelHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;
import pages.S_HomePage;


public class S_Ingresar_AceptacionStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			
			Usuario usr = XMLHelper.object.getUsuario();
			try {
				ExcelHelper.mostrarExcelCargado(testName);
			} catch (IOException e) {
				log.Log.info(e.getMessage());
				log.Log.FailStep("error al leer el excel");
				Assert.fail("Fallo test - " + testName + " - Step: " + "Carga de datos");
			}
			Invitaciones inv = ExcelHelper.objectExcel.getInvitacion();
			
			nombrePaso = "01_Se verifica que sean visibles los elementos de la home";
			CurrentPage = (new S_HomePage().GetInstance(S_HomePage.class));
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisiblePrimerTelefono());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleSegundoTelefono());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtAcceder());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtServicio());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtVersion());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtOSDE());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "02_Se ingresa al rol despacho";
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class)); 
			//NavigateToSite("https://tconsultamedica.osde.com.ar/prestadores");
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia(usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "03_Se ingresa al modulo invitaciones";
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			CurrentPage.As(D_HomePage.class).ingresarModuloInvitaciones();
			CurrentPage.As(D_HomePage.class).esVisibleAlertaLogin();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "04_Se verifica la visualizacion del botón enviar invitacion";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "05_Se verifica la visualizacion del formulario de envio de invitacion";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "06_Se verifica el mensaje de Invitacion Enviada";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).generarInvitacion(inv.getNroSocio(),
					inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(), inv.getDetalleConsulta(),
					inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio(),
					inv.getMesaOperativa(), inv.getPlan(), inv.getProvincia(), inv.getLocalidad(), inv.getBarrio(),
					inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(),
					inv.getMarcaPMI()));
			log.Log.SuccessStep(nombrePaso);

			StepHelper.takeScreenShot(testName);

		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}

		log.Log.endTestCase(testName);
	}

}
