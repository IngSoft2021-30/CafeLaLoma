package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.Producto;

public interface ProductoService {

	public Iterable<Producto> getAllProductos();
	
	public Producto getProductoById(Long id) throws Exception;
	
	public Iterable<String> getProductNombres();
	
	public Iterable<Long> getProductIds();
	
	public void actualizaProdById(int disponible ,Long id) throws Exception;
	
	public Long generarId() throws Exception;
	
	public void addProducto(Producto pord) throws Exception;
	
}
