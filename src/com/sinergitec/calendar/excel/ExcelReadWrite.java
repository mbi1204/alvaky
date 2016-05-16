package com.sinergitec.calendar.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sinergitec.calendar.model.InfEjecutivo;

public class ExcelReadWrite extends AbstractExcelView {
	 
   
    @SuppressWarnings({ "unchecked", "resource" })
	protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbookExcel, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	//Image
        String path = getServletContext().getRealPath("codebase/otros/template.xls");
    	
    	// carga de archivo template
    	
    	FileInputStream inputStream = new FileInputStream(new File(path));
    	workbookExcel = new HSSFWorkbook(inputStream);
    	
    	
    	// get data model which is passed by the Spring container
    	
        List<InfEjecutivo> listBooks = (List<InfEjecutivo>) model.get("listBooks");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbookExcel.getSheetAt(0);
         
        // create data rows
        int rowCount = 6;
        
        String cNomSucursal = "";
         
        for (InfEjecutivo aBook : listBooks) {
            HSSFRow aRow = sheet.getRow(rowCount++);
            cNomSucursal = aBook.getcNomSuc();
            aRow.createCell(1).setCellValue(aBook.getDtFechaV().toString());
            
            aRow.createCell(2).setCellValue(aBook.getDeCloroEnt());
            
            aRow.createCell(3).setCellValue(aBook.getDePHEnt());
            
            aRow.createCell(4).setCellValue(aBook.getDeDurEnt());
            
            aRow.createCell(5).setCellValue(aBook.getDeSTDEnt());
            
            aRow.createCell(6).setCellValue(aBook.getDeCloroFilt());
            
            aRow.createCell(7).setCellValue(aBook.getDePHFilt());
            
            aRow.createCell(8).setCellValue(aBook.getDeDurFilt());
            
            aRow.createCell(9).setCellValue(aBook.getDeSTDFilt());
            
            aRow.createCell(10).setCellValue(aBook.getDeCloroUV());
            
            aRow.createCell(11).setCellValue(aBook.getDePHUV());
            
            aRow.createCell(12).setCellValue(aBook.getDeDurUV());
            
            aRow.createCell(13).setCellValue(aBook.getDeSTDUV());
            
            aRow.createCell(14).setCellValue(aBook.getDeAlcUV());
            
            aRow.createCell(15).setCellValue(aBook.getDeConsSed());
            
            aRow.createCell(16).setCellValue(aBook.getDeConsSal());
            
            aRow.createCell(17).setCellValue(aBook.getDeConsCarb());
            
            aRow.createCell(18).setCellValue(aBook.getDeConsSalP());
            
            aRow.createCell(19).setCellValue(aBook.getcOtRefacc());
            
            aRow.createCell(20).setCellValue(aBook.getDeORCant());
            
            aRow.createCell(21).setCellValue(aBook.getcAcciones());
            
            aRow.createCell(22).setCellValue(aBook.getcRecomienda());
            
            aRow.createCell(23).setCellValue(aBook.getcHoraEntrada());
            
            aRow.createCell(24).setCellValue(aBook.getcHoraSalida());
            
            aRow.createCell(25).setCellValue(aBook.getcTiempoTot());
            
        }
        inputStream.close();
        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\Alex\\Downloads\\reporte.xls"));
        workbookExcel.write(outFile);
        outFile.close();
        //sucursal.createCell(2).setCellValue(cNomSucursal);
        //sucursal.getCell(2).setCellStyle(sucursalStyle);
        //sucursal.getSheet().autoSizeColumn(2);
        
        
    }
}
