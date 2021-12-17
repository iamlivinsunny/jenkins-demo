package utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandle {

	public static void writeUrlDataIntoExcelFile(String filePath, LinkedHashMap<String, String[]> urlDetailsMap)
			throws IOException {
		try {
			// Creating a unique file name
			Calendar date = Calendar.getInstance();
			long millisecondsDate = date.getTimeInMillis();
			filePath = filePath + "/" + "dataExtracted" + millisecondsDate + ".xlsx";

			// Creating a workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet workSheet = workbook.createSheet("url details");
			Object[] ketList = urlDetailsMap.keySet().toArray();
			int noOfEntriesInTheMap = urlDetailsMap.keySet().size();
			XSSFRow titleRow = workSheet.createRow(0);
			titleRow.createCell(0, CellType.STRING).setCellValue("URL");
			titleRow.createCell(1, CellType.STRING).setCellValue("URL Title");
			titleRow.createCell(2, CellType.STRING).setCellValue("URL Details Description");

			// Storing the details of the map into the excel file
			for (int i = 1; i < noOfEntriesInTheMap + 1; i++) {
				XSSFRow row = workSheet.createRow(i);
				String[] urlDetailsArray = urlDetailsMap.get(ketList[i - 1]);
				row.createCell(0, CellType.STRING).setCellValue((String)ketList[i - 1]);
				row.createCell(1, CellType.STRING).setCellValue((String)urlDetailsArray[0]);
				row.createCell(2, CellType.STRING).setCellValue((String)urlDetailsArray[1]);
			}
			// Saving the details into the map
			FileOutputStream excelFile = new FileOutputStream(filePath);
			workbook.write(excelFile);
			excelFile.close();
			workbook.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} catch (Error ex) {
			ex.printStackTrace();
		}

	}

}
