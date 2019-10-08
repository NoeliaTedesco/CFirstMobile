package suiteTest;

import org.testng.annotations.Test;
import java.lang.reflect.Method;


import components.HookMobile;
import steps.S_RealizarVC_NotificacionSMS_Step;
import steps.S_RealizarVC_NotificacionStep;

public class Regresion_Socio_SMS extends HookMobile {
	

	@Test
	public void S_RealizarVC_01(Method method) {
		S_RealizarVC_NotificacionSMS_Step.Run(method.getName());
	}
	

}
