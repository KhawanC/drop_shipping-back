package com.br.egypto.drop_shipping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.egypto.drop_shipping.entity.Categoria;
import com.br.egypto.drop_shipping.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	List<Produto> findByCategoria(Categoria categoria);
}
