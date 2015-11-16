package Contenido;

import java.util.List;

import javax.management.InstanceNotFoundException;

public interface Contenido {

	/**
	 * Método utilizado para obtener el titulo
	 * @return devuelve el título
	 * */
	public String obtenerTitulo();
	/**
	 * Método utilizado para obtener duracion
	 * @return devuelve un entero con la duracion
	 * */
	public int obtenerDuracion();
	/**
	 * Método utilizado para obtener la lista de reproduccion
	 * @return devuelve una lista de contenido
	 **/
	public List<Contenido> obtenerListaReproduccion();
	/**
	 * Método utilizado para buscar a partir de una subcadena
	 * @param la subcadena
	 * @return devuelve una lista de contenido
	 * */
	public List<Contenido> buscar(String subcadena);
	/**
	 * Método que busca el predecesor e inserta el contenido después del predecesor en 
	 * la lista de reproducción
	 * @param  el contenido
	 * @param su predecesor
	 * @return lista de contenido
	 **/
	public void agregar(Contenido contenido, Contenido predecesor);
	/**
	 * Método que elimina el contenido pasado de la emisora 
	 *(solo la primera aparición en la lista)
	 * @param  el contenido
	 **/
	public void eliminar(Contenido contenido) throws InstanceNotFoundException;
	
}
