package dto;

public class ProductMasVend {
	
	String nombre;
	int cantidad;
	double valTotal;
	double valUnitario;
	
	
	public ProductMasVend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductMasVend(String nombre, int cantidad, double valTotal, double valUnitario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valTotal = valTotal;
		this.valUnitario = valUnitario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getValTotal() {
		return valTotal;
	}
	public void setValTotal(double valTotal) {
		this.valTotal = valTotal;
	}
	public double getValUnitario() {
		return valUnitario;
	}
	public void setValUnitario(double valUnitario) {
		this.valUnitario = valUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valUnitario);
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
		ProductMasVend other = (ProductMasVend) obj;
		if (cantidad != other.cantidad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(valTotal) != Double.doubleToLongBits(other.valTotal))
			return false;
		if (Double.doubleToLongBits(valUnitario) != Double.doubleToLongBits(other.valUnitario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductMasVend [nombre=" + nombre + ", cantidad=" + cantidad + ", valTotal=" + valTotal
				+ ", valUnitario=" + valUnitario + "]";
	}
	
	
}
