package com.br.egypto.drop_shipping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.egypto.drop_shipping.DTO.UsuarioLoginDTO;
import com.br.egypto.drop_shipping.entity.Usuario;
import com.br.egypto.drop_shipping.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
//@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAllUsuarios() {
		return new ResponseEntity<>(usuarioService.findAllUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(usuarioService.findUsuarioById(id), HttpStatus.OK);
	}
	
	@PostMapping("/cadastrarUsuario")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody @Valid UsuarioLoginDTO usuarioDTO) throws Exception {
		return new ResponseEntity<>(usuarioService.saveUsuario(usuarioDTO), HttpStatus.CREATED);
	}
}
