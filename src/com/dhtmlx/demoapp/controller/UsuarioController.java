package com.dhtmlx.demoapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
	String usuarioInsertar(@ModelAttribute("ctUsuarioWeb") CtUsuarioWeb obj, Model model,
			HttpServletResponse response, ModelMap mm) throws Open4GLException, IOException{
		
		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		obj.setlActivo(true);
		obj.setcUsuario("SISAEM");
		String mensaje = valor.Inserta("SISAEM", obj);
		if(!mensaje.equals(null)){
			mm.put("mensaje", mensaje);
		}
		
		return "redirect:usuario";
	}
	
	@RequestMapping(value = "/UsuarioModificar", headers = "Accept=application/json")
	public @ResponseBody String UsuarioModificar(String listUsuarios) throws Open4GLException, IOException{
		
		Gson gson = new Gson();
		TypeToken<List<CtUsuarioWeb>> token = new TypeToken<List<CtUsuarioWeb>>(){};
		List<CtUsuarioWeb> usuarioList = gson.fromJson(listUsuarios, token.getType());
		
		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		
		String respuesta = "";
		respuesta = new Gson().toJson(valor.Borra("SISAEM", usuarioList));
		return respuesta;
	}
	
	@RequestMapping(value = "/UsuarioEliminar", headers = "Accept=application/json")
	public @ResponseBody String UsuarioEliminar(String listUsuarios) throws Open4GLException, IOException{
		
		Gson gson = new Gson();
		TypeToken<List<CtUsuarioWeb>> token = new TypeToken<List<CtUsuarioWeb>>(){};
		List<CtUsuarioWeb> usuarioList = gson.fromJson(listUsuarios, token.getType());
		
		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		
		String respuesta = "";
		respuesta = new Gson().toJson(valor.Borra("SISAEM", usuarioList));
		return respuesta;
	}

}
