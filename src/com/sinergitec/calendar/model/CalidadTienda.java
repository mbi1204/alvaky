package com.sinergitec.calendar.model;

import java.util.List;

public class CalidadTienda {
	
	//Objetos
	private List<ManTicket>    manTicket;
	private List<OrdFFecha>    ordFFecha;
	private List<CalidadParam> calidadParam;
	
	//Variables
	private Integer ticketConteo;
	private Integer ordFFechaConteo;
	private Integer calidadParamConteo;
	
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
	public Integer getTicketConteo() {
		return ticketConteo;
	}
	public void setTicketConteo(Integer ticketConteo) {
		this.ticketConteo = ticketConteo;
	}
	public Integer getOrdFFechaConteo() {
		return ordFFechaConteo;
	}
	public void setOrdFFechaConteo(Integer ordFFechaConteo) {
		this.ordFFechaConteo = ordFFechaConteo;
	}
	public Integer getCalidadParamConteo() {
		return calidadParamConteo;
	}
	public void setCalidadParamConteo(Integer calidadParamConteo) {
		this.calidadParamConteo = calidadParamConteo;
	}
	
}
