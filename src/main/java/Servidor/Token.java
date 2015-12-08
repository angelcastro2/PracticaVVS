package Servidor;

import java.util.HashMap;
import java.util.Random;

public class Token {
	
	// Lista de pares <token, numeroUsos>
	public static HashMap<String, Integer> tokens = new HashMap<String, Integer>();
	// Carácteres alfanumericos para generar tokens
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random(); // Usado para generar números aleatorios
	public static int len = 10; // Tamaño del token
	public static int usos = 10; // Número de usos del token
	public static String tokenEspecial = "U8/99Aj-";
	
	/*
	 * Devuelve un token especial
	 * @return token especial
	 */
	public static String tokenEspecial(){
		return tokenEspecial;
	}
	
	/*
	 * Comprueba que es un token especial
	 * @param token a validar
	 * @return boolean que indica si es token especial o no
	 */
	public static boolean esEspecial(String token){
		return tokenEspecial.equals(token);
	}
	
	// Genera un token
	public static String anadirToken() {
		// Generamos un string aleatorio
		String token = randomString();
		// Si el token generado ya existe, volvemos ejecutar la función
		if (tokens.containsKey(token))
			return anadirToken();
		else {
			// Si no existe, lo introducimos en el hashmap
			tokens.put(token, usos);
			return token;
		}
	}

	// Elimina un token del HashMap
	public static void eliminarToken(String token) {
		tokens.remove(token);
	}

	// Comprueba que existe el token
	// TokenNotFoundException: El token no existe
	public static void validarToken(String token) throws TokenNotFoundException {
		if (!tokens.containsKey(token))
			throw new TokenNotFoundException(token);
	}

	// Reduce el número de usos de un token, o elimina el token si se queda sin
	// usos
	// TokenNotFoundException: El token no existe
	public static void usarToken(String token) throws TokenNotFoundException {
		if (!tokens.containsKey(token))
			throw new TokenNotFoundException(token);
		else {
			int usos = tokens.get(token);
			usos = usos - 1;
			if (usos > 0)
				tokens.put(token, usos);			
			else				
				eliminarToken(token);					
		}
	}

	// Funcion que devuelve un string aleatorio
	private static String randomString() {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; ((i < len)&&(i>=0)); i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

}
