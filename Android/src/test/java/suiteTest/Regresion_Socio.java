package suiteTest;

import org.testng.annotations.Test;
import java.lang.reflect.Method;


import components.HookMobile;
import steps.S_RealizarVC_NotificacionSMS_Step;
import steps.S_RealizarVC_NotificacionStep;

public class Regresion_Socio extends HookMobile {

	@Test
	public void S_RealizarVC_01(Method method) {
		S_RealizarVC_NotificacionSMS_Step.Run(method.getName());
	}
 /*	
	@Test
	public void S_RealizarVC_02(Method method) {
		S_RealizarVC_NotificacionStep.Run(method.getName());
	}
*/	


}
