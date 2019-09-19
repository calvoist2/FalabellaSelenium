package controller;

import org.openqa.selenium.WebDriver;

public class FalabellaTest {
	SeleniumHandler sH= new SeleniumHandler();
	public void falabellaSearch(WebDriver driver) {
		
		if(!sH.getURL(driver).equals("https://www.falabella.com/falabella-cl/")) {
			sH.clickObject(sH.lookObjectByXpath(driver, "//*[@id=\"header\"]/nav/div[3]/div/div/a/i[2]"));
			sH.clickObject(sH.lookObjectByLinkText(driver, "Chile"));
		}
		sH.waitForURL(driver, "https://www.falabella.com/falabella-cl/");
		sH.writeText(sH.lookObjectById(driver, "searchQuestionSolr"), "Dragon ball");
		
	}
	
	public void chooseObject(WebDriver driver) {
		sH.clickObject(sH.lookObjectByXpath(driver, "//*[@id=\"searchFormSolr\"]/a/i"));
		sH.clickObject(sH.getChildrenByTagName(sH.lookObjectById(driver, "testId-searchResults-products"), "div").get(0));
	}

}
