package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	  
	//Means keeping data ready like sum=a+B,In genricutility directly will call them 
	//1.creat method and creat obj 
	
	
	public String readDataFromExcel(String sheetname,int row,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New XLSX Worksheet.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetname).getRow(row).getCell(cellNo).getStringCellValue();
		return value;
		
		
	}
	
	public Object [][] readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New XLSX Worksheet.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastRow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[lastRow][lastcell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;i<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		return data;
	}

}
