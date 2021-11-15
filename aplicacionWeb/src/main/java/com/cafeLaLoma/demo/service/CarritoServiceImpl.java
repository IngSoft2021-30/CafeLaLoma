package com.cafeLaLoma.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Carrito;
import com.cafeLaLoma.demo.entity.Usuario;
import com.cafeLaLoma.demo.repository.CarritoRepository;

@Service
public class CarritoServiceImpl implements CarritoService{

	@Autowired
	CarritoRepository repository;
	@Override
	public Iterable<Carrito> getAllCarritos() {
		return repository.findAll();
	}
	@SuppressWarnings("null")
	@Override
	public Iterable<Carrito> getAllCarritosxUser(Usuario user) throws Exception {
		Iterable<Carrito> car = repository.findAll();
		List<Carrito> carRt = null;
		for(Carrito carU: car) {
			System.out.println(carU.getUsuario_id());
			System.out.println(user);
			  if (carU.getUsuario_id().equals(user)) {
			    carRt.add(carU);
			  }
			}
		return carRt;
	}
 
}
