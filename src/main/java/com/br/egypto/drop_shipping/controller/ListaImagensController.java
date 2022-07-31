package com.br.egypto.drop_shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.egypto.drop_shipping.entity.ListaImagens;
import com.br.egypto.drop_shipping.service.ListaImagensService;

@RestController
@RequestMapping("/listaImagens")
public class ListaImagensController {

	@Autowired
	ListaImagensService listaImagensService;
	
	@GetMapping
	public ResponseEntity<List<ListaImagens>> findAllListaImagens() {
		return new ResponseEntity<>(listaImagensService.findAllListaImagens(), HttpStatus.OK);
	}
}
