package suiteTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;

import Modulos.target.classes.steps.D_Mobile_Envio_InvitacionStep;
import Modulos.target.classes.steps.M_Mobile_AtenderStep;
import components.HookMobile;
import steps.S_RealizarVC_NotificacionSMS_Step;
import steps.S_RealizarVC_NotificacionStep;
import steps.S_Visualizar_Elementos_HomeStep;

public class Regresion_Android extends HookMobile {

	// @Test
	// public void S_Home_01(Method method) {
	// S_Visualizar_Elementos_HomeStep.Run(method.getName());
	// }

	@Test
	public void S_Home_01(Method method) {
		D_Mobile_Envio_InvitacionStep.Run(method.getName());
	}

	@Test
	public void S_Home_02(Method method) {
		S_RealizarVC_NotificacionSMS_Step.Run(method.getName());
	}
	
	@Test
	public void M_Mobile_Atender_01(Method method) {
		M_Mobile_AtenderStep.Run(method.getName());
	}

	// @Test
	// public void S_Home_03(Method method) {
	// S_RealizarVC_NotificacionStep.Run(method.getName());
	// }

}
