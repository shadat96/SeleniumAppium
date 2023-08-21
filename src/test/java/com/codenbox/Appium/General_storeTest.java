package com.codenbox.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class General_storeTest extends Base {
@Test (enabled = false)
	public void fillForm() throws InterruptedException {
	Thread.sleep(3000);
	//scroll down and select option from drop down
	driver.findElement(By.id("android:id/text1")).click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Canada\"))"));
	driver.findElement(By.xpath("//android.widget.TextView[@text= 'Canada']")).click();
	
	//Type name in text field
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jeniffer");
	
	driver.hideKeyboard();  // hide keyboard
	
	//select radio button
	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	//driver.findElement(By.xpath("//android.widget.Button[@text='Let's Shop]")).click();
	//Thread.sleep(3000);
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
@Test
public void toastMsgTest() throws InterruptedException 
{
	Thread.sleep(3000);
	//scroll down and select option from drop down
	driver.findElement(By.id("android:id/text1")).click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Canada\"))"));
	driver.findElement(By.xpath("//android.widget.TextView[@text= 'Canada']")).click();
	
	//Type name in text field
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jeniffer");
	
	//driver.hideKeyboard();  // hide keyboard
	
	//select radio button
	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	//driver.findElement(By.xpath("//android.widget.Button[@text='Let's Shop]")).click();
	//Thread.sleep(3000);
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	//spy the toast message get the text and tag name android widget Toast
	String toastMsg =driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("text");
	Assert.assertEquals(toastMsg, "Please enter your name");
	}

}
