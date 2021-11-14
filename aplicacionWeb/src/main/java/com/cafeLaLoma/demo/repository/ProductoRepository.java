package com.cafeLaLoma.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cafeLaLoma.demo.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long>{
	
	public Optional<Producto> findById(Long id);
	
}
