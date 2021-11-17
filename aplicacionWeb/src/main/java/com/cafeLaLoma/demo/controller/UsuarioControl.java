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

import dto.Autenticacion;
import dto.CambiarPassword;

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
	public String ingresoAdm(Model model) {
		model.addAttribute("adminForm", new Autenticacion());
		return "ingresoAdmin";
	}
	
	@PostMapping("/ingresoadmin")
	public String autenticarAdmin(@Valid @ModelAttribute("adminForm") Autenticacion admin, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("autenticarForm", admin);	
			System.out.print("-----------------------------"+result.getFieldError());
		}else {
			try {
				Usuario validar = usuarioService.getUserByIdentificacion(admin.getIdentificacion());
				usuarioService.autenticarAdmin(admin,validar);
				model.addAttribute("adminForm", validar);	
				return "perfilAdmin";
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("autenticarForm", admin);
				System.out.print("______________________"+e.getMessage());
			}
		}		
		System.out.print(admin.getIdentificacion());
		return "ingresoAdmin";
	}
	
	@GetMapping("/usuarioAut/{id}")
	public String perfilUserAut(Model model, @PathVariable(name ="id")String id)throws Exception {
			Usuario user= usuarioService.getUserByIdentificacion(id);
			System.out.print(user);
			model.addAttribute("userForm", user);
			System.out.print("---------"+user.getRoles().toString().contains("id=2"));
		return "perfilUsuario";
	}

	@GetMapping("/usuario/{id}")
	public String perfilUser(Model model, @PathVariable(name ="id")Long id)throws Exception {
			Usuario user= usuarioService.getUserById(id);
			System.out.print(user);
			model.addAttribute("userForm", user);
			System.out.print("---------"+user.getRoles().toString().contains("id=2"));
		return "perfilUsuario";
	}
	@GetMapping("/actualizarPerfil/{id}")
	public String perfilUserAct(Model model, @PathVariable(name ="id")Long id)throws Exception {
		Usuario userActu = usuarioService.getUserById(id);
		model.addAttribute("userForm", userActu);
		model.addAttribute("roles",roleRepository.findAll());
		CambiarPassword cont = new CambiarPassword(userActu.getId());
		cont.setPasswordActual(userActu.getPassword());
		cont.setPasswordNuevo("val");
		cont.setPasswordConfirm("val1");
		model.addAttribute("userFormC", cont);
		return "actualizarPerfil";
	}
	
	@PostMapping("/actualizarPerfil/{id}")
	public String crearUsuario(@Valid @ModelAttribute("userForm") Usuario user, BindingResult result, ModelMap model,@PathVariable(name ="id")Long id) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);	
			System.out.print("-----------------------------"+result.getFieldError());
		}else {
			try {
				model.addAttribute("userForm",usuarioService.getUserById(id));
				usuarioService.updateUser(user);
				model.addAttribute("roles",roleRepository.findAll());
				return "perfilUsuario";
			} catch (Exception e) {
				model.addAttribute(".......................jjjjjjjjjjjjformErrorMessage", e.getMessage());
				model.addAttribute("userForm", user);
			}
		}		
		model.addAttribute("roles",roleRepository.findAll());
		System.out.println("______________________RETORNO ACTUALIZAR PERRRFIL------------"+user.getRoles());
		return "perfilUsuario";
	}
	
	@PostMapping("/actualizarPerfilC")
	public String crearUsuarioC(@Valid @ModelAttribute("userFormC") CambiarPassword user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userFormC", user);	
			System.out.print(user.getId()+"-----------------------------"+result.getFieldError());
		}else {
			try {
				Usuario aux=usuarioService.getUserById(user.getId());
				usuarioService.carbiarPassword(user,aux);	
				usuarioService.updateUser(aux);
				return "perfilUsuario";
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userFormC", user);
				model.addAttribute("roles",roleRepository.findAll());
				System.out.print("______________________"+e.getMessage());
			}
		}		
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles",roleRepository.findAll());
		System.out.print(user.getPasswordActual());
		return "actualizarPerfil";
	}
	
	@GetMapping("/HistoCompras")
	public String infoPedidos() {
		return "historialCompras";
	}
	@GetMapping("/admin/{id}")
	public String perfilAdmin(Model model, @PathVariable(name ="id")String id)throws Exception {
		Usuario admin= usuarioService.getUserByIdentificacion(id);
		model.addAttribute("adminForm", admin);
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
