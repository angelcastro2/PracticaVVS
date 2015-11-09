package Servidor;

import Contenido.Contenido;

@SuppressWarnings("serial")
public class ContenidoDuplicadoException extends Exception {

	// Excepcion que controla la inserción de contenido duplicado en el servidor
	public ContenidoDuplicadoException(Contenido contenido) {
		super(" Contenido " + contenido + " ya esta en el servidor. ");
	}

}
