package GeSoc.Clave;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


import GeSoc.Clave.Validaciones.ValidacionCompararContraPeores;

public class TestValidacionCompararContraPeores {
	private String contrasenia;
	private ValidadorClave validador;
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void generarClave(String clave) {
		this.contrasenia = clave;
	} 
	
	@Before
	public void init() {
		validador = new ValidadorClave();
		validador.AgregarCriterio(new ValidacionCompararContraPeores());
		
	}

	@Test
	public void noDebeAceptarContraseniasDeLaListas() {
		this.generarClave("dragon");
		Assert.assertFalse(validador.EsValida(contrasenia));
	}
	
	@Test
	public void debeAceptarLosQueNoEsteEnLaLista() {
		this.generarClave("cricelli");
		Assert.assertTrue(validador.EsValida(contrasenia));
	}
	
	@Test
	public void debeAceptarAunqueLaClaveTengaFrangmentosDeLaLista() {
		this.generarClave("martespasswordlunes");
		Assert.assertTrue(validador.EsValida(contrasenia));
	}
	
	@Test
	public void debeAceptarAunqueLaClaveTengaFragmentosDeLaListaAlPrincipio() {
		this.generarClave("passwordmartes");
		Assert.assertTrue(validador.EsValida(contrasenia));
		
	}
	
	@Test
	public void debeAceptarAunqueLaClaveTengaFragmentosDeLaListaAlFinal() {
		this.generarClave("lunespassword");
		Assert.assertTrue(validador.EsValida(contrasenia));
		
	}

}
