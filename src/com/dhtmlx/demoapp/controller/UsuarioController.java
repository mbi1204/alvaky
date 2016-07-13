package com.dhtmlx.demoapp.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.open4gl.Open4GLException;

@Controller
public class UsuarioController {
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	String Inicio(Model model) throws Open4GLException, IOException{
		
		return "usuario";
	}

}
