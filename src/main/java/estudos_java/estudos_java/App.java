package estudos_java.estudos_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class App {
  
       private static final String fileName = "C:/teste/teste.xls";
  
       public static void main(String[] args) throws IOException  {
    	   
           try {
                  FileInputStream file = new FileInputStream(new File(
                            App.fileName));

                  HSSFWorkbook workbook = new HSSFWorkbook(file);
                  HSSFSheet sheetAlunos = workbook.getSheetAt(0);

                  System.out.println("Linhas: "+sheetAlunos.getPhysicalNumberOfRows());
                  
                  for (int i = 0; i < sheetAlunos.getPhysicalNumberOfRows(); i++) {

                         Row row = sheetAlunos.getRow(i);
                         System.out.println(row.getCell(4).getStringCellValue() );
                         System.out.println("--" + row.getCell(4).getStringCellValue().contains("CHANGE"));
                         if (row.getCell(4).getStringCellValue().contains("CHANGE") ) {
                        	 
                        	 for ( int c = 0; c < row.getLastCellNum(); c++) {
                            	 Cell cell = row.getCell(c);
                            	 System.out.println(cell.getCellType());
                            	
                            	 System.out.print(" "+ cell.getColumnIndex() + " - "+ cell.getStringCellValue()  );
                             }
                         
                         }
                         
                         
//                         if (cellNota1.getNumericCellValue() < 9) {
//                                cellNota1.setCellValue(cellNota1.getNumericCellValue() + 1);
//                         } else {
//                                cellNota1.setCellValue(10);
//                         }
//
//                         Cell cellNota2 = row.getCell(3);
//                         Cell cellMedia = row.getCell(4);
//                         cellMedia
//                                      .setCellValue((cellNota1.getNumericCellValue() + cellNota2
//                                                    .getNumericCellValue()) / 2);
//                         Cell cellAprovado = row.getCell(5);
//                         cellAprovado.setCellValue(cellMedia.getNumericCellValue() >= 6);
                  }
                  file.close();

                  FileOutputStream outFile = new FileOutputStream(new File(App.fileName));
                  workbook.write(outFile);
                  outFile.close();
                  workbook.close();
                  System.out.println("Arquivo Excel editado com sucesso!");

           } catch (FileNotFoundException e) {
                  e.printStackTrace();
                  System.out.println("Arquivo Excel não encontrado!");
           } catch (IOException e) {
                  e.printStackTrace();
                  System.out.println("Erro na edição do arquivo!");
           }

     }
}