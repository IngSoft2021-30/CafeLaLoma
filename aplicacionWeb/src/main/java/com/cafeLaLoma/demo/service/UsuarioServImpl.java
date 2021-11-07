package com.cafeLaLoma.demo.service;

import java.util.Optional;

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
	
	private boolean checkUsuarioExiste(Usuario user) throws Exception {
		Optional<Usuario> usuarioEncontrado = repository.findByIdentificacion(user.getIdentificacion());
		if(usuarioEncontrado.isPresent()) {
			throw new Exception("Usuario ya se encuentra registrado");
		}
		return true;
	}
	
	private boolean checkPasswordMatch(Usuario user) throws Exception {
		if( !user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("password y confirmacion de password no coinciden");
		}
		return true;
	}

	@Override
	public Usuario crearUsuario(Usuario user) throws Exception {
		if(checkUsuarioExiste(user) && checkPasswordMatch(user)) {
			user = repository.save(user);
		}
		return user;
	}

}
