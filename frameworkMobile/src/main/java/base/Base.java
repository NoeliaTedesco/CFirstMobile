package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class Base {

	public static AndroidDriver<AndroidElement> driver;
	public static BasePage CurrentPage;
	public static IOSDriver<?> iOSdriver;
	
	
	public static AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}
	
	public static void setAndroidDriver(AndroidDriver<AndroidElement> driver) {
		Base.driver = driver;
	}
	
	public static IOSDriver<?> getIOSDriver() {
		return iOSdriver;
	}
	
	public static void setIOSDriver(IOSDriver<?> iOSdriver) {
		Base.iOSdriver = iOSdriver;
	}
	
}
