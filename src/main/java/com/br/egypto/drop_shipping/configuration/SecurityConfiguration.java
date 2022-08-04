package com.br.egypto.drop_shipping.configuration;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.br.egypto.drop_shipping.repository.UsuarioSecurityRepository;
import com.br.egypto.drop_shipping.security.JWTTokenFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioSecurityRepository usuarioRepository;
	
	@Autowired
	JWTTokenFilter jwtTokenFilter;
	
	private String[] PUBLIC_GET = {"/swagger-ui/**", "/v3/api-docs/**", "/listaImagens", "/listaTexto", "/palavrasChaves", "/categoria/**", "/produto/**"};
	
	private String[] PUBLIC_POST = {"/autenticacao", "/usuario/cadastrarUsuario", "/email"};
	
	private String[] PUBLIC_PUT = {"/produto/click", "/categoria/click"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.exceptionHandling().authenticationEntryPoint(
				(request, response, ex) -> {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					ex.getLocalizedMessage());
				});
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET ,PUBLIC_GET).permitAll()
			.antMatchers(HttpMethod.POST, PUBLIC_POST).permitAll()
			.antMatchers(HttpMethod.PUT, PUBLIC_PUT).permitAll()
			.anyRequest().authenticated();
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuario -> usuarioRepository.findByEmail(usuario)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario " + usuario + " não encontrado!")))
		.passwordEncoder(new BCryptPasswordEncoder());;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
