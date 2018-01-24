package generic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Lib implements IAutoConstanst{
	
	public static FileInputStream fis;
	public static Workbook wb;
	public static String getPropertyValue(String key){
		String propertyValue = "";
		try {
			FileInputStream fis =  new FileInputStream(CONFIG_PATH);
			Properties prop = new Properties();
			prop.load(fis);
			propertyValue = prop.getProperty(key);
		} catch (Exception e) {
		}
		return propertyValue;
	}
	public static String getCellValue(String sheet, int row, int column){
		String cellValue="";
		try {
			fis =  new FileInputStream(EXCEL_PATH);
			wb = WorkbookFactory.create(fis);
			cellValue = wb.getSheet(sheet).getRow(row).getCell(column).toString();
			
		} catch (Exception e) {
		}
		return cellValue;
	}
	public static int getRowCount(String sheet){
		int rowCount = 0;
		try {
			fis = new FileInputStream(EXCEL_PATH);
			wb = WorkbookFactory.create(fis);
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}
}
