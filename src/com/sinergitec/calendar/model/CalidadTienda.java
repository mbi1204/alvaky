package com.sinergitec.calendar.model;

import java.util.Date;

public class CalidadTienda {
	
	//Variables tabla tt_ManTicket
	private String  cTicket;
	private Integer iOrdenServ;
	private String  cTienda;
	private Date    dtFechaR;
	private Date    dtFechaE;
	private String  cTecnico;
	
	//Variables tabla tt_OrdFFecha
	private String  cTienda2;
	private Integer iOrdenSer2;
	private Date    dtFechaEA;
	private Date    dtFechaEP;
	private String  cTecnico2;
	
	
	//Variables tabla tt_CalidadParam
	private String cTienda3;
	private Integer iOrdenSer3;
	private String cParametro;
	private Date dtFechaE2;
	private Double deLectura;
	private Double deVMaximo;
	private Double deVMinimo;
	
	
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
	public String getcTienda2() {
		return cTienda2;
	}
	public void setcTienda2(String cTienda2) {
		this.cTienda2 = cTienda2;
	}
	public Integer getiOrdenSer2() {
		return iOrdenSer2;
	}
	public void setiOrdenSer2(Integer iOrdenSer2) {
		this.iOrdenSer2 = iOrdenSer2;
	}
	public Date getDtFechaEA() {
		return dtFechaEA;
	}
	public void setDtFechaEA(Date dtFechaEA) {
		this.dtFechaEA = dtFechaEA;
	}
	public Date getDtFechaEP() {
		return dtFechaEP;
	}
	public void setDtFechaEP(Date dtFechaEP) {
		this.dtFechaEP = dtFechaEP;
	}
	public String getcTecnico2() {
		return cTecnico2;
	}
	public void setcTecnico2(String cTecnico2) {
		this.cTecnico2 = cTecnico2;
	}
	public String getcTienda3() {
		return cTienda3;
	}
	public void setcTienda3(String cTienda3) {
		this.cTienda3 = cTienda3;
	}
	public Integer getiOrdenSer3() {
		return iOrdenSer3;
	}
	public void setiOrdenSer3(Integer iOrdenSer3) {
		this.iOrdenSer3 = iOrdenSer3;
	}
	public String getcParametro() {
		return cParametro;
	}
	public void setcParametro(String cParametro) {
		this.cParametro = cParametro;
	}
	public Date getDtFechaE2() {
		return dtFechaE2;
	}
	public void setDtFechaE2(Date dtFechaE2) {
		this.dtFechaE2 = dtFechaE2;
	}
	public Double getDeLectura() {
		return deLectura;
	}
	public void setDeLectura(Double deLectura) {
		this.deLectura = deLectura;
	}
	public Double getDeVMaximo() {
		return deVMaximo;
	}
	public void setDeVMaximo(Double deVMaximo) {
		this.deVMaximo = deVMaximo;
	}
	public Double getDeVMinimo() {
		return deVMinimo;
	}
	public void setDeVMinimo(Double deVMinimo) {
		this.deVMinimo = deVMinimo;
	}
	
}
