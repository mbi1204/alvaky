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
        //font.setFontHeight((short)24);
        style.setFont(font);
        style.setAlignment(style.ALIGN_CENTER);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        //Row row = sheet.createRow((short) 1);
        //Cell cell = row.createCell((short) 1);
        
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
        sheet.createRow(1).createCell(1).setCellValue("Chlorine (Cloro) 0.2 - 1.5 ppm");
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
        int rowCount = 2;
         
        for (InfEjecutivo aBook : listBooks) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(aBook.getDtFechaV());
            aRow.createCell(1).setCellValue(aBook.getDeCloroEnt());
            aRow.createCell(2).setCellValue(aBook.getDePHEnt());
            aRow.createCell(3).setCellValue(aBook.getDeDurEnt());
            aRow.createCell(4).setCellValue(aBook.getDeSTDEnt());
            aRow.createCell(5).setCellValue(aBook.getDeCloroFilt());
            aRow.createCell(6).setCellValue(aBook.getDePHFilt());
            aRow.createCell(7).setCellValue(aBook.getDeDurFilt());
            aRow.createCell(8).setCellValue(aBook.getDeSTDFilt());
            aRow.createCell(9).setCellValue(aBook.getDeCloroUV());
            aRow.createCell(10).setCellValue(aBook.getDePHUV());
            aRow.createCell(11).setCellValue(aBook.getDeDurUV());
            aRow.createCell(12).setCellValue(aBook.getDeSTDUV());
            aRow.createCell(13).setCellValue(aBook.getDeAlcUV());
            aRow.createCell(14).setCellValue(aBook.getDeConsSed());
            aRow.createCell(15).setCellValue(aBook.getDeConsSal());
            aRow.createCell(16).setCellValue(aBook.getDeConsCarb());
            aRow.createCell(17).setCellValue(aBook.getDeConsSalP());
            aRow.createCell(18).setCellValue(aBook.getcOtRefacc());
            aRow.createCell(19).setCellValue(aBook.getDeORCant());
            aRow.createCell(20).setCellValue(aBook.getcAcciones());
            aRow.createCell(21).setCellValue(aBook.getcRecomienda());
            aRow.createCell(22).setCellValue(aBook.getcHoraEntrada());
            aRow.createCell(23).setCellValue(aBook.getcHoraSalida());
            aRow.createCell(24).setCellValue(aBook.getcTiempoTot());
        }
    }
}
