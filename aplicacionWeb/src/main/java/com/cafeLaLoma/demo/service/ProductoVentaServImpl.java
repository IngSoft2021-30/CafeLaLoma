package com.cafeLaLoma.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.ProductoVenta;
import com.cafeLaLoma.demo.repository.ProductoVentaRepository;

@Service
public class ProductoVentaServImpl implements ProdutoVentaServ{

	@Autowired
	ProductoVentaRepository repository;
	
	@Override
	public Iterable<ProductoVenta> getAllProductosventa() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
