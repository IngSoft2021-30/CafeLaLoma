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
	
	
}
