package GeSoc.Clave;
import GeSoc.Clave.Validaciones.ValidacionPorLongitud;


import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class TestValidacionPorLongitud{
	
	private String contrasenia;
	private ValidadorClave validador;
	
	@Before
	public void init() {
		validador = new ValidadorClave();
		validador.AgregarCriterio(new ValidacionPorLongitud(8,64));
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void generarClave(String clave) {
		this.contrasenia = clave;
	}
	
	@Test
	public void noDeAceptarClaveMenorAOcho() {
		this.generarClave("hola");
		Assert.assertFalse(validador.EsValida(contrasenia));
	}
	
	@Test
	public void noDebeContarEspaciosEnBlanco() {
		this.generarClave("hol      a");
		Assert.assertFalse(validador.EsValida(contrasenia));
	}
	
	@Test
	public void noDebeSuperarElMaximo() {
		this.generarClave("holacomoestasholacomoestasholacomoestasholacomoestasholacomoestas");
		Assert.assertFalse(validador.EsValida(contrasenia));
	}
	
	@Test
	public void noDebeAceptarEspaciosVaciosInicioOFin() {
		this.generarClave("  hola    ");
		Assert.assertFalse(validador.EsValida(contrasenia));
	}
	
	@Test
	public void debeAceptarDentroDelRango() {
		this.generarClave("holaComoEstas");
		Assert.assertTrue(validador.EsValida(contrasenia));
	}

}
