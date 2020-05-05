package GeSoc.Clave;
import GeSoc.Clave.Validaciones.ValidacionPorLongitud;

import org.junit.Test;
import org.junit.Assert;


public class TestValidadorClave {
	ValidadorClave val = new ValidadorClave();
	
	
	private String contrasenia;
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void generarClave(String clave) {
		this.contrasenia = clave;
	}
	

	@Test
	public void noDeAceptarClaveMenorAOcho() {
		this.generarClave("hola");
		Assert.assertFalse(val.EsValida(contrasenia));
        
	}

}
