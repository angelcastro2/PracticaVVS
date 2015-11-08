package Contenido;

import java.util.List;

public class Cancion implements Contenido {

	private String titulo;
	private int duracion;
	
	public Cancion(String titulo, int duracion){
		this.titulo = titulo;
		this.duracion = duracion;
	}

	public String obtenerTitulo() {
		
		return titulo;
	}

	public int obtenerDuracion() {
		
		return duracion;
	}

	public List<Contenido> obtenerListaReproduccion() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contenido> buscar(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregar(Contenido contenido, Contenido predecesor) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Contenido contenido) {
		// TODO Auto-generated method stub
		
	}


	
	
}
