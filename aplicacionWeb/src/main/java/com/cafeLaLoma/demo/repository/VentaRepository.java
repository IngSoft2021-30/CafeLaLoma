package com.cafeLaLoma.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cafeLaLoma.demo.entity.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta,Long> {

	public Optional<Venta> findById(Long id);
}
