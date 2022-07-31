package com.br.egypto.drop_shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.entity.ListaImagens;
import com.br.egypto.drop_shipping.repository.ListaImagensRepository;

@Service
public class ListaImagensService {

	@Autowired
	ListaImagensRepository listaImagensRepository;
	
	public List<ListaImagens> findAllListaImagens(){
		List<ListaImagens> listaImagens = listaImagensRepository.findAll();
		return listaImagens;
	}
}
