package GeSoc.Clave.Validaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public List<String> obtenerMotivosInvalidez(String clave)
	{
		List<String> motivos = new ArrayList<String>();
		
		if (!TieneNumero(clave)) motivos.add(mensajeUsarNumeros);
		
		if (!TieneMayuscula(clave)) motivos.add(mensajeUsarMayuscula);
		
		if (!TieneCaracterEspecial(clave)) motivos.add(mensajeUsarCaracterEspecial);
		
		return motivos;
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
