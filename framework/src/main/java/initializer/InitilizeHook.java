package initializer;

import base.Base;
import config.DataSetter;
import static config.DataSetter.configuration;
import static delivery.EmailSender.InitializeEmailDeliveryConfiguration;
import static delivery.EmailSender.exitDelivery;

import helpers.ExcelHelper;
import helpers.XMLHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import report.ReportConfiguration;

public class InitilizeHook extends Base {

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

	public static void CloseConfiguration() {
		DataSetter.dispose();
	}

	public static void OpenContextData(String testName) throws FileNotFoundException, IOException {
		XMLHelper.leerXml(testName);
		ExcelHelper.leerExcelCargado(testName);
	}

	public static void CloseContextData(String testName) {
		XMLHelper.guardarXml(testName);
	}

	public static void OpenLogger() {
		Log.intilizedLogger();
	}

	public static void CloseBrowser() {
		driver.close();
		driver.quit();
	}

	public static void OpenBrowser() {
		String tipoDeBrowser = configuration.getBrowser();

		switch (tipoDeBrowser) {
		case "Chrome": {
			System.setProperty("webdriver.chrome.driver", configuration.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			setDriver(new ChromeDriver(options));
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
			break;
		}
		case "Internet Explorer": {
			driver = new InternetExplorerDriver();
			break;
		}
		default: {
			driver = new ChromeDriver();
			break;
		}
		}
	}
}
