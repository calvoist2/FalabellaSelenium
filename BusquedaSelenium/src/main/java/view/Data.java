package view;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	
	public static ArrayList<String> readFile(String path) {
		ArrayList<String> lineas = new ArrayList<String>();
		try {
			Workbook workbook = WorkbookFactory.create(new File(path));
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				String aux = "";
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);

					aux = aux + cellValue + "\t";
				}

				lineas.add(aux);
			}
		} catch (Exception e) {

		}
		return lineas;

	}
	
	public void createDateFolder(String path) {
		
		File newFolder = new File(path);
        newFolder.mkdir();
	}
	
	
	public void createExcel(String folderPath,ArrayList<String>information) {
		
		
		try {
	        Workbook workbook = new XSSFWorkbook();
	        CreationHelper createHelper = workbook.getCreationHelper();
	
	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("Resultados");
	        
	        for(int i=0;i<information.size();i++) {
	        	 // Create a Row
		        Row headerRow = sheet.createRow(i);
		        
		        String []eachLine = information.get(i).split("\\t");
		        
		        for(int j=0;j<eachLine.length;j++) {
		        	Cell cell = headerRow.createCell(j);
		            cell.setCellValue(eachLine[j]);
		        }
	        }
	        FileOutputStream fileOut = new FileOutputStream(folderPath+"/reporte.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();
        
        
		}catch(Exception e) {}
	}

}
