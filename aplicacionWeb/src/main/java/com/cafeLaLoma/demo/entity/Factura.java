package com.cafeLaLoma.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 393058667341419788L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="venta_id",unique=true)
	@NotBlank
	private Venta venta_id;
	@Column
	@NotBlank
	private String fecha;
	@Column
	private String guia_envio;
	@Column
	@NotBlank
	private String estado_envio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Venta getVenta_id() {
		return venta_id;
	}
	public void setVenta_id(Venta venta_id) {
		this.venta_id = venta_id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getGuia_envio() {
		return guia_envio;
	}
	public void setGuia_envio(String guia_envio) {
		this.guia_envio = guia_envio;
	}
	public String getEstado_envio() {
		return estado_envio;
	}
	public void setEstado_envio(String estado_envio) {
		this.estado_envio = estado_envio;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", venta_id=" + venta_id + ", fecha=" + fecha + ", guia_envio=" + guia_envio
				+ ", estado_envio=" + estado_envio + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado_envio == null) ? 0 : estado_envio.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((guia_envio == null) ? 0 : guia_envio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Factura other = (Factura) obj;
		if (estado_envio == null) {
			if (other.estado_envio != null)
				return false;
		} else if (!estado_envio.equals(other.estado_envio))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (guia_envio == null) {
			if (other.guia_envio != null)
				return false;
		} else if (!guia_envio.equals(other.guia_envio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (venta_id == null) {
			if (other.venta_id != null)
				return false;
		} else if (!venta_id.equals(other.venta_id))
			return false;
		return true;
	}

}
