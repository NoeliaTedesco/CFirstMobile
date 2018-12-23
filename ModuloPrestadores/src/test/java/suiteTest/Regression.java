package suiteTest;

import org.junit.Test;
import components.Hook;
import steps.GenerarInvitacion_Step;

public class Regression extends Hook {

		
		@Test
	    public void generateInvitation() {
	       GenerarInvitacion_Step.Run(testName.getMethodName());
	    }
	
}
