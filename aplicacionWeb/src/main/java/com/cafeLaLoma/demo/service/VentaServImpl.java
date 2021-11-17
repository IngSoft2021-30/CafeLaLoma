package com.cafeLaLoma.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Producto;
import com.cafeLaLoma.demo.entity.ProductoVenta;
import com.cafeLaLoma.demo.entity.Venta;
import com.cafeLaLoma.demo.repository.VentaRepository;

import dto.ProductMasVend;

@Service
public class VentaServImpl implements VentaService{

	@Autowired
	VentaRepository repository;
	
	@Override
	public Iterable<Venta> getAllVentas() {
		return repository.findAll();
	}

	@Override
	public Iterable<Venta> getMasVendidos() {
		Iterable<Venta> aux = getAllVentas();
		List<ProductMasVend> products = new ArrayList<ProductMasVend>();
		int masVend=0;
		double total=0;
		ProductMasVend auxP = new ProductMasVend();
		List<Producto> vendido = new ArrayList<Producto>();
		
		return null;
	}

}
