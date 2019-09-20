package controller;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHandler {
	
	
	
	public WebDriver setChrome(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromeDriver/chromedriver.exe");
		driver= new ChromeDriver();
		return driver;
		
	}
	
	
	public WebDriver setIE(WebDriver driver) {
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "/drivers/ieDriver/IEDriverServer.exe");
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
	
	public List<WebElement>lookObjectsByName(WebDriver driver,String name) {
		return driver.findElements(By.name(name));
	}
	public List<WebElement> lookObjectsByClass(WebDriver driver,String className) {
		return driver.findElements(By.className(className));
	}
	public List<WebElement> lookObjectsById(WebDriver driver,String id) {
		return driver.findElements(By.id(id));
	}
	public List<WebElement> lookObjectsByLinkText(WebDriver driver,String text) {
		return driver.findElements(By.linkText(text));
	}
	public List<WebElement> lookObjectsByXpath(WebDriver driver,String xpath) {
		return driver.findElements(By.xpath(xpath));
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
	
	public List<WebElement> getChildrenByClassName(WebElement element,String className){
		return element.findElements(By.className(className));
	}
	public boolean elementExists(WebElement element) {
		if(element==null) {
			return false;
		}
		return true;
	}
	
	public void writeText(WebElement element,Keys key ) {
		element.sendKeys(key);
	}
	
	public void takeScreenShot(WebDriver driver,String name,String path,boolean passed) {
		
		try {
			String localPassed="";
			if(passed) {
				
				localPassed="Correcto";
			}
			else {
				localPassed="Incorrecto";
			}
			
			 Thread.sleep(1000);
	         Robot robot = new Robot();
	         String fileName =path+"/"+localPassed+name+".jpg";
	 
	         Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
	                                     .getScreenSize());
	         BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	         ImageIO.write(screenFullImage, "jpg", new File(fileName));
		}catch(Exception e) {
			System.out.println("Error");
		}
		
		
	}
	
	public void waitForElementByClassName(WebDriver driver, String className) {
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
	}
	
	public void close(WebDriver driver) {
		driver.close();
	}


}
