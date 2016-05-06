package com.sinegitec.service;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.calendar.model.CtCliente;

public interface ClienteService {
	
	public List<CtCliente> listaSucursal(String cCveCia) throws Open4GLException, IOException;

}
