package com.facebook.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	/*
	 * row (FirstName)=0 column (FirstName)=0 cell (FirstName)=0,0 cell
	 * (LastName)=0,1
	 * 
	 * Faruq=1,0 Fabiha=2,0 Faiza=3,0
	 * 
	 * 
	 * mmm=1,1 A=2,1 N=3,1
	 * 
	 * row and column starts from 0=because they follow array index. cell value=row
	 * and column intersection data type in excel=text, numeric(double),date in
	 * selenium we only can take webelement=text
	 * 
	 * flow of reading excel== first get into the book second get into the sheet
	 * third get into the row fourth get into the column then it is your cell value
	 * then you need to know the data type of the cell then appropriate method will
	 * read from the cell
	 */

	public String fileLocation;

	public String sheetName;

	public ReadExcel(String fileLocation, String sheetName) {
		super();
		this.fileLocation = fileLocation;
		this.sheetName = sheetName;
	}

	public String getStringData(int rowNum, int columnNum) {
		String cellData = null;
		try {
			FileInputStream fis = new FileInputStream(fileLocation);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell column = row.getCell(columnNum);
			cellData = column.getStringCellValue();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return cellData;
	}
	
	public double getNumericCellData(int rowNum, int ColumNum) {
		double CellNumericData=0.0;
		
		try {
			//get the location of the excel sheet
			FileInputStream fis = new FileInputStream(fileLocation);
			//get the book name
			Workbook registrationBook = new XSSFWorkbook(fis);
			// get the sheet name 
			Sheet sheet2=registrationBook.getSheet(sheetName);
			// get the row num
			Row row=sheet2.getRow(rowNum);
			//get column number
			Cell coulumn=row.getCell(ColumNum);
			CellNumericData=coulumn.getNumericCellValue();
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
		
		return CellNumericData;
		
		
	}
	
	public LocalDateTime getDateCellData(int rowNum, int ColumNum) {
		LocalDateTime CellDateData=null;
		
		try {
			//get the location of the excel sheet
			FileInputStream fis = new FileInputStream(fileLocation);
			//get the book name
			Workbook registrationBook = new XSSFWorkbook(fis);
			// get the sheet name 
			Sheet sheet2=registrationBook.getSheet(sheetName);
			// get the row num
			Row row=sheet2.getRow(rowNum);
			//get column number
			Cell coulumn=row.getCell(ColumNum);
			CellDateData=coulumn.getLocalDateTimeCellValue();
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
		
		return CellDateData;
		
		
	}

	public static void main(String[] args) {
		String fileLocation = "src/test/resources/registration.xlsx";
		String sheetName = "Sheet1";
		ReadExcel re = new ReadExcel(fileLocation, sheetName);
		String fName = re.getStringData(0, 0);
		System.out.println(fName);
		String lName = re.getStringData(0, 1);
		System.out.println(lName);
		String fima = re.getStringData(1, 1);
		System.out.println(fima);
		double data=re.getNumericCellData(1, 8);
		System.out.println(data);
		
		//String fileLocation = "src/test/resources/registration.xlsx";
		String sheet3 = "Sheet3";
		ReadExcel numericSheet = new ReadExcel(fileLocation, sheet3);
		System.out.println(numericSheet.getNumericCellData(1, 0));
		System.out.println(numericSheet.getNumericCellData(1, 1));

	}

}
