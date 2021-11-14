package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.Usuario;

import dto.Autenticacion;
import dto.CambiarPassword;

public interface UsuarioService {
	public Iterable<Usuario> getAllUsuario();

	public Usuario crearUsuario(Usuario user) throws Exception;
	
	public Usuario getUserById(Long id) throws Exception;

	public Usuario updateUser(Usuario user) throws Exception;
	
	public Usuario getUserByIdentificacion(String identificacion) throws Exception;

	public Usuario autenticarCliente(Autenticacion aut,Usuario usuario) throws Exception;

	public Usuario autenticarAdmin(Autenticacion aut,Usuario usuario) throws Exception;
	
	public Usuario carbiarPassword(CambiarPassword aut,Usuario usuario) throws Exception;
		
}
