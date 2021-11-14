package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.Producto;

public interface ProductoService {

	public Iterable<Producto> getAllProductos();
	
	public Producto getUserById(Long id) throws Exception;
}
