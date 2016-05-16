package com.sinergitec.calendar.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sinergitec.calendar.model.InfEjecutivo;

public class ExcelReadWrite extends AbstractExcelView {
	 
   
    @SuppressWarnings({ "unchecked", "resource" })
	protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbookExcel, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	//Excel plantilla
        String path = getServletContext().getRealPath("codebase/otros/reporte.xlt");
    	
    	// carga de archivo template
    	
    	FileInputStream inputStream = new FileInputStream(new File(path));
    	workbookExcel = new HSSFWorkbook(inputStream);
    	
    	
    	// get data model which is passed by the Spring container
    	
        List<InfEjecutivo> listBooks = (List<InfEjecutivo>) model.get("listBooks");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbookExcel.getSheetAt(0);
        HSSFRow sucursal = sheet.createRow(6);
        
        //Style
        CellStyle style = workbookExcel.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         
        // create data rows
        int rowCount = 6;
        
        String cNomSucursal = "";
         
        for (InfEjecutivo aBook : listBooks) {
            HSSFRow aRow = sheet.getRow(rowCount++);
            cNomSucursal = aBook.getcNomSuc();
            
            aRow.createCell(1).setCellValue(aBook.getDtFechaV().toString());
            aRow.getCell(1).setCellStyle(style);
            
            aRow.createCell(2).setCellValue(aBook.getDeCloroEnt());
            aRow.getCell(2).setCellStyle(style);            
            
            aRow.createCell(3).setCellValue(aBook.getDePHEnt());
            aRow.getCell(3).setCellStyle(style);
            
            aRow.createCell(4).setCellValue(aBook.getDeDurEnt());
            aRow.getCell(4).setCellStyle(style);
            
            aRow.createCell(5).setCellValue(aBook.getDeSTDEnt());
            aRow.getCell(5).setCellStyle(style);
            
            aRow.createCell(6).setCellValue(aBook.getDeCloroFilt());
            aRow.getCell(6).setCellStyle(style);
            
            aRow.createCell(7).setCellValue(aBook.getDePHFilt());
            aRow.getCell(7).setCellStyle(style);
            
            aRow.createCell(8).setCellValue(aBook.getDeDurFilt());
            aRow.getCell(8).setCellStyle(style);
            
            aRow.createCell(9).setCellValue(aBook.getDeSTDFilt());
            aRow.getCell(9).setCellStyle(style);
            
            aRow.createCell(10).setCellValue(aBook.getDeCloroUV());
            aRow.getCell(10).setCellStyle(style);
            
            aRow.createCell(11).setCellValue(aBook.getDePHUV());
            aRow.getCell(11).setCellStyle(style);
            
            aRow.createCell(12).setCellValue(aBook.getDeDurUV());
            aRow.getCell(12).setCellStyle(style);
            
            aRow.createCell(13).setCellValue(aBook.getDeSTDUV());
            aRow.getCell(13).setCellStyle(style);
            
            aRow.createCell(14).setCellValue(aBook.getDeAlcUV());
            aRow.getCell(14).setCellStyle(style);
            
            aRow.createCell(15).setCellValue(aBook.getDeConsSed());
            aRow.getCell(15).setCellStyle(style);
            
            aRow.createCell(16).setCellValue(aBook.getDeConsSal());
            aRow.getCell(16).setCellStyle(style);
            
            aRow.createCell(17).setCellValue(aBook.getDeConsCarb());
            aRow.getCell(17).setCellStyle(style);
            
            aRow.createCell(18).setCellValue(aBook.getDeConsSalP());
            aRow.getCell(18).setCellStyle(style);
            
            aRow.createCell(19).setCellValue(aBook.getcOtRefacc());
            aRow.getCell(19).setCellStyle(style);
            
            aRow.createCell(20).setCellValue(aBook.getDeORCant());
            aRow.getCell(20).setCellStyle(style);
            
            aRow.createCell(21).setCellValue(aBook.getcAcciones());
            aRow.getCell(21).setCellStyle(style);
            
            aRow.createCell(22).setCellValue(aBook.getcRecomienda());
            aRow.getCell(22).setCellStyle(style);
            
            aRow.createCell(23).setCellValue(aBook.getcHoraEntrada());
            aRow.getCell(23).setCellStyle(style);
            
            aRow.createCell(24).setCellValue(aBook.getcHoraSalida());
            aRow.getCell(24).setCellStyle(style);
            
            aRow.createCell(25).setCellValue(aBook.getcTiempoTot());
            aRow.getCell(25).setCellStyle(style);
            
        }
        sucursal.createCell(0).setCellValue(cNomSucursal);
        sucursal.getCell(0).setCellStyle(style);
        inputStream.close();
        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\Alex\\Downloads\\reporte.xls"));
        workbookExcel.write(outFile);
        outFile.close();
    }
}
