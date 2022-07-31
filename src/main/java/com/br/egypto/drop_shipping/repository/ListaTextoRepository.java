package com.br.egypto.drop_shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.egypto.drop_shipping.entity.ListaTexto;

@Repository
public interface ListaTextoRepository extends JpaRepository<ListaTexto, Integer>{

}
