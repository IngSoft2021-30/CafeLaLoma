package com.cafeLaLoma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafeLaLoma.demo.service.FacturaService;
import com.cafeLaLoma.demo.service.ProdutoVentaServ;

@Controller
public class CarritoControl {
	//@Autowired
	//CarritoService CarritoService;
	@GetMapping("/carrito")
	public String contactenos() {
		return "carrito";
	}

	/*@GetMapping("/perfilAdm")
	public String perfilAdm() {
		return "perfilAdmin";
	}
	@GetMapping("/inventario")
	public String inventario() {
		return "inventario";
	}
	@GetMapping("/gestionBD")
	public String gestionBD() {
		return "gestionBD";
	}
	@GetMapping("/productos")
	public String productos() {
		return "productos";
	}*/
	
}
