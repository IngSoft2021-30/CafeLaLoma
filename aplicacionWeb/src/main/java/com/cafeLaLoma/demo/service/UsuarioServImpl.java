package com.cafeLaLoma.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Usuario;
import com.cafeLaLoma.demo.repository.UsuarioRepositorio;

import dto.Autenticacion;
import dto.CambiarPassword;

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
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirmar password es obligatorio");
		}
		
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

	@Override
	public Usuario getUserById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

	@Override
	public Usuario updateUser(Usuario fromUser) throws Exception {
		Usuario toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapUser(Usuario from,Usuario to) {
		to.setDepartamento(from.getDepartamento());
		to.setMunicipio(from.getMunicipio());
		to.setDireccion(from.getDireccion());
	}

	@Override
	public Usuario getUserByIdentificacion(String identificacion) throws Exception {
		return repository.findByIdentificacion(identificacion).orElseThrow(() -> new Exception("El usuario no existe."));
		
	}

	public Usuario autenticarCliente(Autenticacion aut, Usuario user) throws Exception {
		if( !user.getPassword().equals(aut.getPassword())) {
			throw new Exception("password incorrecto");
		}
		if( user.getRoles().toString().contains("id=1")) {
			throw new Exception("Permisos denegados");
		}
		return user;
	}
	
	public Usuario autenticarAdmin(Autenticacion aut, Usuario user) throws Exception {
		if( !user.getPassword().equals(aut.getPassword())) {
			throw new Exception("password incorrecto");
		}
		if( !user.getRoles().toString().contains("id=1")) {
			throw new Exception("Permisos denegados");
		}
		return user;
	}
	
	@Override
	public Usuario carbiarPassword(CambiarPassword aut, Usuario usuario) throws Exception {
		if (aut.getPasswordActual() == null || aut.getPasswordActual().isEmpty()) {
			throw new Exception("password actual es obligatorio");
		}
		
		if (aut.getPasswordNuevo() == null || aut.getPasswordNuevo().isEmpty()) {
			throw new Exception("password Nuevo vacio");
		}
		
		if (aut.getPasswordConfirm() == null || aut.getPasswordConfirm().isEmpty()) {
			throw new Exception("Confirmar password es obligatorio");
		}
		
		if( !aut.getPasswordActual().equals(usuario.getConfirmPassword())) {
			throw new Exception("password actual no coincide");
		}
		
		return usuario;
	}

}
