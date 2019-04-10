package steps;

import static config.DataSetter.configuration;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.ChangePasswordPage;
import pages.P_HomePage;
import pages.P_InvitationPage;
import pages.P_LoginPage;

public class ChangePasswordStep extends BaseStep{
	
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
			CurrentPage.As(P_HomePage.class).changePassword();
			PageHelper.WaitForPageLoading();
			CurrentPage = (new ChangePasswordPage().GetInstance(ChangePasswordPage.class));
			CurrentPage.As(ChangePasswordPage.class).ChangePassword("cmotest1", "cmotest1");
			PageHelper.WaitForPageLoading();
			CurrentPage = (new P_HomePage().GetInstance(P_HomePage.class));
			CurrentPage.As(P_HomePage.class).signOff();
			log.Log.SuccessStep(testName);
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(testName);
		}
		log.Log.endTestCase(testName);	

	}	

}
