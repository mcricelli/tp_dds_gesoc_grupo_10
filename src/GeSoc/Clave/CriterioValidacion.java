package GeSoc.Clave;

public interface CriterioValidacion {
	
	Boolean  EsValida(String clave);
	
	String ObtenerMotivoInvalidez(String clave);
}
