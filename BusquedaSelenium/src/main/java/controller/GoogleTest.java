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
		sH.clickObject(sH.lookObjectByXpath(driver, "//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3/div"));
	}

}
