package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Emisora implements Contenido {

	private String titulo;
	private int duracion;
	private List<Contenido> listaReproduccion;
	
	//Constructor 
	public Emisora(String titulo){
		this.titulo=titulo;
		this.duracion=0;
		listaReproduccion = new ArrayList<Contenido>();
	}
	
	
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
		for(Contenido c: listaReproduccion){
			if (c.obtenerTitulo().contains(subcadena)){
				resultado.add(c);
			}
		}
		return resultado;
	}

	
	
	public void agregar(Contenido contenido, Contenido predecesor) {
		listaReproduccion.add((listaReproduccion.indexOf(predecesor) + 1) , contenido);
		duracion+=contenido.obtenerDuracion();
		
	}

	public void eliminar(Contenido contenido) {
		listaReproduccion.remove(contenido);
		
	}

}
