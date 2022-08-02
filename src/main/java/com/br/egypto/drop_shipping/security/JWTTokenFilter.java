package com.br.egypto.drop_shipping.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.br.egypto.drop_shipping.entity.Usuario;
import com.br.egypto.drop_shipping.exceptions.UsuarioException;

@Component
public class JWTTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		if (!hasAuthorizationHeader(request)) {
			filterChain.doFilter(request, response);
			return;
		}

		String acessToken = getAccessToken(request);

		try {
			if (!jwtTokenUtil.validarAcessoToken(acessToken)) {
				filterChain.doFilter(request, response);
				return;
			}
		} catch (UsuarioException | IOException | ServletException e) {
			e.printStackTrace();
		}

		setAuthenticationContext(acessToken, request);
		filterChain.doFilter(request, response);
	}

	private void setAuthenticationContext(String acessToken, HttpServletRequest request) {
		UserDetails detalhesUsuario = getDetalhesUsuario(acessToken);

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(detalhesUsuario,
				null, null);

		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private UserDetails getDetalhesUsuario(String acessToken) {
		Usuario detalhesUsuario = new Usuario();
		String[] subjectArray = jwtTokenUtil.getSubject(acessToken).split(",");
		detalhesUsuario.setId(Integer.parseInt(subjectArray[0]));
		detalhesUsuario.setEmail(subjectArray[1]);

		return detalhesUsuario;
	}

	private boolean hasAuthorizationHeader(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			return false;
		}
		return true;
	}

	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		return token;
	}

}
