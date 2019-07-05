package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;


public class BasePage extends Base {

	public static WebDriverWait wait;
	public static Actions action;
	public static Select select;
	public static TouchAction actionTouch;
	public static TouchActions actions;
	
	@SuppressWarnings("rawtypes")
	public BasePage() {
		wait = new WebDriverWait(driver, 5);
		action = new Actions(driver);
		TouchAction actionTouch = new TouchAction(driver);
		TouchAction actions = new TouchAction(driver);
	}

	public <TPage extends BasePage> TPage GetInstance(Class<TPage> page) {
		Object obj = PageFactory.initElements(driver, page);
		return page.cast(obj);
	}

	@SuppressWarnings("unchecked")
	public <TPage extends BasePage> TPage As(Class<TPage> instancia) {
		try {
			return (TPage) this;
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return null;
	}

//	public <TPage extends BasePage> void GetInstanceMobile(Class<TPage> page) {
//		PageFactory.initElements(driver, page);
//	}
	
}
