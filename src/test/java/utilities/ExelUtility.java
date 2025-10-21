package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtility {

	public static FileInputStream Fi;
	public static FileOutputStream Fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet Sheet;
	public static XSSFRow Row;
	public static XSSFCell Cell;
	public static CellStyle Style;
	String path;
	
	//constructor for receive path from test class
    public ExelUtility(String path){
		this.path= path;
	}
	
  public int GetRowCount(String sheetname) throws IOException {
		
		Fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(Fi);
		Sheet=workbook.getSheet(sheetname);
		int rowscount =Sheet.getLastRowNum();
		workbook.close();
		Fi.close();
		return rowscount;
	}
  public int GetCellCount(String sheetName ,int rownum) throws IOException {
		
		Fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(Fi);
		Sheet=workbook.getSheet(sheetName);
		Row=Sheet.getRow(rownum);
		int cellcount=Row.getLastCellNum();
		workbook.close();
		Fi.close();
		return cellcount;
		
	}
 
  public String getCellData(String sheetName, int rownum,int cellnum ) throws IOException {
		Fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(Fi);
		Sheet=workbook.getSheet(sheetName);
		Row=Sheet.getRow(rownum);
	    Cell=Row.getCell(cellnum);
  
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
		data =formatter.formatCellValue(Cell);	//returns the formatted value of a cell as a String regardless of cell type.
		}catch(Exception e) {
			data="";
		}
		workbook.close();
		Fi.close();
		return data;
  }
  
  public void setCellData(String sheetname ,int rownum ,int cellnum,String data) throws IOException {	
	
	  File xlfile = new File(path);
	  if(!xlfile.exists()) {       //if file is not exists then create a new file 
		  
		  workbook = new XSSFWorkbook();
		  Fo=new FileOutputStream(path);
		  workbook.write(Fo);  
	  }
	  
	  Fi = new FileInputStream(path);
	  workbook = new XSSFWorkbook(Fi);
	 if(workbook.getSheetIndex(sheetname)==-1) //if sheet not exists then create new sheet
	    workbook.createSheet(sheetname);
	    Sheet=workbook.getSheet(sheetname);
			  
	  if(Sheet.getRow(rownum)==null)   //if row not exists then create new row
		  Sheet.createRow(rownum);
		 Row= Sheet.getRow(rownum);
		
		Cell= Row.createCell(cellnum);
		Cell.setCellValue(data);
		Fo= new FileOutputStream(path);
		workbook.write(Fo);
		workbook.close();
		Fi.close();
		Fo.close();
		
}
  
  public void fillgreencolour(String sheetname ,int rownum ,int cellnum) throws IOException {
		
		Fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(Fi);
		Sheet = workbook.getSheet(sheetname);
        Row =Sheet.getRow(rownum);
        Cell=Row.getCell(cellnum);
        
        Style=workbook.createCellStyle();
    
        Style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
      
        Cell.setCellStyle(Style);
        workbook.write(Fo);
        workbook.close();
        Fi.close();
        Fo.close();
	}
  
  public static void fillredcolour(String xlfile, String xlsheet ,int rownum ,int cellnum) throws IOException {
		
		Fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(Fi);
		Sheet = workbook.getSheet(xlsheet);
        Row =Sheet.getRow(rownum);
        Cell=Row.getCell(cellnum);
        Style=workbook.createCellStyle();
      
      
      Style.setFillForegroundColor(IndexedColors.RED.getIndex());
      Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
     
      Cell.setCellStyle(Style);
      workbook.write(Fo);
      workbook.close();
      Fi.close();
      Fo.close();
	}
}
	
	
  
  
  

