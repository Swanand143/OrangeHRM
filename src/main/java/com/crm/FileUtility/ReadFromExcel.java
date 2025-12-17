package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {
	
	public static String readExcel(int row, int col, String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\ExcelFile\\OrangeHRM.xlsx");
		Workbook book= WorkbookFactory.create(ip);
		Sheet sh = book.getSheet(sheet);
		String data = sh.getRow(row).getCell(col).toString();
		return data;
	}

}
