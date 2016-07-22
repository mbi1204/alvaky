package com.dhtmlx.demoapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;


import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.calendar.util.DBConexion;

import alvaky.sinergitec.appserver.yacatmto;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomEventsManager extends DHXEventsManager {

	public CustomEventsManager(HttpServletRequest request) {
		super(request);
	}

	@SuppressWarnings("static-access")
	public Iterable<DHXEv> getEvents(String cCveCia, String cCliente,String cSucursal) {
		List<DHXEv> evs = new ArrayList<DHXEv>();
		
		try {
			
			Connection conexion = new DBConexion().getConnection();
			yacatmto app = new yacatmto(conexion);
			
			ResultSetHolder tt_opCalmnto  = new ResultSetHolder();
			
			StringHolder  texto  = new StringHolder();
			BooleanHolder error  = new BooleanHolder();
			
			app.as_calendario_cargaV3(cCveCia, cCliente, tt_opCalmnto, error, texto);
			System.out.println(texto.getValue().toString());
			
			ResultSet rs_tt_opCalmnto = tt_opCalmnto.getResultSetValue();
			
			while (rs_tt_opCalmnto.next()) { 
				
				Event e = new Event();
				StringBuilder fechaVisita = new StringBuilder();
				
				fechaVisita.append(rs_tt_opCalmnto.getDate("dtFecha"));
				String ruta = ("Ruta: "+rs_tt_opCalmnto.getInt("iRutaID")+"\n");
				String local = ("Local: "+rs_tt_opCalmnto.getInt("iLocalID")+"\n");
				fechaVisita.append(" "+rs_tt_opCalmnto.getString("cHora")+":00");
				String estatus = ("Estatus: "+rs_tt_opCalmnto.getString("cEstatus")+"\n");
				String oSID = String.valueOf(rs_tt_opCalmnto.getInt("iOServID"));
				String nombreL = ("Local: "+rs_tt_opCalmnto.getString("cDesLocal")+"\n");
				String sucursal = (rs_tt_opCalmnto.getString("cSucursal"));
				String nombreR = ("Ruta: "+rs_tt_opCalmnto.getString("cRuta")+"\n");
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date valorD = formatter.parse(fechaVisita.toString());
				
				if(cSucursal != ""){
					if(cSucursal.equals(sucursal)){
						sucursal = sucursal + "\n";
						e.setStart_date(valorD);
						e.setEnd_date(valorD);
						e.setText(sucursal+nombreR+nombreL+estatus+oSID);
						evs.add(e);
					}
				}else{
					sucursal = sucursal + "\n";
					e.setStart_date(valorD);
					e.setEnd_date(valorD);
					e.setText(sucursal+nombreR+nombreL+estatus+oSID);
					evs.add(e);
					}
				}
			app._release();
			conexion.finalize();
		} catch (Open4GLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return evs;
	}
	
	@SuppressWarnings("static-access")
	public Iterable<DHXEv> correctivo(String cCveCia, String cCliente,String cSucursal) {
		List<DHXEv> evs = new ArrayList<DHXEv>();
		
		try {
			
			Connection conexion = new DBConexion().getConnection();
			yacatmto app = new yacatmto(conexion);
			
			ResultSetHolder tt_opOrdenServicio  = new ResultSetHolder();
			
			StringHolder  texto  = new StringHolder();
			BooleanHolder error  = new BooleanHolder();
			
			app.as_calendario_correctivos(cCveCia, cCliente, tt_opOrdenServicio, error, texto);
			
			ResultSet rs_tt_opOrdenServicio = tt_opOrdenServicio.getResultSetValue();
			
			System.out.println(rs_tt_opOrdenServicio.getString(1));
			
			while (rs_tt_opOrdenServicio.next()) { 
				
				Event e = new Event();
				StringBuilder fechaVisita = new StringBuilder();
				
				fechaVisita.append(rs_tt_opOrdenServicio.getDate("dtFecha"));
				String ruta = ("Ruta: "+rs_tt_opOrdenServicio.getInt("iRutaID")+"\n");
				String local = ("Local: "+rs_tt_opOrdenServicio.getInt("iLocalID")+"\n");
				fechaVisita.append(" "+rs_tt_opOrdenServicio.getString("cHora")+":00");
				String estatus = ("Estatus: "+rs_tt_opOrdenServicio.getString("cEstatus")+"\n");
				String oSID = String.valueOf(rs_tt_opOrdenServicio.getInt("iOServID"));
				String nombreL = ("Local: "+rs_tt_opOrdenServicio.getString("cDesLocal")+"\n");
				String sucursal = (rs_tt_opOrdenServicio.getString("cSucursal"));
				String nombreR = ("Ruta: "+rs_tt_opOrdenServicio.getString("cRuta")+"\n");
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date valorD = formatter.parse(fechaVisita.toString());
				
				if(cSucursal != ""){
					if(cSucursal.equals(sucursal)){
						sucursal = sucursal + "\n";
						e.setStart_date(valorD);
						e.setEnd_date(valorD);
						e.setText(sucursal+nombreR+nombreL+estatus+oSID);
						evs.add(e);
					}
				}else{
					sucursal = sucursal + "\n";
					e.setStart_date(valorD);
					e.setEnd_date(valorD);
					e.setText(sucursal+nombreR+nombreL+estatus+oSID);
					evs.add(e);
					}
				}
			app._release();
			conexion.finalize();
		} catch (Open4GLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return evs;
	}

	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			if (status == DHXStatus.UPDATE)
				session.update(event);
			else if (status == DHXStatus.DELETE)
				session.delete(event);
			else if (status == DHXStatus.INSERT)
				session.save(event);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		}
		return status;
	}

	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		return new Event();
	}
}
