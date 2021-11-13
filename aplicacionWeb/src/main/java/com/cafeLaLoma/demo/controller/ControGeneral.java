package com.cafeLaLoma.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafeLaLoma.demo.entity.Usuario;
import com.cafeLaLoma.demo.repository.RoleRepository;
import com.cafeLaLoma.demo.service.UsuarioService;

@Controller
public class ControGeneral {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/ingresar")
	public String ingreso() {
		return "ingreso";
	}
	
	@PostMapping("/ingresar")
	public String autenticar(@Valid @ModelAttribute("userForm") Usuario user, BindingResult result, ModelMap model) {
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
		return "usuario";
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
