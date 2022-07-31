package com.br.egypto.drop_shipping.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.entity.Categoria;
import com.br.egypto.drop_shipping.entity.Produto;
import com.br.egypto.drop_shipping.exceptions.NoSuchElementFoundException;
import com.br.egypto.drop_shipping.repository.CategoriaRepository;
import com.br.egypto.drop_shipping.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Produto> findAllProdutos() {
		List<Produto> listaProdutos = produtoRepository.findAll();
		return listaProdutos;
	}
	
	public Produto findById(Integer id) {
		try {
			Produto produto = produtoRepository.findById(id).get();
			return produto;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementFoundException("Não encontramos o produto com o id " + id + "!");
		}
	}
	
	public List<Produto> findByCategoria(String categoriaNome){
			Categoria categoria = categoriaRepository.findByNome(categoriaNome);
			List<Produto> listaProdutos = produtoRepository.findByCategoria(categoria);
			if(listaProdutos.isEmpty()) {
				throw new NoSuchElementFoundException("Não encontramos produtos com o nome: " + categoriaNome);
			}
			
			return listaProdutos;
		
	}
}
