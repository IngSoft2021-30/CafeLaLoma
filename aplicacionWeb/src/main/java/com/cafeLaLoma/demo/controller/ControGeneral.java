package com.cafeLaLoma.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControGeneral {

	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/registrarse")
	public String registro() {
		return "registro";
	}
	
	@GetMapping("/ingresar")
	public String ingreso() {
		return "ingreso";
	}
	@GetMapping("/empresa")
	public String empresa() {
		return "empresa";
	}
	@GetMapping("/quienS")
	public String quienesSomos() {
		return "quienesSomos";
	}
	@GetMapping("/productos")
	public String productos() {
		return "productos";
	}
	@GetMapping("/contactenos")
	public String contactenos() {
		return "contacto";
	}
}
