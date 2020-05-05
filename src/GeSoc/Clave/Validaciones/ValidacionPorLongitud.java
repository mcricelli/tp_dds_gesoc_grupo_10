package GeSoc.Clave.Validaciones;

import GeSoc.Clave.CriterioValidacion;

public class ValidacionPorLongitud implements CriterioValidacion {
	public int minimo = 8;
	public int maximo = 64;
	private String errorMinimo = "El minimo de caracteres permitidos es: ";
	private String errorMaximo = " El maximo de caracteres permitidos es: ";
	
	public ValidacionPorLongitud(int rangoMinimo,int rangoMaximo) {
		this.minimo = rangoMinimo;
		this.maximo = rangoMaximo;
	}

	@Override
	public Boolean EsValida(String clave) {
		return this.estaEnElRango(clave);
	}
	
	public Boolean estaEnElRango(String clave) {
		return this.eliminarEspacioEnBlanco(clave).length() >= minimo && this.eliminarEspacioEnBlanco(clave).length()<=maximo;
	}
	
	@Override
	public String ObtenerMotivoInvalidez(String clave) {
		if(clave.length()<minimo) {
			return errorMinimo+minimo;
		}else {
			return errorMaximo+maximo;
		}
	}
	
	public String eliminarEspacioEnBlanco(String clave) {
		return clave.replaceAll("\\s","").trim();
	}

}
