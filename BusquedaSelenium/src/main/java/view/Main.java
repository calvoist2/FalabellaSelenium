package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controller.FalabellaTest;
import controller.GoogleTest;
import controller.SeleniumHandler;
import model.SeleniumData;

public class Main {
	
	public static void main(String[] args) {
		
	
		
		
		
		Data data= new Data();
		ArrayList<String> lines =data.readFile(System.getProperty("user.dir")+"/file/Book1.xlsx");
		ArrayList<String> report= new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String folderPath=System.getProperty("user.dir")+"/reporte/"+dateFormat.format(date);
		data.createDateFolder(folderPath);
		
		for(int i=0; i<lines.size();i++) {
			
			
			String []eachData=lines.get(i).split("\\t");
			
			SeleniumData sD= new SeleniumData();
			SeleniumHandler sH=  new SeleniumHandler();
			if(eachData[2].equals("Si")) {
				data.createDateFolder(folderPath+"/Registro"+String.valueOf(i));
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
				ft.falabellaSearch(sD.getDriver(),eachData[1],folderPath+"/Registro"+String.valueOf(i));
				if(ft.chooseObject(sD.getDriver(),folderPath+"/Registro"+String.valueOf(i))) {
					ft.addObjectToCar(sD.getDriver(),folderPath+"/Registro"+String.valueOf(i));
					report.add(lines.get(i)+"Registro "+i+" ejecución exitosa");
					//System.out.println("Registro "+i+" ejecución exitosa");
				}
				else {
					report.add(lines.get(i)+"Registro "+i+" ejecución incompleta");
					//System.out.println("Registro "+i+" ejecución incompleta");
				}
				sH.close(sD.getDriver());
				
			}
			
			
		}

		data.createExcel(folderPath,report);
		
	
		
	}
}
