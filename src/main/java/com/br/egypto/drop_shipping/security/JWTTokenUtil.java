package com.br.egypto.drop_shipping.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.br.egypto.drop_shipping.entity.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
}
