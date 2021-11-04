package com.cafeLaLoma.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.repository.FacturaRepository;

@Service
public class ArchivoServicio {

	  @Autowired
	  FacturaRepository repository;
	  
	/*  public ByteArrayInputStream load() {
	    List<Factura> facturas = repository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(facturas);
	    return in;
	  }*/

}
