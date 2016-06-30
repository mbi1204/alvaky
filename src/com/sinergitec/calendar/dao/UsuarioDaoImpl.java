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

		try {
			app.as_AccesoWeb_Carga(cUsuario, cPassword, compania, cliente, error, texto);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			app._release();
			conexion.finalize();
		}
		
		//Creando Objeto de ctUsuarioWeb
		CtUsuarioWeb usuarioWeb = new CtUsuarioWeb();
		CtUsuaCompWeb usuarioWebCompania = new CtUsuaCompWeb();
		
		usuarioWebCompania.setcCveCia(compania.getStringValue());
		usuarioWeb.setCtUsuaCompWeb(usuarioWebCompania);
		usuarioWeb.setcCliente(cliente.getStringValue());
		usuarioWeb.setError(Boolean.parseBoolean(error.getValue().toString()));
		usuarioWeb.setErrorTexto(texto.getStringValue());
		
		return usuarioWeb;
	}
}
