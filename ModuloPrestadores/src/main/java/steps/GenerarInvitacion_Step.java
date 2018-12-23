package steps;

import static config.DataSetter.configuration;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import helpers.ExcelHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.HomePage;
import pages.InvitationPage;
import pages.LoginPage;

public class GenerarInvitacion_Step extends BaseStep {
	
	public static void Run(String testName) {
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			Invitaciones inv = ExcelHelper.objectExcel.getInvitacion();
			NavigateToSite(configuration.getambiente_testing());
			CurrentPage = (new LoginPage().GetInstance(LoginPage.class));
			StepHelper.takeScreenShot(testName);
			CurrentPage.As(LoginPage.class).loginUsser(usr.getEmail(), usr.getPassword());
			CurrentPage = (new HomePage().GetInstance(HomePage.class));
			CurrentPage.As(HomePage.class).enterInvitationsMenu();
			CurrentPage = (new InvitationPage().GetInstance(InvitationPage.class));
			CurrentPage.As(InvitationPage.class).openInvitationForm();
			CurrentPage.As(InvitationPage.class).generateInvitation(inv.getNroSocio(),inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(),
					inv.getDetalleConsulta(), inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio());
			log.Log.SuccessStep(testName);
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(testName);
		}
		log.Log.endTestCase(testName);	

	}	

}
