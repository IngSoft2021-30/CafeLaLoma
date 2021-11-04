package com.cafeLaLoma.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Factura;
import com.cafeLaLoma.demo.repository.FacturaRepository;

@Service
public class FacturaServImpl implements FacturaService{

	@Autowired
	FacturaRepository repository;
	
	public Iterable<Factura> getAllFacturas() {
		return repository.findAll();
	}

}
