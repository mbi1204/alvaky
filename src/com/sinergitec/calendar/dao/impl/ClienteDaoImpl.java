package com.sinergitec.calendar.dao.impl;


import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.calendar.model.CtCliente;
import com.sinergitec.calendar.util.DBConexion;

import alvaky.sinergitec.appserver.yacatmto;

@Repository
public class ClienteDaoImpl{
	
	@SuppressWarnings({ "static-access" })
	public List<CtCliente> listaCliente(String cCvecia) throws Open4GLException, IOException{
		
		/*Conexion a la base de datos*/
		Connection conexion = new DBConexion().getConnection();
		yacatmto app = new yacatmto(conexion);
		
		/*Variables para guardar errores*/
		StringHolder  texto  = new StringHolder();
		BooleanHolder error  = new BooleanHolder();
		
		/*Lista que almacena la informacion obtenida*/
		List<CtCliente> cliente_List = new ArrayList<CtCliente>();
		
		/*Tabla temporal que almacena los resultados*/
		ResultSetHolder tt_ctCliente  = new ResultSetHolder();
		
		try {
			
			app.as_ctCliente_Carga(cCvecia, tt_ctCliente, error, texto);
			System.out.println(texto.getValue().toString());
			
			ResultSet rs_tt_ctCliente = tt_ctCliente.getResultSetValue();
			
			while(rs_tt_ctCliente.next()){
				
				CtCliente cliente_Obj = new CtCliente();
				
				cliente_Obj.setcCveCia(rs_tt_ctCliente.getString("cCveCia"));
				cliente_Obj.setcCliente(rs_tt_ctCliente.getString("cCliente"));
				cliente_Obj.setcRazonS(rs_tt_ctCliente.getString("cRazonS"));
				cliente_Obj.setcCalle(rs_tt_ctCliente.getString("cCalle"));
				cliente_Obj.setcColonia(rs_tt_ctCliente.getString("cColonia"));
				cliente_Obj.setcCiudad(rs_tt_ctCliente.getString("cCiudad"));
				cliente_Obj.setcMunicipio(rs_tt_ctCliente.getString("cMunicipio"));
				cliente_Obj.setcEstado(rs_tt_ctCliente.getString("cEstado"));
				cliente_Obj.setcContacto(rs_tt_ctCliente.getString("cContacto"));
				cliente_Obj.setcEmail(rs_tt_ctCliente.getString("cEmail"));
				
				cliente_List.add(cliente_Obj);
			}
			
		} catch(Exception e){
			System.out.println(e);
		}finally {
			// TODO: handle finally clause
			app._release();
			conexion.finalize();
		}
		
		return cliente_List;
		
	}
	
}
