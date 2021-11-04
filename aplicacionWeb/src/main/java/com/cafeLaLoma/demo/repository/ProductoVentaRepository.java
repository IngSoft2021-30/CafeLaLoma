package com.cafeLaLoma.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafeLaLoma.demo.entity.ProductoVenta;

@Repository
public interface ProductoVentaRepository extends CrudRepository<ProductoVenta,Long>{

}
