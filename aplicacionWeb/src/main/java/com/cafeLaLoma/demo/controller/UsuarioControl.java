package com.cafeLaLoma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafeLaLoma.demo.service.FacturaService;

@Controller
public class UsuarioControl {
	
	@Autowired
	FacturaService facturaService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/formulario")
	public String registro() {
		return "registro";
	}
	@GetMapping("/reporteF")
	public String reporteF(Model model) {
		model.addAttribute("facturaL",facturaService.getAllFacturas());
		return "reporteFecha";
	}
	@GetMapping("/reporteP")
	public String reporteP() {
		return "reporteMasVend";
	}
	@GetMapping("/perfilAdm")
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
	}
}
