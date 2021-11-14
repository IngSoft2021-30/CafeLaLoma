package com.cafeLaLoma.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Producto;
import com.cafeLaLoma.demo.repository.ProductoRepository;

@Service
public class ProductoServImpl implements ProductoService{
	
	@Autowired
	ProductoRepository repository;
	@Override
	public Iterable<Producto> getAllProductos() {
		return repository.findAll();
	}
	
	@Override
	public Producto getUserById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El producto no existe."));
		
	}

}
