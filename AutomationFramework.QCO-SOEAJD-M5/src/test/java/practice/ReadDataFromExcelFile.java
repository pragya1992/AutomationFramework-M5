package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New XLSX Worksheet.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
	Sheet sh= wb.getSheet("Contacts");//import from ss not si
	
	Row rw=sh.getRow(1);
	
Cell c1=rw.getCell(2);

String Value=c1.getStringCellValue();
System.out.println(Value);
		
		

	}

}
