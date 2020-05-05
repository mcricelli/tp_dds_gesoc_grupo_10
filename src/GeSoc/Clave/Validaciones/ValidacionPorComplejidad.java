package GeSoc.Clave.Validaciones;

import GeSoc.Clave.CriterioValidacion;

public class ValidacionPorComplejidad implements CriterioValidacion {
	
	private String mensajeUsarNumeros = "La clave debe tener al menos un número.";
	
	private String mensajeUsarMayuscula = "La clave debe tener al menos una mayúscula.";

	private String mensajeUsarCaracterEspecial = "La clave debe tener al menos un caracter especial (!@#$%^&*()+-=[]{};':\"|,.<>/?).";

	
	@Override
	public Boolean EsValida(String clave)
	{
		return TieneNumero(clave) && TieneMayuscula(clave) && TieneCaracterEspecial(clave);
	}

	@Override
	public String ObtenerMotivoInvalidez(String clave)
	{
		// TODO: la interfaz deberia soportar un List<String> en vez de solo String para este metodo.
		String motivo = "";
		
		if (!TieneNumero(clave)) motivo += mensajeUsarNumeros;
		
		if (!TieneMayuscula(clave)) motivo += mensajeUsarMayuscula;
		
		if (!TieneCaracterEspecial(clave)) motivo += mensajeUsarCaracterEspecial;
		
		return motivo;
	}
	
	private Boolean TieneNumero(String clave)
	{
		return clave.matches(".*[0-9].*");
	}
	
	private Boolean TieneMayuscula(String clave)
	{
		return clave.matches(".*[A-Z].*");
	}
	
	private Boolean TieneCaracterEspecial(String clave)
	{
		return clave.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
	}

}
