package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Emisora implements Contenido {

	private String titulo;
	private int duracion;
	private List<Contenido> listaReproduccion;
	
	//Constructor 
	public Emisora(String titulo, int duracion){
		this.titulo=titulo;
		this.duracion=duracion;
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
	/*Busca la subcadena pasada pro parámetro en el titulo de los elementos
	 * de la lista de  reproducción, si no encuentra ada entonces devuelve
	 * lista vacía
	 */
	public List<Contenido> buscar(String subcadena) {
		List<Contenido> resultado = new ArrayList<Contenido>();
		for(int i=0; i < listaReproduccion.size();i++){
			if (listaReproduccion.get(i).obtenerTitulo().contains(subcadena)){
				resultado.add(listaReproduccion.get(i));
			}
		}
		return resultado;
	}

	/*Busca el predecesor e inserta el contenido después del predecesor en 
	 * la lista de reproducción
	 * */
	public void agregar(Contenido contenido, Contenido predecesor) {
		listaReproduccion.add(listaReproduccion.indexOf(predecesor) + 1 , contenido);
		
	}
	/*Elimina el contenido pasado de la emisora 
	 *(solo la primera aparicion en la lista)
	 */
	public void eliminar(Contenido contenido) {
		listaReproduccion.remove(contenido);
		
	}

}
