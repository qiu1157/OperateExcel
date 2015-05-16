package com.qiuxg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qiuxg.vo.ExcelVo;

public class ReaderExcel {

	/**
	 * @param args
	 */
	public List<String> getSheetContent(File file) {
		FileInputStream fis = null;
		XSSFWorkbook hwb = null;
		XSSFSheet sheet = null;
		XSSFRow xrow = null;
		XSSFCell xcell = null;
		// NumberFormat nf = NumberFormat.getInstance();
		// nf.setGroupingUsed(false);
		try {
			fis = new FileInputStream(file);
			hwb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int k = 0; k < hwb.getNumberOfSheets(); k++) {
			sheet = hwb.getSheetAt(k);
			String sheetName = sheet.getSheetName();
			if ("".equals(sheetName)) {
				for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
					xrow = sheet.getRow(i);
					xcell = xrow.getCell(6);
					String strtmp = xcell.getStringCellValue();
					if (!"".equals(strtmp)) {
						System.out.println(strtmp.trim());
					}
				}
			}
		}
		return null;
	}

	public static boolean replaceModel(List<ExcelVo> datas,
			String sourceFilePath, String targetFilePath) {
		boolean bool = false;
		FileInputStream fis = null;
		XSSFWorkbook hwb = null;
		XSSFSheet sheet = null;
		XSSFRow xrow = null;
		XSSFCell xcell = null;
		try {
			fis = new FileInputStream(sourceFilePath);
			hwb = new XSSFWorkbook(fis);

			for (int k = 0; k < hwb.getNumberOfSheets(); k++) {
				sheet = hwb.getSheetAt(k);
				String sheetName = sheet.getSheetName();
				for (ExcelVo ev : datas) {
					xrow = sheet.getRow(ev.getRow());
					xcell = xrow.getCell(ev.getCol());
					String str = xcell.getStringCellValue();
					str = str.replace(ev.getKey(), ev.getValue());

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bool;
	}

	public void readMapp(File file) {
		FileInputStream fis = null;
		XSSFWorkbook hwb = null;
		XSSFSheet sheet = null;
		XSSFRow xrow = null;
		XSSFCell xcell = null;
		try {
			fis = new FileInputStream(file);
			hwb = new XSSFWorkbook(fis);
			sheet = hwb.getSheetAt(0);
			String strT = null;
			String strTN = null;
			String strS = null;
			String strSN = null;

			for (int k = 0; k < sheet.getPhysicalNumberOfRows(); k++) {
		
				xrow = sheet.getRow(k);			
				if (k == 15) {	
					strT = xrow.getCell(0).getStringCellValue().trim();
					strTN = xrow.getCell(2).getStringCellValue().trim();
				}
				if (k > 16) {
					strS = xrow.getCell(0).getStringCellValue().trim();
					strSN = xrow.getCell(2).getStringCellValue().trim();
					if(strS.startsWith("G_")||strS.startsWith("PCRM_"))
					System.out.println(strT + "\t" + strTN + "\t" + strS + "\t"
							+ strSN);
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReaderExcel re = new ReaderExcel();
		GetFileName gfn = new GetFileName();
		File file = new File(
				"e:\\个人知识管理\\1_项目工作\\11.华兴银行\\02.工程库\\03.编码实现\\01 Mapping\\G层");
		List<File> l = gfn.getFileName(file);
		for (File file1 : l) {
			//System.out.println(file1.getName());
			re.readMapp(file1);
		}

		// re.getSheetContent(file);
	}

}
