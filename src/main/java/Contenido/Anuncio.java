package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Contenido {

	private String titulo = "PUBLICIDAD";
	private int duracion = 5;
	private List<Contenido> listaReproduccion;
	
	public Anuncio() {
		listaReproduccion = new ArrayList<Contenido>();
	}

	//Obtiene el titulo
	public String obtenerTitulo() {
		return titulo;
	}
	
	//Obtiene la duraci�n
	public int obtenerDuracion() {
		return duracion;
	}
	
	//Obtiene el anuncio
	public List<Contenido> obtenerListaReproduccion() {
		return listaReproduccion;
	}

	//Busca
	public List<Contenido> buscar(String subcadena) {
		if (titulo.contains(subcadena)){
			listaReproduccion.add(this);
		}
		return listaReproduccion;
	}


	//Anuncio no implementa esta funcionalidad
	public void agregar(Contenido contenido, Contenido predecesor) {
	}

	//Anuncio no implementa esta funcionalidad
	public void eliminar(Contenido contenido) {
	}

	
}
