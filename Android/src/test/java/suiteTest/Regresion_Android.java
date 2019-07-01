package suiteTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import components.Hook;
import steps.S_Visualizar_Elementos_HomeStep;

public class Regresion_Android extends Hook {
	
	@Test 
	public void S_Home_01(Method method) {
		S_Visualizar_Elementos_HomeStep.Run(method.getName());
	}

}
