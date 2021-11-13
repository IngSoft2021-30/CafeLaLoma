package dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CambiarPassword {

	@NotNull
	private Long id;
	
	@NotBlank
	private String passwordActual;
	
	@NotBlank
	private String passwordNuevo;
	
	@NotBlank
	private String passwordConfirm;

	public CambiarPassword() { }

	public CambiarPassword(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPasswordActual() {
		return passwordActual;
	}

	public void setPasswordActual(String passwordActual) {
		this.passwordActual = passwordActual;
	}

	public String getPasswordNuevo() {
		return passwordNuevo;
	}

	public void setPasswordNuevo(String passwordNuevo) {
		this.passwordNuevo = passwordNuevo;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passwordActual == null) ? 0 : passwordActual.hashCode());
		result = prime * result + ((passwordConfirm == null) ? 0 : passwordConfirm.hashCode());
		result = prime * result + ((passwordNuevo == null) ? 0 : passwordNuevo.hashCode());
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
		CambiarPassword other = (CambiarPassword) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (passwordActual == null) {
			if (other.passwordActual != null)
				return false;
		} else if (!passwordActual.equals(other.passwordActual))
			return false;
		if (passwordConfirm == null) {
			if (other.passwordConfirm != null)
				return false;
		} else if (!passwordConfirm.equals(other.passwordConfirm))
			return false;
		if (passwordNuevo == null) {
			if (other.passwordNuevo != null)
				return false;
		} else if (!passwordNuevo.equals(other.passwordNuevo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CambiarPassword [id=" + id + ", passwordActual=" + passwordActual + ", passwordNuevo=" + passwordNuevo
				+ ", passwordConfirm=" + passwordConfirm + "]";
	}
	
	
	
}
