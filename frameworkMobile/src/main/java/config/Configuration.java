package config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuration {
	private String platformName;
	private String platformVersion;
	private String deviceName;
	private String apkPath;
	private String log4jPath;
	private String delivery;
	private String deliveryPath;
	private String reportPath;
	private String reportRepository;
	private String imageRepository;
	private String ipAppium;
	private int portAppium;

	public Configuration() {
	}

	public Configuration(String platformName, String platformVersion, String deviceName, String apkPath,
			String log4jPath, String delivery, String reportPath, String reportRepository, String imageRepository,
			String deliveryPath, String ipAppium, int portAppium) {
		this.platformName = platformName;
		this.apkPath = apkPath;
		this.log4jPath = log4jPath;
		this.delivery = delivery;
		this.reportPath = reportPath;
		this.reportRepository = reportRepository;
		this.imageRepository = imageRepository;
		this.deliveryPath = deliveryPath;
		this.ipAppium = ipAppium;
		this.portAppium = portAppium;
		this.deviceName = deviceName;
		this.platformVersion = platformVersion;
	}

	public int getPortAppium() {
		return portAppium;
	}

	@XmlElement
	public void setPortAppium(int portAppium) {
		this.portAppium = portAppium;
	}

	public String getIPAppium() {
		return ipAppium;
	}

	@XmlElement
	public void setIPAppium(String ipAppium) {
		this.ipAppium = ipAppium;
	}

	public String getDeliveryPath() {
		return deliveryPath;
	}

	@XmlElement
	public void setDeliveryPath(String deliveryPath) {
		this.deliveryPath = deliveryPath;
	}

	public String getApkPath() {
		return apkPath;
	}

	@XmlElement
	public void setApkPath(String apkPath) {
		this.apkPath = apkPath;
	}

	public String getLog4jPath() {
		return log4jPath;
	}

	@XmlElement
	public void setLog4jPath(String log4jPath) {
		this.log4jPath = log4jPath;
	}

	public String getDelivery() {
		return delivery;
	}

	@XmlElement
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getReportPath() {
		return reportPath;
	}

	@XmlElement
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getReportRepository() {
		return reportRepository;
	}

	@XmlElement
	public void setReportRepository(String reportRepository) {
		this.reportRepository = reportRepository;
	}

	public String getImageRepository() {
		return imageRepository;
	}

	@XmlElement
	public void setImageRepository(String imageRepository) {
		this.imageRepository = imageRepository;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	@XmlElement
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	@XmlElement
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceName() {
		return deviceName;
	}
	
	public String getPlatformName() {
		return platformName;
	}

	@XmlElement
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

}
