package Contenido;

import java.util.List;

public class Anuncio implements Contenido {

	private String titulo = "PUBLICIDAD";
	private int duracion = 5;
	
	public Anuncio() {	}


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

	public List<Contenido> buscar(String elemento) {
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
