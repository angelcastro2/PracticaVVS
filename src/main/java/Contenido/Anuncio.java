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
		List<Contenido> listaResultado= new ArrayList<Contenido>();
		listaResultado.add(this);
		
		return listaResultado;
	}

	
	public List<Contenido> buscar(String subcadena) {
            List<Contenido> listaResultado= new ArrayList<Contenido>();
            if (titulo.toLowerCase().contains(subcadena.toLowerCase())){
		listaResultado.add(this);
            }
            return listaResultado;
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
