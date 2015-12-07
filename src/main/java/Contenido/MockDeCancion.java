package Contenido;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase representa el mock de la clase Cancion
 */

public class MockDeCancion implements Contenido {
	
	/**
	 * Título de la cancion
	 */
	private String titulo;
	/**
	 * Duracion de la cancion
	 */
	private int duracion;
	

	public String obtenerTitulo() {
		return titulo;
	}
	
	
	public int obtenerDuracion() {
		return duracion;
	}

	
	public List<Contenido> obtenerListaReproduccion() {
		List<Contenido> listaResultado= new ArrayList<Contenido>();
		
		return listaResultado;
	}

	public List<Contenido> buscar(String subcadena) {
		List<Contenido> listaResultado= new ArrayList<Contenido>();
		return listaResultado;
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
