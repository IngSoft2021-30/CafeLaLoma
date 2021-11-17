package com.cafeLaLoma.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafeLaLoma.demo.entity.Carrito;
import com.cafeLaLoma.demo.entity.Usuario;
import com.cafeLaLoma.demo.service.CarritoService;
import com.cafeLaLoma.demo.service.UsuarioService;

@Controller
public class CarritoControl {
	
	@Autowired
	CarritoService carritoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/carrito/{id}")
	public String carritos(Model model,@PathVariable(name = "id")Long id) throws Exception {
		model.addAttribute("carritoUser",carritoService.getAllCarritosxUser(usuarioService.getUserById(id)));
		model.addAttribute("totalCompra",carritoService.getTotal(usuarioService.getUserById(id)));
		return "carrito";
	}
	
	@PostMapping("/carritoB/{id}")
	public String borrarItem(@Valid @ModelAttribute("carritoUser") Carrito carrito,BindingResult result, ModelMap model,@PathVariable(name = "id")Long id) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("carritoUser", carrito);	
			System.out.print(result.getFieldError());
		}else {
			try {
				carritoService.deleteCarritoById(carrito.getId());
				return "exitosa";
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}		
		return "noexitosa";
	}
	
	@GetMapping("/exito/{id}")
	public String trExitosa(Model model,@PathVariable(name = "id")Long id) throws Exception {
		return "exitosa";
	}
	
	@GetMapping("/Nexito/{id}")
	public String trNoExitosa(Model model,@PathVariable(name = "id")Long id) throws Exception {
		return "noexitosa";
	}
}
