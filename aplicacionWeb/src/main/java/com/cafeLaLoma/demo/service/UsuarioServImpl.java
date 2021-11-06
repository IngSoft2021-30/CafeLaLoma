package com.cafeLaLoma.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Usuario;
import com.cafeLaLoma.demo.repository.UsuarioRepositorio;

@Service
public class UsuarioServImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepositorio repository;
	@Override
	public Iterable<Usuario> getAllUsuario() {
		return repository.findAll();
	}


}
