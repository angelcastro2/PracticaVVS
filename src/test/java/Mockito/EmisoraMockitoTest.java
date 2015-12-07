package Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import Contenido.Contenido;
import Contenido.MockDeEmisora;

public class EmisoraMockitoTest {
	
	/**
	 * Primero creamos el mock de emisora.
	 */
	MockDeEmisora mockDeEmisora = Mockito.mock(MockDeEmisora.class);
	
	/* Ahora comenzamos con los test de los métodos de la clase Emisora */
	
	/**
	 * Test de prueba del método obtenerTitulo.
	 */
	@Test
	public void obtenerTituloEmisoraMockitoTest(){
		when(mockDeEmisora.obtenerTitulo()).thenReturn("ProbandoMockEmisora");
		assertEquals(mockDeEmisora.obtenerTitulo(), "ProbandoMockEmisora");
	}
	
	/**
	 * Test de prueba del método obtenerDuracion.
	 */
	@Test
	public void obtenerDuracionEmisoraMockitoTest(){
		when(mockDeEmisora.obtenerDuracion()).thenReturn(50);
		assertEquals(mockDeEmisora.obtenerDuracion(), 50);
	}
	
	/**
	 * Test de prueba del método obtenerListaReproduccion.
	 */
	@Test
	public void obtenerListaReproduccionEmisoraMockitoTest(){
		List<Contenido> lista = new ArrayList<Contenido>();
		lista.add(mockDeEmisora);
		when(mockDeEmisora.obtenerListaReproduccion()).thenReturn(lista);
		assertEquals(mockDeEmisora.obtenerListaReproduccion(), lista);
	}
	
	/**
	 * Test de prueba del método buscar.
	 */
	@Test
	public void buscarEmisoraMockitoTest(){
		List<Contenido> lista = new ArrayList<Contenido>();
		lista.add(mockDeEmisora);
		when(mockDeEmisora.buscar(Mockito.anyString())).thenReturn(lista);
		assertEquals(mockDeEmisora.buscar("ProbandoMockEmisora"), lista);
	}
	
	//Falta agregar y eliminar
}
