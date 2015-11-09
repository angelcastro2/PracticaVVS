package Servidor;

import java.util.List;

import Contenido.Contenido;

public interface Servidor {

	// Devuelve el nombre del servidor
	public String obtenerNombre();

	// El servidor devuelve un token válido para 10 contenidos
	public String alta();

	// Inutiliza un token que aún no está agotado
	public void baja(String token) throws TokenNotFoundException;

	// Añade un contenido al servidor
	public void agregar(Contenido contenido, String token) throws TokenNotFoundException, ContenidoDuplicadoException;

	// Elimina un contenido del servidor
	public void eliminar(Contenido contenido, String token) throws TokenNotFoundException;

	// Busca contenidos cuyo nombre coincida con la subcadena total o
	// parcialmente. Si se agota el token, a partir de ese momento, se considera
	// token vacío y se añadirá un anuncio al principio, y un anuncio cada 3
	// contenidos.
	public List<Contenido> buscar(String subcadena, String token);
}
