package view;

import controller.FalabellaTest;
import controller.GoogleTest;
import controller.SeleniumHandler;
import model.SeleniumData;

public class Main {
	public static void main(String[] args) {
		
		String navegador="Chrome";
		
		SeleniumData sD= new SeleniumData();
		SeleniumHandler sH=  new SeleniumHandler();
		if(navegador.equals("Chrome")) {
			sD.setDriver(sH.setChrome(sD.getDriver()));
		}
		
		GoogleTest gt= new GoogleTest();
		gt.googleSearch(sD.getDriver());
		FalabellaTest ft= new FalabellaTest();
		ft.falabellaSearch(sD.getDriver());
		ft.chooseObject(sD.getDriver());
		
		
		
	}
}
