package com.group.cast.ws;



import static com.group.cast.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.group.cast.security.Constants.ISSUER_INFO;
import static com.group.cast.security.Constants.SUPER_SECRET_KEY;
import static com.group.cast.security.Constants.TOKEN_BEARER_PREFIX;
import static com.group.cast.security.Constants.TOKEN_EXPIRATION_TIME;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.cast.bean.ResponseLogin;
import com.group.cast.bean.SigIn;
import com.group.cast.bean.Usuario;
import com.group.cast.model.User;
import com.group.cast.service.AppService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/open")
public class wsApiOpen {
            
	@Autowired
	private AppService appService;
	
	@PostMapping("/login")
    public ResponseLogin login(@RequestBody SigIn credenciales) {
		System.out.println("login");
		String vcToken="";
		Integer nuError=0;
		String vcError="";
		String email=credenciales.getVcEmail();
		String password=credenciales.getVcPassword();
		Usuario usuario=null;
		
		
		try {
		User user=  appService.getUser(email,password);
		

            if(user!=null) {System.out.println("ENCONTRO");
	        	
	        	System.out.println("successfulAuthentication");
	    		vcToken = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
	    				.setSubject("")
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
	    		
	    		vcToken = TOKEN_BEARER_PREFIX + " " + vcToken;
	        	
	        	usuario=new Usuario();
	        	usuario.setVcEmail(email);
	        	usuario.setVcNome(user.getVcName());
	        	usuario.setVcToken(vcToken);
            }
            else {
            	nuError=-1;
            	vcError="El email y/o passord son incorrectos";
            	System.out.println("USUARIO NULO");
            }
	    }
        catch(Exception e) {
        	
        }
		return new ResponseLogin(usuario,nuError,vcError);
		
	}
}

