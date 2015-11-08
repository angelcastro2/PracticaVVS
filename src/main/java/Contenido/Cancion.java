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
		listaReproduccion.add(this);
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

	//Buscar
	public List<Contenido> buscar(String subcadena) {
		if (titulo.equalsIgnoreCase(subcadena)){
			return listaReproduccion;
		}else{
			List<Contenido> listaVacia = new ArrayList<Contenido>();
			return listaVacia;
		}
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
