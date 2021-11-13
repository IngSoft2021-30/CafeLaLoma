package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.Usuario;

public interface UsuarioService {
	public Iterable<Usuario> getAllUsuario();

	public Usuario crearUsuario(Usuario user) throws Exception;
	
	public Usuario getUserById(Long id) throws Exception;

	public Usuario updateUser(Usuario user) throws Exception;
	
	public Usuario getUserByIdentificacion(String identificacion) throws Exception;
}
