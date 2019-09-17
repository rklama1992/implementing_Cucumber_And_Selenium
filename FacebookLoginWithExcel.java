/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cucumberverifyproject;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author RLAMA
 */
public class FacebookLoginWithExcel {
    XSSFWorkbook wb;
    XSSFSheet sheet;
    
    //Constructor 
    public FacebookLoginWithExcel(String src)
    {
        try
        {
           File srcFile = new File(src);
           FileInputStream file = new FileInputStream(srcFile);
           this.wb = new XSSFWorkbook(file); // loading excel file
                                             // HSSFWorkbook for xsl excel file   
        }
        catch(Exception e)
        {
            System.out.println("Error while reading the data file.");
        }  
    }
    // Returns the row number of the Excel data sheet.
    public int displayNumRows(int SheetIndex)
    {
        int row = wb.getSheetAt(SheetIndex).getLastRowNum();
        return (row + 1);
    }
    
    // This function retrives the data from the Excel Data sheet using 
    // specific sheetnum, row and colulmn. 
    public String getData(int sheetNum, int row, int column)
    {
        String data = "";
        try
        {
            sheet = wb.getSheetAt(sheetNum);
            data = sheet.getRow(row).getCell(column).getStringCellValue();
            
        }
        catch(Exception e)
        {
            System.out.println("Error going through all of the data");
        }
        return data;
    }
}
