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
	
	//Obtiene la duración
	public int obtenerDuracion() {
		return duracion;
	}
	
	//Obtiene el anuncio
	public List<Contenido> obtenerListaReproduccion() {
		return listaReproduccion;
	}

	//Busca
	public List<Contenido> buscar(String elemento) {
		return null;
	}



	public void agregar(Contenido contenido, Contenido predecesor) {
		// TODO Auto-generated method stub
		
	}


	public void eliminar(Contenido contenido) {
		// TODO Auto-generated method stub
		
	}

	
}
