package com.br.egypto.drop_shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.DTO.UsuarioLoginDTO;
import com.br.egypto.drop_shipping.entity.Endereco;
import com.br.egypto.drop_shipping.entity.Usuario;
import com.br.egypto.drop_shipping.exceptions.NoSuchElementFoundException;
import com.br.egypto.drop_shipping.exceptions.UsuarioException;
import com.br.egypto.drop_shipping.repository.EnderecoRepository;
import com.br.egypto.drop_shipping.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	private final PasswordEncoder encoder;

	public UsuarioService(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public List<Usuario> findAllUsuarios() {
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		return listaUsuarios;
	}

	public Usuario findUsuarioById(Integer id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		if (usuario == null) {
			throw new NoSuchElementFoundException("Não foi possivel encontrar o cliente com o id " + id);
		} else {
			return usuario;
		}
	}

	public Usuario saveUsuario(UsuarioLoginDTO usuarioDTO) throws Exception {

		usuarioDTO.setCpf(usuarioDTO.getCpf().replaceAll("[.-]", ""));
		usuarioDTO.setTelefone(usuarioDTO.getTelefone().replaceAll("[()-]", ""));

		List<Usuario> usuariosCPF = usuarioRepository.findByCpf(usuarioDTO.getCpf());
		List<Usuario> usuariosEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		List<Usuario> usuariosTelefone = usuarioRepository.findByTelefone(usuarioDTO.getTelefone());

		if (!usuariosCPF.isEmpty()) {
			throw new UsuarioException("Esse CPF já foi registrado");
		} else if (!usuariosEmail.isEmpty()) {
			throw new UsuarioException("Esse email já foi registrado");
		} else if (!usuariosTelefone.isEmpty()) {
			throw new UsuarioException("Esse telefone já foi registrado");
		} else {
			Usuario usuario = UsuarioDtoToEntity(usuarioDTO);
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			Usuario newUsuario = usuarioRepository.save(usuario);
			Endereco endereco = EnderecoDtoToEntity(usuarioDTO, newUsuario);
			enderecoRepository.save(endereco);
			return newUsuario;
		}
	}

	private Usuario UsuarioDtoToEntity(UsuarioLoginDTO usuarioDTO) {

		Usuario usuario = new Usuario();

		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setIdade(usuarioDTO.getIdade());
		usuario.setIsSuperUsuario(false);
		usuario.setNomeCompleto(usuarioDTO.getNomeCompleto());
		usuario.setTelefone(usuarioDTO.getTelefone());
		usuario.setSenha(usuarioDTO.getSenha());

		return usuario;
	}

	private Endereco EnderecoDtoToEntity(UsuarioLoginDTO usuarioDTO, Usuario usuario) {

		Endereco endereco = new Endereco();

		endereco.setBairro(usuarioDTO.getBairro());
		endereco.setCep(usuarioDTO.getCep());
		endereco.setCidade(usuarioDTO.getCidade());
		endereco.setComplemento(usuarioDTO.getComplemento());
		endereco.setEstado(usuarioDTO.getEstado());
		endereco.setNumero(usuarioDTO.getNumero());
		endereco.setRua(usuarioDTO.getRua());
		endereco.setUsuario(usuario);

		return endereco;
	}
}
