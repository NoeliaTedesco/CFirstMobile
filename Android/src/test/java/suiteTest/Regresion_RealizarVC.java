package suiteTest;

import org.testng.annotations.Test;
import java.lang.reflect.Method;


import components.HookMobile;
import steps.S_RealizarVC_NotificacionSMS_Step;

public class Regresion_RealizarVC extends HookMobile {

	@Test
	public void S_Home_02(Method method) {
		S_RealizarVC_NotificacionSMS_Step.Run(method.getName());
	}
	


}
