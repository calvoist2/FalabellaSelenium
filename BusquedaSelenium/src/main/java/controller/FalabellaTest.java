package controller;

import org.openqa.selenium.WebDriver;

public class FalabellaTest {
	SeleniumHandler sH= new SeleniumHandler();
	
	public void falabellaSearch(WebDriver driver, String object) {
		
		if(!sH.getURL(driver).equals("https://www.falabella.com/falabella-cl/")) {
			sH.clickObject(sH.lookObjectByXpath(driver, "//*[@id=\"header\"]/nav/div[3]/div/div/a/i[2]"));
			sH.clickObject(sH.lookObjectByLinkText(driver, "Chile"));
		}
		sH.waitForURL(driver, "https://www.falabella.com/falabella-cl/");
		sH.writeText(sH.lookObjectById(driver, "searchQuestionSolr"), object);
		sH.takeScreenShot(driver,"UrlFalabellaChile", true);
		
	}
	
	public boolean chooseObject(WebDriver driver) {
		sH.clickObject(sH.lookObjectByXpath(driver, "//*[@id=\"searchFormSolr\"]/a/i"));
		if(!sH.lookObjectsById(driver, "testId-searchResults-products").isEmpty()) {
			sH.clickObject(sH.getChildrenByClassName(sH.lookObjectById(driver, "testId-searchResults-products"), "jsx-1395131234").get(1));
			sH.takeScreenShot(driver,"Resultados_encontrados", true);
			return true;
		}
		else {
			sH.takeScreenShot(driver,"Resultados_no_encontrados", false);
			System.out.println("No se encuentran resultados para el producto");
			return false;
		}
	}
	
	public void addObjectToCar(WebDriver driver) {
		if(sH.getChildrenByTagName(sH.lookObjectByXpath(driver, "//*[@id=\"fbra_browseMainProduct\"]/div/div/div[2]/div/div[5]"), "div").size()>0) {
			
			if(sH.lookObjectsByClass(driver, "fb-product-cta__size").size()>0) {
				sH.clickObject(sH.lookObjectByClass(driver, "fb-inline-dropdown__link"));
				sH.clickObject(sH.getChildrenByTagName(sH.lookObjectByClass(driver,"fb-inline-dropdown__list"), "li").get(0));		
				System.out.println("Objeto con tamaño");
			}
			
		}
		
		if(sH.lookObjectByName(driver, "quantity1").getAttribute("value").equals("0")) {
			
			sH.clickObject(sH.lookObjectByClass(driver, "fb-quantity-input__plus"));
		}
		
		sH.clickObject(sH.lookObjectByClass(driver, "fb-product-cta__controls--actions--choose"));
		
		
	}

}
