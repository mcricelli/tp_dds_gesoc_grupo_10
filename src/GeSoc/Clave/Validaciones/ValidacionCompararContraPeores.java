package GeSoc.Clave.Validaciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import GeSoc.Clave.CriterioValidacion;

public class ValidacionCompararContraPeores implements CriterioValidacion {
	
	private String archivoPeoresClaves = "./resources/claves_mas_comunes.txt";

	private String motivoInvalidez = "La clave es demasiado común.";
	
	@Override
	public Boolean EsValida(String clave) {
		
		try {
			FileInputStream fis = new FileInputStream(archivoPeoresClaves);			
			Scanner sc = new Scanner(fis);
			
			while (sc.hasNextLine())  
			{  
				if (sc.nextLine().equals(clave))
					return false;
			}  
			sc.close();
			
		} catch (FileNotFoundException e) {
			return true;
		}
		
		return true;
	}

	@Override
	public String ObtenerMotivoInvalidez(String clave) {
		return motivoInvalidez;
	}

}
