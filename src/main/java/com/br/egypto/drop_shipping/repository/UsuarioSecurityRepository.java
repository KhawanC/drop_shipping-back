package com.br.egypto.drop_shipping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.egypto.drop_shipping.entity.Usuario;

public interface UsuarioSecurityRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByEmail(String email);
}
