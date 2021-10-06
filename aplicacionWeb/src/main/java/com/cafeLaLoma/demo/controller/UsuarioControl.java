package com.cafeLaLoma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cafeLaLoma.demo.service.FacturaService;
import com.cafeLaLoma.demo.service.ProdutoVentaServ;

@Controller
public class UsuarioControl {
	
	@Autowired
	FacturaService facturaService;
	
	@Autowired
	ProdutoVentaServ productoVentaService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/formulario")
	public String registro() {
		return "registro";
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
	@GetMapping("/productos")
	public String productos() {
		return "productos";
	}
	/*@GetMapping("/exportar")
	public ResponseEntity<Resource> getFile() {
	    String filename = "tutorials.csv";
	    InputStreamResource file = new InputStreamResource(fileService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }*/
}
