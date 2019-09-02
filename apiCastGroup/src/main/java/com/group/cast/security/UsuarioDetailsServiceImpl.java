package com.group.cast.security;


import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group.cast.bean.SigIn;


@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	/*
	private UsuarioRepository usuarioRepository;

	public UsuarioDetailsServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		//Login usuario = usuarioRepository.findByUsername(username);
		SigIn login=null;
		//usuario.setVcPassword("$2a$10$A1yvOHi5FF0C6bLAK4i9C.ps/gsC7EmZbe0syjBsJsGNOh.EXsQ9G");
		//usuario.setVcUsuario("accanto");
		if (login == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(login.getVcEmail(), login.getVcPassword(), emptyList());
	}
	
}
