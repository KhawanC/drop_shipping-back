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

import com.br.egypto.drop_shipping.DTO.ProdutoDTO;
import com.br.egypto.drop_shipping.entity.Produto;
import com.br.egypto.drop_shipping.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProdutos() {
		return new ResponseEntity<>(produtoService.findAllProdutos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findProdutoById(@PathVariable Integer id) {
		return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/{nomeCategoria}")
	public ResponseEntity<List<Produto>> findProdutoByCategoria(@PathVariable String nomeCategoria){
		System.out.println(nomeCategoria);
		return new ResponseEntity<>(produtoService.findByCategoria(nomeCategoria), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Produto> saveListaPalavrasChave(@RequestBody ProdutoDTO produto) {
		return new ResponseEntity<>(produtoService.saveProduto(produto), HttpStatus.OK);
	}
}
