package com.dhtmlx.demoapp.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.progress.open4gl.Open4GLException;
import com.sinergitec.calendar.dao.UsuarioDaoImpl;
import com.sinergitec.calendar.model.CtUsuarioWeb;

@Controller
@SessionAttributes("usuarioIniciado")
public class SimpleInitController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String Inicio(Model model) throws Open4GLException, IOException{
		
		return "login";
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	String Login(@RequestParam("cUsuario") String cUsuario,
			@RequestParam("cPassword") String cPassword, ModelMap mm, Model model) 
					throws Open4GLException, IOException{
		
		//Instancia del Dao y ctUsuarioWeb
		UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
		CtUsuarioWeb usuarioWebCompania = new CtUsuarioWeb();
		
		usuarioWebCompania = usuarioDao.Valida(cUsuario, cPassword);
		
		if(!usuarioWebCompania.getError() & usuarioWebCompania.getErrorTexto().equals("")){
			//Sesion :V
			model.addAttribute("usuarioIniciado",usuarioWebCompania);
			return"redirect:index"; 
		}
		mm.put("mensaje", "Usuario y/o Contraseña Inválidos");
		return"login";
	}
	
	@RequestMapping(value = "/cerrarSesion", method = RequestMethod.GET)
	String Fin(Model model, HttpServletRequest request) throws Open4GLException, IOException{
		
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioIniciado");
		
		return "login";
	}

	@RequestMapping({"/01_simple_init.html", "/index"})
    public ModelAndView scheduler_01( HttpServletRequest request, 
    		HttpServletResponse response, 
    		@ModelAttribute("usuarioIniciado") CtUsuarioWeb usuarioWebCompania) 
    				throws Exception {
    	// creates and configures scheduler instance
		
		Cookie compania = new Cookie("compania", usuarioWebCompania.getCtUsuaCompWeb().getcCveCia());
		Cookie cliente = new Cookie("cliente", usuarioWebCompania.getcCliente());
		response.addCookie(compania);
		response.addCookie(cliente);
		
		String cSucursal = ""; 
		
		if(request.getParameter("sucursal") != null){
			cSucursal = request.getParameter("sucursal");
		}
		
    	DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
    	
    	s.localizations.set("es");
    	s.config.setScrollHour(8);
    	s.setWidth(1000);
    	s.templates.getEventText();
    	s.config.setHourSizePx(25);
    	s.config.setDetailsOnDblClick(true);

    	// calendario de mantenimientos
    	CustomEventsManager evs = new CustomEventsManager(request);
    	s.parse(evs.getEvents(usuarioWebCompania.getCtUsuaCompWeb().getcCveCia(),
    			usuarioWebCompania.getcCliente(),cSucursal));
    	
    	// mantenimiento traidos de opOrdenServicio
    	s.parse(evs.correctivo(usuarioWebCompania.getCtUsuaCompWeb().getcCveCia(),
    			usuarioWebCompania.getcCliente(),cSucursal));
    	

    	ModelAndView mnv = new ModelAndView("article");
    	mnv.addObject("title", "Calendario de Alvaky");
    	mnv.addObject("sample_name", "Calendario de Visitas");
    	mnv.addObject("sample_dsc", "");
    	// puts scheduler code in view
    	
		mnv.addObject("body", s.render());

        return mnv;
    }
	
}
