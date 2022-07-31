package com.br.egypto.drop_shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.egypto.drop_shipping.entity.ListaTexto;
import com.br.egypto.drop_shipping.service.ListaTextoService;

@RestController
@RequestMapping("/listaTexto")
public class ListaTextoController {

	@Autowired
	ListaTextoService listaTextoService;
	
	@GetMapping
	public ResponseEntity<List<ListaTexto>> findAllListaTexto() {
		return new ResponseEntity<>(listaTextoService.findAllListaTexto(), HttpStatus.OK);
	}
}
