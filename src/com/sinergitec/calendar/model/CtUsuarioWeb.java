package com.sinergitec.calendar.model;

public class CtUsuarioWeb {
	
	private String cUsuarioWeb;
	private String cPassword;
	private Boolean lActivo;
	private String cCliente;
	private String dtCreado;
	private String dtModificado;
	private String cUsuario;
	private String cNombre;
	private CtUsuaCompWeb ctUsuaCompWeb;
	private Boolean error;
	private String errorTexto;
	
	public String getcUsuarioWeb() {
		return cUsuarioWeb;
	}
	public void setcUsuarioWeb(String cUsuarioWeb) {
		this.cUsuarioWeb = cUsuarioWeb;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public String getcCliente() {
		return cCliente;
	}
	public void setcCliente(String cCliente) {
		this.cCliente = cCliente;
	}
	public String getDtCreado() {
		return dtCreado;
	}
	public void setDtCreado(String dtCreado) {
		this.dtCreado = dtCreado;
	}
	public String getDtModificado() {
		return dtModificado;
	}
	public void setDtModificado(String dtModificado) {
		this.dtModificado = dtModificado;
	}
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public CtUsuaCompWeb getCtUsuaCompWeb() {
		return ctUsuaCompWeb;
	}
	public void setCtUsuaCompWeb(CtUsuaCompWeb ctUsuaCompWeb) {
		this.ctUsuaCompWeb = ctUsuaCompWeb;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getErrorTexto() {
		return errorTexto;
	}
	public void setErrorTexto(String errorTexto) {
		this.errorTexto = errorTexto;
	}
	
}