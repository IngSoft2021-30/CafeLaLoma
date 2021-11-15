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

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Carrito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuario_id",unique=false)
	private Usuario usuario_id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "carrito_productos",
			joinColumns=@JoinColumn(name="carrito_id"),
			inverseJoinColumns=@JoinColumn(name="producto_id"))
	@JoinColumn(name="producto_id")
	private Set<Producto> productos;
	
	@Column
	private int cantidad;
	@Column
	private double valoTotal;
	
	public Carrito(Long id) {
		super();
		this.id = id;
	}

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValoTotal() {
		return valoTotal;
	}

	public void setValoTotal(double valoTotal) {
		this.valoTotal = valoTotal;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", usuario_id=" + usuario_id + ", productos=" + productos + ", cantidad="
				+ cantidad + ", valoTotal=" + valoTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		result = prime * result + ((usuario_id == null) ? 0 : usuario_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valoTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Carrito other = (Carrito) obj;
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
		if (usuario_id == null) {
			if (other.usuario_id != null)
				return false;
		} else if (!usuario_id.equals(other.usuario_id))
			return false;
		if (Double.doubleToLongBits(valoTotal) != Double.doubleToLongBits(other.valoTotal))
			return false;
		return true;
	}

}
