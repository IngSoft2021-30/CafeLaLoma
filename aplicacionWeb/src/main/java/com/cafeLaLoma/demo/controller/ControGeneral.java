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
import com.cafeLaLoma.demo.service.ProductoService;
import com.cafeLaLoma.demo.service.UsuarioService;

import dto.Autenticacion;

@Controller
public class ControGeneral {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ProductoService productoService;
	
	@GetMapping({"/","/index","/index/{id}"})
	public String index(@PathVariable(required = false)Long id) {
		return "index";
	}
	
	@GetMapping("/ingresar")
	public String ingreso(Model model) {
		model.addAttribute("autenticarForm", new Autenticacion());
		return "ingreso";
	}
	
	@PostMapping("/ingresar")
	public String autenticar(@Valid @ModelAttribute("autenticarForm") Autenticacion user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("autenticarForm", user);	
			System.out.print("-----------------------------"+result.getFieldError());
		}else {
			try {
				Usuario validar = usuarioService.getUserByIdentificacion(user.getIdentificacion());
				usuarioService.autenticarCliente(user,validar);
				model.addAttribute("userForm", validar);	
				return "perfilUsuario";
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("autenticarForm", user);
				System.out.print("______________________"+e.getMessage());
			}
		}		
		System.out.print(user.getIdentificacion());
		return "ingreso";
	}
	
	@GetMapping("/registrarse")
	public String registro(Model model) {
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles",roleRepository.findAll());
		return "registro";
	}
		
	@PostMapping("/registrarse")
	public String crearUsuario(@Valid @ModelAttribute("userForm") Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);	
			System.out.print("-----------------------------"+result.getFieldError());
		}else {
			try {
				usuarioService.crearUsuario(user);
				return "ingreso";
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
		return "registro";
	}
	
	@GetMapping({"/empresa","/empresa/{id}"})
	public String empresa(@PathVariable(required = false)Long id) {
		return "empresa";
	}
	@GetMapping({"/quienS","/quienS/{id}"})
	public String quienesSomos(@PathVariable(required = false)Long id) {
		return "quienesSomos";
	}
	@GetMapping({"/productos","/productos/{id}"})
	public String productos(Model model, @PathVariable(required = false)Long id) {
		model.addAttribute("productos",productoService.getAllProductos());
		if(id !=null) {
			System.out.print("con usuario");
		}else
			System.out.print("sin usuario");
			
		return "productos";
	}
	@GetMapping({"/contactenos","/contactenos/{id}"})
	public String contactenos(@PathVariable(required = false)Long id) {
		return "contacto";
	}
}
