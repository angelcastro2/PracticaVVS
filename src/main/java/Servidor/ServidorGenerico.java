package Servidor;

import java.util.ArrayList;
import java.util.List;

import Contenido.Contenido;

public abstract class ServidorGenerico implements Servidor {

	private String nombre; // Nombre del servidor
	private List<Contenido> contenidos; // Lista de contenidos del servidor
	private List<Contenido> anuncios; // Lista de anuncios del servidor
	private int indiceAnuncio; // Indice usado para recorrer los anuncios

	public ServidorGenerico(String nombre, List<Contenido> contenidos, List<Contenido> anuncios) {
		super();
		this.nombre = nombre;
		if (contenidos == null)
				this.contenidos = new ArrayList<Contenido> ();
		else
			this.contenidos = contenidos;
		if (anuncios == null)
			this.anuncios = new ArrayList<Contenido> ();
		else
			this.anuncios = anuncios;
		this.indiceAnuncio = 0;
	}

	// Devuelve el nombre del servidor
	public String obtenerNombre() {
		return nombre;
	}

	// Crea un token con 10 usos
	public String alta() {
		return Token.anadirToken();
	}

	// Elimina un token
	public void baja(String token) {
		Token.eliminarToken(token);
	}

	// Agrega contenido a un servidor, requiere un token válido.
	// TokenNotFoundException: El token no existe
	// ContenidoDuplicadoException: El contenido ya está en el servidor
	public void agregar(Contenido contenido, String token) throws TokenNotFoundException, ContenidoDuplicadoException {
		if(Token.esEspecial(token)){
			if (contenidos.contains(contenido))
				throw new ContenidoDuplicadoException(contenido);
			contenidos.add(contenido);
		}else{
			throw new TokenNotFoundException(token);
		}
	}

	// Elimina un contenido de un servidor, requiere un token válido.
	// TokenNotFoundException: El token no existe
	public void eliminar(Contenido contenido, String token) throws TokenNotFoundException {
		if(Token.esEspecial(token))
			contenidos.remove(contenido);
		else
			throw new TokenNotFoundException(token);
	}

	// Devuelve los contenidos del servidor
	protected List<Contenido> getContenidos() {
		return contenidos;
	}

	// Obtiene un anuncio y incrementa el indice para que el siguiente indice
	// devuelto sea el siguiente, si el anuncio devuelto es el último, el indice
	// se pone a 0
	protected Contenido obtenerAnuncio() {
		Contenido anuncio = anuncios.get(indiceAnuncio);
		indiceAnuncio++;
		if (indiceAnuncio == anuncios.size())
			indiceAnuncio = 0;
		return anuncio;
	}

}
