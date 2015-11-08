package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Emisora implements Contenido {

	private String titulo;
	private int duracion;
	private List<Contenido> listaReproduccion;
	
	
	public Emisora(String titulo, int duracion){
		this.titulo=titulo;
		this.duracion=duracion;
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
		for(int i=0; i < listaReproduccion.size();i++){
			if (listaReproduccion.get(i).obtenerTitulo().contains(subcadena)){
				resultado.add(listaReproduccion.get(i));
			}
		}
		return resultado;
	}

	public void agregar(Contenido contenido, Contenido predecesor) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Contenido contenido) {
		listaReproduccion.remove(contenido);
		
	}

}
