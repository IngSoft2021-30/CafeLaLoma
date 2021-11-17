package com.cafeLaLoma.demo.service;

import com.cafeLaLoma.demo.entity.Carrito;
import com.cafeLaLoma.demo.entity.Usuario;

public interface CarritoService {
	public Iterable<Carrito> getAllCarritos();

	public Iterable<Carrito> getAllCarritosxUser(Usuario user) throws Exception;

	public double getTotal(Usuario user) throws Exception;
	
	public void deleteCarritoById(Long id) throws Exception;
	
	public Carrito getCarritoById(Long id) throws Exception ;

}
