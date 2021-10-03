package com.cafeLaLoma.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioControl {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/formulario")
	public String registro() {
		return "registro";
	}
}
