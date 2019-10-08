package suiteTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;

import components.Hook;


public class Regresion_Web_Mail extends Hook {

	@Test
	public void M_Ingresar_01(Method method) {
		steps.M_EntrarVC_IngresarStep.Run(method.getName());
	}

	//Enviar invitacion por MAIL
	@Test (dependsOnMethods = {"M_Ingresar_01" })
	public void D_Mobile_EnvioInvitacion_02(Method method) {
		steps.D_Mobile_Envio_InvitacionStep.Run(method.getName());
	}

	@Test (dependsOnMethods = { "D_Mobile_EnvioInvitacion_02" })
	public void M_Mobile_Atender_01(Method method) {
		steps.M_Mobile_AtenderStep.Run(method.getName());
	}
	
}
