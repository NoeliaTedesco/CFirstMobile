package steps;

import org.testng.Assert;
import base.BaseStep;
import helpers.StepHelper;
import pages.S_HomePage;


public class S_Visualizar_Elementos_HomeStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			CurrentPage = (new S_HomePage().GetInstance(S_HomePage.class));

			nombrePaso = "01_Se verifica que se muestre el primer telefono";
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisiblePrimerTelefono());
			Assert.assertEquals(CurrentPage.As(S_HomePage.class).recuperarPrimerTelefono(),"0810.888.7788");
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "02_Se verifica que se muestre el segundo telefono";
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleSegundoTelefono());
			Assert.assertEquals(CurrentPage.As(S_HomePage.class).recuperarSegundoTelefono(),"0810.999.6300");
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "03_Se verifica la que se muestra el primer texto";
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtAcceder());
			Assert.assertEquals(CurrentPage.As(S_HomePage.class).recuperarPrimerTexto(),"Para acceder a este servicio, es necesario que te comuniques con los teléfonos de Urgencias de OSDE");
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "04_Se verifica la que se muestra el segundo texto";
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtServicio());
			Assert.assertEquals(CurrentPage.As(S_HomePage.class).recuperarSegundoTexto(),"El servicio de Urgencias de OSDE determinará si es adecuado el ofrecimiento de la asistencia médica virtual según los síntomas informados.");
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "05_Se verifica la que se muestra la version";
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtVersion());
			Assert.assertEquals(CurrentPage.As(S_HomePage.class).recuperarVersion(),"v1.0 - b43");
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "06_Se verifica la que se muestra el texto de OSDE";
			Assert.assertTrue(CurrentPage.As(S_HomePage.class).esVisibleLabelTxtOSDE());
			Assert.assertEquals(CurrentPage.As(S_HomePage.class).recuperarTxtOSDE(),"©OSDE 2018 - Todos los derechos reservados");
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
