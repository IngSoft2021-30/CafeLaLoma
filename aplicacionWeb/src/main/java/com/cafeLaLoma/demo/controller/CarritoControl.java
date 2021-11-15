package com.cafeLaLoma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cafeLaLoma.demo.service.FacturaService;
import com.cafeLaLoma.demo.service.ProdutoVentaServ;

@Controller
public class CarritoControl {
	//@Autowired
	//CarritoService CarritoService;
	@GetMapping("/carrito/{id}")
	public String contactenos(@PathVariable(name = "id")Long id) {
		return "carrito";
	}

}
