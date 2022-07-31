package com.br.egypto.drop_shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.entity.ListaTexto;
import com.br.egypto.drop_shipping.repository.ListaTextoRepository;

@Service
public class ListaTextoService {

	@Autowired
	ListaTextoRepository listaTextoRepository;
	
	public List<ListaTexto> findAllListaTexto() {
		List<ListaTexto> listaTexto = listaTextoRepository.findAll();
		return listaTexto;
	}
}
