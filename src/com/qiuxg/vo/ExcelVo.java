package com.qiuxg.vo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelVo {
	//excel文件名
	private String excelName;
	//excel工作薄
	private XSSFWorkbook hwb;
	private XSSFSheet sheet;
	private int row;
	private int col;
	private XSSFRow xrow;
	private XSSFCell xcell;
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
   

	public void setKey(String key) {
		this.key = key;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	public String getExcelName() {
		return excelName;
	}


	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}




	public XSSFWorkbook getHwb() {
		return hwb;
	}




	public void setHwb(XSSFWorkbook hwb) {
		this.hwb = hwb;
	}




	public XSSFSheet getSheet() {
		return sheet;
	}




	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}




	public int getRow() {
		return row;
	}




	public void setRow(int row) {
		this.row = row;
	}




	public int getCol() {
		return col;
	}




	public void setCol(int col) {
		this.col = col;
	}




	public XSSFRow getXrow() {
		return xrow;
	}




	public void setXrow(XSSFRow xrow) {
		this.xrow = xrow;
	}




	public XSSFCell getXcell() {
		return xcell;
	}




	public void setXcell(XSSFCell xcell) {
		this.xcell = xcell;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
