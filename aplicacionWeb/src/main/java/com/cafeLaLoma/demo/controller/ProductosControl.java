package com.cafeLaLoma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cafeLaLoma.demo.service.ProductoService;

@Controller
public class ProductosControl {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/inventario/{id}")
	public String inventario(Model model, @PathVariable(required = false)Long id) {
		model.addAttribute("inventForm", productoService.getAllProductos());
		return "inventario";
	}
	
}
