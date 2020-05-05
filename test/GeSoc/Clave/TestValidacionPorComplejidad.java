package GeSoc.Clave;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GeSoc.Clave.Validaciones.ValidacionPorComplejidad;

public class TestValidacionPorComplejidad {

	private ValidacionPorComplejidad validacion;
	
	private String clave;
	
	private String mensajeUsarNumeros = "La clave debe tener al menos un numero.";
	
	private String mensajeUsarMayuscula = "La clave debe tener al menos una mayuscula.";

	private String mensajeUsarCaracterEspecial = "La clave debe tener al menos un caracter especial (!@#$%^&*()+-=[]{};':\"|,.<>/?).";
	
	@Before
	public void init() {
		validacion = new ValidacionPorComplejidad();
	}

	@Test
	public void ValidacionPorComplejidadFallaConClaveSinNumerosNiCaracteresEspecialesNiMayusculas() {
		clave = "clave";
		Assert.assertFalse(validacion.EsValida(clave));
	}
	
	@Test
	public void ValidacionPorComplejidadFallaConClaveSinNumerosNiCaracteresEspeciales() {
		clave = "Clave";
		Assert.assertFalse(validacion.EsValida(clave));
	}
	
	@Test
	public void ValidacionPorComplejidadFallaConClaveSinNumeros() {
		clave = "Clave!";
		Assert.assertFalse(validacion.EsValida(clave));
	}
	
	@Test
	public void ValidacionPorComplejidadFunciona() {
		clave = "Clave1!";
		Assert.assertTrue(validacion.EsValida(clave));
	}
	
	@Test
	public void ValidacionPorComplejidadRetornaMensajesInvalidezConClaveSinNumerosNiCaracteresEspecialesNiMayusculas() {
		clave = "clave";
		List<String> mensajesInvalidez = validacion.ObtenerMotivosInvalidez(clave);
		Assert.assertTrue(
				mensajesInvalidez.contains(mensajeUsarNumeros)
				&& mensajesInvalidez.contains(mensajeUsarCaracterEspecial)
				&& mensajesInvalidez.contains(mensajeUsarMayuscula)
			);
	}
	
	@Test
	public void ValidacionPorComplejidadRetornaMensajesInvalidezConClaveSinNumerosNiCaracteresEspeciales() {
		clave = "Clave";
		List<String> mensajesInvalidez = validacion.ObtenerMotivosInvalidez(clave);
		Assert.assertTrue(
				mensajesInvalidez.contains(mensajeUsarNumeros)
				&& mensajesInvalidez.contains(mensajeUsarCaracterEspecial)
			);
	}
	
	@Test
	public void ValidacionPorComplejidadRetornaMensajesInvalidezConClaveSinNumeros() {
		clave = "Clave!";
		List<String> mensajesInvalidez = validacion.ObtenerMotivosInvalidez(clave);
		Assert.assertTrue(
				mensajesInvalidez.contains(mensajeUsarNumeros)
			);
	}	

}
