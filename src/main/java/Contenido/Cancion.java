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
	
	//Obtiene la duración
	public int obtenerDuracion() {
		return duracion;
	}

	//Obtiene la lista de reproducción
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
	
	//Canción no implementa esta funcionalidad
	public void agregar(Contenido contenido, Contenido predecesor) {
		return;
	}

	//Canción no implementa esta funcionalidad
	public void eliminar(Contenido contenido) {
		return;
	}


	
	
}
