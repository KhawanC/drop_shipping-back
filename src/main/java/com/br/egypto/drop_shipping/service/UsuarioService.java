package com.br.egypto.drop_shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.DTO.UsuarioLoginDTO;
import com.br.egypto.drop_shipping.entity.Endereco;
import com.br.egypto.drop_shipping.entity.Usuario;
import com.br.egypto.drop_shipping.exceptions.NoSuchElementFoundException;
import com.br.egypto.drop_shipping.exceptions.UsuarioException;
import com.br.egypto.drop_shipping.repository.EnderecoRepository;
import com.br.egypto.drop_shipping.repository.UsuarioRepository;
import com.br.egypto.drop_shipping.security.AuthPedido;
import com.br.egypto.drop_shipping.security.AuthResposta;
import com.br.egypto.drop_shipping.security.JWTTokenUtil;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JWTTokenUtil jwtUtil;

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

	public Usuario saveUsuario(UsuarioLoginDTO usuarioDTO) throws UsuarioException {

		usuarioDTO.setCpf(usuarioDTO.getCpf().replaceAll("[.-]", ""));
		usuarioDTO.setCep(usuarioDTO.getCep().replaceAll("[-]", ""));
		usuarioDTO.setTelefone(usuarioDTO.getTelefone().replaceAll("[()-]", ""));

		List<Usuario> usuariosCPF = usuarioRepository.findByCpf(usuarioDTO.getCpf());
		List<Usuario> usuariosEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		List<Usuario> usuariosTelefone = usuarioRepository.findByTelefone(usuarioDTO.getTelefone());

		if (!usuariosCPF.isEmpty()) {
			throw new UsuarioException("Houve um problema ao se registrar");
		} else if (!usuariosEmail.isEmpty()) {
			throw new UsuarioException("Houve um problema ao se registrar");
		} else if (!usuariosTelefone.isEmpty()) {
			throw new UsuarioException("Houve um problema ao se registrar");
		} else {
			Endereco endereco = enderecoRepository.save(EnderecoDtoToEntity(usuarioDTO));
			Usuario usuario = UsuarioDtoToEntity(usuarioDTO);
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			usuario.setEndereco(endereco);
			Usuario newUsuario = usuarioRepository.save(usuario);

			return newUsuario;
		}
	}

	public AuthResposta autenticarUsuario(AuthPedido usuarioDTO) throws Exception {
		try {
			List<Usuario> listUsuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
			Usuario oldUsuario = listUsuario.get(0);
			Authentication auth = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getPassword()));
			Usuario usuario = (Usuario) auth.getPrincipal();
			String tokenAcesso = jwtUtil.gerarToken(usuario);
			AuthResposta res = new AuthResposta(usuario.getEmail(), tokenAcesso);
			return res;
		} catch (BadCredentialsException e) {
			throw new UsuarioException("Credências inválidas!");
		} catch (IndexOutOfBoundsException e) {
			throw new UsuarioException("Email não registrado!");
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

	private Endereco EnderecoDtoToEntity(UsuarioLoginDTO usuarioDTO) {

		Endereco endereco = new Endereco();

		endereco.setBairro(usuarioDTO.getBairro());
		endereco.setCep(usuarioDTO.getCep());
		endereco.setCidade(usuarioDTO.getCidade());
		endereco.setComplemento(usuarioDTO.getComplemento());
		endereco.setEstado(usuarioDTO.getEstado());
		endereco.setNumero(usuarioDTO.getNumero());
		endereco.setRua(usuarioDTO.getRua());

		return endereco;
	}

}
