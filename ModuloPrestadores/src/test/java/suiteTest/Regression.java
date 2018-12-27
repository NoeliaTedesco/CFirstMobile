package suiteTest;

import org.junit.Test;
import components.Hook;
import steps.ChangePasswordStep;
import steps.GenerateInvitationStep;

public class Regression extends Hook {


	@Test
	public void generateInvitation() {
		GenerateInvitationStep.Run(testName.getMethodName());
	}

}
