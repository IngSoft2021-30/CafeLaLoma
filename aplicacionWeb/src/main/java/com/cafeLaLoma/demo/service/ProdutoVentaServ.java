package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.ProductoVenta;

import dto.ProductMasVend;

public interface ProdutoVentaServ {
	public Iterable<ProductoVenta> getAllProductosventa();
	
	public Iterable<ProductMasVend> getMasVendidos();
}
