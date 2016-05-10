package com.sinergitec.calendar.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sinergitec.calendar.model.InfEjecutivo;

public class ExcelBuilder extends AbstractExcelView {
	 
   
    @SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
    	
        List<InfEjecutivo> listBooks = (List<InfEjecutivo>) model.get("listBooks");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Reporte Ejecutivo");
        sheet.setDefaultColumnWidth(30);
         
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        /*Row row = sheet.createRow((short) 1);
        Cell cell = row.createCell((short) 1);*/
        
        sheet.addMergedRegion(CellRangeAddress.valueOf("A1:A2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("B1:E1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("F1:I1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("J1:N1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("O1:R1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("S1:T1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("U1:U2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("V1:V2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("W1:Y1"));
        
        header.createCell(0).setCellValue("Fecha de Visita");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Agua Cruda");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(5).setCellValue("Agua Suavizada");
        header.getCell(5).setCellStyle(style);
         
        header.createCell(9).setCellValue("Agua Filtrada");
        header.getCell(9).setCellStyle(style);
         
        header.createCell(14).setCellValue("Consumibles");
        header.getCell(14).setCellStyle(style);
        
        header.createCell(18).setCellValue("Refacciones");
        header.getCell(18).setCellStyle(style);
        
        header.createCell(20).setCellValue("Acciones Realizadas");
        header.getCell(20).setCellStyle(style);	
        
        header.createCell(21).setCellValue("Comentarios Realizados");
        header.getCell(21).setCellStyle(style);
        
        header.createCell(22).setCellValue("Tiempos Reales de Trabajo");
        header.getCell(22).setCellStyle(style);
        
         
        // create data rows
        int rowCount = 1;
         
        for (InfEjecutivo aBook : listBooks) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(aBook.getcSucursal());
            aRow.createCell(1).setCellValue(aBook.getcNomSuc());
            aRow.createCell(2).setCellValue(aBook.getcAcciones());
            aRow.createCell(3).setCellValue(aBook.getDtFechaV());
            aRow.createCell(4).setCellValue(aBook.getcRecomienda());
        }
    }
}
