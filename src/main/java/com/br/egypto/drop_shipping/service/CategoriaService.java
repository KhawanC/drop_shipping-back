package com.br.egypto.drop_shipping.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.entity.Categoria;
import com.br.egypto.drop_shipping.exceptions.CategoriaException;
import com.br.egypto.drop_shipping.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAllCategoria() {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		return listaCategorias;
	}
	
	public Categoria findCategoriaById(Integer id) throws CategoriaException {
		try {
			Categoria categoria = categoriaRepository.findById(id).get();
			return categoria;
		} catch (NoSuchElementException e) {
			throw new CategoriaException("Não encontramos a categoria com o id " + id);
		}
	}
}
