package Servidor;

import java.util.List;

import Contenido.Contenido;

public interface Servidor {


	/**
	 * Método que devuelve el nombre del servidor
	 * @return devuelve el nombre del servidor
	 * */
	public String obtenerNombre();


	/**
	 * Método en el que el servidor devuelve un token válido para 10 contenidos
	 * @return token
	 * */
	public String alta();

	// Inutiliza un token que aún no está agotado
	/**
	 * Método que inutiliza un token que aún no está agotado
	 * @param token
	 * */
	public void baja(String token) throws TokenNotFoundException;

	/**
	 * Método que añade un contenido al servidor.
	 * @param Contenido que el elemento que queremos eliminar.
	 * @param Token especial para agregar y eliminar contenidos.
	 * */
	public void agregar(Contenido contenido, String token) throws TokenNotFoundException, ContenidoDuplicadoException;

	
	/**
	 * Método que elimina un contenido del servidor.
	 * @param Contenido que el elemento que queremos eliminar.
	 * @param Token especial para agregar y eliminar contenidos.
	 * */
	public void eliminar(Contenido contenido, String token) throws TokenNotFoundException;

	// Busca contenidos cuyo nombre coincida con la subcadena total o
	// parcialmente. Si se agota el token, a partir de ese momento, se considera
	// token vacío y se añadirá un anuncio al principio, y un anuncio cada 3
	// contenidos.
	/**
	 * Método que busca contenidos cuyo nombre coincida con la subcadena total o
	 * parcialmente. Si se agota el token, a partir de ese momento, se considera
	 * token vacío y se añadirá un anuncio al principio, y un anuncio cada 3
	 * contenidos.
	 * @param Contenido
	 * @param Token
	 * @return Lista de contenido
	 * */
	public List<Contenido> buscar(String subcadena, String token);
}
