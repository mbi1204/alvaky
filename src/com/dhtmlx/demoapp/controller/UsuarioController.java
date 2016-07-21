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
import com.sinergitec.calendar.model.CtUsuaCompWeb;
import com.sinergitec.calendar.model.CtUsuarioWeb;


@Controller
public class UsuarioController {
	
	private CtUsuarioWeb usuarioOLD;
	
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
			mm.addAttribute("mensaje", mensaje);
		}
		
		return "usuario";
	}
	
	@RequestMapping(value = "/usuarioModificado", method = RequestMethod.POST)
	String usuarioModificado(@ModelAttribute("ctUsuarioWeb") CtUsuarioWeb obj, Model model,
			HttpServletResponse response, ModelMap mm) throws Open4GLException, IOException{
		
		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		obj.setcUsuario("SISAEM");
		obj.setId(usuarioOLD.getId());
		String mensaje = valor.Actualiza("SISAEM", usuarioOLD, obj);
		if(!mensaje.equals(null)){
			mm.addAttribute("mensaje", mensaje);
		}
		
		return "usuario";
	}
	
	@RequestMapping(value = "/UsuarioModificar", method=RequestMethod.GET)
	public String UsuarioModificar(Model model) throws Open4GLException, IOException{
		
		UsuarioDaoImpl valor = new UsuarioDaoImpl();
		ClienteDaoImpl valor2 = new ClienteDaoImpl();
		
		model.addAttribute("ctUsuarioWeb", usuarioOLD);
		model.addAttribute("listCompania",valor.ListaCompania(true));
		model.addAttribute("listCliente",valor2.listaCliente(usuarioOLD.getCtUsuaCompWeb().getcCveCia()));
		
		return "usuarioUpdate";
	}
	
	@RequestMapping(value = "/UsuarioGet", headers = "Accept=application/json")
	public @ResponseBody  String UsuarioGet(String listUsuarios) throws Open4GLException, IOException{
		
		Gson gson = new Gson();
		TypeToken<List<CtUsuarioWeb>> token = new TypeToken<List<CtUsuarioWeb>>(){};
		List<CtUsuarioWeb> usuarioList = gson.fromJson(listUsuarios, token.getType());
		
		usuarioOLD = new CtUsuarioWeb();
		
		for (CtUsuarioWeb ctUsuarioWeb : usuarioList) {
			usuarioOLD.setcUsuarioWeb(ctUsuarioWeb.getcUsuarioWeb());
			usuarioOLD.setcPassword(ctUsuarioWeb.getcPassword());
			usuarioOLD.setlActivo(ctUsuarioWeb.getlActivo());
			usuarioOLD.setcCliente(ctUsuarioWeb.getcCliente());
			usuarioOLD.setDtCreado(ctUsuarioWeb.getDtCreado());
			usuarioOLD.setDtModificado(ctUsuarioWeb.getDtModificado());
			usuarioOLD.setcUsuario(ctUsuarioWeb.getcUsuario());
			usuarioOLD.setcNombre(ctUsuarioWeb.getcNombre());
			
			//Para llenar el objeto de ctUsuCompWeb
			CtUsuaCompWeb objUsuaCompWeb = new CtUsuaCompWeb();
			objUsuaCompWeb.setcCveCia(ctUsuarioWeb.getCtUsuaCompWeb().getcCveCia());
			usuarioOLD.setCtUsuaCompWeb(objUsuaCompWeb);
			
			usuarioOLD.setId(ctUsuarioWeb.getId());
			usuarioOLD.setError(ctUsuarioWeb.getError());
			usuarioOLD.setErrorTexto(ctUsuarioWeb.getErrorTexto());
		}
		
		return new Gson().toJson(usuarioOLD);
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
