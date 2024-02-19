package com.app.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {

	static Sheet worksheet;
	static Workbook workbook = null;
	static Hashtable<String, Object> dict = new Hashtable<>();

	// Create a Constructor
	public ExcelUtil(String ExcelSheetPath) throws BiffException, IOException {
		// Initialize
		workbook = Workbook.getWorkbook(new File(ExcelSheetPath));
		// For demo purpose the excel sheet name is hardcoded, but not recommended :)
		worksheet = workbook.getSheet("Sheet1");

		// Call the Column Dictionary to store column Names
		columnDictionary();
	}

	// Returns the number of rows
	public static int RowCount() {
		return worksheet.getRows();
	}

	// Returns the cell value by taking row and column values as argument
	private static String readCell(int column, int row) {
		return worksheet.getCell(column, row).getContents();
	}

	public static String readCell(String columnName, int rowNumber) {
		return readCell(getCell(columnName), rowNumber);
	}

	// Create column dictionary to hold all the column names
	private static void columnDictionary() {
		// Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for (int col = 0; col < worksheet.getColumns(); col++) {
			dict.put(readCell(col, 0), col);
		}
	}

	// Read column names
	private static int getCell(String colName) {
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);
		}
	}

}
