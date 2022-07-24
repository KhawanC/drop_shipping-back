package com.br.egypto.drop_shipping.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.br.egypto.drop_shipping.entity.Usuario;
import com.br.egypto.drop_shipping.exceptions.UsuarioException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTTokenUtil {

	@Value("${app.token_expiration}")
	private Long TEMPO_EXPIRACAO;
	
	@Value("${app.encryption_key}")
	private String CHAVE_SECRETA;
	
	public String gerarToken(Usuario usuario) {
		return Jwts.builder()
				.setSubject(usuario.getId() + "," + usuario.getEmail())
				.setIssuer("kauacassiano")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + TEMPO_EXPIRACAO))
				.signWith(SignatureAlgorithm.HS512, CHAVE_SECRETA)
				.compact();
	}
	
	public boolean validarAcessoToken(String token) throws UsuarioException {
		try {
			Jwts.parser().setSigningKey(CHAVE_SECRETA).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			throw new UsuarioException("O token expirou");
		} catch (IllegalArgumentException e) {
			throw new UsuarioException("O token está nulo ou inválido");
		} catch (MalformedJwtException e) {
			throw new UsuarioException("O token é inválido");
		} catch (UnsupportedJwtException e) {
			throw new UsuarioException("O token não é suportado");
		} catch (SignatureException e) {
			throw new UsuarioException("A assinatura do token falhou");
		}
	}
	
}
