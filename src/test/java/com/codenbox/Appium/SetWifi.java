package com.codenbox.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class SetWifi extends Base {
      @Test
	public void setwifiTest() {
		
		 driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		 driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		 driver.findElement(By.id("android:id/checkbox")).click();
		 
		 driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();     //use 2nd tagName od Xpath
		 
		 
		 
		 driver.findElement(By.id("android:id/edit")).sendKeys("no1234");
		 driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();   // get (1) index of className attribute
		 
		 
	}
}
