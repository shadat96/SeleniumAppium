
package com.codenbox.Appium;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	public static AndroidDriver driver;
	
	public static  AppiumDriverLocalService  service;
	
	@BeforeClass
	public static void configureAppium() throws MalformedURLException {
		
		//Run server automatically
		  service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Shadat\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
		  .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		  
		//service.start();
		  
		//create capabilities
		UiAutomator2Options  options =new UiAutomator2Options();
		options.setDeviceName("Shadat");
		//options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");
		options.setPlatformName("Android");
		options.setCapability("platformVersion", "10.0");
		options.setChromedriverExecutable("C:\\Users\\Shadat\\webdrivers\\chromedriver74.exe");
		
		//create object for AndroidDriver/ IOSDriver
		 driver =new AndroidDriver(new  URL("http://127.0.0.1:4723"), options);
		
	//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		 
	public void scrollToEnd() {
		boolean canScrollMore;
		do{
		
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		} while (canScrollMore);
	}
	
	public void scrollToElement(String ele){
		
		driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"ele\")) "));
	}
	
	public void swipeAction(WebElement ele, String swipeDdirection) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
		    "direction", swipeDdirection,
		    "percent", 0.75
		));
	}
	
	@AfterClass
	public void tearDown() {
			 driver.quit();
		service.stop();
	 }
	
 
}
