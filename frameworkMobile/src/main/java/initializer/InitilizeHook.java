package initializer;

import config.DataSetter;
import static delivery.EmailSender.InitializeEmailDeliveryConfiguration;
import static delivery.EmailSender.exitDelivery;

import helpers.ExcelHelper;
import helpers.XMLHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import log.Log;

import org.openqa.selenium.remote.DesiredCapabilities;

import base.Base;
import report.ReportConfiguration;

public class InitilizeHook extends Base {
	
	static AppiumDriverLocalService service;

	public static void StartAppiumService() {
		String ipAppium = DataSetter.configuration.getIpAppium();
		int puertoAppium = DataSetter.configuration.getPortAppium();

		try {
			AppiumServiceBuilder build = new AppiumServiceBuilder();
			build.withIPAddress(ipAppium);
			build.usingPort(puertoAppium);
			service = AppiumDriverLocalService.buildService(build);
			service.start();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo el inicio del servicio de appium");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void OpenApplication() {
		String platformName = DataSetter.configuration.getPlatformName();
		String deviceName = DataSetter.configuration.getDeviceName();
		String platformVersion = DataSetter.configuration.getPlatformVersion();
		String ipAppium = DataSetter.configuration.getIpAppium();
		int puertoAppium = DataSetter.configuration.getPortAppium();
		
		try {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", deviceName);
			capability.setCapability("platformVersion", platformVersion);
			capability.setCapability("platformName", platformName);
			File file = new File(System.getProperty("user.dir")+DataSetter.configuration.getApkPath());
			capability.setCapability("app",file.getAbsolutePath());
			switch (platformName) {
			case "Android":
				driver = new AndroidDriver(new URL("http://" + ipAppium + ":" + puertoAppium + "/wd/hub"), capability);
				break;
			case "iOS":
				iOSdriver = new IOSDriver(new URL("http://" + ipAppium + ":" + puertoAppium + "/wd/hub"), capability);
				break;
			default:
				driver = new AndroidDriver(new URL("http://" + ipAppium + ":" + puertoAppium + "/wd/hub"), capability);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo el abrir la aplicacion en el dispositivo");
		}
	}

	public static void OpenDelivery() {
		InitializeEmailDeliveryConfiguration();
	}

	public static void OpenReport(String testName) {
		ReportConfiguration.getReportConfig(testName);
	}

	public static void CloseReport() {
		ReportConfiguration.exitReport();
	}

	public static void CloseDelivery() {
		exitDelivery();
	}

	public static void OpenConfiguration() {
		DataSetter.getConfiguration();
	}

	public static void CreateFolder() {
		File imagePath = new File(DataSetter.configuration.getImageRepository());
		if (!imagePath.exists()) {
			imagePath.mkdirs();
		}
	}

	public static void OpenContextData(String testName) throws FileNotFoundException, IOException {
		XMLHelper.leerXml(testName);
	}

	public static void CloseConfiguration() {
		DataSetter.dispose();
	}

	public static void CloseContextData(String testName) {
		XMLHelper.guardarXml(testName);
	}

	public static void OpenLogger() {
		Log.intilizedLogger();
	}

	public static void StopAppiumService() {
		service.stop();
	}
	
	public static void CloseDriver() {
		switch (DataSetter.configuration.getPlatformName()) {
		case "Android":
			driver.quit();
			break;
		case "iOS":
			iOSdriver.quit();
			break;
		default:
			driver.quit();
			break;
		}

	}
}
