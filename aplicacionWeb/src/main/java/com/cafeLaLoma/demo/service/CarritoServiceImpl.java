package com.cafeLaLoma.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		List<Carrito> carRt = new ArrayList<Carrito>();
		for(Carrito carU: car) {
			if (carU.getUsuario_id().equals(user)) {
					carRt.add(carU);
			}
		}
		return carRt;
	}
	@Override
	public double getTotal(Usuario user) throws Exception {
		Iterable<Carrito> car = new ArrayList<Carrito>();
		car = getAllCarritosxUser(user);
		double total=0;
		for(Carrito carU: car) {
			total=total+carU.getValoTotal();
		}
		// TODO Auto-generated method stub
		return total;
	}
	
	@Override
	public Carrito getCarritoById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}
	@Override
	public void deleteCarritoById(Long id) throws Exception {
		// TODO Auto-generated method stub

		repository.deleteById(id);
	}
 
}
