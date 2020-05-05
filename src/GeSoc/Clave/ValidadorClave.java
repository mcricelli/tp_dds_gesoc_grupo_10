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
		return criteriosValidacion.stream().allMatch( criterio -> criterio.EsValida(clave));
	}
	
	public List<String> ObtenerMotivosInvalidez(String clave)
	{
		return criteriosValidacion.stream().filter(criterio -> !criterio.EsValida(clave))
				.map(criterio -> criterio.ObtenerMotivoInvalidez(clave))
				.collect(Collectors.toList());
	}
	
	public void AgregarCriterio(CriterioValidacion criterioValidacion)
	{
		criteriosValidacion.add(criterioValidacion);
	}
}
