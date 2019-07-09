package suiteTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import components.Hook;
import steps.S_RealizarVC_NotificacionSMS_Step;
import steps.S_RealizarVC_NotificacionStep;
import steps.S_Visualizar_Elementos_HomeStep;

public class Regresion_Android extends Hook {
	
//	@Test
//	public void S_Home_01(Method method) {
//		S_Visualizar_Elementos_HomeStep.Run(method.getName());
//	}

//	@Test
//	public void S_Home_02(Method method) {
//	S_RealizarVC_NotificacionSMSStep.Run(method.getName());
//	}
	
	@Test
	public void S_Home_03(Method method) {
		S_RealizarVC_NotificacionStep.Run(method.getName());
	}
	

}
