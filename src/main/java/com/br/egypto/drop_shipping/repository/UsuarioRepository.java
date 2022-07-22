package com.br.egypto.drop_shipping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.egypto.drop_shipping.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	List<Usuario> findByEmail(String email);
	List<Usuario> findByCpf(String cpf);
	List<Usuario> findByTelefone(String telefone);
}
