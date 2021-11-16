package com.cafeLaLoma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cafeLaLoma.demo.service.CarritoService;
import com.cafeLaLoma.demo.service.UsuarioService;

@Controller
public class CarritoControl {
	
	@Autowired
	CarritoService carritoService;
	
	@Autowired
	UsuarioService usuarioService;
	@GetMapping("/carrito/{id}")
	public String contactenos(Model model,@PathVariable(name = "id")Long id) throws Exception {
		model.addAttribute("carritoUser",carritoService.getAllCarritosxUser(usuarioService.getUserById(id)));
		model.addAttribute("totalCompra",carritoService.getTotal(usuarioService.getUserById(id)));
		return "carrito";
	}

}
