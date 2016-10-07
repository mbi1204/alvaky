package com.sinergitec.calendar.model;

import java.util.List;

public class CalidadTienda {
	
	//Objetos
	private List<ManTicket>    manTicket;
	private List<OrdFFecha>    ordFFecha;
	private List<CalidadParam> calidadParam;
	
	public List<ManTicket> getManTicket() {
		return manTicket;
	}
	public void setManTicket(List<ManTicket> manTicket) {
		this.manTicket = manTicket;
	}
	public List<OrdFFecha> getOrdFFecha() {
		return ordFFecha;
	}
	public void setOrdFFecha(List<OrdFFecha> ordFFecha) {
		this.ordFFecha = ordFFecha;
	}
	public List<CalidadParam> getCalidadParam() {
		return calidadParam;
	}
	public void setCalidadParam(List<CalidadParam> calidadParam) {
		this.calidadParam = calidadParam;
	}
	
}
