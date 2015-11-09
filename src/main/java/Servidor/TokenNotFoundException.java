package Servidor;

@SuppressWarnings("serial")
public class TokenNotFoundException extends Exception {

	// Excepcion que controla la existencia de un token determinado
	public TokenNotFoundException(String token) {
		super(" Token " + token + "Not Found ");
	}

}
