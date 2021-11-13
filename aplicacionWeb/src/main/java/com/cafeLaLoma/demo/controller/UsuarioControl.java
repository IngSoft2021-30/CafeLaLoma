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

import com.cafeLaLoma.demo.entity.Usuario;
import com.cafeLaLoma.demo.repository.RoleRepository;
import com.cafeLaLoma.demo.service.FacturaService;
import com.cafeLaLoma.demo.service.ProdutoVentaServ;
import com.cafeLaLoma.demo.service.UsuarioService;

@Controller
public class UsuarioControl {
	
	@Autowired
	FacturaService facturaService;
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	ProdutoVentaServ productoVentaService;
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/ingresoadmin")
	public String ingresoAdm() {
		
		return "ingresoAdmin";
	}
	@GetMapping("/usuario/{id}")
	public String perfilUser(Model model, @PathVariable(name ="id")String id)throws Exception {
		Usuario user= usuarioService.getUserByIdentificacion(id);
		model.addAttribute("userForm", user);
		return "perfilUsuario";
	}

	@GetMapping("/actualizarPerfil/{id}")
	public String perfilUserAct(Model model, @PathVariable(name ="id")Long id)throws Exception {
		Usuario userActu = usuarioService.getUserById(id);
		model.addAttribute("userForm", userActu);
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles",roleRepository.findAll());
		return "actualizarPerfil";
	}
	
	@PostMapping("/actualizarPerfil")
	public String crearUsuario(@Valid @ModelAttribute("userForm") Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);	
			System.out.print(user.getNombre()+"-----------------------------"+result.getFieldError());
		}else {
			try {
				usuarioService.updateUser(user);
				return "perfilUsuario";
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("userList", usuarioService.getAllUsuario());
				model.addAttribute("roles",roleRepository.findAll());
				System.out.print("______________________"+e.getMessage());
			}
		}		
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles",roleRepository.findAll());
		System.out.print(user.getTipoID());
		return "actualizarPerfil"+user.getId();
	}
	
	@GetMapping("/HistoCompras")
	public String infoPedidos() {
		return "historialCompras";
	}
	@GetMapping("/admin")
	public String perfilAdmin() {
		return "perfilAdmin";
	}
	@GetMapping("/reporteF")
	public String reporteF(Model model) {
		model.addAttribute("facturaL",facturaService.getAllFacturas());
		return "reporteFecha";
	}
	@GetMapping("/reporteP")
	public String reporteP(Model model) {
		model.addAttribute("ventasL",productoVentaService.getAllProductosventa());
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

	
}
