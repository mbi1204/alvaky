package com.sinergitec.calendar.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sinergitec.calendar.model.InfEjecutivo;

public class PDFBuilder extends AbstractITextPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*PDF de reporete ejecutivo*/
		
		
		List<InfEjecutivo> listBooks = (List<InfEjecutivo>) model.get("listBooks");
		
		// Carga y redimensiona una imagen en el pdf
		String path = getServletContext().getRealPath("codebase/imgs/Starbucks_Coffee_Logo.png");
		Image img = Image.getInstance(path);
		img.scaleAbsolute(80, 80);
        doc.add(img);
		
        doc.add(new Paragraph("Reporte Ejecutivo"));
        
        //Inicio de la tabla reporte ejecutivo parte 1
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {1.0f, 0.8f, 0.8f, 0.8f, 0.8f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(3);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
         
        // write table header
        PdfPCell cellVisita = new PdfPCell(new Phrase("Fecha de Visita", font));
        cellVisita.setBackgroundColor(BaseColor.BLUE);
        cellVisita.setPadding(3);
        cellVisita.setRowspan(2);
        
        table.addCell(cellVisita);

        PdfPCell cellAguaCruda = new PdfPCell(new Phrase("Agua Cruda", font));
        cellAguaCruda.setBackgroundColor(BaseColor.BLUE);
        cellAguaCruda.setPadding(3);
        cellAguaCruda.setColspan(4);
        
        table.addCell(cellAguaCruda);
         
        cell.setPhrase(new Phrase("Chlorine (Cloro) 0.2 - 1.5 ppm", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("pH 6.5 - 8.5", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Total Hardness (Dureza) 0 - 500 ppm", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Total Dissolved Solid (STD) 0 - 1000 ppm", font));
        table.addCell(cell);
         
        // write table row data
        for (InfEjecutivo aBook : listBooks) {
        	table.addCell(aBook.getDtFechaV().toString());
        	table.addCell(aBook.getDeCloroEnt().toString());
        	table.addCell(aBook.getDePHEnt().toString());
        	table.addCell(aBook.getDeDurEnt().toString());
        	table.addCell(aBook.getDeSTDEnt().toString());
        }
         
        doc.add(table);
        
        //Termino de la tabla reporte ejecutivo parte 1
        
        
        //Inicio de la tabla reporte ejecutivo parte 2
        
        PdfPTable table2 = new PdfPTable(4);
        table2.setWidthPercentage(100.0f);
        table2.setWidths(new float[] {1.0f, 0.8f, 0.8f, 0.8f});
        table2.setSpacingBefore(10);
         
        // define font for table header row
        
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell2 = new PdfPCell();
        cell2.setBackgroundColor(BaseColor.BLUE);
        cell2.setPadding(3);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell2.setHorizontalAlignment(Element.ALIGN_MIDDLE);
         
        // write table header

        PdfPCell cellAguaSuavizada = new PdfPCell(new Phrase("Agua Suavizada", font));
        cellAguaSuavizada.setBackgroundColor(BaseColor.BLUE);
        cellAguaSuavizada.setPadding(3);
        cellAguaSuavizada.setColspan(4);
        
        table2.addCell(cellAguaSuavizada);
         
        cell2.setPhrase(new Phrase("Chlorine (Cloro) 0.2 - 1.5 ppm", font));
        table2.addCell(cell2);
         
        cell2.setPhrase(new Phrase("pH 6.5 - 8.5", font));
        table2.addCell(cell2);
        
        cell2.setPhrase(new Phrase("Total Hardness (Dureza) 0 - 500 ppm", font));
        table2.addCell(cell2);
        
        cell2.setPhrase(new Phrase("Total Dissolved Solid (STD) 0 - 1000 ppm", font));
        table2.addCell(cell2);
         
        // write table row data
        for (InfEjecutivo aBook : listBooks) {
        	table2.addCell(aBook.getDeCloroFilt().toString());
        	table2.addCell(aBook.getDePHFilt().toString());
        	table2.addCell(aBook.getDeDurFilt().toString());
        	table2.addCell(aBook.getDeSTDFilt().toString());
        }
         
        doc.add(table2);
        
        //Termino de la tabla reporte ejecutivo parte 2
        
        //Inicio de la tabla reporte ejecutivo parte 3
        
        PdfPTable table3 = new PdfPTable(5);
        table3.setWidthPercentage(100.0f);
        table3.setWidths(new float[] {1.0f, 0.8f, 0.8f, 0.8f, 0.8f});
        table3.setSpacingBefore(10);
         
        // define font for table header row
        
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell3 = new PdfPCell();
        cell3.setBackgroundColor(BaseColor.BLUE);
        cell3.setPadding(3);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell3.setHorizontalAlignment(Element.ALIGN_MIDDLE);
         
        // write table header

        PdfPCell cellAguaFiltrada = new PdfPCell(new Phrase("Agua Filtrada", font));
        cellAguaFiltrada.setBackgroundColor(BaseColor.BLUE);
        cellAguaFiltrada.setPadding(3);
        cellAguaFiltrada.setColspan(5);
        
        table3.addCell(cellAguaFiltrada);
         
        cell3.setPhrase(new Phrase("Chlorine (Cloro) 0.2 - 1.5 ppm", font));
        table3.addCell(cell3);
         
        cell3.setPhrase(new Phrase("pH 6.5 - 8.5", font));
        table3.addCell(cell3);
        
        cell3.setPhrase(new Phrase("Total Hardness (Dureza) 0 - 500 ppm", font));
        table3.addCell(cell3);
        
        cell3.setPhrase(new Phrase("Total Dissolved Solid (STD) 0 - 1000 ppm", font));
        table3.addCell(cell3);
        
        cell3.setPhrase(new Phrase("Alkalinity (Alcalinidad) < - 100 ppm", font));
        table3.addCell(cell3);
         
        // write table row data
        for (InfEjecutivo aBook : listBooks) {
        	table3.addCell(aBook.getDeCloroUV().toString());
        	table3.addCell(aBook.getDePHUV().toString());
        	table3.addCell(aBook.getDeDurUV().toString());
        	table3.addCell(aBook.getDeSTDUV().toString());
        	table3.addCell(aBook.getDeAlcUV().toString());
        }
         
        doc.add(table3);
        
        //Termino de la tabla reporte ejecutivo parte 3
        
        //Inicio de la tabla reporte ejecutivo parte 4
        
        PdfPTable table4 = new PdfPTable(4);
        table4.setWidthPercentage(100.0f);
        table4.setWidths(new float[] {1.0f, 0.8f, 0.8f, 0.8f});
        table4.setSpacingBefore(10);
         
        // define font for table header row
        
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell4 = new PdfPCell();
        cell4.setBackgroundColor(BaseColor.BLUE);
        cell4.setPadding(3);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell4.setHorizontalAlignment(Element.ALIGN_MIDDLE);
         
        // write table header

        PdfPCell cellConsumibles = new PdfPCell(new Phrase("Consumibles", font));
        cellConsumibles.setBackgroundColor(BaseColor.BLUE);
        cellConsumibles.setPadding(3);
        cellConsumibles.setColspan(4);
        
        table4.addCell(cellConsumibles);
         
        cell4.setPhrase(new Phrase("Sedimentos", font));
        table4.addCell(cell4);
         
        cell4.setPhrase(new Phrase("Sal", font));
        table4.addCell(cell4);
        
        cell4.setPhrase(new Phrase("Carbón", font));
        table4.addCell(cell4);
        
        cell4.setPhrase(new Phrase("Sal Pellet", font));
        table4.addCell(cell4);
         
        // write table row data
        for (InfEjecutivo aBook : listBooks) {
        	table4.addCell(aBook.getDeConsSed().toString());
        	table4.addCell(aBook.getDeConsSal().toString());
        	table4.addCell(aBook.getDeConsCarb().toString());
        	table4.addCell(aBook.getDeConsSalP().toString());
        }
         
        doc.add(table4);
        
        //Termino de la tabla reporte ejecutivo parte 4
        
       /* //Inicio de la tabla reporte ejecutivo parte 5 Atencion con este bloque
        
        PdfPTable table5 = new PdfPTable(4);
        table5.setWidthPercentage(100.0f);
        table5.setWidths(new float[] {1.0f, 0.8f, 0.8f, 0.8f});
        table5.setSpacingBefore(10);
         
        // define font for table header row
        
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell5 = new PdfPCell();
        cell5.setBackgroundColor(BaseColor.BLUE);
        cell5.setPadding(3);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell5.setHorizontalAlignment(Element.ALIGN_MIDDLE);
         
        // write table header

        PdfPCell cellRefacciones = new PdfPCell(new Phrase("Consumibles", font));
        cellRefacciones.setBackgroundColor(BaseColor.BLUE);
        cellRefacciones.setPadding(3);
        cellRefacciones.setColspan(4);
        
        table5.addCell(cellRefacciones);
         
        cell5.setPhrase(new Phrase("Sedimentos", font));
        table5.addCell(cell5);
         
        cell5.setPhrase(new Phrase("Sal", font));
        table5.addCell(cell5);
        
        cell5.setPhrase(new Phrase("Carbón", font));
        table5.addCell(cell5);
        
        cell5.setPhrase(new Phrase("Sal Pellet", font));
        table5.addCell(cell5);
         
        // write table row data
        for (InfEjecutivo aBook : listBooks) {
        	table4.addCell(aBook.getDeConsSed().toString());
        	table4.addCell(aBook.getDeConsSal().toString());
        	table4.addCell(aBook.getDeConsCarb().toString());
        	table4.addCell(aBook.getDeConsSalP().toString());
        }
         
        doc.add(table4);
        
        //Termino de la tabla reporte ejecutivo parte 5 */
	}

}
