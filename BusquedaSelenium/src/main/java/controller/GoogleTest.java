package controller;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleTest {
	
	
	public void googleSearch(WebDriver driver) {
		SeleniumHandler sH= new SeleniumHandler();
		driver.get("http://www.google.cl");
		sH.maximizeWindow(driver);
		sH.writeText(sH.lookObjectByName(driver, "q"), "falabella");
		sH.writeText(sH.lookObjectByName(driver, "q"), Keys.RETURN);
		sH.clickObject(sH.lookObjectsByClass(driver, "ellip").get(0));
	}

}
