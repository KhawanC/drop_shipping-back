package com.br.egypto.drop_shipping.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.DTO.ProdutoDTO;
import com.br.egypto.drop_shipping.entity.Categoria;
import com.br.egypto.drop_shipping.entity.ListaImagens;
import com.br.egypto.drop_shipping.entity.ListaPalavrasChaves;
import com.br.egypto.drop_shipping.entity.ListaTexto;
import com.br.egypto.drop_shipping.entity.Produto;
import com.br.egypto.drop_shipping.exceptions.NoSuchElementFoundException;
import com.br.egypto.drop_shipping.repository.CategoriaRepository;
import com.br.egypto.drop_shipping.repository.ListaImagensRepository;
import com.br.egypto.drop_shipping.repository.ListaPalavrasRepository;
import com.br.egypto.drop_shipping.repository.ListaTextoRepository;
import com.br.egypto.drop_shipping.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ListaTextoRepository listaTextoRepository;
	
	@Autowired
	ListaPalavrasRepository listaPalavrasRepository;
	
	@Autowired
	ListaImagensRepository listaImagensRepository;
	
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
	
	public Produto saveProduto(ProdutoDTO produtoDTO) {
		Produto newProduto = produtoRepository.save(DTOtoEntity(produtoDTO));
		return newProduto;
	}
	
	public Produto DTOtoEntity(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		
		Categoria categoria = categoriaRepository.findById(produtoDTO.getIdCategoria()).get();
		ListaTexto listaTexto = listaTextoRepository.findById(produtoDTO.getIdListaTexto()).get();
		ListaPalavrasChaves listaPalavras = listaPalavrasRepository.findById(produtoDTO.getIdListaPalavrasChaves()).get();
		ListaImagens listaImagens = listaImagensRepository.findById(produtoDTO.getIdListaImagens()).get();
		
		if(categoria == null) {
			throw new NoSuchElementFoundException("Não encontramos categorias com o id " + produtoDTO.getIdCategoria());
		}
		if(listaTexto == null ) {
			throw new NoSuchElementFoundException("Não encontramos textos com o id " + produtoDTO.getIdListaTexto());
		}
		if(listaPalavras == null ) {
			throw new NoSuchElementFoundException("Não encontramos palavras com o id " + produtoDTO.getIdListaTexto());
		}
		if(listaImagens == null ) {
			throw new NoSuchElementFoundException("Não encontramos imagens com o id " + produtoDTO.getIdListaTexto());
		}
		
		produto.setCategoria(categoria);
		produto.setLink(produtoDTO.getLink());
		produto.setListaImagens(listaImagens);
		produto.setListaPalavrasChaves(listaPalavras);
		produto.setListaTexto(listaTexto);
		produto.setNome(produtoDTO.getNome());
		produto.setPrcntDesconto(produtoDTO.getPrcntDesconto());
		produto.setPreco(produtoDTO.getPreco());
		produto.setTotalCompras(0);
		
		return produto;
	}
}
