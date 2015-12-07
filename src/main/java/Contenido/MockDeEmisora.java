package Contenido;

import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceNotFoundException;

public class MockDeEmisora implements Contenido {

	/**
	 * Título de la emisora
	 */
	private String titulo;
	
	/**
	 * Duracion de la emisora
	 */
	private int duracion;
	
	/**
	 * Inicializo la lista de reproducción
	 */
	private List<Contenido> listaReproduccion;
	
	
	
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
		List<Contenido> resultado = new ArrayList<Contenido>();
		return resultado;
	}

	
	
	public void agregar(Contenido contenido, Contenido predecesor) {

	}

	public void eliminar(Contenido contenido) throws InstanceNotFoundException {
		
		
	}
}
