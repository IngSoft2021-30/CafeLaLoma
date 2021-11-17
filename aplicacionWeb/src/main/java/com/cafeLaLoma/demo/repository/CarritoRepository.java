package com.cafeLaLoma.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cafeLaLoma.demo.entity.Carrito;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito, Long> {

	public Optional<Carrito> findById(Long id);
	
	public void deleteById(Long id);	
	
}
