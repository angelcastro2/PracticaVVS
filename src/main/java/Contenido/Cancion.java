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

	//Buscar
	public List<Contenido> buscar(String subcadena) {
		if (titulo.contains(subcadena)){
			listaReproduccion.add(this);
		}
		return listaReproduccion;
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
