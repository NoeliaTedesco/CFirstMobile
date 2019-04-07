package base;

import static base.Base.driver;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;

public class BaseStep extends Base {
	
	private static ArrayList<String> tabs;
	
	public static void NavigateToSite(String urlsite) {
		driver.navigate().to(urlsite);
	}
	
    public static void openNewTab(String newPage) {
    	((JavascriptExecutor)driver).executeScript("window.open('about:blank', '_blank');");
    	tabs = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(tabs.size()-1));
    	NavigateToSite(newPage);
    }
    
    public static void switchToTab(String url) {
    	tabs = new ArrayList<String>(driver.getWindowHandles());
    	for (String tab : tabs) {
    		driver.switchTo().window(tab);
    		if (driver.getCurrentUrl().contains(url)) {
    			break;
    		} 		
    	}
    	
    }
	

}
