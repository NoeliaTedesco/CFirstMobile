package steps;

import static config.DataSetter.configuration;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.P_HomePage;
import pages.P_InvitationPage;
import pages.P_LoginPage;

public class VcReturnStep extends BaseStep {

	public static void Run(String testName) {
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			Invitaciones inv = ExcelHelper.objectExcel.getInvitacion();
			PageHelper.deleteAllCookies(driver);
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new P_LoginPage().GetInstance(P_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			CurrentPage.As(P_LoginPage.class).loginUsser(usr.getEmail(), usr.getPassword());
			PageHelper.WaitForPageLoading();
			CurrentPage = (new P_HomePage().GetInstance(P_HomePage.class));
			CurrentPage.As(P_HomePage.class).enterInvitationsMenu();
			PageHelper.WaitForPageLoading();
			CurrentPage = (new P_InvitationPage().GetInstance(P_InvitationPage.class));
			CurrentPage.As(P_InvitationPage.class).returnToTheAssociate(inv.getNroSocio(),inv.getNroCelular(), inv.email);	
			CurrentPage.As(P_InvitationPage.class).returnToTheAssociatePriority(inv.getNroSocio(),inv.getNroCelular(), inv.email);
			log.Log.SuccessStep(testName);
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(testName);
		}
		log.Log.endTestCase(testName);	

	}	
}
