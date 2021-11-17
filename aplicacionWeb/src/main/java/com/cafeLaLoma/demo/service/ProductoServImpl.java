package com.cafeLaLoma.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeLaLoma.demo.entity.Producto;
import com.cafeLaLoma.demo.entity.Usuario;
import com.cafeLaLoma.demo.repository.ProductoRepository;

@Service
public class ProductoServImpl implements ProductoService{
	
	@Autowired
	ProductoRepository repository;
	@Override
	public Iterable<Producto> getAllProductos() {
		return repository.findAll();
	}
	
	@Override
	public Producto getProductoById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El producto no existe."));
		
	}

	@Override
	public Iterable<String> getProductNombres() {
		Iterable<Producto> prodsIterable = getAllProductos(); 
		List<String> nombres = new ArrayList<String>();
		for(Producto prods : prodsIterable) {
			nombres.add(prods.getNombre());
		}
		return nombres;
	}

	@Override
	public Iterable<Long> getProductIds() {
		Iterable<Producto> prodsIterable = getAllProductos(); 
		List<Long> ids = new ArrayList<Long>();
		for(Producto prods : prodsIterable) {
			ids.add(prods.getId());
		}
		return ids;
	}

	@Override
	public void actualizaProdById(int disponible, Long id) throws Exception {
		Producto toProd = getProductoById(id);
		int dispo= toProd.getDisponible()+disponible;
		toProd.setDisponible(dispo);
		repository.save(toProd);
	}

	@Override
	public Long generarId() throws Exception {
		Iterable <Producto> aux= getAllProductos();
		Long tam = (long) 0;
		for(Producto value : aux) {
		   tam++;
		}
		return tam+1;
	}

	@Override
	public void addProducto(Producto pord) throws Exception {
		repository.save(pord);
	}

}
