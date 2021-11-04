package com.cafeLaLoma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafeLaLoma.demo.entity.Factura;
import com.cafeLaLoma.demo.service.FacturaService;
import com.cafeLaLoma.demo.service.ProdutoVentaServ;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

@Controller
public class UsuarioControl {
	
	@Autowired
	FacturaService facturaService;
	
	@Autowired
	ProdutoVentaServ productoVentaService;
	
	/*@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/formulario")
	public String registro() {
		return "registro";
	}*/
	@GetMapping("/ingresoadmin")
	public String ingresoAdm() {
		return "ingresoAdmin";
	}
	@GetMapping("/usuario")
	public String perfilUser() {
		return "perfilUsuario";
	}
	@GetMapping("/actualizarPerfil")
	public String perfilUserAct() {
		return "actualizarPerfil";
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
