package com.br.egypto.drop_shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.egypto.drop_shipping.entity.Categoria;
import com.br.egypto.drop_shipping.exceptions.CategoriaException;
import com.br.egypto.drop_shipping.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria() {
		return new ResponseEntity<>(categoriaService.findAllCategoria(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> findCategoriaById(@PathVariable Integer id) throws CategoriaException {
		return new ResponseEntity<>(categoriaService.findCategoriaById(id), HttpStatus.OK);
	}
}
