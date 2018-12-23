package components;

import initializer.InitilizeHook;
import org.junit.AfterClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestName;

public class Hook extends InitilizeHook {
	
    @Rule
    public TestName testName = new TestName();
    
    
	public Hook() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		OpenConfiguration();
		OpenLogger();
		OpenDelivery();
		OpenReport("Reporte");
	}
	
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		OpenBrowser();
		OpenContextData(testName.getMethodName());
		
	}
	
	@After
	public void tearDown() {
		CloseContextData(testName.getMethodName());
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		CloseBrowser();
		CloseReport();
		CloseDelivery();
		CloseConfiguration();
		
		
		
	}
	
}
