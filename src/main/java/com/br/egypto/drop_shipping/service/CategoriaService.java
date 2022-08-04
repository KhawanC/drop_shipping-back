package com.br.egypto.drop_shipping.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.DTO.CategoriaDTO;
import com.br.egypto.drop_shipping.DTO.ClickDTO;
import com.br.egypto.drop_shipping.entity.Categoria;
import com.br.egypto.drop_shipping.entity.ListaPalavrasChaves;
import com.br.egypto.drop_shipping.exceptions.CategoriaException;
import com.br.egypto.drop_shipping.exceptions.NoSuchElementFoundException;
import com.br.egypto.drop_shipping.repository.CategoriaRepository;
import com.br.egypto.drop_shipping.repository.ListaPalavrasRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ListaPalavrasRepository listaPalavrasRepository;

	@Autowired
	KafkaTemplate<String, ClickDTO> kafkaTemplate;
	
	public void clickCategoriaProducer(ClickDTO click) {
		kafkaTemplate.send("click.categoria", click);
	}
	
	public void clickCategoriaConsumer(ClickDTO click) {
		Categoria produto = categoriaRepository.findById(click.getId()).get();
		if(produto == null) {
			System.out.println("Produto não identificado");
		} else {
			produto.setTotalCliques(produto.getTotalCliques() + 1);
			categoriaRepository.save(produto);
		}
	}
	
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

	public Categoria saveCategoria(CategoriaDTO categoriaDTO) {
		Categoria newCategoria = categoriaRepository.save(DTOtoEntity(categoriaDTO));
		return newCategoria;
	}

	Categoria DTOtoEntity(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();

		ListaPalavrasChaves listaPalavras = listaPalavrasRepository.findById(categoriaDTO.getIdListaPalavrasChaves())
				.get();

		if (listaPalavras == null) {
			throw new NoSuchElementFoundException(
					"Não encontramos palavras com o id " + categoriaDTO.getIdListaPalavrasChaves());
		}

		categoria.setIcone_home(categoriaDTO.getIcone_home());
		categoria.setLink(categoriaDTO.getLink());
		categoria.setListaPalavrasChaves(listaPalavras);
		categoria.setNome(categoriaDTO.getNome());
		categoria.setTotalCliques(0);

		return categoria;
	}
}
