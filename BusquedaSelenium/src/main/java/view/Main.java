package view;

import java.util.ArrayList;

import controller.FalabellaTest;
import controller.GoogleTest;
import controller.SeleniumHandler;
import model.SeleniumData;

public class Main {
	
	public static void main(String[] args) {
		Data data= new Data();
		ArrayList<String> lines =data.readFile(System.getProperty("user.dir")+"/file/Book1.xlsx");
		
		for(int i=0; i<lines.size();i++) {
			
			String []eachData=lines.get(i).split("\\t");
			SeleniumData sD= new SeleniumData();
			SeleniumHandler sH=  new SeleniumHandler();
			if(eachData[2].equals("Si")) {
				
				String navegador=eachData[0];
				
				if(navegador.equals("Chrome")) {
					sD.setDriver(sH.setChrome(sD.getDriver()));
				}
				if(navegador.equals("Internet Explorer")) {
					sD.setDriver(sH.setIE(sD.getDriver()));
				}
				
				GoogleTest gt= new GoogleTest();
				gt.googleSearch(sD.getDriver());
				FalabellaTest ft= new FalabellaTest();
				ft.falabellaSearch(sD.getDriver(),eachData[1]);
				if(ft.chooseObject(sD.getDriver())) {
					ft.addObjectToCar(sD.getDriver());
				}
				else {
					System.out.println("Ejecución incompleta");
				}
				sH.close(sD.getDriver());
				
			}
			
			
		}
		
		
		
		
	}
}
