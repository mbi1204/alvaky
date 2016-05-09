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
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sinergitec.calendar.model.InfEjecutivo;

public class ExcelBuilder extends AbstractExcelView {
	 
   
    @SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
    	
    	System.out.println("Estoy en el que crea el excel");
    	
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
         
        header.createCell(0).setCellValue("Fecha de Visita");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Agua Cruda");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("Agua Suavizada");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Agua Filtrada");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("Consumibles");
        header.getCell(4).setCellStyle(style);
        
        header.createCell(5).setCellValue("Acciones Realizadas");
        header.getCell(5).setCellStyle(style);
        
        header.createCell(6).setCellValue("Consumibles");
        header.getCell(6).setCellStyle(style);
        
        header.createCell(7).setCellValue("Comentarios Realizados");
        header.getCell(7).setCellStyle(style);
        
        header.createCell(8).setCellValue("Tiempos Reales de Trabajo");
        header.getCell(8).setCellStyle(style);
        
         
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
