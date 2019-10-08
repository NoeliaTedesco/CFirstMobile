package steps;

import org.testng.Assert;
import base.BaseStepMobile;
import helpers.StepHelperMobile;
import pages.S_AgradecimientosPage;
import pages.S_CalificarPage;
import pages.S_GmailPage;
import pages.S_HomePage;
import pages.S_MensajesPage;
import pages.S_NotificacionPage;
import pages.S_SalaEsperaPage;
import pages.S_TerminosYCondicionesPage;
import pages.S_VideoconsultaPage;


public class S_RealizarVC_NotificacionSMS_Step extends BaseStepMobile {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.LogMobile.startTestCase(testName);
			CurrentPage = (new S_HomePage().GetInstance(S_HomePage.class));

			nombrePaso = "01_Se verifica que sean visibles los elementos de la home";
			CurrentPage = (new S_HomePage().GetInstance(S_HomePage.class));
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisiblePrimerTelefono());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleSegundoTelefono());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtAcceder());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtServicio());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtVersion());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtOSDE());
			log.LogMobile.SuccessStep(nombrePaso);

			nombrePaso = "02_Se abren las notificaciones del dispositivo";
			CurrentPage = (new S_NotificacionPage().GetInstance(S_NotificacionPage.class));
			CurrentPage.As(S_NotificacionPage.class).abrirPanelNotificacion();
			StepHelperMobile.takeScreenShot(testName+"Notificaciones");
			log.LogMobile.SuccessStep(nombrePaso);

			nombrePaso = "03_Se abre la notificacion de la invitacion";
			CurrentPage.As(S_NotificacionPage.class).abrirNotificacion();
			StepHelperMobile.takeScreenShot(testName);
			log.LogMobile.SuccessStep(nombrePaso);
			
			nombrePaso = "04_Se ingresa al link de la invitacion";
			CurrentPage = (new S_MensajesPage<Object>().GetInstance(S_MensajesPage.class));
			CurrentPage.As(S_MensajesPage.class).abrirLinkInvitacion();
			log.LogMobile.SuccessStep(nombrePaso);
			
			nombrePaso = "05_Se ingresa a la sala de espera";
			CurrentPage = (new S_TerminosYCondicionesPage().GetInstance(S_TerminosYCondicionesPage.class));
			CurrentPage.As(S_TerminosYCondicionesPage.class).quitarPopUpNotificacion();
			CurrentPage.As(S_TerminosYCondicionesPage.class).aceptarTerminosYCondiciones("Juan", "Perez", "35645678", "Abuelo / Abuela");
			CurrentPage.As(S_TerminosYCondicionesPage.class).clicIngresarConsultorio();
			log.LogMobile.SuccessStep(nombrePaso);

			nombrePaso = "06_Sala de espera - Ingresar al consultorio";
			CurrentPage = (new S_SalaEsperaPage().GetInstance(S_SalaEsperaPage.class));
			CurrentPage.As(S_SalaEsperaPage.class).aceptarTiempoEspera();
			CurrentPage.As(S_SalaEsperaPage.class).aceptarLlamadaConsultorio();
			log.LogMobile.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Videoconsulta - Finalizar VC";
			CurrentPage = (new S_VideoconsultaPage().GetInstance(S_VideoconsultaPage.class));
			CurrentPage.As(S_VideoconsultaPage.class).clicIBtnFinalizar();
			CurrentPage.As(S_VideoconsultaPage.class).aceptarFinalizarPopUp();
			log.LogMobile.SuccessStep(nombrePaso);
			
			nombrePaso = "08_Calificar - Calificar VC";
			CurrentPage = (new S_CalificarPage().GetInstance(S_CalificarPage.class));
			CurrentPage.As(S_CalificarPage.class).calificar("tres", "Comentario VC");
			log.LogMobile.SuccessStep(nombrePaso);
			
			nombrePaso = "09_Pantalla Agradecimiento - Visualizar";
			CurrentPage = (new S_AgradecimientosPage().GetInstance(S_AgradecimientosPage.class));
			Assert.assertTrue(CurrentPage.As(S_AgradecimientosPage.class).esVisibleTxtAgradecimiento());
			Assert.assertEquals(CurrentPage.As(S_AgradecimientosPage.class).recuperarTxtAgradecimiento(), "¡Gracias por utilizar nuestro servicio!");
			CurrentPage.As(S_AgradecimientosPage.class).clicBtnSalir();
			log.LogMobile.SuccessStep(nombrePaso);

			StepHelperMobile.takeScreenShot(testName);

		} catch (AssertionError ex) {
			log.LogMobile.info(ex.getMessage());
			log.LogMobile.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}

		log.LogMobile.endTestCase(testName);
	}

}
