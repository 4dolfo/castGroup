package com.group.cast.ws;

import static com.group.cast.security.Constants.ISSUER_INFO;
import static com.group.cast.security.Constants.SUPER_SECRET_KEY;
import static com.group.cast.security.Constants.TOKEN_BEARER_PREFIX;
import static com.group.cast.security.Constants.TOKEN_EXPIRATION_TIME;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.cast.bean.FeriasBean;
import com.group.cast.bean.Response;
import com.group.cast.bean.ResponseEquipe;
import com.group.cast.bean.ResponseFerias;
import com.group.cast.bean.ResponseFuncionario;
import com.group.cast.bean.ResponseLogin;
import com.group.cast.bean.SigIn;
import com.group.cast.bean.Usuario;
import com.group.cast.model.Equipe;
import com.group.cast.model.Ferias;
import com.group.cast.model.Funcionario;
import com.group.cast.model.User;

import com.group.cast.service.AppService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/security")
public class wsApiSecurity {

	@Autowired
	private AppService appService;
	
	//http://localhost:8182/rest/personels
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers(@RequestHeader("Authorization") String vcJWT){
		List<User> lstUser=appService.getAllUsers();
		return ResponseEntity.ok(lstUser);
	}
	
	/*LISTA TODOS LOS EQUIPOS*/
	@GetMapping("/equipe")
	public ResponseEquipe getAllEquipe(@RequestHeader("Authorization") String vcJWT){
		Integer nuError=0;
		String vcError="";
		List<Equipe> lstEquipe=new ArrayList<>();
		try {
			lstEquipe=appService.getAllEquipe();
		
		}catch(Exception e) {
			e.printStackTrace();
			nuError=-1;
			vcError="Problemas al obtener la lista de equipos";
		}
		return new ResponseEquipe(lstEquipe,nuError,vcError);
	}
	
	/*LISTA TODOS LOS FUNCIONARIOS*/
	@GetMapping("/funcionario")
	public ResponseFuncionario getAllFuncionario(@RequestHeader("Authorization") String vcJWT){
		Integer nuError=0;
		String vcError="";
		List<Funcionario> lstFuncionario=new ArrayList<>();
		try {
			lstFuncionario=appService.getAllFuncionario();
		
		}catch(Exception e) {
			e.printStackTrace();
			nuError=-1;
			vcError="Problemas al obtener la lista de equipos";
		}
		return new ResponseFuncionario(lstFuncionario,nuError,vcError);
	}
	
	
	@GetMapping("/funcionario-equipe/{idEquipe}")
	public ResponseFuncionario getFuncionarioByEquipe(@RequestHeader("Authorization") String vcJWT,
												 @PathVariable Integer idEquipe){
		Integer nuError=0;
		String vcError="";
		List<Funcionario> lstFuncionario=new ArrayList<>();
		try {
			lstFuncionario=appService.getFuncionarioByEquipe(idEquipe);
		
		}catch(Exception e) {
			e.printStackTrace();
			nuError=-1;
			vcError="Problemas al obtener la lista de equipos";
		}
		return new ResponseFuncionario(lstFuncionario,nuError,vcError);
	}
	

	@PostMapping("/ferias")
    public ResponseFerias ferias(@RequestHeader("Authorization") String vcJWT,
    							 @RequestBody FeriasBean objFerias) {
		System.out.println("ferias");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Integer nuError=0;
		String vcError="";

		try {
			long diff = System.currentTimeMillis() - format.parse(objFerias.getObjPeriodo().getDtInicio()).getTime();
			long years = diff / (24 * 60 * 60 * 1000 * 365);
			if(years < 0) {
				//nao ferias
				nuError=-1;
				vcError="Voce ainda nao cumplir o ano do trabalho";
			}
			else {
				//
				List<Funcionario> lstFuncionario=new ArrayList<>();
				lstFuncionario=appService.getFuncionarioByEquipe(objFerias.getObjFuncionario().getNuIdEquipe());
				
				List<Ferias> lstFerias=new ArrayList<>();
				lstFerias=appService.getFeriasByEquipe(objFerias.getObjFuncionario().getNuIdEquipe());
				
				
				if(lstFuncionario!=null && lstFuncionario.size()<=4) {
					for(int i=0;i<lstFerias.size();i++) {
						String a=objFerias.getObjPeriodo().getDtInicio();
						String b=objFerias.getObjPeriodo().getDtInicio();
						
						String c=lstFerias.get(i).getDtInicio();
						String d=lstFerias.get(i).getDtFin();
						
						if(!(a.compareTo(c)<0 && b.compareTo(c)<0) || (c.compareTo(a)<0 && d.compareTo(a)<0)) {
							//nao ferias
							nuError=-1;
							vcError="Suas Ferias cruzan en ao menos um dia com outros trabalhadores do sua Equipe";
						}
						
						
					}
					
				
				}
				
				
			}
			System.out.println("nuERROR = "+nuError);
			if(nuError.equals(0)) { // add no banco do datos
				appService.cadastrarFerias(objFerias);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			nuError=-1;
			vcError="Se teve problemas con conexao base do datos";
		}
			
	   return new ResponseFerias(objFerias,nuError, vcError);
	}



	@PostMapping("/equipe")
    public Response equipe(@RequestHeader("Authorization") String vcJWT,
    							 @RequestBody Equipe objEquipe) {
		System.out.println("equipe");
		Integer nuError=0;
		String vcError="";
		try{		
			appService.cadastrarEquipe(objEquipe);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			nuError=-1;
			vcError="Se teve problemas con conexao base do datos";
		}
			
	   return new Response(nuError, vcError);
	}

}