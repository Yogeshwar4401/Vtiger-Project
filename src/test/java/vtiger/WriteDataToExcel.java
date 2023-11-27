package vtiger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		 //To read data from external resource
			FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger.xlsx");
			
		    Workbook wb = WorkbookFactory.create(fis); 
		  
		    Sheet sh = wb.getSheet("Sheet1");

		    Row rw = sh.createRow(10);
		    
		    Cell cl = rw.createCell(20);
		    
		    cl.setCellValue("Pune");
		    
		    FileOutputStream fos = new FileOutputStream("src\\test\\resources\\Vtiger.xlsx");
		    
		    wb.write(fos);
		    
		    


	}

}
