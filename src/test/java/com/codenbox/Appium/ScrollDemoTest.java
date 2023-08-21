package com.codenbox.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemoTest extends Base {

	
	@Test
	public void scrollTest() {
		//scroll until view element
		driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\")) "));
		
		//  method created in base class here just calling method with string arg value
		//scrollToElement("Views");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		
		// scroll until  element
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WebView\"]")).click();
		
		//scroll as long as we have screen view
		scrollToEnd();
	}
}
