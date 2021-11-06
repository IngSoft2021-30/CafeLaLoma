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
	
	@GetMapping("/registrarse")
	public String registro(Model model) {
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles",roleRepository.findAll());
		return "registro";
	}
	
	@GetMapping("/ingresar")
	public String ingreso() {
		return "ingreso";
	}
	
	@PostMapping("/registrarse")
	public String crearUsuario(@Valid @ModelAttribute("userForm") Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);	
			System.out.print(user.getNombre());
		}else {
			System.out.print("No hay error");
			return "perfilUsuario";
		}		
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles",roleRepository.findAll());
		System.out.print(user.getTipoID());
		return "registro";
	}
	
	/*@PostMapping("/habilitar")
	public String habiliita() {
		System.out.print("entra");
		return "registro";
	}*/
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
