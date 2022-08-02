package com.br.egypto.drop_shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.entity.ListaImagens;
import com.br.egypto.drop_shipping.exceptions.NoSuchElementFoundException;
import com.br.egypto.drop_shipping.repository.ListaImagensRepository;

@Service
public class ListaImagensService {

	@Autowired
	ListaImagensRepository listaImagensRepository;
	
	public List<ListaImagens> findAllListaImagens(){
		List<ListaImagens> listaImagens = listaImagensRepository.findAll();
		return listaImagens;
	}
	
	public ListaImagens findListaImagensById(Integer id) {
		ListaImagens palavras = listaImagensRepository.findById(id).get();
		if(palavras == null) {
			throw new NoSuchElementFoundException("Não encontramos a lista de texto com o id " + id);
		} else {
			return palavras;
		}
	}
	
	public ListaImagens saveListaImagens(ListaImagens listaImagens) {
		ListaImagens newLista = listaImagensRepository.save(listaImagens);
		return newLista;
	}
}
