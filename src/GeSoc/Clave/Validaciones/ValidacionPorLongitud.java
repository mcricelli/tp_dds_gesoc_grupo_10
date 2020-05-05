package GeSoc.Clave.Validaciones;

import GeSoc.Clave.CriterioValidacion;

public class ValidacionPorLongitud implements CriterioValidacion {
	char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t',
			'u','v','w','x','y','z'};
	String claveGenerada;

	@Override
	public Boolean EsValida(String clave) {
		if(this.esCreadaPorUsuario(clave)){
			return true;
		}else {
			claveGenerada = this.generarContrasenia(clave);
			return false;
			
		}
	}
	
	public String generarContrasenia(String clave){
		char [] conjunto = new char[6];
		for(int i=0;i<7;i++){
			int el = (int)(Math.random()*37);
			conjunto[i] = elementos[el];
		}
		return clave = new String(conjunto);
	}
	
	public boolean esCreadaDeFormaAleatoria(String clave) {
		return clave.length()>6;
	}
	
	public boolean esCreadaPorUsuario(String clave){
		return clave.length()>8;
		
	}

	@Override
	public String ObtenerMotivoInvalidez(String clave) {
		if(this.esCreadaPorUsuario(clave)) {
			return "No respeta la longitud minima por usuario";
		}else {
			return "Error al generar clave aleatoria";
		}
	}

}
