package com.sinergitec.calendar.model;

import java.sql.Timestamp;
import java.util.Vector;

public class CtUsuarioWeb {
	
	private String cUsuarioWeb;
	private String cPassword;
	private Boolean lActivo;
	private String cCliente;
	private Timestamp dtCreado;
	private Timestamp dtModificado;
	private String cUsuario;
	private String cNombre;
	private CtUsuaCompWeb ctUsuaCompWeb;
	private Boolean error;
	private String errorTexto;
	private byte[] id;
	
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
	public Timestamp getDtCreado() {
		return dtCreado;
	}
	public void setDtCreado(Timestamp dtCreado) {
		this.dtCreado = dtCreado;
	}
	public Timestamp getDtModificado() {
		return dtModificado;
	}
	public void setDtModificado(Timestamp dtModificado) {
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
	
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		this.id = id;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();		

		vector.add(this.getcUsuarioWeb());
		vector.add(this.getcPassword());
		vector.add(this.getlActivo());		
		vector.add(this.getcCliente());
		vector.add(this.getDtCreado());
		vector.add(this.getDtModificado());
		vector.add(this.getcUsuario());
		vector.add(this.getcNombre());
		vector.add(this.getCtUsuaCompWeb().getcCveCia());
		vector.add(this.getId());
		return vector;
	}
	
}
