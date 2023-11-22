package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataInto_ExcelFile {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New XLSX Worksheet.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Contacts");
		Row rw=sh.createRow(8);
		Cell cl=rw.createCell(10);
		cl.setCellValue("Pragya");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\New XLSX Worksheet.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Data got inserted in excel");
	}

}
