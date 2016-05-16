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
	 
   
    @SuppressWarnings({ "unchecked", "static-access" })
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
        CellStyle aguaCruda = workbook.createCellStyle();
        CellStyle aguaSuavizada = workbook.createCellStyle();
        CellStyle aguaFiltrada = workbook.createCellStyle();
        CellStyle textoAjustado = workbook.createCellStyle();
        CellStyle sucursalStyle = workbook.createCellStyle();
        
        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        
        Font fontDos = workbook.createFont();
        fontDos.setFontName("Arial");
        fontDos.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontDos.setColor(HSSFColor.BLACK.index);
        
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(font);
        style.setWrapText(true);
        style.setAlignment(style.ALIGN_CENTER);
        
        sucursalStyle.setFillForegroundColor(HSSFColor.DARK_YELLOW.index);
        sucursalStyle.setFont(fontDos);
        sucursalStyle.setWrapText(true);
        sucursalStyle.setAlignment(sucursalStyle.ALIGN_CENTER);
         
        aguaCruda.setFillForegroundColor(HSSFColor.GREEN.index);
        aguaCruda.setFillPattern(CellStyle.SOLID_FOREGROUND);
        aguaCruda.setFont(font);
        aguaCruda.setWrapText(true);
        aguaCruda.setAlignment(aguaCruda.ALIGN_CENTER);
        
        aguaSuavizada.setFillForegroundColor(HSSFColor.OLIVE_GREEN.index);
        aguaSuavizada.setFillPattern(CellStyle.SOLID_FOREGROUND);
        aguaSuavizada.setFont(font);
        aguaSuavizada.setWrapText(true);
        aguaSuavizada.setAlignment(aguaSuavizada.ALIGN_CENTER);
        
        aguaFiltrada.setFillForegroundColor(HSSFColor.DARK_BLUE.index);
        aguaFiltrada.setFillPattern(CellStyle.SOLID_FOREGROUND);
        aguaFiltrada.setFont(font);
        aguaFiltrada.setWrapText(true);
        aguaFiltrada.setAlignment(aguaFiltrada.ALIGN_CENTER);
         
        textoAjustado.setFont(fontDos);
        textoAjustado.setWrapText(false);
        textoAjustado.setAlignment(textoAjustado.ALIGN_CENTER);
        
        //font.setFontHeight((short)24);
        /*
        //Image
        String path = getServletContext().getRealPath("codebase/imgs/Starbucks_Coffee_Logo.png");
        
        // read the image to the stream
        FileInputStream stream = new FileInputStream(path);
        
        byte[] imageBytes = IOUtils.toByteArray(stream);
        int pictureIndex = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);
        stream.close();
        
        HSSFCreationHelper helper = workbook.getCreationHelper();
        HSSFPatriarch drawing = sheet.createDrawingPatriarch();

        HSSFClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(0);
        anchor.setRow1(0); // same row is okay
        
        HSSFPicture pict = drawing.createPicture( anchor, pictureIndex );
        pict.resize(80, 80);*/
        
        // create header row
        HSSFRow sucursal = sheet.createRow(1);
        HSSFRow header = sheet.createRow(2);
        HSSFRow row1 = sheet.createRow(3);
        
        //Creacion de Celdas combinadas
        sheet.addMergedRegion(CellRangeAddress.valueOf("A2:B2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("A3:A4"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("B3:E3"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("F3:I3"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("J3:N3"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("O3:R3"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("S3:T3"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("U3:U4"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("V3:V4"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("W3:Y3"));
        
        sucursal.createCell(0).setCellValue("Sucursal: ");
        sucursal.getCell(0).setCellStyle(sucursalStyle);
        
        header.createCell(0).setCellValue("Fecha de Visita");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Agua Cruda");
        header.getCell(1).setCellStyle(aguaCruda);
        
        row1.createCell(1).setCellValue("Chlorine (Cloro) 0.2 - 1.5 ppm");
        row1.getCell(1).setCellStyle(aguaCruda);
        row1.createCell(2).setCellValue("pH 6.5 - 8.5");
        row1.getCell(2).setCellStyle(aguaCruda);
        row1.createCell(3).setCellValue("Total Hardness (Dureza) 0 - 500 ppm");
        row1.getCell(3).setCellStyle(aguaCruda);
        row1.createCell(4).setCellValue("Total Dissolved Solid (STD) 0 - 1000 ppm");
        row1.getCell(4).setCellStyle(aguaCruda);
        
         
        header.createCell(5).setCellValue("Agua Suavizada");
        header.getCell(5).setCellStyle(aguaSuavizada);
        
        row1.createCell(5).setCellValue("Chlorine (Cloro) 0.2 - 1.5 ppm");
        row1.getCell(5).setCellStyle(aguaSuavizada);
        row1.createCell(6).setCellValue("pH 6.5 - 8.5");
        row1.getCell(6).setCellStyle(aguaSuavizada);
        row1.createCell(7).setCellValue("Total Hardness (Dureza) 0 - 500 ppm");
        row1.getCell(7).setCellStyle(aguaSuavizada);
        row1.createCell(8).setCellValue("Total Dissolved Solid (STD) 0 - 1000 ppm");
        row1.getCell(8).setCellStyle(aguaSuavizada);
        
        
         
        header.createCell(9).setCellValue("Agua Filtrada");
        header.getCell(9).setCellStyle(aguaFiltrada);
        
        row1.createCell(9).setCellValue("Chlorine (Cloro) 0.2 - 1.5 ppm");
        row1.getCell(9).setCellStyle(aguaFiltrada);
        row1.createCell(10).setCellValue("pH 6.5 - 8.5");
        row1.getCell(10).setCellStyle(aguaFiltrada);
        row1.createCell(11).setCellValue("Total Hardness (Dureza) 0 - 500 ppm");
        row1.getCell(11).setCellStyle(aguaFiltrada);
        row1.createCell(12).setCellValue("Total Dissolved Solid (STD) 0 - 1000 ppm");
        row1.getCell(12).setCellStyle(aguaFiltrada);
        row1.createCell(13).setCellValue("Alkalinity (Alcalinidad) ");
        row1.getCell(13).setCellStyle(aguaFiltrada);
        
         
        header.createCell(14).setCellValue("Consumibles");
        header.getCell(14).setCellStyle(style);
        
        row1.createCell(14).setCellValue("Sed.");
        row1.getCell(14).setCellStyle(style);
        row1.createCell(15).setCellValue("Sal");
        row1.getCell(15).setCellStyle(style);
        row1.createCell(16).setCellValue("Carbon");
        row1.getCell(16).setCellStyle(style);
        row1.createCell(17).setCellValue("Sal pellet");
        row1.getCell(17).setCellStyle(style);
        
        
        header.createCell(18).setCellValue("Refacciones");
        header.getCell(18).setCellStyle(style);
        
        row1.createCell(18).setCellValue("Otras");
        row1.getCell(18).setCellStyle(style);
        row1.createCell(19).setCellValue("Cantidad");
        row1.getCell(19).setCellStyle(style);
        
        
        header.createCell(20).setCellValue("Acciones Realizadas");
        header.getCell(20).setCellStyle(style);	
        
        header.createCell(21).setCellValue("Comentarios Realizados");
        header.getCell(21).setCellStyle(style);
        
        
        header.createCell(22).setCellValue("Tiempos Reales de Trabajo");
        header.getCell(22).setCellStyle(style);
        
        row1.createCell(22).setCellValue("Hora de Llegada");
        row1.getCell(22).setCellStyle(style);
        row1.createCell(23).setCellValue("Hora de Salida");
        row1.getCell(23).setCellStyle(style);
        row1.createCell(24).setCellValue("Tiempo Total");
        row1.getCell(24).setCellStyle(style);
        
         
        // create data rows
        int rowCount = 4;
        
        String cNomSucursal = "";
         
        for (InfEjecutivo aBook : listBooks) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            cNomSucursal = aBook.getcNomSuc();
            aRow.createCell(0).setCellValue(aBook.getDtFechaV().toString());
            aRow.getCell(0).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(0);
            aRow.createCell(1).setCellValue(aBook.getDeCloroEnt());
            aRow.getCell(1).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(1);
            aRow.createCell(2).setCellValue(aBook.getDePHEnt());
            aRow.getCell(2).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(2);
            aRow.createCell(3).setCellValue(aBook.getDeDurEnt());
            aRow.getCell(3).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(3);
            aRow.createCell(4).setCellValue(aBook.getDeSTDEnt());
            aRow.getCell(4).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(4);
            aRow.createCell(5).setCellValue(aBook.getDeCloroFilt());
            aRow.getCell(5).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(5);
            aRow.createCell(6).setCellValue(aBook.getDePHFilt());
            aRow.getCell(6).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(6);
            aRow.createCell(7).setCellValue(aBook.getDeDurFilt());
            aRow.getCell(7).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(7);
            aRow.createCell(8).setCellValue(aBook.getDeSTDFilt());
            aRow.getCell(8).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(8);
            aRow.createCell(9).setCellValue(aBook.getDeCloroUV());
            aRow.getCell(9).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(9);
            aRow.createCell(10).setCellValue(aBook.getDePHUV());
            aRow.getCell(10).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(10);
            aRow.createCell(11).setCellValue(aBook.getDeDurUV());
            aRow.getCell(11).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(11);
            aRow.createCell(12).setCellValue(aBook.getDeSTDUV());
            aRow.getCell(12).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(12);
            aRow.createCell(13).setCellValue(aBook.getDeAlcUV());
            aRow.getCell(13).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(13);
            aRow.createCell(14).setCellValue(aBook.getDeConsSed());
            aRow.getCell(14).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(14);
            aRow.createCell(15).setCellValue(aBook.getDeConsSal());
            aRow.getCell(15).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(15);
            aRow.createCell(16).setCellValue(aBook.getDeConsCarb());
            aRow.getCell(16).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(16);
            aRow.createCell(17).setCellValue(aBook.getDeConsSalP());
            aRow.getCell(17).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(17);
            aRow.createCell(18).setCellValue(aBook.getcOtRefacc());
            aRow.getCell(18).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(18);
            aRow.createCell(19).setCellValue(aBook.getDeORCant());
            aRow.getCell(19).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(19);
            aRow.createCell(20).setCellValue(aBook.getcAcciones());
            aRow.getCell(20).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(20);
            aRow.createCell(21).setCellValue(aBook.getcRecomienda());
            aRow.getCell(21).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(21);
            aRow.createCell(22).setCellValue(aBook.getcHoraEntrada());
            aRow.getCell(22).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(22);
            aRow.createCell(23).setCellValue(aBook.getcHoraSalida());
            aRow.getCell(23).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(23);
            aRow.createCell(24).setCellValue(aBook.getcTiempoTot());
            aRow.getCell(24).setCellStyle(textoAjustado);
            aRow.getSheet().autoSizeColumn(24);
        }

        sucursal.createCell(2).setCellValue(cNomSucursal);
        sucursal.getCell(2).setCellStyle(sucursalStyle);
        sucursal.getSheet().autoSizeColumn(2);
        
    }
}
