package com.sinergitec.calendar.dao;

import java.io.IOException;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.calendar.model.CtUsuaCompWeb;
import com.sinergitec.calendar.model.CtUsuarioWeb;
import com.sinergitec.calendar.util.DBConexion;

import alvaky.sinergitec.appserver.yacatmto;

public class UsuarioDaoImpl {
	
	@SuppressWarnings("static-access")
	public CtUsuarioWeb Valida(String cUsuario, String cPassword) throws Open4GLException, IOException{
		
		//Conexion a la base de datos
		Connection conexion = new DBConexion().getConnection();
		yacatmto app = new yacatmto(conexion);
		
		//Variables para guardar errores
		StringHolder texto  = new StringHolder();
		BooleanHolder error  = new BooleanHolder();
		
		//Variables para compañia y cliente
		StringHolder compania  = new StringHolder();
		StringHolder cliente  = new StringHolder();
		
		//Creando Objeto de ctUsuarioWeb
		CtUsuarioWeb usuarioWeb = new CtUsuarioWeb();
		CtUsuaCompWeb usuarioWebCompania = new CtUsuaCompWeb();
		
		try {
			app.as_AccesoWeb_Carga(cUsuario, cUsuario, compania, cliente, error, texto);
			
			String companiaB = compania.getValue().toString();
			String clienteB = cliente.getValue().toString();
			Boolean errorB = Boolean.parseBoolean(error.getValue().toString());
			
			usuarioWebCompania.setcCveCia(companiaB);
			usuarioWeb.setCtUsuaCompWeb(usuarioWebCompania);
			usuarioWeb.setcCliente(clienteB);
			usuarioWeb.setError(errorB);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			app._release();
			conexion.finalize();
		}
		
		return usuarioWeb;
	}
}
