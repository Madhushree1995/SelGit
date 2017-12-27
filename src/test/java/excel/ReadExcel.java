package excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel {

	public Object[][] readExcel() throws InvalidFormatException, IOException  {

		File src = new File("./Data/1stexcel.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(src);

		XSSFSheet sheet = wbook.getSheet("Madhu");

		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		int cellCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		return data;

		/*
		 * int RowCount = sheet.getLastRowNum();
		 * 
		 * for (int i = 1; i <= sheet.getLastRowNum(); i++) { XSSFCell cell1
		 * =row.getCell(i);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * for (int i = 1; i <=; i++) { XSSFCell cell1 =row.getCell(i);
		 * 
		 */
	}

}
