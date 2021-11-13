package com.cafeLaLoma.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafeLaLoma.demo.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario,Long> {

	public Optional<Usuario> findById(Long id);
	
	public Optional<Usuario> findByIdentificacion(String identificacion);
}
