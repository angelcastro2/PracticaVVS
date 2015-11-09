package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Contenido {

	private String titulo = "PUBLICIDAD";
	private int duracion = 5;
	private List<Contenido> listaReproduccion;
	
	public Anuncio() {
		listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(this);
	}

	//Obtiene el titulo
	public String obtenerTitulo() {
		return titulo;
	}
	
	//Obtiene la duraci�n
	public int obtenerDuracion() {
		return duracion;
	}
	
	//Obtiene el anuncio
	public List<Contenido> obtenerListaReproduccion() {
		return listaReproduccion;
	}

	//Busca
	public List<Contenido> buscar(String subcadena) {
		if (titulo.equalsIgnoreCase(subcadena)){
			return listaReproduccion;
		}else{
			List<Contenido> listaVacia = new ArrayList<Contenido>();
			return listaVacia;
		}
	}


	//Anuncio no implementa esta funcionalidad
	public void agregar(Contenido contenido, Contenido predecesor) {
	}

	//Anuncio no implementa esta funcionalidad
	public void eliminar(Contenido contenido) {
	}

	
}