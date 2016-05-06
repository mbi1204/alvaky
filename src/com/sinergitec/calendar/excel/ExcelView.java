package com.sinergitec.calendar.excel;

import java.util.LinkedList;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.formula.functions.Hyperlink;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.sinergitec.calendar.model.InfEjecutivo;
 
public class ExcelView extends AbstractExcelView {
 
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
 
        Sheet sheet = workbook.createSheet("sheet 1");
 
        @SuppressWarnings("unchecked")
        LinkedList<InfEjecutivo> articles = (LinkedList<InfEjecutivo>) model.get("articles");
 
        Row row = null;
        Cell cell = null;
        int r = 0;
        int c = 0;
 
        //Style for header cell
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
 
        //Create header cells
        row = sheet.createRow(r++);
 
        cell = row.createCell(c++);
        cell.setCellStyle(style);
        cell.setCellValue("Title");
 
        cell = row.createCell(c++);
        cell.setCellStyle(style);
        cell.setCellValue("URL");
 
        cell = row.createCell(c++);
        cell.setCellStyle(style);
        cell.setCellValue("Categories");
 
        cell = row.createCell(c++);
        cell.setCellStyle(style);
        cell.setCellValue("Tags");
 
        //Create data cell
        for(InfEjecutivo article:articles){
            row = sheet.createRow(r++);
            c = 0;
            row.createCell(c++).setCellValue(article.getcNomSuc());
            row.createCell(c++).setCellValue(article.getcSucursal());
            row.createCell(c++).setCellValue(article.getDtFechaV().toString());
            row.createCell(c++).setCellValue(article.getcAcciones());
 
        }
        for(int i = 0 ; i < 4; i++)
            sheet.autoSizeColumn(i, true);
 
    }
 
}
