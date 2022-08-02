package com.br.egypto.drop_shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.entity.ListaTexto;
import com.br.egypto.drop_shipping.exceptions.NoSuchElementFoundException;
import com.br.egypto.drop_shipping.repository.ListaTextoRepository;

@Service
public class ListaTextoService {

	@Autowired
	ListaTextoRepository listaTextoRepository;
	
	public List<ListaTexto> findAllListaTexto() {
		List<ListaTexto> listaTexto = listaTextoRepository.findAll();
		return listaTexto;
	}
	
	public ListaTexto findListaTextoById(Integer id) {
		ListaTexto texto = listaTextoRepository.findById(id).get();
		if(texto == null) {
			throw new NoSuchElementFoundException("Não encontramos a lista de texto com o id " + id);
		} else {
			return texto;
		}
	}
	
	public ListaTexto saveListaTexto(ListaTexto listaTexto) {
		ListaTexto newLista = listaTextoRepository.save(listaTexto);
		return newLista;
	}
			
}
