package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Cancion implements Contenido {

	private String titulo;
	private int duracion;
	private List<Contenido> listaReproduccion;
	
	public Cancion(String titulo, int duracion){
		this.titulo = titulo;
		this.duracion = duracion;
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
	 * Método no implementado por Cancion.
	 */
	public void agregar(Contenido contenido, Contenido predecesor) {
		return;
	}

	/*
	 * Método no implementado por Cancion.
	 */
	public void eliminar(Contenido contenido) {
		return;
	}


	
	
}
