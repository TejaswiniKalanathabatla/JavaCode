
  package com.imaginea.amazontask;
  
  import java.io.File; import java.io.FileInputStream;
  
  import org.apache.poi.xssf.usermodel.XSSFCell;
  import org.apache.poi.xssf.usermodel.XSSFRow;
  import org.apache.poi.xssf.usermodel.XSSFSheet;
  import org.apache.poi.xssf.usermodel.XSSFWorkbook;
  
  public class Excel { public static void main(String[] args) {
  
  try { File src = new File("./resources/dataForTesting.xlsx"); FileInputStream
  fis = new FileInputStream(src);
   XSSFWorkbook wb = new XSSFWorkbook(fis);
   XSSFSheet sh1 = wb.getSheet("testdata"); int cell=sh1.getLastRowNum();
  System.out.println(" collumns are"+ cell);
  System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
  System.out.println(" passsword is  "+
  sh1.getRow(1).getCell(1).getStringCellValue());
  System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
  System.out.println(" password is   "+sh1.getRow(2).getCell(1).
  getNumericCellValue());
  
  } catch (Exception e) {
  
  System.out.println(e.getMessage());
  
  }
  
  }
  
  
  
  }
 