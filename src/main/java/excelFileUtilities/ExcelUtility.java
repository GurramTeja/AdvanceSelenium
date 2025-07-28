package excelFileUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//getting data from single row
public class ExcelUtility {
	public String getDataFromExcel(String SheetName, int RowNum,int CellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/TestScriptDataAdv.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
		wb.close();
		return data;	
	}
	
//getting data from multiple row
	public int togetRowCount(String Sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/TestScriptDataAdv.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
}
