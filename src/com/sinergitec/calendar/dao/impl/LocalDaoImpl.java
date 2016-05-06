package com.sinergitec.calendar.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.calendar.model.CtLocal;
import com.sinergitec.calendar.util.DBConexion;

import alvaky.sinergitec.appserver.yacatmto;

public class LocalDaoImpl {
	
	@SuppressWarnings("static-access")
	public List<CtLocal> listaLocal(String cCveCia) throws Open4GLException, IOException{

		//Conexion a la base de datos
		Connection conexion = new DBConexion().getConnection();
		yacatmto app = new yacatmto(conexion);

		//Variables para guardar errores
		StringHolder  texto  = new StringHolder();
		BooleanHolder error  = new BooleanHolder();

		//Lista que almacena la informacion obtenida
		List<CtLocal> local_List = new ArrayList<CtLocal>();

		//Tabla temporal que almacena los resultados
		ResultSetHolder tt_ctLocal  = new ResultSetHolder();

		try {

			app.as_ctLocal_Carga(cCveCia, tt_ctLocal, error, texto);
			System.out.println(texto.getValue().toString());

			ResultSet rs_tt_ctlocal = tt_ctLocal.getResultSetValue();

			while(rs_tt_ctlocal.next()){

				CtLocal local_Obj = new CtLocal();

				local_Obj.setcCveCia(rs_tt_ctlocal.getString("cCveCia"));
				local_Obj.setiLocalID(rs_tt_ctlocal.getInt("iLocalID"));
				local_Obj.setcCliente(rs_tt_ctlocal.getString("cCliente"));
				local_Obj.setcNombre(rs_tt_ctlocal.getString("cNombre"));
				local_Obj.setcCalle(rs_tt_ctlocal.getString("cCalle"));
				local_Obj.setcColonia(rs_tt_ctlocal.getString("cColonia"));
				local_Obj.setcCiudad(rs_tt_ctlocal.getString("cCiudad"));
				local_Obj.setcEstado(rs_tt_ctlocal.getString("cEstado"));
				local_Obj.setcCP(rs_tt_ctlocal.getString("cCP"));
				local_Obj.setcTelefono1(rs_tt_ctlocal.getString("cTelefono1"));
				local_Obj.setcTelefono2(rs_tt_ctlocal.getString("cTelefono2"));
				local_Obj.setlPermiso(rs_tt_ctlocal.getBoolean("lPermiso"));
				local_Obj.setiRuta(rs_tt_ctlocal.getInt("iRutaID"));
				local_Obj.setcEmail(rs_tt_ctlocal.getString("cEmail"));
				local_Obj.setiMensaje(rs_tt_ctlocal.getInt("iMensajeID"));
				local_Obj.setcSucursal(rs_tt_ctlocal.getString("cSucursal"));
				local_Obj.setiSUpervID(rs_tt_ctlocal.getInt("iSupervID"));

				local_List.add(local_Obj);
			}

		} catch(Exception e){
			System.out.println(e);
		}finally {
			// TODO: handle finally clause
			app._release();
			conexion.finalize();
		}

		return local_List;
	}

	@SuppressWarnings("static-access")
	public List<CtLocal> listaLocal(String cCveCia, String cCliente) throws Open4GLException, IOException{

		//Conexion a la base de datos
		Connection conexion = new DBConexion().getConnection();
		yacatmto app = new yacatmto(conexion);

		//Variables para guardar errores
		StringHolder  texto  = new StringHolder();
		BooleanHolder error  = new BooleanHolder();

		//Lista que almacena la informacion obtenida
		List<CtLocal> local_List = new ArrayList<CtLocal>();

		//Tabla temporal que almacena los resultados
		ResultSetHolder tt_ctLocal  = new ResultSetHolder();

		try {

			app.as_ctLocal_cargaV2(cCveCia, cCliente, tt_ctLocal, error, texto);
			System.out.println(texto.getValue().toString());

			ResultSet rs_tt_ctlocal = tt_ctLocal.getResultSetValue();

			while(rs_tt_ctlocal.next()){
				
				CtLocal local_Obj = new CtLocal();

				local_Obj.setcCveCia(rs_tt_ctlocal.getString("cCveCia"));
				local_Obj.setiLocalID(rs_tt_ctlocal.getInt("iLocalID"));
				local_Obj.setcCliente(rs_tt_ctlocal.getString("cCliente"));
				local_Obj.setcNombre(rs_tt_ctlocal.getString("cNombre"));
				local_Obj.setcCalle(rs_tt_ctlocal.getString("cCalle"));
				local_Obj.setcColonia(rs_tt_ctlocal.getString("cColonia"));
				local_Obj.setcCiudad(rs_tt_ctlocal.getString("cCiudad"));
				local_Obj.setcEstado(rs_tt_ctlocal.getString("cEstado"));
				local_Obj.setcCP(rs_tt_ctlocal.getString("cCP"));
				local_Obj.setcTelefono1(rs_tt_ctlocal.getString("cTelefono1"));
				local_Obj.setcTelefono2(rs_tt_ctlocal.getString("cTelefono2"));
				local_Obj.setlPermiso(rs_tt_ctlocal.getBoolean("lPermiso"));
				local_Obj.setiRuta(rs_tt_ctlocal.getInt("iRutaID"));
				local_Obj.setcEmail(rs_tt_ctlocal.getString("cEmail"));
				local_Obj.setiMensaje(rs_tt_ctlocal.getInt("iMensajeID"));
				local_Obj.setcSucursal(rs_tt_ctlocal.getString("cSucursal"));
				local_Obj.setiSUpervID(rs_tt_ctlocal.getInt("iSupervID"));
				
				local_List.add(local_Obj);
			}

		} catch(Exception e){
			System.out.println(e);
		}finally {
			// TODO: handle finally clause
			app._release();
			conexion.finalize();
		}
		return local_List;
	}
	
}
