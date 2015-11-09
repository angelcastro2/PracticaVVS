package Servidor;

import java.util.ArrayList;
import java.util.List;

import Contenido.Contenido;

//Servidor sin respaldo. 
public class ServidorBasico extends ServidorGenerico {

	public ServidorBasico(String nombre, List<Contenido> contenidos, List<Contenido> anuncios) {
		super(nombre, contenidos, anuncios);
	}

	// Busca el contenido coincidente con la subcadena
	// Si el token tiene usos devuelve contenidos, cuando se acaben los usos
	// o si el token es inválido, devuelve 1 anuncio al principio y 1 anuncio
	// cada 3 contenidos
	public List<Contenido> buscar(String subcadena, String token) {

		List<Contenido> contenidos = super.getContenidos(); // Contenidos del servidor
		List<Contenido> resultado = new ArrayList<Contenido>(); // Contenidos + Anuncios a devolver
		List<Contenido> aux = new ArrayList<Contenido>(); // Contenidos del servidor coincidentes con la subcadena
		List<Contenido> busqueda = new ArrayList<Contenido>();
		
		
		// Hacemos el filtro de elementos coincidentes con la subcadena
		for (Contenido c : contenidos)
			if ((busqueda = c.buscar(subcadena)) != null)
				aux.addAll(busqueda);

		try {
			// Comprobamos el token
			Token.validarToken(token);

			// Recorremos los contenidos filtrados y los añadimos a resultado
			// usamos el token para consumir ese contenido
			for (Contenido c : aux) {
				resultado.add(c);
				Token.usarToken(token);
			}
		} catch (TokenNotFoundException e) { // En este punto, acabamos el token
												// o el token no era válido
			// Añadimos un anuncio al principio
			resultado.add(super.obtenerAnuncio());
			// Empezamos en resultado.size para no recorrer los contenidos
			// obtenidos con el token
			for (int i = resultado.size() - 1; i < aux.size(); i++) {
				resultado.add(aux.get(i));
				// Si es multiplo de 3 metemos un anuncio. 0%3 es 0 por lo que
				// tenemos que controlar que no meta anuncio entre el contenido
				// 0 y el 1
				if (((i % 3) == 0) && (i > 2))
					resultado.add(super.obtenerAnuncio());
			}
		}

		return resultado;
	}

}
