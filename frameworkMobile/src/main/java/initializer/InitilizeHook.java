package initializer;

import base.Base;
import config.DataSetter;
import static config.DataSetter.configuration;
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
import report.ReportConfiguration;

public class InitilizeHook extends Base {

	private static String ipAppium = configuration.getIPAppium();
	private static int puertoAppium = configuration.getPortAppium();
	private static String platformName = configuration.getPlatformName();
	private static String deviceName = configuration.getDeviceName();
	private static String platformVersion = configuration.getPlatformVersion();

	public static void StartAppiumService() {

		try {
			AppiumServiceBuilder build = new AppiumServiceBuilder();
			build.withIPAddress(ipAppium);
			build.usingPort(puertoAppium);
			AppiumDriverLocalService service = AppiumDriverLocalService.buildService(build);
			service.start();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo el inicio del servicio de appium");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void OpenApplication() {
		try {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", deviceName);
			capability.setCapability("platformVersion", platformVersion);
			capability.setCapability("platformName", platformName);
			File file = new File(configuration.getApkPath());
			capability.setCapability("app", file.getAbsolutePath());
			switch (platformName) {
			case "Android":
				driver = new AndroidDriver(new URL("http://" + ipAppium + ":" + puertoAppium + "/wd/hub"), capability);

			case "iOS":
				iOSdriver = new IOSDriver(new URL("http://" + ipAppium + ":" + puertoAppium + "/wd/hub"), capability);

			default:
				driver = new AndroidDriver(new URL("http://" + ipAppium + ":" + puertoAppium + "/wd/hub"), capability);

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
		File imagePath = new File(configuration.getImageRepository());
		if (!imagePath.exists()) {
			imagePath.mkdirs();
		}
	}

	public static void OpenContextData(String testName) throws FileNotFoundException, IOException {
		XMLHelper.leerXml(testName);
		ExcelHelper.leerExcelCargado(testName);
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

	public static void CloseDriver() {
		switch (platformName) {
		case "Android":
			driver.close();
			driver.quit();
		case "iOS":
			iOSdriver.close();
			iOSdriver.quit();
		default:
			driver.close();
			driver.quit();
		}

	}
}
