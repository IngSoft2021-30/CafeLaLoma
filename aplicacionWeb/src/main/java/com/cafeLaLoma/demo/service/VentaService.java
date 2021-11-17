package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.Venta;

public interface VentaService {
	
	public Iterable<Venta> getAllVentas();
	
	public Iterable<Venta> getMasVendidos();
}
