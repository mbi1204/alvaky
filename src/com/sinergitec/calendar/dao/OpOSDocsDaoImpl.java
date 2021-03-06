package com.sinergitec.calendar.dao;

import java.io.IOException;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.ConnectException;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.dynamicapi.ResultSet;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.calendar.model.OpOSDocs;
import com.sinergitec.calendar.util.DBConexion;

import alvaky.sinergitec.appserver.yacatmto;

public class OpOSDocsDaoImpl {

	public OpOSDocs getOpOSDocs(String cCveCia, Integer iOServID, Integer iPartida) throws ConnectException, SystemErrorException, Open4GLException, IOException{
		
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		ResultSetHolder tt_OpOsDocsBlob = new ResultSetHolder();
		
		OpOSDocs obj = new OpOSDocs();
		
		Connection conexion = DBConexion.getConnection();
		yacatmto app = new yacatmto(conexion);
		
		try {
			app.as_opOSDocsBlob_Carga(cCveCia, iOServID, iPartida, tt_OpOsDocsBlob, oplError, opcError);
			ResultSet rs_tt_OpOsDocsBlob = (ResultSet) tt_OpOsDocsBlob.getResultSetValue();
			
			while(rs_tt_OpOsDocsBlob.next()){
				obj.setcCveCia(rs_tt_OpOsDocsBlob.getString("cCveCia"));
				obj.setiOServID(rs_tt_OpOsDocsBlob.getInt("iOServID"));
				obj.setiPartida(rs_tt_OpOsDocsBlob.getInt("iPartida"));
				obj.setcDescripcion(rs_tt_OpOsDocsBlob.getString("cDescripcion"));
				obj.setcNombre(rs_tt_OpOsDocsBlob.getString("cNombre"));
				obj.setbImagen(rs_tt_OpOsDocsBlob.getBytes("bImagen"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

		return obj;
	}
}
