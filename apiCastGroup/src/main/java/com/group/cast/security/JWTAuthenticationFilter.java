package com.group.cast.security;

import static com.group.cast.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.group.cast.security.Constants.ISSUER_INFO;
import static com.group.cast.security.Constants.SUPER_SECRET_KEY;
import static com.group.cast.security.Constants.TOKEN_BEARER_PREFIX;
import static com.group.cast.security.Constants.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.cast.bean.SigIn;
import com.group.cast.model.User;
import com.group.cast.service.AppService;
import com.group.cast.service.AppServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Autowired
	private AuthenticationManager authenticationManager;
	//private Usuario objUsuario;
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			SigIn credenciales = new ObjectMapper().readValue(request.getInputStream(), SigIn.class);
			/*
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
			System.out.println(auth.isAuthenticated());
			*/
			
			User user = new User();
			
			AppService obj = new AppServiceImpl();
			
			Authentication auth = null;
			
			user = obj.getUser(credenciales.getVcEmail(), credenciales.getVcPassword());
			
            if(user!=null) {
	        	auth = new UsernamePasswordAuthenticationToken(credenciales.getVcEmail(), credenciales.getVcPassword(), new ArrayList<>());
				System.out.println(auth.isAuthenticated());
	        }
        
	        
			return auth;
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		System.out.println("successfulAuthentication");
		String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
				.setSubject(auth.getPrincipal()+"")
				.setIssuer("com.group.cast")
		/*
				.claim("nuIdUsuario", this.objUsuario.getNuIdUsuario())
				.claim("vcUsuario", this.objUsuario.getVcUsuario())
				.claim("vcNombre", this.objUsuario.getVcNombre())
				.claim("nuIdSesion", this.objUsuario.getNuIdSesion())
				.claim("nuIdPerfil", this.objUsuario.getNuIdPerfil())
				.claim("nuIdAplicativo", this.objUsuario.getNuIdAplicativo())
				.claim("vcSiglaAplicativo", this.objUsuario.getVcSiglaAplicativo())
				.claim("nuIdOficina", this.objUsuario.getNuIdOficina())
				.claim("vcOficina", this.objUsuario.getVcOficina())
				.claim("vcCodTipoPersona", this.objUsuario.getVcCodTipoPersona())
				.claim("vcCodTipoDocumento", this.objUsuario.getVcCodTipoDocumento())
				.claim("vcNroDocumento", this.objUsuario.getVcNroDocumento())
	*/			
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
		
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
	}
}