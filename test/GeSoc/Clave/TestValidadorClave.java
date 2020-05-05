package GeSoc.Clave;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GeSoc.Clave.Validaciones.ValidacionPorComplejidad;
import GeSoc.Clave.Validaciones.ValidacionPorLongitud;

public class TestValidadorClave {

	private String clave;
	private ValidadorClave validador;
	
	@Before
	public void init() {
		validador = new ValidadorClave();
	}

	@Test
	public void SinCriteriosSiempreVacio() {
		clave = "";
		Assert.assertTrue(validador.EsValida(clave));
	}
	
	@Test
	public void SinCriteriosSiempreClaveComun() {
		clave = "password";
		Assert.assertTrue(validador.EsValida(clave));
	}
	
	@Test
	public void ConCriterioPorLongitudFalla() {
		validador.AgregarCriterio(new ValidacionPorLongitud(2,5));
		clave = "a";
		Assert.assertFalse(validador.EsValida(clave));
	}
	
	@Test
	public void ConCriterioPorLongitudFunciona() {
		validador.AgregarCriterio(new ValidacionPorLongitud(2,5));
		clave = "hola";
		Assert.assertTrue(validador.EsValida(clave));
	}
	
	@Test
	public void ConCriterioPorLongitudMuestraMensajeClaveCorta() {
		validador.AgregarCriterio(new ValidacionPorLongitud(2,5));
		clave = "a";
		String mensajeClaveCorta = "El minimo de caracteres permitidos es: 2";
		Assert.assertTrue(validador.ObtenerMotivosInvalidez(clave).get(0)
				.equals(mensajeClaveCorta));
	}
	
	@Test
	public void ConCriterioPorLongitudYComplejidadFunciona() {
		validador.AgregarCriterio(new ValidacionPorLongitud(2,5));
		validador.AgregarCriterio(new ValidacionPorComplejidad());
		clave = "h2N!";
		Assert.assertTrue(validador.EsValida(clave));
	}
	
	@Test
	public void ConCriterioPorLongitudYComplejidadMuestraCuatroErrores() {
		validador.AgregarCriterio(new ValidacionPorLongitud(2,5));
		validador.AgregarCriterio(new ValidacionPorComplejidad());
		clave = "a";
		Assert.assertTrue(validador.ObtenerMotivosInvalidez(clave).size() == 4);
	}

}
