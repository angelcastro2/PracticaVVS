package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Contenido {

	private String titulo = "PUBLICIDAD";
	private int duracion = 5;
	private List<Contenido> listaReproduccion;
	
	// Constructor de Anuncio
	public Anuncio() {
		listaReproduccion = new ArrayList<Contenido>();
	}

	
	public String obtenerTitulo() {
		return titulo;
	}
	
	public int obtenerDuracion() {
		return duracion;
	}
	
	
	public List<Contenido> obtenerListaReproduccion() {
		return listaReproduccion;
	}

	
	public List<Contenido> buscar(String subcadena) {
		if (titulo.contains(subcadena)){
			listaReproduccion.add(this);
		}
		return listaReproduccion;
	}


	/*
	 * Método no implementado por Anuncio.
	 */
	public void agregar(Contenido contenido, Contenido predecesor) {
	}

	/*
	 * Método no implementado por Anuncio.
	 */
	public void eliminar(Contenido contenido) {
	}

	
}
