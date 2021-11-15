package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.Producto;

public interface ProductoService {

	public Iterable<Producto> getAllProductos();
	
	public Producto getProductoById(Long id) throws Exception;
}
