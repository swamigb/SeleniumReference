package myOrg.ApachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        getData();
    }
    public static void getData() throws IOException {
    	FileInputStream fis = new FileInputStream("/home/swami/Selenium/Book.xlsx");
    	XSSFWorkbook workbook = new XSSFWorkbook(fis);
    	int sheets= workbook.getNumberOfSheets();
    	System.out.println(sheets);
    	for(int i=0;i<sheets;i++) {
        	System.out.println("hi");

    		Sheet sh = workbook.getSheetAt(i);
    		Iterator<Row> rows = sh.iterator();
    		while(rows.hasNext()) {
    			Row row = rows.next();
    			Iterator<Cell> cell = row.cellIterator();
    			while(cell.hasNext()) {
    				Cell cl = cell.next();
    				if(cl.getCellType().equals(CellType.NUMERIC)) {
        				System.out.print(cl.getNumericCellValue()+"|");

    				} else {
    				System.out.print(cl.getStringCellValue()+"|");
    				}
    			}
    			System.out.println("");
    		}
    	}
    }
}
