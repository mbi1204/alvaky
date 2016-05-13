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
        int rowCount = 7;
        
        String cNomSucursal = "";
         
        for (InfEjecutivo aBook : listBooks) {
            HSSFRow aRow = sheet.getRow(rowCount++);
            cNomSucursal = aBook.getcNomSuc();
            aRow.getCell(0).setCellValue(aBook.getDtFechaV().toString());
            
            aRow.getCell(1).setCellValue(aBook.getDeCloroEnt());
            
            aRow.getCell(2).setCellValue(aBook.getDePHEnt());
            
            aRow.getCell(3).setCellValue(aBook.getDeDurEnt());
            
            aRow.getCell(4).setCellValue(aBook.getDeSTDEnt());
            
            aRow.getCell(5).setCellValue(aBook.getDeCloroFilt());
            
            aRow.getCell(6).setCellValue(aBook.getDePHFilt());
            
            aRow.getCell(7).setCellValue(aBook.getDeDurFilt());
            
            aRow.getCell(8).setCellValue(aBook.getDeSTDFilt());
            
            aRow.getCell(9).setCellValue(aBook.getDeCloroUV());
            
            aRow.getCell(10).setCellValue(aBook.getDePHUV());
            
            aRow.getCell(11).setCellValue(aBook.getDeDurUV());
            
            aRow.getCell(12).setCellValue(aBook.getDeSTDUV());
            
            aRow.getCell(13).setCellValue(aBook.getDeAlcUV());
            
            aRow.getCell(14).setCellValue(aBook.getDeConsSed());
            
            aRow.getCell(15).setCellValue(aBook.getDeConsSal());
            
            aRow.getCell(16).setCellValue(aBook.getDeConsCarb());
            
            aRow.getCell(17).setCellValue(aBook.getDeConsSalP());
            
            aRow.getCell(18).setCellValue(aBook.getcOtRefacc());
            
            aRow.getCell(19).setCellValue(aBook.getDeORCant());
            
            aRow.getCell(20).setCellValue(aBook.getcAcciones());
            
            aRow.getCell(21).setCellValue(aBook.getcRecomienda());
            
            aRow.getCell(22).setCellValue(aBook.getcHoraEntrada());
            
            aRow.getCell(23).setCellValue(aBook.getcHoraSalida());
            
            aRow.getCell(24).setCellValue(aBook.getcTiempoTot());
            
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
