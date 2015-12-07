package Contenido;

import java.util.ArrayList;
import java.util.List;

public class MockDeAnuncio implements Contenido {
	
	/**
	 * Creo las variables titulo y duracion.
	 */
	private String titulo;
	private int duracion;
	/**
	 * En anuncio el titulo debe ser PUBLICIDAD.
	 */
	public String obtenerTitulo() {
		return titulo;
	}
	/**
	 * En anuncio la duracion debe de ser 5.
	 */
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
