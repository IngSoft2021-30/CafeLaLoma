package com.cafeLaLoma.demo.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProductoVenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5923724526510314063L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "venta_productos",
			joinColumns=@JoinColumn(name="ProductosVenta_id"),
			inverseJoinColumns=@JoinColumn(name="producto_id"))
	@JoinColumn(name="producto_id")
	private Set<Producto> productos;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="venta_id",unique=false)
	private Venta venta_id;
	
	@Column
	@NotBlank
	private int cantidad;
	
	@Column
	@NotBlank
	private double valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Venta getVenta_id() {
		return venta_id;
	}

	public void setVenta_id(Venta venta_id) {
		this.venta_id = venta_id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "ProductoVenta [id=" + id + ", productos=" + productos + ", venta_id=" + venta_id + ", cantidad="
				+ cantidad + ", valorTotal=" + valorTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((venta_id == null) ? 0 : venta_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoVenta other = (ProductoVenta) obj;
		if (cantidad != other.cantidad)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		if (venta_id == null) {
			if (other.venta_id != null)
				return false;
		} else if (!venta_id.equals(other.venta_id))
			return false;
		return true;
	}
	
	
}
