package model;

import org.openqa.selenium.WebDriver;

public class SeleniumData {
	
	
	WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	

}
