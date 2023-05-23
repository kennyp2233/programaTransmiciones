/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author kenny
 */
public class ReadExcel {

    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ReadExcel(String file) {

        try {
            FileInputStream fis = new FileInputStream(new File(file));
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        sheet = wb.getSheetAt(0);
    }

    public String[][] getMatriz() {
        String[][] dataTable = null;
        // Create a file input stream to read Excel workbook and worksheet

        // Get the number of rows and columns
        int numRows = sheet.getLastRowNum() + 1;
        int numCols = sheet.getRow(0).getLastCellNum();
        // Create double array data table - rows x cols
        // We will return this data table
        dataTable = new String[numRows][numCols];
        // For each row, create a HSSFRow, then iterate through the "columns"
        // For each "column" create an HSSFCell to grab the value at the specified cell (i,j)
        for (int i = 0; i < numRows; i++) {
            XSSFRow xlRow = (XSSFRow) sheet.getRow(i);
            for (int j = 0; j < numCols; j++) {
                Cell xlCell = xlRow.getCell(j);
                dataTable[i][j] = xlCell.toString();
            }
        }
        return dataTable;
    }

    public String returnExcelString() {
        String r = "";
        Iterator<Row> rowIterator = sheet.iterator();

        Row row;
        // se recorre cada fila hasta el final
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            //se obtiene las celdas por fila
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell;
            //se recorre cada celda
            while (cellIterator.hasNext()) {
                // se obtiene la celda en específico y se la imprime

                cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        r += cell.getStringCellValue() + " | ";
                        break;
                    case NUMERIC:
                        r += cell.getNumericCellValue() + " | ";
                        break;
                    default:
                        throw new AssertionError();
                }

            }
            r += "\n";
        }
        return r;
    }
}
