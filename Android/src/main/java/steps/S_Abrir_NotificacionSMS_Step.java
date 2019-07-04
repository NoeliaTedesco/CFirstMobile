package steps;

import org.testng.Assert;
import base.BaseStep;
import helpers.StepHelper;
import pages.S_GmailPage;
import pages.S_HomePage;
import pages.S_MensajesPage;
import pages.S_NotificacionPage;


public class S_Abrir_NotificacionSMS_Step extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			CurrentPage = (new S_HomePage().GetInstance(S_HomePage.class));

			nombrePaso = "01_Se verifica que sean visibles los elementos de la home";
			CurrentPage = (new S_HomePage().GetInstance(S_HomePage.class));
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisiblePrimerTelefono());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleSegundoTelefono());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtAcceder());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtServicio());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtVersion());
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtOSDE());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "02_Se abren las notificaciones del dispositivo";
			CurrentPage = (new S_NotificacionPage().GetInstance(S_NotificacionPage.class));
			CurrentPage.As(S_NotificacionPage.class).abrirPanelNotificacion();
			StepHelper.takeScreenShot(testName+"Notificaciones");
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "03_Se abre la notificacion de la invitacion";
			CurrentPage.As(S_NotificacionPage.class).abrirNotificacion();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "04_Se ingresa al link de la invitacion";
			CurrentPage = (new S_MensajesPage().GetInstance(S_MensajesPage.class));
			CurrentPage.As(S_MensajesPage.class).abrirLinkInvitacion();
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
