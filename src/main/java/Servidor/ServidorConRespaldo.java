package Servidor;

import java.util.List;

import Contenido.Contenido;

//Servidor con respaldo. 
public class ServidorConRespaldo extends ServidorBasico {

	// Servidor al que accedemos si no tenemos contenidos coincidentes
	private Servidor respaldo;

	public ServidorConRespaldo(String nombre, List<Contenido> contenidos, List<Contenido> anuncios, Servidor respaldo) {
		super(nombre, contenidos, anuncios);
		this.respaldo = respaldo;
	}

	public List<Contenido> buscar(String subcadena, String token) {
		List<Contenido> resultado = super.buscar(subcadena, token);
		// Si no tenemos resultados coincidentes en nuestro servidor, se pide el
		// contenido al servidor de respaldo
		if (resultado.isEmpty())
			return respaldo.buscar(subcadena, token);
		return resultado;
	}

}
