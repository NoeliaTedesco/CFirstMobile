package suiteTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;

import Modulos.target.classes.components.Hook;
import Modulos.target.classes.steps.D_Mobile_Envio_InvitacionStep;
import Modulos.target.classes.steps.M_EntrarVC_IngresarStep;
import Modulos.target.classes.steps.M_Mobile_AtenderStep;


public class Regresion_Despacho extends Hook {
	
	@Test
	public void M_Ingresar_01(Method method) {
		M_EntrarVC_IngresarStep.Run(method.getName());
	}

	@Test (dependsOnMethods = {"M_Ingresar_01" })
	public void S_Home_01(Method method) {
		D_Mobile_Envio_InvitacionStep.Run(method.getName());
	}

	@Test (dependsOnMethods = { "S_Home_01" })
	public void M_Mobile_Atender_01(Method method) {
		M_Mobile_AtenderStep.Run(method.getName());
	}
}
