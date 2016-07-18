package com.dhtmlx.demoapp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.progress.open4gl.Open4GLException;
import com.sinergitec.calendar.dao.ClienteDaoImpl;
import com.sinergitec.calendar.dao.UsuarioDaoImpl;
import com.sinergitec.calendar.model.CtUsuarioWeb;

@Controller
public class UsuarioController {
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	String Inicio(Model model) throws Open4GLException, IOException{
		
		model.addAttribute("ctUsuarioWeb",new CtUsuarioWeb());
		
		return "usuario";
	}
	
	@RequestMapping(value = "/CompaniaListado", headers = "Accept=application/json")
	public @ResponseBody String CompaniaListado(Boolean lActivos)	
					throws Open4GLException, IOException {

		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		String lista = "";

		lista = new Gson().toJson(valor.ListaCompania(lActivos));
		return lista;
	}
	
	@RequestMapping(value = "/ClienteListado", headers = "Accept=application/json")
	public @ResponseBody String ClienteListado(String cCveCia)	
					throws Open4GLException, IOException {

		ClienteDaoImpl valor = new ClienteDaoImpl();
		String lista = "";

		lista = new Gson().toJson(valor.listaCliente(cCveCia));
		return lista;
	}
	
	@RequestMapping(value = "/UsuarioListado", headers = "Accept=application/json")
	public @ResponseBody String UsuarioListado(Boolean lActivo)	
					throws Open4GLException, IOException {

		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		String lista = "";

		lista = new Gson().toJson(valor.ListaUsuarioWeb(lActivo));
		return lista;
	}
	
	@RequestMapping(value = "/usuarioInsertar", method = RequestMethod.POST)
	String usuarioInsertar(@ModelAttribute("ctUsuarioWeb") CtUsuarioWeb obj, Model model) throws Open4GLException, IOException{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
		String auxFecha = dateFormat.format(new Date());
		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		obj.setlActivo(true);
		obj.setDtCreado(auxFecha);
		obj.setDtModificado(auxFecha);
		obj.setcUsuario("SISAEM");
		valor.Inserta("SISAEM", obj);
		
		return "redirect:/usuario";
	}

}
