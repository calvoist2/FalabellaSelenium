package controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumHandler {
	
	
	
	public WebDriver setChrome(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromeDriver/chromedriver.exe");
		driver= new ChromeDriver();
		return driver;
		
	}
	
	
	public WebDriver setIE(WebDriver driver) {
		driver= new InternetExplorerDriver();
		return driver;
		
	}
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void writeText(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	public WebElement lookObjectByName(WebDriver driver,String name) {
		return driver.findElement(By.name(name));
	}
	public WebElement lookObjectByClass(WebDriver driver,String className) {
		return driver.findElement(By.className(className));
	}
	public WebElement lookObjectById(WebDriver driver,String id) {
		return driver.findElement(By.id(id));
	}
	public WebElement lookObjectByLinkText(WebDriver driver,String text) {
		return driver.findElement(By.linkText(text));
	}
	public WebElement lookObjectByXpath(WebDriver driver,String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	
	public void clickObject(WebElement element) {
		element.click();
	}
	
	public void waitSeconds(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public boolean waitForURL(WebDriver driver, String url) {
		while(!getURL(driver).equals(url)) {
			waitSeconds(driver,1);
		}
		return true;
	}
	public List<WebElement> getChildrenByTagName(WebElement element,String tagName){
		return element.findElements(By.tagName(tagName));
	}
	
	public void writeText(WebElement element,Keys key ) {
		element.sendKeys(key);
	}


}
