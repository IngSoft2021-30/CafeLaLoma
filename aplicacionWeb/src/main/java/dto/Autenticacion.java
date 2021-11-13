package dto;

import javax.validation.constraints.NotBlank;

public class Autenticacion {
	
	@NotBlank
	private String identificacion;
	
	@NotBlank
	private String password;
	
}
