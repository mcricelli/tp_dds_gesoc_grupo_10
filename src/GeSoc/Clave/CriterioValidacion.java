package GeSoc.Clave;

import java.util.List;

public interface CriterioValidacion {
	
	Boolean EsValida(String clave);
	
	List<String> obtenerMotivosInvalidez(String clave);
}
