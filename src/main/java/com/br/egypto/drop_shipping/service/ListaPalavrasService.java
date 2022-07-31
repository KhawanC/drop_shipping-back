package com.br.egypto.drop_shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.entity.ListaPalavrasChaves;
import com.br.egypto.drop_shipping.repository.ListaPalavrasRepository;

@Service
public class ListaPalavrasService {

	@Autowired
	ListaPalavrasRepository listaPalavrasRepository;
	
	public List<ListaPalavrasChaves> findAllPalavrasChaves() {
		List<ListaPalavrasChaves> listaPalavras = listaPalavrasRepository.findAll();
		return listaPalavras;
	}
}
