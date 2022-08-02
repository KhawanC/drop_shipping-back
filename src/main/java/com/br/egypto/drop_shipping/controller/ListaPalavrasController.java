package com.br.egypto.drop_shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.egypto.drop_shipping.entity.ListaPalavrasChaves;
import com.br.egypto.drop_shipping.service.ListaPalavrasService;

@RestController
@RequestMapping("/palavrasChaves")
public class ListaPalavrasController {

	@Autowired
	ListaPalavrasService listaPalavrasService;
	
	@GetMapping
	public ResponseEntity<List<ListaPalavrasChaves>> findAllPalavrasChaves() {
		return new ResponseEntity<>(listaPalavrasService.findAllPalavrasChaves(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ListaPalavrasChaves> findListaPalavrasChaveById(@PathVariable Integer id) {
		return new ResponseEntity<>(listaPalavrasService.findListaPalavrasById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ListaPalavrasChaves> saveListaPalavrasChave(@RequestBody ListaPalavrasChaves listaPalavrasChave) {
		return new ResponseEntity<>(listaPalavrasService.saveListaPalavrasChave(listaPalavrasChave), HttpStatus.OK);
	}
}
