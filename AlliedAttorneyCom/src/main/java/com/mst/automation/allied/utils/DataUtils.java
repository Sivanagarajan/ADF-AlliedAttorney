package com.mst.automation.allied.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.CellValue;

public class DataUtils {

	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	
	public static ArrayList<String> getdata(String testcasename) throws IOException {

		// Configuring access for specific sheet
		
		ArrayList a = new ArrayList();
		FileInputStream fis = new FileInputStream("D:\\Selenium Projects\\AlliedAttorneyCom\\ExcelFiles\\AA-TestData.xlsx");
			
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		int k=0;
		int column=0;
		
		for(int i=0; i<sheets; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("Arete_Application_Data")) {
				
								
				XSSFSheet sheet = workbook.getSheetAt(i);
				
								
		// Getting rows and its cell from sheet
				Iterator<Row> rows = sheet.iterator(); // sheet is colloection of rows
				Row firstrow = rows.next();
				//Row secondrow = rows.next();
				
				Iterator<Cell> ce = firstrow.iterator(); // rows is collection of cells 166
				while(ce.hasNext()) {
					
					Cell value= ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCaseID")) {
						
						// Desired column
						column= k;
					}
					
					k++;
				}
				
				System.out.println(column);
				
				while(rows.hasNext()) {
					
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						
						Iterator<Cell> cv= r.cellIterator();
						while(cv.hasNext()) {
							
							Cell c = cv.next();
									
									if(c.getCellType()== Cell.CELL_TYPE_STRING) {
										
										a.add((c.getStringCellValue()));
									
									}
									
									else {
										
										a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
										//a.add(c.getNumericCellValue());
									}
							
						//a.add(NumberToTextConverter.toText(cv.next().getNumericCellValue()));				
						
							//System.out.println(cv.next().getRichStringCellValue());
							
						}
					}
					
					
				}
				
				}

				
			}
		return a;
		}
		}
	

