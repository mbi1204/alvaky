package com.dhtmlx.demoapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.calendar.dao.ClienteDaoImpl;
import com.sinergitec.calendar.dao.InformeEjecutivoDaoImpl;
import com.sinergitec.calendar.dao.LocalDaoImpl;
import com.sinergitec.calendar.model.CtCliente;
import com.sinergitec.calendar.model.InfEjecutivo;

@Controller
public class ReporteController {
	
	@RequestMapping(value = "/reporte", method = RequestMethod.GET)
	String Inicio(Model model) throws Open4GLException, IOException{
		
		ClienteDaoImpl valor = new ClienteDaoImpl();
		List<CtCliente> cliente = valor.listaCliente("ALVAKY");
		
		model.addAttribute("ctCliente", new CtCliente());
		model.addAttribute("lista_ctCliente",cliente);
		
		return "reporte";
	}
	
	@RequestMapping(value = "/BuscaSucursal", headers = "Accept=application/json")
	public @ResponseBody String BuscaSucursal(String cCliente, Model model) throws Open4GLException, IOException {
		
		LocalDaoImpl valor = new LocalDaoImpl();
		String lista = "";
		
		lista = new Gson().toJson(valor.listaLocal("ALVAKY",cCliente));
		
		return lista;

	}
	
	@RequestMapping(value = "/ejecutivo", method = RequestMethod.GET)
	String Ejecutivo(Model model) throws Open4GLException, IOException{
		return "ejecutivo";
	}
	
	@RequestMapping(value = "/reporteEjecutivo", headers = "Accept=application/json")
	public @ResponseBody String Reporte(String cSucursal, Model model) throws Open4GLException, IOException{
		
		InformeEjecutivoDaoImpl valor = new InformeEjecutivoDaoImpl();
		String lista = "";
		
		lista = new Gson().toJson(valor.listaInforme("ALVAKY","06", cSucursal));
		return lista;
	}
	
	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadPDF(@RequestParam("sucursal") String sucursal) throws Open4GLException, IOException {
		
        // create some sample data
		InformeEjecutivoDaoImpl valor = new InformeEjecutivoDaoImpl();
        List<InfEjecutivo> listEjecutivo = new ArrayList<InfEjecutivo>();
        
        listEjecutivo = valor.listaInforme("ALVAKY","06", sucursal);
 
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("pdfView", "listBooks", listEjecutivo);
    }
	
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
    public ModelAndView downloadExcel(@RequestParam("sucursal") String sucursal) throws Open4GLException, IOException {
		
        // create some sample data
		InformeEjecutivoDaoImpl valor = new InformeEjecutivoDaoImpl();
        List<InfEjecutivo> listEjecutivo = new ArrayList<InfEjecutivo>();
        
        listEjecutivo = valor.listaInforme("ALVAKY","06", sucursal);
        
        // return a view which will be resolved by an excel view resolver
        //Crea el excel de 0
        return new ModelAndView("excelView", "listBooks", listEjecutivo);
 
        // return a view which will be resolved by an excel view resolver
        //Utiliza una plantilla y crea el excel
        //return new ModelAndView("excelViewRW", "listBooks", listEjecutivo);
    }
}
