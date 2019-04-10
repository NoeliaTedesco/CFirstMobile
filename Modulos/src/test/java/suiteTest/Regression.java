package suiteTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import components.Hook;
import steps.GenerateInvitationStep;
import steps.VcReturnStep;

public class Regression extends Hook {

	@Test
	public void generateInvitation(Method method) {
		GenerateInvitationStep.Run(method.getName());
	}
	

	public void returnVC(Method method) {
		VcReturnStep.Run(method.getName());
	}

}
