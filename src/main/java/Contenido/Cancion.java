package Contenido;

import java.util.List;

public class Cancion implements Contenido {

	private String titulo;
	private int duracion;
	private List<Contenido> listaReproduccion;
	
	public Cancion(String titulo, int duracion){
		this.titulo = titulo;
		this.duracion = duracion;
	}

	//Obtiene el titulo
	public String obtenerTitulo() {
		return titulo;
	}
	
	//Obtiene la duraci�n
	public int obtenerDuracion() {
		return duracion;
	}

	//Obtiene la lista de reproducci�n
	public List<Contenido> obtenerListaReproduccion() {
		return listaReproduccion;
	}

	/* AQUI TENGO DUDAS
	 * */
	public List<Contenido> buscar(String subcadena) {
		
		/*
		 * AQUI TENGO DUDAS, falta acabar esto
		 */
		return null;
	}
	
	//Canci�n no implementa esta funcionalidad
	public void agregar(Contenido contenido, Contenido predecesor) {
		return;
	}

	//Canci�n no implementa esta funcionalidad
	public void eliminar(Contenido contenido) {
		return;
	}


	
	
}
