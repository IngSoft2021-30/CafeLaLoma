package com.cafeLaLoma.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafeLaLoma.demo.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario,Long> {
	
}
