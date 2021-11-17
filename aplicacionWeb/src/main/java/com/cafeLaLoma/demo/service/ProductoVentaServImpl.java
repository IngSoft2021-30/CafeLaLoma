package com.cafeLaLoma.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Producto;
import com.cafeLaLoma.demo.entity.ProductoVenta;
import com.cafeLaLoma.demo.repository.ProductoVentaRepository;

import dto.ProductMasVend;

@Service
public class ProductoVentaServImpl implements ProdutoVentaServ{

	@Autowired
	ProductoVentaRepository repository;
	
	@Override
	public Iterable<ProductoVenta> getAllProductosventa() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Iterable<ProductMasVend> getMasVendidos() {
		Iterable<ProductoVenta> aux = getAllProductosventa();
		List<ProductMasVend> products = new ArrayList<ProductMasVend>();
		int masVend=0;
		double total=0;
		ProductMasVend auxP = new ProductMasVend();
		List<Producto> vendido = new ArrayList<Producto>();
		
		for(ProductoVenta venta: aux) {
			auxP.setCantidad(venta.getCantidad());
			auxP.setValTotal(0);
			for(Producto prod: venta.getProductos()) {			
				auxP.setNombre(prod.getNombre());
				auxP.setValUnitario(prod.getPrecio());
				auxP.setValTotal(auxP.getValTotal()+prod.getPrecio());
				products.add(auxP);
			}
			auxP=new ProductMasVend();
		}
		/*for(ProductoVenta venta: aux) {
			for(Producto prod: venta.getProductos()) {
				vendido.add(prod);		
			}
		}
		for(Producto prodV: vendido) {
			for(Producto prodVAux: vendido) {
				auxP.setNombre(prodV.getNombre());
				if(prodV.getId()==prodVAux.getId()) {
					
					total=total+prodV.getPrecio();
				}
			}
			auxP.setCantidad(masVend);
			auxP.setValTotal(total);
			auxP.setValUnitario(prodV.getPrecio());
			masVend=0;
			total=0;
			products.add(auxP);
		}*/
		//products.stream().distinct();
		return products;
		
	}
}
