package br.com.alura.mvc.mudi.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class UsuarioUtil {
	
	public static String getNomeUsuario() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
