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
