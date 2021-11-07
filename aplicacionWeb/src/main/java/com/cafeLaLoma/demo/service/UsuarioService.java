package com.cafeLaLoma.demo.service;

import javax.validation.Valid;

import com.cafeLaLoma.demo.entity.Usuario;

public interface UsuarioService {
	public Iterable<Usuario> getAllUsuario();

	public Usuario crearUsuario(Usuario user) throws Exception;
}
