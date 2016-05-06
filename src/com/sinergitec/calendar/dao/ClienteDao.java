package com.sinergitec.calendar.dao;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.calendar.model.CtCliente;

public interface ClienteDao {
	
	public List<CtCliente> listaCliente(String cCvecia) throws Open4GLException, IOException;

}
