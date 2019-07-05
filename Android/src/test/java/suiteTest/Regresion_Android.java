package suiteTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import components.Hook;
import steps.S_Abrir_NotificacionSMS_Step;
import steps.S_Abrir_NotificacionStep;
import steps.S_Visualizar_Elementos_HomeStep;

public class Regresion_Android extends Hook {
	
//	@Test 
//	public void S_Home_01(Method method) {	
//		S_Ingresar_AceptacionStep.Run(method.getName());
//	}
//	
//	@Test
//	public void S_Home_02(Method method) {
//		S_Visualizar_Elementos_HomeStep.Run(method.getName());
//	}

	@Test
	public void S_Home_03(Method method) {
	S_Abrir_NotificacionStep.Run(method.getName());
	}
	
//	@Test
//	public void S_Home_04(Method method) {
//		S_Abrir_NotificacionSMS_Step.Run(method.getName());
//	}
	

}
