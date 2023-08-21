package com.codenbox.Appium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HybridTest extends Base {
	@Test
	public void doHybrid() throws InterruptedException{
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
		
		//scroll until air jordan 9
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))"));
		
		int count =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count; i++) {
			String  productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			 
			if(productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
                    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click(); 
		}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(20001);
		//type codenbox in google search
	
		
		Set<String> contextNames = driver.getContextHandles(); // this will get both context name app and web
		for(String contextName : contextNames) {

			  System.out.println(contextName); // print out something like NATIVE_APP / WEBVIEW_1
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Codenbox");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(20001);
		driver.context("NATIVE_APP");  // pass the native context mobile app
}
}