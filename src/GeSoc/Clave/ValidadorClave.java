package GeSoc.Clave;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidadorClave
{
	private List<CriterioValidacion> criteriosValidacion;
	
	public ValidadorClave()
	{
		criteriosValidacion = new ArrayList<CriterioValidacion>();
	}
	
	public Boolean EsValida(String clave)
	{
		return !criteriosValidacion.isEmpty() ? criteriosValidacion.stream().allMatch( criterio -> criterio.EsValida(clave)) : true;
	}
	
	public List<String> ObtenerMotivosInvalidez(String clave)
	{
		return !criteriosValidacion.isEmpty() ? criteriosValidacion.stream().filter(criterio -> !criterio.EsValida(clave))
				.map(criterio -> criterio.ObtenerMotivosInvalidez(clave)).
				flatMap(motivosPorCriterio -> motivosPorCriterio.stream())
				.collect(Collectors.toList()) : new ArrayList<String>();
	}
	
	public void AgregarCriterio(CriterioValidacion criterioValidacion)
	{
		criteriosValidacion.add(criterioValidacion);
	}
}
