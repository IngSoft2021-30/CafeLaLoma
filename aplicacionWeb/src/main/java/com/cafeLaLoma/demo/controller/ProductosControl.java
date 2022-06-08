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
import com.cafeLaLoma.demo.entity.Producto;
import com.cafeLaLoma.demo.service.ProductoService;

import dto.Autenticacion;

@Controller
public class ProductosControl {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/inventario/{id}")
	public String inventario(Model model, @PathVariable(required = false)Long id) {
		model.addAttribute("inventForm", productoService.getAllProductos());
		return "inventario";
	}
	
	@GetMapping("/gestionBD/{id}")
	public String gestionBD(Model model, @PathVariable(name ="id")String id)throws Exception {
		model.addAttribute("nombres", productoService.getProductNombres());
		model.addAttribute("ids", productoService.getProductIds());
		//model.addAttribute("ActProd", productoService.getAllProductos());
		return "gestionBD";
	}	
	
	@PostMapping("/gestionBD/{id}")
	public String actualizaProd(@Valid @ModelAttribute("nombres") Producto user, BindingResult result, ModelMap model,@PathVariable(name ="id")String id) {
		if(result.hasErrors()) {
			model.addAttribute("ActProd", user);
			System.out.print(result.getFieldError());
		}else {
			try {
				//System.out.println("ACTUALIZAR"+idProd);
				//productoService.actualizaProdById(prod,idProd);
				return "exitosa";
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}		
		return "noexitosa";
	}
	
	@GetMapping("/GenID/{id}")
	public String GenID(Model model, @PathVariable(name ="id")String id)throws Exception {
		model.addAttribute("nombres", productoService.getProductNombres());
		model.addAttribute("ids", productoService.getProductIds());
		model.addAttribute("consecutivo", productoService.generarId());
		return "gestionBD";
	}
	//Test No.1
}
