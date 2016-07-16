package com.sinergitec.calendar.util;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.javaproxy.Connection;

public class DBConexion {
	
	static String cURL = "AppServer://192.168.2.20:5163/asalvaky";
	//OJO Produccion no vayas a borrar nada
	//static String cURL = "AppServer://192.168.2.40:5162/as_yacatmto";
	//static String cURL = "http://mioficina.ddns.net:8080/aia/Aia?AppService=as_yacatmto"; 
	 
	static Connection conexion;
	
	public static Connection getConnection() throws Open4GLException, IOException {
		conexion = new Connection(cURL,"", "",null);
		return conexion;
			
	}
	
	public static void closeConnection(Connection conexion) throws Open4GLException, IOException {
		conexion.finalize();
		conexion.releaseConnection();
		
	}
	
}
