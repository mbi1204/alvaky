package com.sinegitec.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.sinegitec.service.ClienteService;
import com.sinergitec.calendar.dao.ClienteDao;
import com.sinergitec.calendar.model.CtCliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;
	
	public List<CtCliente> listaSucursal(String cCveCia) throws Open4GLException, IOException{
		return clienteDao.listaCliente(cCveCia);
	}

}
