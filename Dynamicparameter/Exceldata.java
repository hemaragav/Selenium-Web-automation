package Dynamicparameter;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {

	public static String[][] excelData() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./Data/Leads.xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();

		int cellcount = sheet.getRow(1).getLastCellNum();

		String[][] data = new String[rowCount][cellcount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellcount; j++) {

				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = value;

			}

		}

		wb.close();
		return data;

	}

}
