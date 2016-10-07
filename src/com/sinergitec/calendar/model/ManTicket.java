package com.sinergitec.calendar.model;

import java.util.Date;

public class ManTicket {

	//Variables tabla tt_ManTicket
	private String  cTicket;
	private Integer iOrdenServ;
	private String  cTienda;
	private String  cPrioridad;
	private Date    dtFechaR;
	private Date    dtFechaE;
	private Date    dtFechaMax;
	private String  cTecnico;
	
	public String getcTicket() {
		return cTicket;
	}
	public void setcTicket(String cTicket) {
		this.cTicket = cTicket;
	}
	public Integer getiOrdenServ() {
		return iOrdenServ;
	}
	public void setiOrdenServ(Integer iOrdenServ) {
		this.iOrdenServ = iOrdenServ;
	}
	public String getcTienda() {
		return cTienda;
	}
	public void setcTienda(String cTienda) {
		this.cTienda = cTienda;
	}
	public Date getDtFechaR() {
		return dtFechaR;
	}
	public void setDtFechaR(Date dtFechaR) {
		this.dtFechaR = dtFechaR;
	}
	public Date getDtFechaE() {
		return dtFechaE;
	}
	public void setDtFechaE(Date dtFechaE) {
		this.dtFechaE = dtFechaE;
	}
	public String getcTecnico() {
		return cTecnico;
	}
	public void setcTecnico(String cTecnico) {
		this.cTecnico = cTecnico;
	}
	
}
