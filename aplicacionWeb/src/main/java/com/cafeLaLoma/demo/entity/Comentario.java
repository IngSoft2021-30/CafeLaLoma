package com.cafeLaLoma.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comentario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5781214526701370884L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	@NotBlank
	private Usuario usuario_id;
	@ManyToOne
	@JoinColumn(name="producto_id",unique=false)
	@NotBlank
	private Producto producto_id;
	@Column
	@NotBlank
	private String fecha;
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
	public Producto getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(Producto producto_id) {
		this.producto_id = producto_id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", usuario_id=" + usuario_id + ", producto_id=" + producto_id + ", fecha="
				+ fecha + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((producto_id == null) ? 0 : producto_id.hashCode());
		result = prime * result + ((usuario_id == null) ? 0 : usuario_id.hashCode());
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
		Comentario other = (Comentario) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (producto_id == null) {
			if (other.producto_id != null)
				return false;
		} else if (!producto_id.equals(other.producto_id))
			return false;
		if (usuario_id == null) {
			if (other.usuario_id != null)
				return false;
		} else if (!usuario_id.equals(other.usuario_id))
			return false;
		return true;
	}
	
}
